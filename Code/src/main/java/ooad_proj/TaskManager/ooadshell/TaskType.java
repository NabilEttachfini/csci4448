package ooad_proj.TaskManager.ooadshell;
public enum  TaskType {
    SCRUM, SOFTWAREENGINEER, QAE;

    /**
     *  This takes the type of employee to help makes that task object
     * @param str
     * @return type of employee
     */
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