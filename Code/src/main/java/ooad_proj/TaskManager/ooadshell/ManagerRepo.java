package ooad_proj.TaskManager.ooadshell;


        import org.springframework.data.mongodb.MongoDbFactory;
        import org.springframework.data.mongodb.repository.MongoRepository;
        import org.springframework.stereotype.Repository;

/**
 *  This is the manager repository, that extends the built in mongo repo, this is of type Manager and String.
 */
@Repository
public interface ManagerRepo extends MongoRepository<Manager,String> {} // this class gives database functions ( find save del)

