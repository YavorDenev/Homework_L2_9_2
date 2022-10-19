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
        if (!this.tasks.isEmpty()) {
            System.out.println("Enter the number of the task to be removed ... ");
            this.tasks.remove(inputNumberOfTask()-1);
        } else System.out.println("Your TODO list is empty.");
    }

    public void changeTaskTitle() {
        if (!this.tasks.isEmpty()) {
            int num = getNumOfTaskToChange();
            this.tasks.get(num).changeTitle();
        } else System.out.println("Your TODO list is empty.");
    }

    public void changeTaskDescription() {
        if (!this.tasks.isEmpty()) {
            int num = getNumOfTaskToChange();
            this.tasks.get(num).changeDescription();
        } else System.out.println("Your TODO list is empty.");
    }

    public void changeTaskPriority() {
        if (!this.tasks.isEmpty()) {
            int num = getNumOfTaskToChange();
            this.tasks.get(num).changePriority();
        } else System.out.println("Your TODO list is empty.");
    }

    public void swapTasks() {
        if(this.tasks.isEmpty()) System.out.println("Your TODO list is empty.");
        else if (this.tasks.size()==1) System.out.println("Your TODO list has just one task.");
        else {
            System.out.println("Enter the numbers of the tasks to be swapped ... ");
            int n1 = inputNumberOfTask();
            int n2 = inputNumberOfTask();
            Collections.swap(this.tasks, (n1-1), (n2-1));
        }
    }

    public void checkWhetherIsEmpty() {
        if(this.tasks.isEmpty()) System.out.println("Your TODO list is empty.");
        else System.out.println("Your TODO list is not empty.");
    }

    private int inputNumberOfTask() {
        Scanner sc = new Scanner(System.in);
        while (!(sc.hasNextInt())) {
            System.out.println("Invalid input. Try again!");
            sc.next();
        }
        int num = sc.nextInt();
        while (num < 1 || num > this.tasks.size()) {
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
        if(this.tasks.isEmpty()) System.out.println("Your TODO list is empty.");
        else {
            System.out.println("Your TODO list is: ");
            for (int i = 0; i < this.tasks.size(); i++) {
                System.out.println((i+1) + ".  " + this.tasks.get(i));
            }
        }
    }
}
