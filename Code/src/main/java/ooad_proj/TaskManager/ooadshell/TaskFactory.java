package ooad_proj.TaskManager.ooadshell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import java.util.Scanner;

public class TaskFactory {
    TaskService taskService;
    @Autowired
    /**
     * taking in task service for D.I
     * @param taskService this is the taskservice
     */
    public TaskFactory(TaskService taskService){
        this.taskService = taskService;
    }

    /**
     * All these are task details that a scrum task will use
     * @param descrption
     * @param completionTime
     * @param difficulty
     * @param estatus
     * @param name
     * @param t_id
     * @return
     */
    public static Task getScrumTask(String descrption, String completionTime, int difficulty, String estatus,String name,String t_id){
        return new Scrum(descrption, completionTime, difficulty, estatus,name, t_id);
    }

    /**
     * All these are task details a QA task will use
     * @param descrption
     * @param completionTime
     * @param difficulty
     * @param estatus
     * @param name
     * @param t_id
     * @return
     */
    public static Task getQaTask(String descrption, String completionTime, int difficulty, String estatus,String name,String t_id){
        return new QA(descrption, completionTime, difficulty, estatus,name, t_id);
    }

    /**
     * All these are task details software engineer task will use
     * @param descrption
     * @param completionTime
     * @param difficulty
     * @param estatus
     * @param name
     * @param t_id
     * @return
     */
    public static Task getSoftwareTask(String descrption, String completionTime, int difficulty, String estatus,String name,String t_id){
        return new SoftwareEngineer(descrption, completionTime, difficulty, estatus,name, t_id);
    }

    /**
     *  this is to get the size of the object in the DB to later get a unique ID
     * @return taskService.getSize()
     */
    public String getId(){
        return taskService.getSize();
    }
}
