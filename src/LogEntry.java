import java.util.*;

public class LogEntry {
    Date createdAt;
    Date updatedAt;
    String message;
    String updatedMessage;

    public LogEntry(String message){
        this.updatedMessage  = updatedMessage;
        this.message = message;
        createdAt = new Date();
        updatedAt = new Date();
    }
    public Date getCreatedAt(){
        return createdAt;
    }

    public Date getUpdatedAt(){
        return updatedAt;
    }

    public String getMessage(){
        return message;
    }

    public String getUpdatedMessage(){
        return updatedMessage;
    }

    @Override
    public String toString() {
        return "Log Entry{" +
                "Entry=" + message +
                ", Created=" + createdAt +
                ", Updated='" + updatedAt + '\'' +
                '}';
    }

    public void updateMsg(String message) {

    }
}
