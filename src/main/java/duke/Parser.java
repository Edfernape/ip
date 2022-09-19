package duke;

import java.util.LinkedList;
import java.util.List;

/**
 * The Parser class handles the detection of all user commands.
 */
public class Parser {
    public static final String EXACT_KEYWORD_BYE = "bye";
    public static final String EXACT_KEYWORD_LIST = "list";
    public static final String MARK_KEYWORD_MARK = "mark ";
    public static final String MARK_KEYWORD_UNMARK = "unmark ";
    public static final String TASK_KEYWORD_TODO = "todo ";
    public static final String TASK_KEYWORD_DEADLINE = "deadline ";
    public static final String TASK_KEYWORD_EVENT = "event ";
    public static final String MARK_KEYWORD_DELETE = "delete ";
    private static final LinkedList<String> listOfExactKeywords = new LinkedList<>(
            List.of(Parser.EXACT_KEYWORD_BYE,
                    Parser.EXACT_KEYWORD_LIST)
    );

    /**
     * Gets whether an exact keyword is present.
     * @param userInput the user input.
     * @return true if an exact keyword is present, false otherwise.
     */
    public static Boolean containsExactKeyword(String userInput) {
        return Parser.listOfExactKeywords.contains(userInput);
    }

    /**
     * Gets whether a mark type keyword is present.
     * @param userInput the user input.
     * @return true if a mark type keyword if present, false otherwise.
     */
    public static Boolean containsMarkKeyword(String userInput) {
        Boolean hasMarkKeyword = false;

        if (userInput.startsWith(Parser.MARK_KEYWORD_MARK)) {
            hasMarkKeyword = true;
        } else if (userInput.startsWith(Parser.MARK_KEYWORD_UNMARK)) {
            hasMarkKeyword = true;
        } else if (userInput.startsWith(Parser.MARK_KEYWORD_DELETE)) {
            hasMarkKeyword = true;
        }

        return hasMarkKeyword;
    }

    /**
     * Gets whether a task type keyword is present.
     * @param userInput the user input.
     * @return true if a task type keyword is present, false otherwise.
     */
    public static Boolean containsTaskKeyword(String userInput) {
        Boolean hasTaskKeyword = false;

        if (userInput.startsWith(Parser.TASK_KEYWORD_TODO)) {
            hasTaskKeyword = true;
        } else if (userInput.startsWith(Parser.TASK_KEYWORD_DEADLINE)) {
            hasTaskKeyword = true;
        } else if (userInput.startsWith(Parser.TASK_KEYWORD_EVENT)) {
            hasTaskKeyword = true;
        }

        return hasTaskKeyword;
    }

    /**
     * Gets the nonexact keyword present in the user input.
     * @param userInput the user input.
     * @return the nonexact keyword if present, an empty string otherwise.
     */
    public static String getNonexactKeyword(String userInput) {
        String nonexactKeyword = "";

        if (userInput.startsWith(Parser.MARK_KEYWORD_MARK)) {
            nonexactKeyword = Parser.MARK_KEYWORD_MARK;
        } else if (userInput.startsWith(Parser.MARK_KEYWORD_UNMARK)) {
            nonexactKeyword = Parser.MARK_KEYWORD_UNMARK;
        } else if (userInput.startsWith(Parser.MARK_KEYWORD_DELETE)) {
            nonexactKeyword = Parser.MARK_KEYWORD_DELETE;
        } else if (userInput.startsWith(Parser.TASK_KEYWORD_TODO)) {
            nonexactKeyword = Parser.TASK_KEYWORD_TODO;
        } else if (userInput.startsWith(Parser.TASK_KEYWORD_DEADLINE)) {
            nonexactKeyword = Parser.TASK_KEYWORD_DEADLINE;
        } else if (userInput.startsWith(Parser.TASK_KEYWORD_EVENT)) {
            nonexactKeyword = Parser.TASK_KEYWORD_EVENT;
        }

        return nonexactKeyword;
    }

    /**
     * Gets the specifier following a nonexact keyword.
     * e.g. In "mark 1", the specifier is '1'.
     * @param userInput the user input.
     * @return the relevant specifier.
     */
    public static int getSpecifier(String userInput) {
        int specifier = -1;

        switch (Parser.getNonexactKeyword(userInput)) {
            case Parser.MARK_KEYWORD_MARK:
                specifier = Integer.parseInt(userInput.substring(5));
                break;
            case Parser.MARK_KEYWORD_UNMARK:
            case Parser.MARK_KEYWORD_DELETE:
                specifier = Integer.parseInt(userInput.substring(7));
                break;
            default:
                break;
        }

        return specifier;
    }
}
