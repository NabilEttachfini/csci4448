package ooad_proj.TaskManager.ooadshell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    private final ManagerRepo Manrepo;
    @Autowired
    public ManagerService(ManagerRepo Manrepo) {this.Manrepo = Manrepo;}


    public void makeManager(String username, String password, String employeeType)
    {
        Manager M = new Manager(username, password, employeeType);
        Manrepo.save(M);
    }
}
