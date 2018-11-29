package ooad_proj.TaskManager.ooadshell;
import java.util.*;


import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepo repo;

    @Autowired
    /**
     * takes task repo, this is a constructor
     * @param repo
     */
    public TaskService(TaskRepo repo) {
        this.repo = repo;
    }

    /**
     * this saves a task to the DB
     * @param task task to save
     */
    public void addTask(Task task)
    {
        repo.save(task);
    }

    /**
     * this delets a task from the DB
     * @param id id to find task to delete
     */
    public void DeleteTask(String id)
    {
        repo.deleteById(id);
    }

    /**
     * gets a unique task ID and converts a long to string.
     * @return tostring a strinf version of the size of the DB for a unique ID
     */
    public String getSize(){
        long size = repo.count();
        String tostring = String.valueOf(size);
        return tostring;
    }

    /**
     * takes task details so it can print.
     * @param description
     * @param completionTime
     * @param difficulty
     * @param estatus
     * @param name
     * @param t_id
     */
    private void printSession(String description, String completionTime, int difficulty, String estatus, String name, String t_id){
        System.out.println("##########");
        System.out.println("Task ID: " + t_id);
        System.out.println("Task description: " + description);
        System.out.println("Time taken to complete: " + completionTime);
        System.out.println("Difficulty of Task: " + difficulty);
        System.out.println("Status of Project: " + estatus);
        System.out.println("Name of assignee: " + name);
        System.out.println("##########");
    }

    /**
     * Finds all task details so they can be printed
     */
    public void printAllSessions() {
        List<Task> result = repo.findAll();
        for (Task t : result) {
            printSession(t.getTaskDescription(), t.getCompletionTime(), t.getDifficulty(), t.getEmployeeStatus(), t.getName(), t.getId());
        }
    }

    /**
     * This allows an employee to change a status by finding through an id
     * @param id
     * @param newEStatus
     */
    public void ChangeStatus(String id, String newEStatus){
         Optional <Task> result = repo.findById(id);
//         System.out.println(result);
         if (result.isPresent()) {
            Task task = result.get();
            task.setEstatus(newEStatus);
            addTask(task);
         }
        }
    }

