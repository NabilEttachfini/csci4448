package ooad_proj.TaskManager.ooadshell;

import org.springframework.data.annotation.Id;

/**
 * This is where the task will be stored and saved
 */
// DO A FUNNCTION FOR STATUS FOR THE EMPLOYEE AND FOR MANAGER JUST SET IT TO NULL AND THEN THE EMPLOYEE CAN IMPLEMENT IT
public abstract class Task{
    // THIS IS FOR THE FACTORY DESIGN PATTERN.
    public String taskDescription;
    public String completionTime;
    public String estatus;
    @Id
    public String id;
    public String name;
    public int difficulty;


    public Task(){
        taskDescription = "";
        name = "";
        completionTime = "";
        difficulty = 0;
        estatus = "";
        id = "";
//                UUID.randomUUID().toString();
    }
    public Task(String _description, String _completionTime, int _difficulty, String _estatus, String _name, String _t_id){
        taskDescription = _description;
        completionTime = _completionTime;
        difficulty = _difficulty;
        estatus = _estatus;
        name = _name;
        id = _t_id;

    }
    /**
     *
     *  Doing gettets and setters for the task details, or the components that make up a task object.
     */
    public abstract void customInit();
    public String getEmployeeStatus() {return estatus;}
    public String getName(){return name;}
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
    public void setEstatus(String estatus){ this.estatus = estatus;}

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    public String getEstatus() {
        return estatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}