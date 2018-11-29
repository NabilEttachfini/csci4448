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
/**
 * This class is the main class in which the program runs through
 */
class myCommands extends MainMenu{ // CHECK THIS
    /**
     *  This is the constructor for this class.
     * @param employeeService Dependency injection for the employeeService database connection
     * @param managerService  Dependency injection for the managerService database connection
     * @param taskService  Dependency injection for the taskService database connection
     */
    @Autowired
   public myCommands(EmployeeService employeeService, ManagerService managerService, TaskService taskService){
       super(employeeService, managerService, taskService);
   }

    /**
     * Takes a user through login and signup and calls the proper functions for each user response, this uses the main menu class.
     * @param employeeService Dependency injection for the employeeService database connection
     * @param managerService Dependency injection for the managerService database connection
     * @param taskService Dependency injection for the taskService database connection
     * @param m injecting the main menu class since it is called many times
     */
    @Autowired
    @ShellMethod("MainMenu")
    public void welcome(EmployeeService employeeService, ManagerService managerService, TaskService taskService, MainMenu m) // DEPENDENCY INJECT INTO SHELL

    {

        Scanner numinput = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);
        System.out.println("Are you a Manager(1) or an Employee(2)");
        int kindofperson = numinput.nextInt();
        if(kindofperson == 1){

            System.out.println("Would you like to Signup(1) or Login(2)");
            int choose = numinput.nextInt();
            if(choose == 1){ m.SignUpManager();}
            if (choose == 2){m.loginManager();}
            m.managerMenu();

        }
        else if(kindofperson == 2){
            System.out.println("Would you like to Signup(1) or Login(2)");
            int choose = numinput.nextInt();
            if(choose == 1){ m.SignUpEmployee();}
            if (choose == 2){m.loginEmployee();}
            }
        }

    }

