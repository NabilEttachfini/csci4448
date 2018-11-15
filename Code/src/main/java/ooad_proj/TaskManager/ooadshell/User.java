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
        employeeType = "";
//        id = UUID.randomUUID().toString();
    }

//    private String id;
    @Id
    public String username;
    private String password;
    public String employeeType;




    /**
     * @return
     */



    public  User(String _username, String _password, String _employeeType) {
        // TODO implement here
        username = _username;
        password = _password;
        employeeType = _employeeType;
//        id = UUID.randomUUID().toString(); // this will make a random id
        String taskId = UUID.randomUUID().toString();
//        taskDetails = _taskDetails;// this is for the task details for the respective users.
    }

    /**
     * @return
     */
    public String getUserName() {
        return username;

    }
    public String getEmployeeType()
    {return employeeType;}


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

    public void getEmployeeType(String _employeeType){employeeType = _employeeType;}

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