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

    /**
     * setting user information
     */
    @Id
    public String username;
    private String password;
    public String employeeType;

    /**
     * Takes in info for user.
     * @param _username username for Users
     * @param _password password for Users
     * @param _employeeType employee type for Users
     */
    public  User(String _username, String _password, String _employeeType) {
        // TODO implement here
        username = _username;
        password = _password;
        employeeType = _employeeType;
//        String taskId = UUID.randomUUID().toString();
    }

    /**
     * getting username
     * @return return the username
     */
    public String getUserName() {
        return username;

    }

    /**
     * getting employee type
     * @return return employee type
     */
    public String getEmployeeType()
    {return employeeType;}


    /**
     * getting password
     * @return the password
     */
    private String getPassword() {
        return password;
    }

    /**
     * setting username
     * @param _username to set
     * @return _username return just the username
     */
    public void setUserName(String _username) {
        username = _username;
    }

    /**
     * getting employee type
     * @param _employeeType to get the employee type
     */
    public void getEmployeeType(String _employeeType){employeeType = _employeeType;}

    /**
     * setting password
     * @param  _Password to set the password
     * @return the password saved
     */
    private void setPassword(String _Password) {
        _Password = _Password;

    }
}