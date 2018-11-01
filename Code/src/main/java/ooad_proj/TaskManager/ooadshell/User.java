package ooad_proj.TaskManager.ooadshell;
import org.springframework.data.annotation.Id;

import java.util.*;

/**
 *
 */

public abstract class User {

    /**
     * Default constructor
     */
    public User() {
        username = "";
        password = "";
        id = UUID.randomUUID().toString();
    }
    @Id
    private String id;
    public String username;
    private String password;


    /**
     * @return
     */



    public  User(String _username, String _password) {
        // TODO implement here
        username = _username;
        password = _password;
        id = UUID.randomUUID().toString(); // this will make a random id
    }

    /**
     * @return
     */
    public String getUserName() {
        return username;

    }

    /**
     * @return
     */
    private String getPassword() {
        return password;
    }

    /**
     * @param
     * @return
     */
    public void setUserName(String _username) {
        // TODO implement here
        username = _username;
    }

    /**
     * @param  Password
     * @return
     */
    private void setPassword(String Password) {
        // TODO implement here

    }

    /**
     * @return
     */
    public int getEmployeeID() {
        // TODO implement here
        return 0;
    }

    /**
     * @param  EmployeeID
     * @return
     */
    public void setEmployeeID(int EmployeeID) {
        // TODO implement here

    }

    /**
     * @param  password
     * @param username
     * @param  EmployeeID
     * @return
     */
    public boolean login( String password, String username,  int EmployeeID) {
        // TODO implement here
        return true;

    }

    /**
     * @return
     */
    public void logout() {
        // TODO implement here

    }

    /**
     *
     */
    public interface Interface1 {

    }

}