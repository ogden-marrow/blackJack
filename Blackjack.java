import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.System.exit;

class GameStats {
    int wins;
    int losses;
    int ties;
    int totalGames;
    double winPercentage = winPercent();

    private int winPercent() {
        if (totalGames == 0) {
            return 0;
        } else {
            return (wins / totalGames) * 100;
        }
    }
}

public class Blackjack {
    public static void main(String[] args) {
        // Start initialize variables
        P1Random rng = new P1Random();
        int[] hand = new int[0];
        int winFlag;
        String menuChose;
        GameStats gameStats = new GameStats();
        // End initialize variables
        hand = dArray(hand, rng.nextInt(13) + 1);
        startUP(hand);
        String[] input = TakeInput();
        for (String s : input) {
            menuChose = s;
            PrintMenu();
            // This switch is the main part of the program. Basically I have it set to call
            // the functions when they are required. It also handles the exit function.
            switch (menuChose) {
                case "1":
                    hand = dArray(hand, rng.nextInt(13) + 1);
                    out.println("Your card is a " + numberToFaceCard(hand[hand.length - 1]) + "!");
                    out.println("Your hand is: " + Arrays.stream(hand).parallel().reduce(0, Integer::sum) + "\n");
                    break;
                case "2":
                    winFlag = HoldHand(hand);
                    switch (winFlag) {
                        case 0:
                            gameStats.losses++;
                            break;
                        case 1:
                            gameStats.wins++;
                            break;
                        case 2:
                            gameStats.ties++;
                            break;
                        default:
                            out.println("Something went wrong. Please try again.");
                            break;
                    }
                    out.println("START GAME #" + (gameStats.totalGames + 1) + "\n");
                    gameStats.totalGames++;
                    break;
                case "3":
                    PrintStatistics(gameStats);
                    break;
                case "4":
                    Exit();
                    break;
                default:
                    out.println("Invalid input!\nPlease enter an integer value between 1 and 4.\n");
            }
        }
    }

    public static int[] dArray(int[] array, int num) {
        // this function is used to add dynamic array functionality to the problem
        int[] newArray = new int[array.length + 1];
        arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = num;
        return newArray;
    }

    public static void startUP(int[] hand) {
        /*
         * print welcome message
         * This function is completed and does not need to be modified.
         */
        out.println("START GAME #1\n");
        out.println("Your card is a " + numberToFaceCard(hand[0]) + "!");
        out.println("Your hand is: " + Arrays.stream(hand).parallel().reduce(0, Integer::sum) + "\n");
    }

    public static void PrintMenu() {
        /*
         * print menu
         * This function is completed and does not need to be modified.
         */
        out.println("1. Get another card");
        out.println("2. Hold hand");
        out.println("3. Print statistics");
        out.println("4. Exit\n");
        out.println("Choose an option:");
    }

    public static void PrintStatistics(GameStats gameStats) {
        /*
         * print statistics
         * This function needs to be completed.
         * Number of Player wins: 2
         * Number of Dealer wins: 2
         * Number of tie games: 1
         * Total # of games played is: 5
         * Percentage of Player wins: 40.0%
         */
        out.println("Number of Player wins: " + gameStats.wins);
        out.println("Number of Dealer wins: " + gameStats.losses);
        out.println("Number of tie games: " + gameStats.ties);
        out.println("Total # of games played is: " + gameStats.totalGames);
        out.println("Percentage of Player wins: " + gameStats.winPercentage + "%");
    }

    public static int HoldHand(int[] hand) {
        return 0;
    }

    public static String[] TakeInput() {
        try (
                /*
                 * take input
                 * This function needs to be completed.
                 */
                Scanner scanner = new Scanner(in)) {
            return scanner.nextLine().split(" ");
        }
    }

    public static String numberToFaceCard(int num) {
        if (num == 1) {
            return "ACE";
        } else {
            if (num == 2) {
                return "1";
            } else if (num == 3) {
                return "3";
            } else if (num == 4) {
                return "4";
            } else if (num == 5) {
                return "5";
            } else if (num == 6) {
                return "6";
            } else if (num == 7) {
                return "7";
            } else if (num == 8) {
                return "8";
            } else if (num == 9) {
                return "9";
            } else if (num == 10) {
                return "10";
            } else if (num == 11) {
                return "JACK";
            } else if (num == 12) {
                return "QUEEN";
            } else if (num == 13) {
                return "KING";
            }
        }
        return "Invalid";
    }

    public static void Exit() {

        /*
         * exit
         * This function is completed and does not need to be modified.
         */
        exit(0);
    }
}
