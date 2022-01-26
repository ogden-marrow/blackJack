import java.io.File; // Import the File class
import java.io.IOException; // Import the IOException class to handle errors

public class P1RandomTest {
    public static void main(String[] args) {
        P1Random rng = new P1Random();
        for (int i = 0; i < 1000; i++) {
            System.out.println(numberToFaceCard(rng.nextInt(13) + 1));
        }
    }

    public static void makeFile(String fileName, String[] data) throws IOException {
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
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
}
