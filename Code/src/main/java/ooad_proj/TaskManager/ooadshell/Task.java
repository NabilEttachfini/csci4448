package ooad_proj.TaskManager.ooadshell;

import org.springframework.data.annotation.Id;

/**
 * This is where the task will be stored and saved
 */
// DO A FUNNCTION FOR STATUS FOR THE EMPLOYEE AND FOR MANAGER JUST SET IT TO NULL AND THEN THE EMPLOYEE CAN IMPLEMENT IT
public abstract class Task{
    // THIS IS FOR THE FACTORY DESIGN PATTERN.
    /**
     *  initializing the tasks.
     */
    public String taskDescription;
    public String completionTime;
    public String estatus;
    @Id
    public String id;
    public String name;
    public int difficulty;

    /**
     * Setting all task details to a blank string or 0
     */
    public Task(){
        taskDescription = "";
        name = "";
        completionTime = "";
        difficulty = 0;
        estatus = "";
        id = "";
    }

    /**
     * This is the constructor that is setting values for the task details.
     * @param _description  description for all the task objects
     * @param _completionTime completion time for all the task objects
     * @param _difficulty difficulty for all the task objects
     * @param _estatus employee status for all the task objects
     * @param _name  name of employee for all the task objects
     * @param _t_id task id for all the task objects
     */
    public Task(String _description, String _completionTime, int _difficulty, String _estatus, String _name, String _t_id){
        taskDescription = _description;
        completionTime = _completionTime;
        difficulty = _difficulty;
        estatus = _estatus;
        name = _name;
        id = _t_id;

    }

    /**
     * Method for all the custom initializing
     */
    public abstract void customInit();

    /**
     * getting employee status and returning it
     * @return estatus
     */
    public String getEmployeeStatus() {return estatus;}

    /**
     * getting name and returning it
     * @return name
     */
    public String getName(){return name;}

    /**
     * getting task description and returning it
     * @return taskDescription
     */
    public String getTaskDescription(){
        return taskDescription;
    }

    /**
     * getting completion time and returning it
     * @return completionTime
     */
    public String getCompletionTime()
    {
        return completionTime;
    }

    /**
     *  getting difficulty and returning them
     * @return difficulty
     */
    public int getDifficulty()
    {
        return difficulty;
    }

    /**
     *  setting employee status
     * @param estatus
     */
    public void setEstatus(String estatus){ this.estatus = estatus;}

    /**
     * setting task description
     * @param taskDescription
     */
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    /**
     *  Setting completion time
     * @param completionTime
     */
    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    /**
     * getting estatus and retuning it
     * @return estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * getting id and returning it
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     *  setting id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * setting name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setting difficulty and returning it
     * @param difficulty
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}