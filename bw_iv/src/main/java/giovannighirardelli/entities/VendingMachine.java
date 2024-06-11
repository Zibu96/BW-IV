package giovannighirardelli.entities;

import giovannighirardelli.enums.TaskStatus;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("distributore_automatico")
@Table (name = "distributore_automatico")
public class VendingMachine extends Retailer{
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
public VendingMachine(){}
    public VendingMachine(String location, TaskStatus taskStatus) {
        super(location);
        this.taskStatus = taskStatus;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "VendingMachine{" +
                "taskStatus=" + taskStatus +
                ", id=" + id +
                '}';
    }
}
