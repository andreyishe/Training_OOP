import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskManager {
       private List<Task> tasks;
       private List<User> users;

    public TaskManager() {
        tasks = new ArrayList<>();
        users = new ArrayList<>();
    }
    public void createTask(Task task){
        String sql = "INERT INTO tasks (INSERT INTO tasks (title, description, created_at, status, priority) VALUES (?, ?, ?, ?, ?))";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getDescription());
            pstmt.setTimestamp(3, new Timestamp(task.getCreatedAt().getTime()));
            pstmt.setString(4, task.getStatus().name());
            pstmt.setString(5, task.getPriority().name());
            pstmt.executeUpdate();
        }
    }
    public void viewAllTasks(){
        for (Task task :
             tasks) {
            System.out.println(task.getStatus()+" "+task.getPriority());
        }
    }
    public void addUser(String password, String email, String name){
        User user = new User(email, password, name);
    }
    public List<Task>getTask(){
        return tasks;
    }
    public List<User>getUsers(){
        return users;
    }

}
