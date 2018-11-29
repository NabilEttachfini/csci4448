package ooad_proj.TaskManager.ooadshell;
import java.util.Scanner;
public class QA extends Task {
    private String server;
    private String users;

    public QA()
    {
        super();
    }

    /**
     * This is the initialization of the task for a QA engineer.
     * @param description these are the task details for the task object, description of task
     * @param completionTime  these are the task details for the task object, completion time of task
     * @param difficulty these are the task details for the task object, difficulty of the task
     * @param estatus these are the task details for the task object, employee status of the task
     * @param name these are the task details for the task object, name of employee for the task
     * @param t_id these are the task details for the task object, this is the task id
     */
   public QA(String description, String completionTime, int difficulty, String estatus,String name, String t_id)
   {
       super(description, completionTime, difficulty, estatus,name, t_id);
   }
    @Override
    /**
     *  This is the specific details that only go into a QA task object.
     */
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

