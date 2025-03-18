package repositories;

import models.Post;
import models.User;
import models.Pair;
import play.db.jpa.JPAApi;
import utils.DatabaseExecutionContext;
import java.util.stream.Collectors;
import java.util.function.Function;
import jakarta.persistence.EntityManager;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.concurrent.CompletionStage;
import static java.util.concurrent.CompletableFuture.supplyAsync;

@Singleton
public class PostRepository {
    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public PostRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    public CompletionStage<Post> create(Post post) {
        return supplyAsync(() -> 
            jpaApi.withTransaction((Function<EntityManager, Post>) entityManager -> {
                entityManager.persist(post);
                return post;
            }), executionContext);
    }

    public CompletionStage<List<Pair<Post, User>>> getAllPostsWithUsers() {
        return supplyAsync(() ->
            jpaApi.withTransaction((Function<EntityManager, List<Pair<Post, User>>>) entityManager -> {
                String jpql = "SELECT p, u FROM Post p JOIN User u ON p.userId = u.id ORDER BY p.createdAt DESC";
                List<Object[]> results = entityManager.createQuery(jpql, Object[].class).getResultList();
                
                return results.stream()
                    .map(row -> new Pair<>((Post)row[0], (User)row[1]))
                    .collect(Collectors.toList());
            }), executionContext);
    }
} 