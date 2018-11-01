package ooad_proj.TaskManager.ooadshell;
import com.sun.xml.internal.ws.api.config.management.ManagedEndpointFactory;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 *
 */
@Document(collection = "managers")
public class Manager extends User {

    /**
     * Default constructor
     */
    public Manager() {
        super();


    }

    public Manager(String username, String password)
    {
        super(username, password);
    }
    /**
     * @return
     */
    public int addTask() {
        // TODO implement here
        return 0;
    }

    /**
     * @param  TaskID
     * @return
     */
    public void editTask(int TaskID) {
        // TODO implement here

    }

    /**
     * @param  TaskID
     * @return
     */
    public void DeleteTask(int TaskID) {
        // TODO implement here

    }

    /**
     * @param  EmployeeID
     * @param  TaskID
     * @return
     */
    public void assignTask(int EmployeeID,int TaskID) {
        // TODO implement here

    }

    /**
     * @return
     */
    public void Manager() {
        // TODO implement here

    }

}