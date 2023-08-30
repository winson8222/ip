package duke.ui;

import java.util.ArrayList;

import duke.task.Task;

public class UI {
    public static final String LINEBREAK = "____________________________________________________________";
    public static void printMessage(String... msgs) {
        System.out.println(LINEBREAK);
        for (String msg : msgs) {
            System.out.println(msg);
        }
        System.out.println(LINEBREAK);
    }

    public static void printFileError() {
        UI.printMessage("Something is wrong with the list file");
    }

    public static void noSuchTaskError() {
        UI.printMessage("No Such Task");
    }

    public static void printList(ArrayList<Task> items) {
        System.out.println(LINEBREAK);
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < items.size(); i++) {
            String index = String.valueOf(i + 1);
            System.out.println(index + ". " + items.get(i).showTaskinList());
        }
        System.out.println(LINEBREAK);
    }

    public static void printFound(ArrayList<Task> items) {
        System.out.println(LINEBREAK);
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < items.size(); i++) {
            String index = String.valueOf(i + 1);
            System.out.println(index + ". " + items.get(i).showTaskinList());
        }
        System.out.println(LINEBREAK);
    }


}
