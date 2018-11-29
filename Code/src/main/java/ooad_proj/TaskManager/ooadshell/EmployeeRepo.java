package ooad_proj.TaskManager.ooadshell;

import org.springframework.data.mongodb.repository.MongoRepository;
        import org.springframework.stereotype.Repository;
/**
 *
 *  This is creating the employee repo by extending the mongoRepo for the database
 */
@Repository
public interface EmployeeRepo extends MongoRepository<Employee,String> {} // this class gives database functions (find save del)

