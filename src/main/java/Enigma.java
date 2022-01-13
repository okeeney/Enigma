/// Filename: Enigma.java
// / Author: Dr. Shane Wilson
/// Description: Add a useful description of this file

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


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

                //If rotor rotation does not apply, apply the increment
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

        // Steps in brief
        // 1. For each rotor in the list rotors, starting with the last rotor
        //  1.1 Translate the message using the rotor
        // 2. Apply the CAESAR shift
        // 3. Return the decrypted string

        char[] cList = message.toCharArray();

        //returns a reversed rotors List
        Collections.reverse(rotors);


        for(int i = 0; i < cList.length; i++) {

            if(cList[i] == ' ')continue;

            char temp = cList[i];

            //for each iterates through the reversed rotor list
            for (String x : rotors) {

                int charIndex = x.indexOf(temp);

                //if the decrementing number needs to pass zero
                if(charIndex - incrementNumber < 0)
                {
                    //determines the amount of positions it needs to pass zero by
                    //and gets the character at length-(that amount)
                    temp = x.charAt((x.length())+(charIndex-incrementNumber));
                }

                //assigns the rotated value to the temp position
                //in cases where it is not crossing zero
                else
                {
                    temp = x.charAt(charIndex - incrementNumber);
                    System.out.println(temp + " here");

                }

                //assigns the value back to the message array
                cList[i] = temp;
            }

        }

        //typecasts back to string to return for display
        return String.valueOf(cList);

    }
}
