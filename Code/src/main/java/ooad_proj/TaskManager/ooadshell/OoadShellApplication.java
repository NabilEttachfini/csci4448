//package com.example.ooadshell;
package ooad_proj.TaskManager.ooadshell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.HashMap;
import java.util.Scanner;


@SpringBootApplication
public class OoadShellApplication {

	public static void main(String[] args) {
	    SpringApplication.run(OoadShellApplication.class, args);
	}
}
@ShellComponent
class myCommands
{
    @Autowired
    @ShellMethod("MainMenu")
    public void welcome(EmployeeService employeeService, ManagerService managerService, TaskService taskService) // DEPENDENCY INJECT INTO SHELL

    {
        Scanner numinput = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);
        System.out.println("Would you like to Signup(1) or Login(2)");
        int account = numinput.nextInt();
        if (account == 1)
        {
            System.out.println("Please enter Username");
            String username = stringInput.nextLine();
            System.out.println("Please enter Password");
            String password = stringInput.nextLine();
            System.out.println("Are you a manager(1) or employee(2)");
            int type = numinput.nextInt();
            if (type == 1) // if they are a manager
            {
                // .retrieve Password
                String t = "manager";
                managerService.makeManager(username, password, t);
                System.out.println("Main Menu:");
                System.out.println("Create a new task(1)");
                System.out.println("Check Project progress(2)");
                System.out.println("Delete a task(3)");
                System.out.println("View all tasks (4)");
                System.out.println("Logout(5)");
                int menu = numinput.nextInt();
                Task theTask = null;
                if(menu == 1)
                {
                    System.out.println("Is this task for a Scrum Master(scrum), QA Engineer(qae), or a Software Engineer(softwareengineer)");
                    String cast = stringInput.next();

                    System.out.println("Please enter task details/Progress report updates (for scrum)");
                    String description = stringInput.next();
                    System.out.println("Please enter the time this should take to complete in days");
                    String time = stringInput.next();
                    System.out.println("Please enter the level of difficulty for this task");
                    int diff = numinput.nextInt();
                    System.out.println("Task added!");
                    System.out.println("would you like to print all tasks out of 5 (1)");
                    int print = numinput.nextInt();
                    Task ta = TaskFactory.getTask(TaskType.castStringEnum(cast), description, time, diff);
                    taskService.addTask(ta);
                    if(print == 1)
                    {
                        taskService.printAllSessions();
                    }
                    if(print == 2)
                    {
                        System.out.print("Okay Bye");
                    }





                }
                else if (menu == 2)
                {

                }
                else if (menu == 3)
                {
                }
                else if(menu == 4)
                {
                }
            }
            else if (type == 2) // THIS IS THE EMPLOYEE !
            {
                System.out.println("Are you a Scrum Master(1), Software Engineer(2) or QA(3)");
                int emenu = numinput.nextInt();
                if(emenu == 1)
                {
                    String employeeType = "Scrum Master";
                    employeeService.makeEmployee(username, password, employeeType);
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
                System.out.println("Welcome" + e.username);
                System.out.println("Main Menu:");
                System.out.println("View Tasks(1)");
                System.out.println("Update Task Status(2)");
                System.out.println("Delete a task(3)");

            }
        }
        else
        {
            System.out.print("Please select valid option");
        }
    }
}
