import java.util.Scanner;

public class EncryptDecryptSystem {
    
    interface EncryptionStrategy {
        String encrypt(String text);
        String decrypt(String text);
    }



    
    static class CaesarCipher implements EncryptionStrategy {
        private int shift = 3;


        

        public String encrypt(String text) {
            StringBuilder result = new StringBuilder();
            for (char c : text.toCharArray()) {
                result.append((char) (c + shift));
            }
            return result.toString();
        }

        public String decrypt(String text) {
            StringBuilder result = new StringBuilder();
            for (char c : text.toCharArray()) {
                result.append((char) (c - shift));
            }
            return result.toString();
        }
    }

    static class ReverseCipher implements EncryptionStrategy {
        public String encrypt(String text) {
            return new StringBuilder(text).reverse().toString();
        }

        public String decrypt(String text) {
            return new StringBuilder(text).reverse().toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text to encrypt:");
        String input = scanner.nextLine();

        System.out.println("Choose encryption strategy:\n1. Caesar Cipher\n2. Reverse Cipher");
        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        EncryptionStrategy strategy;

        if (choice == 1) {
            strategy = new CaesarCipher();
        } else {
            strategy = new ReverseCipher();
        }

        String encrypted = strategy.encrypt(input);
        System.out.println("Encrypted text: " + encrypted);

        String decrypted = strategy.decrypt(encrypted);
        System.out.println("Decrypted text: " + decrypted);
    }
}
