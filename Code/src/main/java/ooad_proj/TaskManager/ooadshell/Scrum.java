package ooad_proj.TaskManager.ooadshell;

import java.util.Scanner;

public class Scrum extends Task
{
    private String teams;
    private String meetings;
    public Scrum(){
        super();
    }
    /**
     * This is the initialization of the task for a scrum master.
     * @param description these are the task details for the task object, description of task
     * @param completionTime  these are the task details for the task object, completion time of task
     * @param difficulty these are the task details for the task object, difficulty of the task
     * @param estatus these are the task details for the task object, employee status of the task
     * @param name these are the task details for the task object, name of employee for the task
     * @param t_id these are the task details for the task object, this is the task id
     */
    public Scrum(String description, String completionTime, int difficulty, String estatus,String name, String t_id)
    {
        super(description, completionTime, difficulty, estatus,name, t_id);
    }
    /**
     *  This is the specific details that only go into a scrum task object.
     */
    @Override
    public void customInit() {
        Scanner string = new Scanner(System.in);
        System.out.println("Please enter what teams the Scrum Master should have meet");
        String teams = string.nextLine();
        System.out.println("Please enter the amount of meetings you want them to have with the team this sprint");
        String meetings = string.nextLine();
        this.teams = teams;
        this.meetings = meetings;
        // this is where the customization options for task.

    }




}