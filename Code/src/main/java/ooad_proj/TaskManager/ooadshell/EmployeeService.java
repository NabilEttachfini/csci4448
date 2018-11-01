package ooad_proj.TaskManager.ooadshell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepo repo;
    @Autowired
    public EmployeeService(EmployeeRepo repo) {this.repo = repo;}


    public void makeEmployee(String username, String password)
    {
        Employee E = new Employee(username, password);
        repo.save(E);
    }

}
