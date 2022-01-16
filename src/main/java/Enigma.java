/// Filename: Enigma.java
// / Author: Dr. Shane Wilson
/// Description: Add a useful description of this file

import java.util.ArrayList;
import java.util.List;

public final class Enigma {

    public static String Encrypt(String message, int incrementNumber, List<String> rotors)
    {
        //Create a fully uppercase version of message.
        String upperShift = message.toUpperCase();

        //Convert message to char array
        char[] charList = upperShift.toCharArray();

        for(int i = 0; i < charList.length; i++)
        {
            //if char at index is a space, continue with loop
            if(charList[i] == ' ')continue;

            //Assign char @ current index to temp variable
            char temp = charList[i];

            for(String s : rotors)
            {
                //Gets index of first occurance of temp char in rotor
                int charIndex = s.indexOf(temp);

                //If rotor rotatio does not apply, apply the increment
                if(charIndex + incrementNumber < s.length())
                {
                    temp = s.charAt(charIndex + incrementNumber);
                }
                else
                {
                    //Create an int to specify rotation if applying caeser shift will complete a full rotation of rotor
                    int rotation = (incrementNumber+charIndex) % s.length();
                    temp = s.charAt(rotation);
                }

                //replace char at index with temp value
                charList[i] = temp;
            }
        }
        //return char array as string
        return String.valueOf(charList);
    }


    public static String Decrypt(String message, int incrementNumber, List<String> rotors)
    {
        // TODO - Implement the Decrypt method

        //Create a fully uppercase version of message.
        String upperShift = message.toUpperCase();

        //Convert message to char array
        char[] charList = upperShift.toCharArray();

        for(int i = 0; i < charList.length; i++)
        {
            //if char at index is a space, continue with loop
            if(charList[i] == ' ')continue;

            //Assign char @ current index to temp variable
            char temp = charList[i];

            for(int j = rotors.size()-1; j > -1; j--)
            {
                //Gets index of first occurance of temp char in rotor
                int charIndex = rotors.get(j).indexOf(temp);

                //If rotor rotatio does not apply, apply the decrement
                if(charIndex - incrementNumber > -1)
                {
                    temp = rotors.get(j).charAt(charIndex - incrementNumber);
                }
                else
                {
                    //Create an int to specify rotation if applying caeser shift will complete a full rotation of rotor
                    int rotation = (charIndex-incrementNumber) * -1;
                    temp = rotors.get(j).charAt(rotors.get(j).length() -(rotation));
                }

                //replace char at index with temp value
                charList[i] = temp;
            }
        }
        //return char array as string
        return String.valueOf(charList);
    }
}
