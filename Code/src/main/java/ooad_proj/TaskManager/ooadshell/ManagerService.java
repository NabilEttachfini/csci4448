package ooad_proj.TaskManager.ooadshell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * This is the class that is the manager service that saves things to the database
 */
@Service
public class ManagerService {
    private final ManagerRepo Manrepo;
    /**
     * @param Manrepo this is taking in the ManagerRepo to make the saves
     */
    @Autowired
    public ManagerService(ManagerRepo Manrepo) {this.Manrepo = Manrepo;}

    /**
     * makeManager is going to maken the manager object with the specefic params and then save it to the database
     * @param username this is the manager username to save to the DB
     * @param password this is the manager password to save to the DB
     * @param employeeType this is the employeeType to save to the DB
     */
    public void makeManager(String username, String password, String employeeType)
    {
        Manager M = new Manager(username, password, employeeType);
        Manrepo.save(M);
    }
}
