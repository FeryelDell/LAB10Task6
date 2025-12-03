import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class BankFinder {

    public static void main(String[] args) {

        Scanner userScanner = new Scanner(System.in);
        System.out.println("--- Bank Account Identifier ---");
        System.out.print("Please enter the first three digits of the bank account: ");

        String userDigits = userScanner.nextLine().trim();

        if (userDigits.length() < 3) {
            System.out.println("Error: Please enter at least 3 digits.");
            return;
        }

        String fileUrl = "https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt";

        System.out.println("Searching for bank information...");

        try {

            URL url = new URL(fileUrl);

            Scanner webScanner = new Scanner(url.openStream());

            boolean found = false;

            while (webScanner.hasNextLine()) {
                String line = webScanner.nextLine();

                String[] parts = line.split("\\s+", 2);

                if (parts.length >= 2) {
                    String bankNumber = parts[0];
                    String bankName = parts[1];

                    if (bankNumber.startsWith(userDigits)) {

                        String abbreviatedBankNumber = bankNumber;
                        String nameOfTheBank = bankName;

                        System.out.println("\nSuccess! Match found.");
                        System.out.println("Abbreviated Bank Number: " + abbreviatedBankNumber);
                        System.out.println("Bank Name: " + nameOfTheBank);

                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("No bank found starting with digits: " + userDigits);
            }

            webScanner.close();

        } catch (IOException e) {
            System.out.println("An error occurred while trying to download the file.");
            System.out.println("Error details: " + e.getMessage());
        } finally {
            userScanner.close();
        }
    }
}