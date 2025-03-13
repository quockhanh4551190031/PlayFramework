package repositories;

import models.User;
import play.db.jpa.JPAApi;
import utils.DatabaseExecutionContext;
import jakarta.persistence.EntityManager;
import java.util.function.Function;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import static java.util.concurrent.CompletableFuture.supplyAsync;

@Singleton
public class UserRepository {
    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public UserRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    public CompletionStage<User> create(User user) {
        return supplyAsync(() -> 
            jpaApi.withTransaction((Function<EntityManager, User>) entityManager -> {
                entityManager.persist(user);
                return user;
            }), executionContext);
    }

    public CompletionStage<Optional<User>> findByUsername(String username) {
        return supplyAsync(() ->
            jpaApi.withTransaction((Function<EntityManager, Optional<User>>) entityManager ->
                Optional.ofNullable(entityManager
                    .createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getResultStream()
                    .findFirst()
                    .orElse(null))
            ), executionContext);
    }
} 