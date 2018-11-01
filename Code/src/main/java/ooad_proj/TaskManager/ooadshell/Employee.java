package ooad_proj.TaskManager.ooadshell;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 *
 */
@Document(collection = "employees") // for mongoDB
public class Employee extends User {

    /**
     * Default constructor
     */
    public Employee() {
        super();
    }
    public Employee(String username, String password)
    {
        super(username, password);
    }
    /**
     *
     */
    /**
     * @param  TaskID
     * @return
     */
    public int UpdateStatus( int TaskID) {
        // TODO implement here
        return 0;
    }

    /**
     * @param  TaskID
     * @return
     */
    public String CommentTask(int TaskID) {
        // TODO implement here
        return "test";
    }

}