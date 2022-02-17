import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.System.exit;

// This is the Game Stats class.
// It is has wins looses and ties.
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
        String menuChose;
        GameStats gameStats = new GameStats();
        // End initialize variables
        hand = dArray(hand, rng.nextInt(13) + 1);
        startUP(hand);
        String[] input = TakeInput();
        for (String s : input) {
            PrintMenu();
            menuChose = s;
            // This switch is the main part of the program. Basically I have it set to call
            // the functions when they are required. It also handles the exit function.
            switch (menuChose) {
                case "1":
                    hand = dArray(hand, rng.nextInt(13) + 1);
                    out.println("Your card is a " + numberToFaceCard(hand[hand.length - 1]) + "!");
                    out.println("Your hand is: " + addUpHand(hand) + "\n");
                    if (addUpHand(hand) == 21) {
                        out.println("BLACKJACK! You win!\n");
                        gameStats.wins++;
                        gameStats.totalGames++;
                        out.printf("START GAME #%.0f\n", (gameStats.totalGames + 1));
                        hand = new int[0];
                        hand = dArray(hand, rng.nextInt(13) + 1);
                        out.println("Your card is a " + numberToFaceCard(hand[hand.length - 1]) + "!");
                        out.println("Your hand is: " + addUpHand(hand) + "\n");
                    } else if (addUpHand(hand) > 21) {
                        out.println("You exceeded 21! You lose.\n");
                        gameStats.losses++;
                        gameStats.totalGames++;
                        out.printf("START GAME #%.0f\n", (gameStats.totalGames + 1));
                        hand = new int[0];
                        hand = dArray(hand, rng.nextInt(13) + 1);
                        out.println("Your card is a " + numberToFaceCard(hand[hand.length - 1]) + "!");
                        out.println("Your hand is: " + addUpHand(hand) + "\n");
                    }
                    break;
                case "2":
                    int dealerHand = rng.nextInt(11) + 16;
                    int testVal = HoldHand(addUpHand(hand), dealerHand);
                    switch (testVal) {
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
                    gameStats.totalGames++;
                    out.printf("START GAME #%.0f\n", (gameStats.totalGames + 1));
                    hand = new int[0];
                    hand = dArray(hand, rng.nextInt(13) + 1);
                    out.println("Your card is a " + numberToFaceCard(hand[hand.length - 1]) + "!");
                    out.println("Your hand is: " + addUpHand(hand) + "\n");
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

    private static int[] dArray(int[] array, int num) {
        // this function is used to add dynamic array functionality to the problem
        int[] newArray = new int[array.length + 1];
        arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = num;
        return newArray;
    }

    private static double winPercent(Double wins, Double totalGames) {
        if (totalGames == 0) {
            return 0;
        } else {
            return (wins / totalGames) * 100;
        }
    }

    private static int addUpHand(int[] hand) {
        // this function is used to add up the hand
        int outNum = 0;
        for (int i : hand) {
            outNum += (i > 10) ? 10 : i;
        }
        return outNum;
    }

    private static void startUP(int[] hand) {
        /*
         * print welcome message
         * This function is completed and does not need to be modified.
         */
        out.println("START GAME #1\n");
        out.println("Your card is a " + numberToFaceCard(hand[0]) + "!");
        out.println("Your hand is: " + addUpHand(hand) + "\n");
    }

    private static void PrintMenu() {
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

    private static void PrintStatistics(GameStats gameStats) {
        /*
         * print statistics
         * This function needs to be completed.
         * Number of Player wins: 2
         * Number of Dealer wins: 2
         * Number of tie games: 1
         * Total # of games played is: 5
         * Percentage of Player wins: 40.0%
         */
        out.printf("Number of Player wins: %.0f\n", gameStats.wins);
        out.printf("Number of Dealer wins: %.0f\n", gameStats.losses);
        out.printf("Number of tie games: %.0f\n", gameStats.ties);
        out.printf("Total # of games played is: %.0f\n", gameStats.totalGames);
        out.printf("Percentage of Player wins: %.1f", winPercent(gameStats.wins, gameStats.totalGames));
        out.println("%\n");
    }

    private static int HoldHand(int handTotal, int dealerHand) {
        int outVal = 0;
        System.out.println("Dealer's hand: " + dealerHand);
        System.out.println("Your hand is: " + handTotal + "\n");
        if (handTotal > 21) {
            System.out.println("You exceeded 21! You lose\n");
            outVal = 0;
        } else if (dealerHand > 21) {
            System.out.println("You win!\n");
            outVal = 1;
        } else if (handTotal < dealerHand) {
            System.out.println("Dealer wins!\n");
            outVal = 0;
        } else if (handTotal > dealerHand) {
            System.out.println("You win!\n");
            outVal = 1;
        } else {
            System.out.println("It's a tie! No one wins!\n");
            outVal = 2;
        }
        return outVal;
    }

    private static String[] TakeInput() {
        try (
                /*
                 * take input
                 * This function needs to be completed.
                 */
                Scanner scanner = new Scanner(in)) {
            return scanner.nextLine().split(" ");
        }
    }

    private static String numberToFaceCard(int num) {
        switch (num) {
            case 1:
                return "Ace";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return "invalid";
        }
    }

    private static void Exit() {
        /*
         * exit
         * This function is completed and does not need to be modified.
         */
        exit(0);
    }
}
