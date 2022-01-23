import java.util.List;

/**
 * This is a simple class to encrypt/decrypt a String using Caeser shift type, basic encryption.
 *
 * @FileName Enigma
 * @author Oisin Keeney
 * @author David Curtin
 */
public final class Enigma {

  /**
   * The encrypt function encrypts a message using caeser shift and the rotors.
   *
   * @param message         - this is the message to be encrypted.
   * @param incrementNumber - this is the amount of letters forward you wish to apply as the shift
   * @param rotors          - strings of random characters to apply complexity to the shift.
   * @return - char array converted to a string
   */
  public static String encrypt(String message, int incrementNumber, List<String> rotors) {
    //Create a fully uppercase version of message.
    String upperShift = message.toUpperCase();

    //Convert message to char array
    char[] charList = upperShift.toCharArray();

    for (int i = 0; i < charList.length; i++) {
      //if char at index is a space, continue with loop
      if (charList[i] == ' ') {
        continue;
      }

      //Assign char @ current index to temp variable
      char temp = charList[i];

      for (String s : rotors) {
        //Gets index of first occurance of temp char in rotor
        int charIndex = s.indexOf(temp);

        if (charIndex + incrementNumber < s.length()) {
          temp = s.charAt(charIndex + incrementNumber);
        } else {
          //Create an int to specify rotation if applying caeser
          // shift will complete a full rotation of rotor
          int rotation = (incrementNumber + charIndex) % s.length();
          temp = s.charAt(rotation);
        }

        //replace char at index with temp value
        charList[i] = temp;
      }
    }
    //return char array as string
    return String.valueOf(charList);
  }

  /**
   * Decrypt function decrypts the string using the caeser shift and the rotors.
   *
   * @param message         - the message to be decrypted
   * @param incrementNumber - the amount of shift that was applied to encrypt the message
   * @param rotors          - the list of strings that were used to apply complexity to the shift
   * @return - returns a char array converted to a string
   */
  public static String decrypt(String message, int incrementNumber, List<String> rotors) {
    // TODO - Implement the Decrypt method

    //Create a fully uppercase version of message.
    String upperShift = message.toUpperCase();

    //Convert message to char array
    char[] charList = upperShift.toCharArray();

    for (int i = 0; i < charList.length; i++) {
      //if char at index is a space, continue with loop
      if (charList[i] == ' ') {
        continue;
      }

      //Assign char @ current index to temp variable
      char temp = charList[i];

      for (int j = rotors.size() - 1; j > -1; j--) {
        //Gets index of first occurance of temp char in rotor
        int charIndex = rotors.get(j).indexOf(temp);

        //If rotor rotatio does not apply, apply the decrement
        if (charIndex - incrementNumber > -1) {
          temp = rotors.get(j).charAt(charIndex - incrementNumber);
        } else {
          //Create an int to specify rotation if applying caeser
          //shift will complete a full rotation of rotor
          int rotation = (charIndex - incrementNumber) * -1;
          temp = rotors.get(j).charAt(rotors.get(j).length() - (rotation));
        }
        charList[i] = temp;
      }
      //return char array as string
    }
    return String.valueOf(charList);
  }
}
