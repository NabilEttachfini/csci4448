package ooad_proj.TaskManager.ooadshell;

import java.util.Scanner;

public class Scrum extends Task
{
    private String teams;
    private String meetings;
    public Scrum(){
        super();
    }
    public Scrum(String description, String completionTime, int difficulty, String estatus,String name, String t_id)
    {
        super(description, completionTime, difficulty, estatus,name, t_id);
//        initialize();
    }

    @Override
    public void customInit() {
        Scanner string = new Scanner(System.in);
        System.out.println("Please enter what teams the Scrum Master should have meet");
        String teams = string.nextLine();
        System.out.println("Please enter the amount of meetings you want them to have with the team");
        String meetings = string.nextLine();
        this.teams = teams;
        this.meetings = meetings;
        // this is where the customization options for task.

    }






//    public void initialize()
//    {
//        String meeting;
//        String tname;
//        Scanner stringInput = new Scanner(System.in);
//        System.out.println("Please enter the meeting times for this task");
//        String meetingTime = stringInput.next();
//        System.out.println("Please enter the team name(s) for this task");
//        String TeamName = stringInput.next();
//        System.out.println(TeamName);
//        tname = TeamName;
//        meeting = meetingTime;
//    }

}