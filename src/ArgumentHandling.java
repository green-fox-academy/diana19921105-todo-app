import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArgumentHandling {

    public void handleArgument(String[] arguments) {
        if (arguments.length == 0) {
            System.out.println(getInstructions());
        } else if (arguments.length == 1) {
            System.out.println(arguments[0]);
            if (arguments[0].equals("-l")) {
                listTasks();

            }
            if (arguments[0].equals("-a Feed the monkey")) {
                addNewTask();
            }
            if (arguments[0].equals("-a")) {
                System.out.println(errorHandling());
            }
            if (arguments[0].equals("-r 2")) {
                removeTask();
            }
        }

    }

    public void removeTask() {
        List<String> line = new ArrayList<>();

        try {
            Path path = Paths.get("C:\\Users\\dszan\\Desktop\\repo\\greenfox\\diana19921105-todo-app\\src\\removeargument.txt");
            line = Files.readAllLines(path);
        } catch (IOException exception) {
            System.out.println("No such file");
        }


       List<Task> taskList = new ArrayList<>();

        for(String lines : line) {
            taskList.add(new Task(lines));
        }

        for (int i = 0; i < taskList.size(); i++) {
            taskList.remove(1);
        }
        System.out.println(taskList);
    }

    private String errorHandling() {
        return "Unable to add: no task provided";
    }


    public void addNewTask() {
       String content = "Feed the monkey";
       List<String> toAdd = new ArrayList<>();
       toAdd.add(content);

        Path path = Paths.get("C:\\Users\\dszan\\Desktop\\repo\\greenfox\\diana19921105-todo-app\\src\\listtasks.txt");

        try {
            Files.write(path, toAdd, StandardOpenOption.APPEND);
        } catch (IOException exception) {
            System.out.println("tdghefjke");
        }
        List<String> allLines = new ArrayList<>();

        Path filePath = Paths.get("C:\\Users\\dszan\\Desktop\\repo\\greenfox\\diana19921105-todo-app\\src\\listtasks.txt");

        try {
            allLines = Files.readAllLines(filePath);
        } catch (IOException e) {
            System.out.println("hfjdk");

        }
        StringBuilder stringBuilder = new StringBuilder();

        for (String lines : allLines) {
            stringBuilder.append(lines).append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    private void listTasks() {
        Path listPath = Paths.get("C:\\Users\\dszan\\Desktop\\repo\\greenfox\\diana19921105-todo-app\\src\\listtasks.txt");
        List<String> content = new ArrayList<>();


        try {
            content = Files.readAllLines(listPath);
        } catch (IOException exception) {
            System.out.println("List file doesn't exist");
        }

        List<Task> tasks = new ArrayList<>();

        for (String line : content) {
            tasks.add(new Task(line));
        }

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.isEmpty()) {
                System.out.println("No todos for today");
            }
            if (tasks.get(i).description.equals("Buy milk")) {
                tasks.get(i).complete();
            }
            System.out.println(i + 1 + " - " + tasks.get(i).toString());
        }

    }

    private String getInstructions() {
        Path instructionPath = Paths.get("C:\\Users\\dszan\\Desktop\\repo\\greenfox\\diana19921105-todo-app\\src\\instructions.txt");
        List<String> content = new ArrayList<>();

        try {
            content = Files.readAllLines(instructionPath);
        } catch (IOException e) {
            System.out.println("File isn't available");
        }

        StringBuilder contentAsString = new StringBuilder();

        for (String line : content) {
            contentAsString.append(line).append("\n");
        }
        return contentAsString.toString();
    }

}
