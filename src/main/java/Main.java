import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Main {
    public static void main(String[] args)
    {
        // Obtain a reference to the console
        Console con = System.console();

        System.out.println("Hello World");

        // List of rotors to map characters. Spaces in the rotor strings should be ignored.
        List<String> rotors = new ArrayList<String>();
        rotors.add("BDFHJLCPRTXVZNYEIWGAKMUSQO");
        rotors.add("AJDKSIRUXBLHWTMCQGZNPYFVOE");
        rotors.add("EKMFLGDQVZNTOWYHXUSPAIBRCJ");

        // ToDO
        // Get a start message, encrypt it and then decrypt it

        String startMessage = "Hello World";
        String encryptedMessage = Enigma.encrypt(startMessage, 4, rotors);
        System.out.println("The encrypted message is: " + encryptedMessage);

        String decryptedMessage = Enigma.decrypt(encryptedMessage, 4, rotors);

        System.out.println("The decrypted message is: " + decryptedMessage);
    }
}
