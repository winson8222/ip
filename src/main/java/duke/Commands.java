package duke;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import duke.storage.*;
import duke.task.ItemList;
import duke.ui.UI;
import duke.task.deadline.DeadlineException;
import duke.task.event.EventException;
import duke.task.todo.ToDoException;


/**
 * The Command Class encapsulates the functions to check the input string with the available commands.
 */
public class Commands {
    /**
     * The Enum Class encapsulates all the available commands.
     */
    public enum CommandType {
        MARK,
        UNMARK,
        LIST,
        EVENT,
        DEADLINE,
        TODO,
        BYE,
        DELETE,

    }


    /**
     * This method Run the Scanner to begin taking inputs from user, and check to see which commands to run.
     *
     */
    public static void Run(Storage storage) {
        Scanner sc = new Scanner(System.in);
        ItemList items = storage.getItems();

        boolean isRunning = true;
        do {
            if(!sc.hasNextLine()) {
                break;
            }
            try {
                String line = sc.nextLine();
                Parser parser = new Parser(line);
                String command = parser.getCommand();
                CommandType given = CommandType.valueOf(command);

                switch(given) {
                    case BYE:
                        isRunning = false;
                        break;
                    case LIST:
                        items.showitems();
                        break;
                    case MARK:
                        parser.parseMark(items);
                        break;
                    case UNMARK:
                        parser.parseUnmark(items);
                        break;
                    case DELETE:
                        parser.parseDelete(items);
                        break;
                    case DEADLINE:
                        parser.parseDeadline(items);
                        break;
                    case TODO:
                        parser.parseTodo(items);
                        break;
                    case EVENT:
                        parser.parseEvent(items);
                        break;
                    default:
                        throw new DukeException();

                }
            } catch (DukeException e) {
                UI.printMessage(e.getMessage());
            } catch (IllegalArgumentException e) {
                UI.printMessage("Invalid input");
            }


        } while (isRunning);
        Greeting.bye();
    }


}
