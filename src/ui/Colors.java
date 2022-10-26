/**
 * @author Tom Ole Haelbich
 */

package ui;
/**
 * defines colors for terminal outStream
 */
public class Colors {
    private final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public String reset() {
        return ANSI_RESET;
    }

    public String red() {
        return ANSI_RED;
    }

    public String yellow() {
        return ANSI_YELLOW;
    }

    public String blue() {
        return ANSI_BLUE;
    }
}
