package ooad_proj.TaskManager.ooadshell;

import java.util.Scanner;

public class SoftwareEngineer extends Task {
    private String sprint;
    private String help;
    public SoftwareEngineer() {
        super();
    }

    public SoftwareEngineer(String description, String completionTime, int difficulty, String estatus, String name, String t_id)
    {
        super(description, completionTime, difficulty, estatus, name, t_id);
    }
    @Override
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
