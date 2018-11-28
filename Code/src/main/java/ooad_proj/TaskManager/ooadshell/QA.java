package ooad_proj.TaskManager.ooadshell;
import java.util.Scanner;
public class QA extends Task {
    private String server;
    private String users;

    public QA()
    {
        super();
    }
   public QA(String description, String completionTime, int difficulty, String estatus,String name, String t_id)
   {
       super(description, completionTime, difficulty, estatus,name, t_id);
   }
    @Override
    public void customInit() {
        Scanner string = new Scanner(System.in);
        System.out.println("What server should they test on?");
        String server = string.nextLine();
        System.out.println("How many users should they run the test on?");
        String users = string.nextLine();
        this.server = server;
        this.users = users;
        // this is where the customization options for task.

    }
}

