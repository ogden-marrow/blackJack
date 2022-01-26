import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.System.exit;

class GameStats {
    double wins;
    double losses;
    double ties;
    double totalGames;
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
                    for (int i = 0; i < hand.length; i++) {
                        if (hand[i] <= 11) {
                            hand[i] = 10;
                        }
                    }
                    int handSum = Arrays.stream(hand).parallel().reduce(0, Integer::sum); // this mess is to get the sum of the hand
                    int DHandTotal = rng.nextInt(11) + 16; // this is the dealers hand total
                    out.println("Dealer's hand: " + DHandTotal);
                    out.println("Your hand is: " + handSum); // this is the players hand total
                    if (handSum == 21) { // this is the player winning condition FOR SOME REASON THIS DOES NOT WORK
                        out.print("You win!\n");
                    } else if (DHandTotal > 21) { // this is the dealer winning condition
                        out.println("Dealer wins!\n");
                    } else if (handSum > 21) { // this is the player winning condition FOR SOME REASON THIS DOES NOT WORK
                        out.println("Dealer wins!\n");
                    } else if (handSum > DHandTotal) { // this is the player winning condition FOR SOME REASON THIS DOES NOT WORK
                        out.print("You win!\n");
                    } else if (handSum < DHandTotal) { // this is the dealer winning condition
                        out.println("Dealer wins!\n");
                    } else { // this is the tie condition
                        out.println("It's a tie! No one wins!\n");
                    }
                    out.println("START GAME #" + (gameStats.totalGames + 1) + "\n");
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
        out.println("Your card is a " + hand[0] + "!");
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
        out.println("Percentage of Player wins: " + (gameStats.wins / gameStats.totalGames) * 100 + "%");
    }

    public static int HoldHand(int[] hand) {
        /*
         * hold hand
         * This function needs to be completed. this function still needs the 21 rule
         * and text add to it.
         * !!!!! FOR SOME REASON THE HAND DOES NOT WORK WITH THE 21 RULE.
         */
        P1Random rng = new P1Random();
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] <= 11) {
                hand[i] = 10;
            }
        }
        int handSum = Arrays.stream(hand).parallel().reduce(0, Integer::sum); // this mess is to get the sum of the hand
        int DHandTotal = rng.nextInt(11) + 16; // this is the dealers hand total
        out.println("Dealer's hand: " + DHandTotal);
        out.println("Your hand is: " + handSum); // this is the players hand total
        if (handSum == 21) { // this is the player winning condition FOR SOME REASON THIS DOES NOT WORK
            out.print("You win!\n");
            return 0;
        } else if (DHandTotal > 21) { // this is the dealer winning condition
            out.println("Dealer wins!\n");
            return 1;
        } else if (handSum > 21) { // this is the player winning condition FOR SOME REASON THIS DOES NOT WORK
            out.println("Dealer wins!\n");
            return 1;
        } else if (handSum > DHandTotal) { // this is the player winning condition FOR SOME REASON THIS DOES NOT WORK
            out.print("You win!\n");
            return 0;
        } else if (handSum < DHandTotal) { // this is the dealer winning condition
            out.println("Dealer wins!\n");
            return 1;
        } else { // this is the tie condition
            out.println("It's a tie! No one wins!\n");
            return 2;
        }
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