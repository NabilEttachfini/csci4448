package ooad_proj.TaskManager.ooadshell;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 *
 */
@Document(collection = "employees") // for mongoDB
public class Employee extends User {


    public Employee() {
        super();
    }
    /**
     * Default constructor, extending the User class
     *   @param  username this is the username for employee
     *   @param password this is the username for employee
     *   @param  employeeType this is where the employee type will go
     */
    public Employee(String username, String password, String employeeType)

    {
        super(username, password, employeeType);
    }
}