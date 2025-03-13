package utils;

import play.libs.concurrent.CustomExecutionContext;
import org.apache.pekko.actor.ActorSystem;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DatabaseExecutionContext extends CustomExecutionContext {
    
    @Inject
    public DatabaseExecutionContext(ActorSystem actorSystem) {
        super(actorSystem, "database.dispatcher");
    }
} 