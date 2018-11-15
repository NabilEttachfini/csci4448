package ooad_proj.TaskManager.ooadshell;
public enum  TaskType {
    SCRUM, SOFTWAREENGINEER, QAE;

    public static TaskType castStringEnum(String str) {
        switch (str.toUpperCase()) {
            case "SCRUM":
                return SCRUM;
            case "SOFTWAREENGINEER":
                return SOFTWAREENGINEER;
            case "QAE":
                return QAE;
        }
        return null;
    }
}