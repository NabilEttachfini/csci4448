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
    public TaskService(TaskRepo repo) {
        this.repo = repo;
    }
    public void addTask(Task task)
    {
        repo.save(task);
    }
    public void DeleteTask(Task task)
    {

    }
    private void printSession(String description, String completionTime, int difficulty){
        System.out.println("##########");
        System.out.println("Task description: " + description);
        System.out.println("Time taken to complete: " + completionTime);
        System.out.println("Difficulty of Task: " + difficulty);
        System.out.println("##########");
    }
    public void printAllSessions() {
        List<Task> result = repo.findAll();
        for (Task t : result) {
            printSession(t.getTaskDescription(), t.getCompletionTime(), t.getDifficulty());
        }
    }
}
