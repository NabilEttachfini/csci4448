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
	    System.out.println("Welcome to task manager, please print mainmenu to begin!");
	}
}

@ShellComponent
class myCommands
{
    @Autowired
    @ShellMethod("MainMenu")
    public void welcome(EmployeeService employeeService, ManagerService managerService) // DEPENDENCY INJECT INTO SHELL
    {
        Scanner numinput = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);
        System.out.println("Would you like to Signup(1) or Login(2) ");
        int account = numinput.nextInt();
        if (account == 1)
        {
            System.out.println("Please enter Username");
            String username = stringInput.nextLine();
            System.out.println("Please enter Password");
            String password = stringInput.nextLine();
            System.out.println("Are you a manager(1) or employee(2)");
            int type = numinput.nextInt();
            if (type == 1)
            {
                managerService.makeManager(username, password);
            }
            else if (type == 2)
            {
                employeeService.makeEmployee(username, password);
            }


            // This should just automatically use the User login account.
            // this can check the key and value pair match from sign-up

        }
        else if (account == 2)
        {
            System.out.println("Thank you for choosing TaskManager! ");
            System.out.println("Please choose a username");
            String username = numinput.nextLine();


            // this can check the key and values
            // this should use the user signup method as well.
        }
        else
        {
            System.out.print("Please select valid option");
        }


    }
}
