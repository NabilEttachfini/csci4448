package ooad_proj.TaskManager.ooadshell;

import org.omg.CORBA.ACTIVITY_COMPLETED;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import sun.security.pkcs11.wrapper.CK_DESTROYMUTEX;

import java.util.*;

/**
 * This is where the task will be stored and saved
 */

public abstract class Task{
    // THIS IS FOR THE FACTORY DESIGN PATTERN.
    public String taskDescription;
    public String completionTime;
    public int difficulty;
    public Task(){
        taskDescription = "";
        completionTime = "";
        difficulty = 0;
    }
    public Task(String _description, String _completionTime, int _difficulty){
        taskDescription = _description;
        completionTime = _completionTime;
        difficulty = _difficulty;
    }
//   public abstract String TaskDescription(String details);
    /**
     *
     * Default construct
     */

    public String getTaskDescription(){
        return taskDescription;
    }
    public String getCompletionTime()
    {
        return completionTime;
    }
    public int getDifficulty()
    {
        return difficulty;
    }



}