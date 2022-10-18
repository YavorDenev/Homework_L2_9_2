import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class User {
    protected String password;
    protected ArrayList<Task> tasks = new ArrayList<>();

    public User(String password) {
        this.password = password;
    }

    public void addTask() {
        this.tasks.add(Task.input());
    }

    public void removeTask() {
        if (!tasks.isEmpty()) {
            System.out.println("Enter the number of the task to be removed ... ");
            tasks.remove(inputNumberOfTask()-1);
        } else System.out.println("Your TODO list is empty.");
    }

    public void changeTaskTitle() {
        if (!tasks.isEmpty()) {
            int num = getNumOfTaskToChange();
            Task task = tasks.get(num);;
            task.changeTitle();
            tasks.set(num, task);
        } else System.out.println("Your TODO list is empty.");
    }

    public void changeTaskDescription() {
        if (!tasks.isEmpty()) {
            int num = getNumOfTaskToChange();
            Task task = tasks.get(num);;
            task.changeDescription();
            tasks.set(num, task);
        } else System.out.println("Your TODO list is empty.");
    }

    public void changeTaskPriority() {
        if (!tasks.isEmpty()) {
            int num = getNumOfTaskToChange();
            Task task = tasks.get(num);;
            task.changePriority();
            tasks.set(num, task);
        } else System.out.println("Your TODO list is empty.");
    }

    public void swapTasks() {
        if(tasks.isEmpty()) System.out.println("Your TODO list is empty.");
        else if (tasks.size()==1) System.out.println("Your TODO list has just one task.");
        else {
            System.out.println("Enter the numbers of the tasks to be swapped ... ");
            int n1 = inputNumberOfTask();
            int n2 = inputNumberOfTask();
            Collections.swap(tasks, (n1-1), (n2-1));
        }
    }

    public void checkWhetherIsEmpty() {
        if(tasks.isEmpty()) System.out.println("Your TODO list is empty.");
        else System.out.println("Your TODO list is not empty.");
    }

    private int inputNumberOfTask() {
        Scanner sc = new Scanner(System.in);
        while (!(sc.hasNextInt())) {
            System.out.println("Invalid input. Try again!");
            sc.next();
        }
        int num = sc.nextInt();
        while (num < 1 || num > tasks.size()) {
            System.out.println("Invalid input number. Try again!");
            num = inputNumberOfTask();
        }
        return num;
    }

    private int getNumOfTaskToChange() {
        System.out.println("Enter the number of the task to be changed ... ");
        return inputNumberOfTask()-1;
    }

    public void printTodoList() {
        if(tasks.isEmpty()) System.out.println("Your TODO list is empty.");
        else {
            System.out.println("User " + password + "'s TODO list: ");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i+1) + ".  " + tasks.get(i));
            }
        }
    }
}
