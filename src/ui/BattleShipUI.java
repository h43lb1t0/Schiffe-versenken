/**
 * @author Tom Ole Haelbich
 */

package ui;

import java.io.*;


public class BattleShipUI {

    private String playerName;

    private static final Colors color = new Colors();

    private final BufferedReader inBufferedReader;
    private final PrintStream outStream;
    private GameBoard board;


    public static void main(String[] args) {
        System.out.println(color.red() + "Welcome to battle ship!" + color.reset());

        try {
            BattleShipUI game = new BattleShipUI(System.in, System.out);
            game.runLoop();
        } catch (IOException e) {
            System.out.println("game could not be started: " + e.getMessage());
            System.exit(0);
        }

        
    }

    private static String getPlayerName(BufferedReader inBufferedReader, PrintStream outStream) {
        String playerName = null;
        try {
            playerName = inBufferedReader.readLine();
        } catch (IOException exp) {
            outStream.println("something went wrong: " + exp.getMessage());
        }
        if (playerName.equals("") | playerName.equals(" ")) {
            outStream.println("please enter your name");
            return getPlayerName(inBufferedReader, outStream);
        }
        return playerName;
    }


    public BattleShipUI(InputStream is, PrintStream os) throws IOException {
        this.inBufferedReader = new BufferedReader(new InputStreamReader(is));
        this.outStream = os;
        this.board = new GameBoard(this.outStream);
    }

    private void showHelp() {
        StringBuilder b = new StringBuilder();

        b.append("\nvalid commands:\n\n");
        b.append("QUIT/quit/q");
        b.append("... to quit the game");
        b.append("\n");
        b.append("SHIPS/ships");
        b.append("... to start placing the ships");
        b.append("\n\tat <x/y> <x/y>");
        b.append("\n");
        b.append("fire <x/y>");

        this.outStream.println(b.toString());
    }

    private void placeShips() {
        this.board.show();
    }

    public void runLoop() {
        boolean isRunning = true;
        String input = null;

        this.outStream.println("Please enter your name");
        this.playerName = getPlayerName(inBufferedReader, outStream);

        this.outStream.println("your name is " + this.playerName);

        this.showHelp();

        while (isRunning) {
            

            try {

                input = this.inBufferedReader.readLine();

                if (input == null) {
                    break;
                }

                input = input.trim();
                input = input.toLowerCase();
                int spaceIndex = input.indexOf(' ');
                spaceIndex = spaceIndex != -1 ? spaceIndex : input.length();

                // got command string
                String commandString =input.substring(0, spaceIndex);

                 // extract parameters string - can be empty
                 String parameterString = input.substring(spaceIndex);
                 parameterString = parameterString.trim();

                 switch (commandString) {
                    case "quit" -> System.exit(1);
                    case "q" -> System.exit(1);
                    case "help" -> this.showHelp();
                    case "ships" -> this.placeShips();
                    case "at" -> this.placeShips(parameterString);
                    case "fire" -> this.fire(parameterString);
                    default -> this.outStream.println(color.red() + "unknown command: " + commandString + "\nPlease enter a valid command \nget command list with 'help'" + color.reset());

            } 
        }
            catch (IOException exp) {
                this.outStream.println("cannot read from input stream - fatal, give up");
                System.exit(0);
            }
        }
    }

}