package ooad_proj.TaskManager.ooadshell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import java.util.Scanner;

public class TaskFactory {
    TaskService taskService;
    @Autowired
    public TaskFactory(TaskService taskService){
        this.taskService = taskService;
    }
    public static Task getScrumTask(String descrption, String completionTime, int difficulty, String estatus,String name,String t_id){
        return new Scrum(descrption, completionTime, difficulty, estatus,name, t_id);
    }
    public static Task getQaTask(String descrption, String completionTime, int difficulty, String estatus,String name,String t_id){
        return new QA(descrption, completionTime, difficulty, estatus,name, t_id);
    }
    public static Task getSoftwareTask(String descrption, String completionTime, int difficulty, String estatus,String name,String t_id){
        return new SoftwareEngineer(descrption, completionTime, difficulty, estatus,name, t_id);
    }

    public String getId(){
        return taskService.getSize();
    }
}
