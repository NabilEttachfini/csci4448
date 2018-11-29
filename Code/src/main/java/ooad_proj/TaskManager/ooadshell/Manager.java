package ooad_proj.TaskManager.ooadshell;
import com.sun.xml.internal.ws.api.config.management.ManagedEndpointFactory;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 * Class for creating a manager object
 */

@Document(collection = "managers")
public class Manager extends User {

    /**
     * Default constructor, uses super of User
     */
    public Manager() {
        super();
    }
    /**
     * This a constructor for the manager class that helps create the manager object
     * @param username this is the username of the Manager
     * @param password this is the password of the Manager
     * @param employeeType takes in employee type of Manager
     */

    public Manager(String username, String password, String employeeType)
    {
        super(username, password, employeeType);
    }
}