import java.util.Scanner;

public class Task {
    private String title;
    private String description;
    private int priority;

    public Task(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    protected void changeTitle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new title ... ");
        this.title = sc.nextLine();
    }

    protected void changeDescription() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new description ... ");
        this.description = sc.nextLine();
    }

    protected void changePriority() {
        System.out.println("Enter an integer between 1 and 5 to change priority ... ");
        this.priority = inputPriority();
    }

    protected static Task input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter title ... ");
        String title = sc.nextLine();
        System.out.println("Enter description ... ");
        String description = sc.nextLine();
        System.out.println("Enter an integer between 1 and 5 for priority ... ");
        int priority = inputPriority();
        return new Task(title, description, priority);
    }

    protected static int inputPriority() {
        Scanner sc = new Scanner(System.in);
        while (!(sc.hasNextInt())) {
            System.out.println("Invalid input. Try again!");
            sc.next();
        }
        int priority = sc.nextInt();
        while (priority < 1 || priority > 5) {
            System.out.println("Invalid input number. Try again!");
            priority = inputPriority();
        }
        return priority;
    }

    @Override
    public String toString() {
        return "{ " +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                " }";
    }
}
