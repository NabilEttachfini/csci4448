package ooad_proj.TaskManager.ooadshell;


    import jdk.nashorn.internal.runtime.options.Option;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.Optional;

@Service
public class EmployeeService {
    /**
     *  Stating and creating the employee repo, and creating the constructor for the employee service class
     * @param repo this is the employee rep
     */
    private final EmployeeRepo repo;
    @Autowired
    public EmployeeService(EmployeeRepo repo) {this.repo = repo;}

    /**
     * Method that takes in the proper params to create an employee and save it to the database.
     * @param username this is the username for the DB save
     * @param password this is the password for the DB save
     * @param employeeType this is the employee type for the DB save
     */
    public void makeEmployee(String username, String password, String employeeType)
    {
        Employee E = new Employee(username, password, employeeType);
        repo.save(E);
    }
    /**
     * Method that gets an employee, finds person by username in the database, this will return what is found.
     * @param username username for employee in DB
     * @return solution what is being returned if found.
     */
    public Employee getEmployee(String username)
    {
        Optional<Employee> solution = repo.findById(username);
        return solution.orElse(null);
    }

}
