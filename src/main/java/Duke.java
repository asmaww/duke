import java.util.*;

public class Duke {

    String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    public static void main(String[] args) {
        Duke d = new Duke();
        //System.out.println(d);

        System.out.println("\tHello! I'm Duke \n\tWhat can I do for you?");

        Scanner in = new Scanner(System.in);
//DEFINE Keyword
        String keywords[] = {"done", "todo", "deadline", "event"};

        String echo = " ";
        /* while(echo != null) {
            echo = in.nextLine();
            if (echo.equals("bye")) // DO NOT use ==
                break;
            System.out.println("\t" + echo + "\n");
        } */

//MAKE LIST
        ArrayList<Task> list = new ArrayList<Task>();

//USER INPUT
        while(echo != null) {
            echo = in.nextLine();
            echo = echo.trim();

            if (echo.equals("list")) {
                cmdPrintList(list);
                continue;
            }

            if (echo.contains("done")) {
                cmdMarkDone(echo, list);
                continue;
            }
//TODO contains is not very good : DONE
            if (containsKeyword(echo, "todo")) {
                list.add(new Todo(echo));
                continue;
            }
            if (containsKeyword(echo, "deadline")) {
                list.add(new Deadline(echo));
                continue;
            }
            if (containsKeyword(echo, "event")) {
                list.add(new Event(echo));
                continue;
            }

            /////////
            if (echo.equals("bye"))
                break;
            // list.add(new Task(echo));
            // At level-4, I think original task input should no longer be allowed
            // every task must be either todo or deadline or event
        }

        System.out.println("\tBye. Hope to see you again soon!");

    }

    public static void cmdMarkDone(String echo, ArrayList<Task> list) {
        int listIndex = getIntStringSpace(echo) - 1;
        list.get(listIndex).setcompleted();
        printMarkDone(list, listIndex);
    }

    public static void printMarkDone(ArrayList<Task> list, int listIndex) {
        System.out.println("\tNice! I've marked this task as done: ");
        System.out.println("\t  " + list.get(listIndex));
    }

    public static boolean containsKeyword(String echo, String keyword) {
        String[] parts = echo.split(" ", 2);
        if (parts[0].equals(keyword))
            return true;
        return false;
    }

    public static String removeKeyword(String echo) {
        String[] parts = echo.split(" ", 2);
        return parts[1];
    }

    public static int getIntStringSpace(String echo) {
        //echo = echo.substring(echo.indexOf(" ") + 1); //split number str
        echo = removeKeyword(echo);
        return Integer.parseInt(echo); // get number
    }

    public static void cmdPrintList(ArrayList<Task> list) {
        System.out.println("\tHere are the tasks in your list: ");
        int taskNumber = 1;
        for (Task task : list) {
            System.out.printf("\t%d.%s" + System.lineSeparator(),taskNumber, task);
            ++taskNumber;
        }
    }


    /*
    @Override
    public String toString() {
        return "|"  + logo + "|" ;
    } */



}
