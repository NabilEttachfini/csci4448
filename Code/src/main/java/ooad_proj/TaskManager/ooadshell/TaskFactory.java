package ooad_proj.TaskManager.ooadshell;

import java.util.Scanner;

public class TaskFactory {

    public static Task getTask(TaskType task, String descrption, String completionTime, int difficulty)
    {
        switch (task)
        {
            case SCRUM:
                return new Scrum(descrption, completionTime, difficulty);
            case QAE:
                return new QA(descrption, completionTime, difficulty);
            case SOFTWAREENGINEER:
                return new SoftwareEngineer(descrption, completionTime, difficulty);
        }
        return null;
    }
}
