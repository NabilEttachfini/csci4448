package ooad_proj.TaskManager.ooadshell;

import java.util.Scanner;

public class SoftwareEngineer extends Task {
    private String sprint;
    private String help;
    public SoftwareEngineer() {
        super();
    }
    /**
     * This is the initialization of the task for a software engineer task.
     * @param description these are the task details for the task object, description of task
     * @param completionTime  these are the task details for the task object, completion time of task
     * @param difficulty these are the task details for the task object, difficulty of the task
     * @param estatus these are the task details for the task object, employee status of the task
     * @param name these are the task details for the task object, name of employee for the task
     * @param t_id these are the task details for the task object, this is the task id
     */
    public SoftwareEngineer(String description, String completionTime, int difficulty, String estatus, String name, String t_id)
    {
        super(description, completionTime, difficulty, estatus, name, t_id);
    }
    @Override
    /**
     *  This is the specific details that only go into a scrum task object.
     */
    public void customInit() {
        Scanner string = new Scanner(System.in);
        System.out.println("Please enter percentage of project complete by half-way sprint mark");
        String sprint = string.nextLine();
        System.out.println("Please enter which other engineers can help with this task");
        String help = string.nextLine();
        this.sprint = sprint;
        this.help = help;
        // this is where the customization options for task.

    }
}
