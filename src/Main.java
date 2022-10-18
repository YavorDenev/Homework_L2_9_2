import java.util.*;

public class Main {

    static Scanner scan = new Scanner(System.in);

    static HashMap<String, User> userHashMap = new HashMap<>();

    public static void enterUserChoice(String name) {
        System.out.print("Enter a number from 1 to 9 ... ");
        String choice = scan.next();
        switch (choice) {
            case "1" -> {
                userHashMap.get(name).printTodoList();
                enterUserChoice(name);
            }
            case "2" -> {
                userHashMap.get(name).addTask();
                enterUserChoice(name);
            }
            case "3" -> {
                userHashMap.get(name).removeTask();
                enterUserChoice(name);
            }
            case "4" -> {
                userHashMap.get(name).changeTaskTitle();
                enterUserChoice(name);
            }
            case "5" -> {
                userHashMap.get(name).changeTaskDescription();
                enterUserChoice(name);
            }
            case "6" -> {
                userHashMap.get(name).changeTaskPriority();
                enterUserChoice(name);
            }
            case "7" -> {
                userHashMap.get(name).swapTasks();
                enterUserChoice(name);
            }
            case "8" -> {
                userHashMap.get(name).checkWhetherIsEmpty();
                enterUserChoice(name);
            }
            case "9" -> showMainMenu();
            default -> {
                System.out.println("Invalid input. Try again!");
                enterUserChoice(name);
            }
        }
    }

    public static void showUserMenu(String name) {
        System.out.println("""

                What do you want to do?
                \t1. Show my list of tasks;
                \t2. Add new task;
                \t3. Delete a task;
                \t4. Change task title;
                \t5. Change task description;
                \t6. Change task priority;
                \t7. Swap tasks;
                \t8. Check whether my list is empty;
                \t9. Return to main menu.""");
        enterUserChoice(name);
    }

    public static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you name...;");
        String name = sc.nextLine();
        System.out.println("Enter you password...;");
        String password = sc.nextLine();
        if (userHashMap.containsKey(name) && userHashMap.get(name).password.equals(password)) {
            System.out.println("Welcome!");
            showUserMenu(name);
        } else {
            System.out.println("Invalid Username or Password!");
            showMainMenu();
        }
    }

    public static void addUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you name...;");
        String name = sc.nextLine();
        if (!(userHashMap.containsKey(name))) {
            System.out.println("Enter you password...;");
            String password = sc.nextLine();
            userHashMap.put(name, new User(password));
        } else {
            System.out.println("There is already a user with the same name!");
        }
        showMainMenu();
    }

    public static void enterChoice() {
        System.out.print("Enter 1, 2 or 3 ... ");
        String choice = scan.next();
        switch (choice) {
            case "1" -> addUser();
            case "2" -> login();
            case "3" -> System.out.println("Good bye!");   //--- TODO ----> saving the data to a file
            default -> {
                System.out.println("Invalid input. Try again!");
                enterChoice();
            }
        }
    }

    public static void showMainMenu() {
        System.out.println("""

                What do you want to do?
                \t1. Add new user;
                \t2. Login;
                \t3. Exit.""");
        enterChoice();
    }

    public static void main(String[] args) {      //--- TODO ----> reading the data from a file
        System.out.println("\nThis is a simple TODO list.");
        showMainMenu();
    }
}