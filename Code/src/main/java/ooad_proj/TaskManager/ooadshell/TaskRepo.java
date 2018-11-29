package ooad_proj.TaskManager.ooadshell;


import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * repo set up for the task
 */
@Repository
public interface TaskRepo extends MongoRepository <Task, String> {}

