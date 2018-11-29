package ooad_proj.TaskManager.ooadshell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import java.util.Scanner;
import java.util.UUID;
import java.util.*;

import static java.lang.System.exit;

public class MainMenu {
    /**
     * Setting all the services to be used in the main menu
     */
    private final EmployeeService employeeService;
    private final ManagerService managerService;
    private final TaskService taskService;
    private final Scanner scanner;
    /**
     * Initializing the services in the main menu through dependency injection.
     * Also doing the scanner here so it can be used throughout the main menu.
     * @param employeeService database for employee
     * @param managerService database for manager
     * @param taskService  database for tasks
     *
     */
    @Autowired
    MainMenu(EmployeeService employeeService, ManagerService managerService, TaskService taskService) {
        this.employeeService = employeeService;
        this.managerService = managerService;
        this.taskService = taskService;
        this.scanner = new Scanner(System.in);
    }
    /**
     * This is the sign-up for the manager case, so they can sign-up
     */
    public void SignUpManager() {
        //prompts for making a manager
        System.out.println("Please enter Username");
        String username = scanner.nextLine();
        System.out.println("Please enter Password");
        String password = scanner.nextLine();
        String t = "manager";
        managerService.makeManager(username, password, t);
    }
    /**
     * This is so the manager can login and then access all the manager privileges
     */
    public void loginManager(){

        System.out.println("Please enter Username");
        String username = scanner.nextLine();
        System.out.println("Please enter Password");
        String password = scanner.nextLine();
        managerMenu();
    }
    /**
     * This is for the manager menu, so they can access the rest of the program.
     * Here the manager can access all the task responsibilities.
     */
    public void managerMenu(){
        System.out.println("Main Menu:");
        System.out.println("Create a new task(1)");
        System.out.println("Check Project progress(2)"); // may not do this either
        System.out.println("Delete a task(3)");
        System.out.println("View all tasks (4)");
        System.out.println("Project Creation(5)"); // may not implement this.
        System.out.println("Logout(6)");
        int option = scanner.nextInt();
        if(option == 1){TaskCreation();}
        if(option == 2){}
        if(option == 3){DeleteTask();}
        if(option == 4){taskService.printAllSessions();}
//        if(option == 5){CreateProject();}
        if(option == 6){exit(0);}

        else managerMenu();
    }
    /**
     *
     */
//    public int CreateProject(){
//        Scanner sting = new Scanner(System.in);
//        System.out.println("How many tasks make up current project");
//        int amount = sting.nextInt();
//        managerMenu();
//        return amount;
//    }
    /**
     * This asks the manager if they would like to delete a task, takes the taskID and allows them to delete it by making a call to the Task service.
     */
    public void DeleteTask(){
        Scanner sting = new Scanner(System.in);
        System.out.println("Please enter the taskID of the task you want to delete");
        String del = sting.nextLine();
        taskService.DeleteTask(del);
        System.out.println("Task Deleted!");
    }
    /**
     * This is for the task creation, this allows the manager to select the type of task
     *  This then goes into the task details and everything that goes with that
     *  This then takes the input of what kind of employee they are and creates a task specific to them. Using the factory pattern.
     *  Then there is save to the database.
     */
    public void TaskCreation()
    {
        Scanner sting = new Scanner(System.in);
        System.out.println("Lets create this task!");
        System.out.println("######");
        Task theTask = null;
        System.out.println("Is this task for a Scrum Master(scrum), QA Engineer(qae), or a Software Engineer(softwareengineer) ?");
        String cast = sting.nextLine();
        System.out.println("Please enter task details");
        String description = sting.nextLine();
        System.out.println("Please enter the time this should take to complete in days");
        String time = sting.nextLine();
        System.out.println("Please enter the level of difficulty for this task out of 5");
        int diff = scanner.nextInt();
        System.out.println("Please set a status on this task, before the employee does");
        String estatus = sting.nextLine();
        System.out.println("Almost there! What is the username of the person this task is assigned to?");
        String name = sting.nextLine();
        System.out.println("Task added!");
        System.out.println("###########");
        // Here we get the size of the database then we use that as a unique ID
        String t_id = taskService.getSize();
         Task task;
         switch (TaskType.castStringEnum(cast)){
             case SCRUM:
                 task = TaskFactory.getScrumTask(description, time, diff, estatus,name, t_id);
                 break;
             case QAE:
                 task = TaskFactory.getQaTask(description, time, diff, estatus,name, t_id);
                 break;
             case SOFTWAREENGINEER:
             // no break
             default:
                 task = TaskFactory.getSoftwareTask(description, time, diff, estatus,name, t_id);

         }
          task.customInit();
          taskService.addTask(task);
//        Task task = TaskFactory.getTask(TaskType.castStringEnum(cast), description, time, diff, estatus, name, id);
        // call task.initi
         managerMenu();
    }
    /**
     * This is the login for the employee
     */
    public void loginEmployee(){
        System.out.println("Please enter Username");
        String username = scanner.nextLine();
        System.out.println("Please enter Password");
        String password = scanner.nextLine();
        EmployeeMainMenu();
    }
    /**
     * Sign up for the employee that takes the user info and creates the employee object, this then saves to the database.
     */

    public void SignUpEmployee() {
        System.out.println("Please enter Username");
        String  username = scanner.nextLine();
        System.out.println("Please enter password");
        String password = scanner.nextLine();
        System.out.println("Are you a Scrum Master(1), Software Engineer(2) or QA(3)");
        int emenu = scanner.nextInt();
        if(emenu == 1)
        {
            String employeeType = "Scrum Master";
            employeeService.makeEmployee(username, password, employeeType);
            // do a data base print all.
        }
        if (emenu == 2)
        {
            String employeeType = "Software Engineer";
            employeeService.makeEmployee(username, password, employeeType);
        }
        if(emenu == 3)
        {
            String employeeType = "QA";
            employeeService.makeEmployee(username, password, employeeType);
        }
        Employee e =  employeeService.getEmployee(username);
        System.out.println("Welcome: " + e.username);
        EmployeeMainMenu();
    }

    /**
     * This is the the main employee menu, which calls the respective tasks
     */

    public void EmployeeMainMenu(){
        System.out.println("View Tasks(1)");
        System.out.println("Edit task status(2)");
        System.out.println("Logout(3)");
        int choice = scanner.nextInt();

//        System.out.println("");
        if(choice == 1)
        {
            taskService.printAllSessions();
            EmployeeMainMenu();
        }
        if(choice == 2)
        {
            editTask();
            EmployeeMainMenu();
        }
        if(choice == 3){
            exit(0);
        }
        EmployeeMainMenu();

    }
    /**
     * The edit task is a method, that takes in a taskID and runs a database match, so the employee can edit a specific task
     * And then edits that task. By taking in a new status. This rebuilds the object and saves it into the database.
     */
    public void editTask(){
        int counter = 0;
        Scanner string = new Scanner(System.in);
//        Scanner longer = new Scanner(System.in);
        System.out.println("Please enter task ID");
        String taskid = string.nextLine();
        System.out.println("Please enter new task status");
        String newStatus = string.nextLine();
//        if(newStatus.equals("Deployed")){
//            ProgressTracker(counter);
//        }
        taskService.ChangeStatus(taskid, newStatus);
        EmployeeMainMenu();
    }

//    public int ProgressTracker(int counter){
//        counter +=1;
//        return counter;
//
//    }
}
