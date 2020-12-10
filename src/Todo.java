import java.util.ArrayList;
import java.util.List;

public class Todo {

    private static ArgumentHandling handling = new ArgumentHandling();

    public static void main(String[] args) {
        List<Task> taskList = new ArrayList<>();
        Task buyMilk = new Task("Buy Milk");
        Task walkTheDog = new Task("Walk the dog");
        Task doHomework = new Task("Do homework");

        taskList.add(buyMilk);
        taskList.add(walkTheDog);
        taskList.add(doHomework);


        buyMilk.complete();



//        handling.handleArgument(args);
        handling.removeTask();
//        handling.addNewTask();
    }
}
