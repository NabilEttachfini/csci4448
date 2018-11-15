package ooad_proj.TaskManager.ooadshell;


    import jdk.nashorn.internal.runtime.options.Option;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepo repo;
    @Autowired
    public EmployeeService(EmployeeRepo repo) {this.repo = repo;}


    public void makeEmployee(String username, String password, String employeeType)
    {
        Employee E = new Employee(username, password, employeeType);
        repo.save(E);
    }
    public Employee getEmployee(String username)
    {
        Optional<Employee> solution = repo.findById(username);
        return solution.orElse(null);
    }

}
