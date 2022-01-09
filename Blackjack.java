import java.util.Scanner;

import static java.lang.System.exit;

public class Blackjack {
    public static void main(String[] args) {
        // initialize variables
        String menuChose = "1";
        Number gameNumber;
        startUP();
        while (true) {
            PrintMenu();
            menuChose = TakeInput();
            switch (menuChose) {
                case "1":
                    GetAnotherCard();
                    break;
                case "2":
                    HoldHand();
                    break;
                case "3":
                    PrintStatistics();
                    break;
                case "4":
                    Exit();
                    break;
                default:
                    System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.");
                    break;
            }
        }
    }
    public static void startUP() {
        // print welcome message
        System.out.println("START GAME #1");
    }
    public static void PrintMenu() {
        // print menu
        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");
    }
    public static void PrintStatistics() {
        // print statistics
        System.out.println("Print statistics");
    }
    public static void GetAnotherCard() {
        // get another card
        System.out.println("Get another card");
    }
    public static void HoldHand() {
        // hold hand
        System.out.println("Hold hand");
    }
    public static String TakeInput() {
        // take input
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
    public static void Exit() {
        // exit
        exit(0);
    }
}
