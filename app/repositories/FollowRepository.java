package repositories;

import models.Follow;
import models.User;
import play.db.jpa.JPAApi;
import utils.DatabaseExecutionContext;
import java.util.function.Function;
import jakarta.persistence.EntityManager;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.CompletionStage;
import static java.util.concurrent.CompletableFuture.supplyAsync;

@Singleton
public class FollowRepository {
    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public FollowRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    public CompletionStage<Void> follow(Long followerId, Long followedId) {
        return supplyAsync(() ->
            jpaApi.withTransaction((Function<EntityManager, Void>) entityManager -> {
                Follow follow = new Follow(null, followerId, followedId, 
                    new Timestamp(System.currentTimeMillis()));
                entityManager.persist(follow);
                return null;
            }), executionContext);
    }

    public CompletionStage<Void> unfollow(Long followerId, Long followedId) {
        return supplyAsync(() ->
            jpaApi.withTransaction(entityManager -> {
                entityManager.createQuery("DELETE FROM Follow f WHERE f.followerId = :followerId AND f.followedId = :followedId")
                    .setParameter("followerId", followerId)
                    .setParameter("followedId", followedId)
                    .executeUpdate();
                return null;
            }), executionContext);
    }

    public CompletionStage<List<User>> getFollowers(Long userId) {
        return supplyAsync(() ->
            jpaApi.withTransaction(entityManager -> {
                String jpql = "SELECT u FROM User u JOIN Follow f ON u.id = f.followerId WHERE f.followedId = :userId";
                return entityManager.createQuery(jpql, User.class)
                    .setParameter("userId", userId)
                    .getResultList();
            }), executionContext);
    }

    public CompletionStage<List<User>> getFollowing(Long userId) {
        return supplyAsync(() ->
            jpaApi.withTransaction(entityManager -> {
                String jpql = "SELECT u FROM User u JOIN Follow f ON u.id = f.followedId WHERE f.followerId = :userId";
                return entityManager.createQuery(jpql, User.class)
                    .setParameter("userId", userId)
                    .getResultList();
            }), executionContext);
    }

    public CompletionStage<Boolean> isFollowing(Long followerId, Long followedId) {
        return supplyAsync(() ->
            jpaApi.withTransaction(entityManager -> {
                String jpql = "SELECT COUNT(f) FROM Follow f WHERE f.followerId = :followerId AND f.followedId = :followedId";
                Long count = entityManager.createQuery(jpql, Long.class)
                    .setParameter("followerId", followerId)
                    .setParameter("followedId", followedId)
                    .getSingleResult();
                return count > 0;
            }), executionContext);
    }
} 