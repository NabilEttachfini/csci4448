package ooad_proj.TaskManager.ooadshell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import java.util.Scanner;
import java.util.UUID;
import java.util.*;

import static java.lang.System.exit;

public class MainMenu {

    private final EmployeeService employeeService;
    private final ManagerService managerService;
    private final TaskService taskService;
    private final Scanner scanner;

    @Autowired
    MainMenu(EmployeeService employeeService, ManagerService managerService, TaskService taskService) {
        this.employeeService = employeeService;
        this.managerService = managerService;
        this.taskService = taskService;
        this.scanner = new Scanner(System.in);
    }

    public void SignUpManager() {
        //prompts for making a manager

        System.out.println("Please enter Username");
        String username = scanner.nextLine();
        System.out.println("Please enter Password");
        String password = scanner.nextLine();
        String t = "manager";
        managerService.makeManager(username, password, t);
    }
    public void loginManager(){

        System.out.println("Please enter Username");
        String username = scanner.nextLine();
        System.out.println("Please enter Password");
        String password = scanner.nextLine();
        managerMenu();
    }
    public void managerMenu(){
        System.out.println("Main Menu:");
        System.out.println("Create a new task(1)");
        System.out.println("Check Project progress(2)");
        System.out.println("Delete a task(3)");
        System.out.println("View all tasks (4)");
        System.out.println("Project Creation(5)"); // may not implement this.
        System.out.println("Logout(6)");
        int option = scanner.nextInt();
        if(option == 1){TaskCreation();}
//        if(option == 3){taskService.DeleteTask();}
        if(option == 4){taskService.printAllSessions();}
        if(option == 6){exit(0);}

        else managerMenu();
    }
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
    public void loginEmployee(){
        System.out.println("Please enter Username");
        String username = scanner.nextLine();
        System.out.println("Please enter Password");
        String password = scanner.nextLine();
        EmployeeMainMenu();
    }

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

//    public employeeWelcome(){}

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

    public void editTask(){
        Scanner string = new Scanner(System.in);
//        Scanner longer = new Scanner(System.in);
        System.out.println("Please enter task ID");
        String taskid = string.nextLine();
        System.out.println("Please enter new task status");
        String newStatus = string.nextLine();
        taskService.ChangeStatus(taskid, newStatus);
        EmployeeMainMenu();
    }
}
