import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Random;

class Functions {
  public static String input_text(String label) {
    try {
      System.out.print(Color("yellow") + label + Color("reset"));
      // Call of system.in to read input from console by bufferedreader
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Эта хрень не работает StandardCharsets.UTF_8 и "cp866" тоже
      String text = reader.readLine(); // Write string with stream from buffer
      
      return text;
    } catch (IOException exception) {
      exception.printStackTrace();
      return exception.toString();
    }

    // Потуги разобраться с кириллицей в джаве, но она не работает. Убил кучу времени, так и не решив проблему

    // try { // здесь идет считывание текста (Scanner input = new Scanner(System.in, "cp866")) - это можно ввести в круглые скобки трая по правилам try-with-resources 
    // https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
    //   System.out.print(label);
    //   Scanner input = new Scanner(System.in, "cp866");
    //   String text = input.next();

    //   return text;
    // } catch (Exception exception) {
    //   exception.printStackTrace();
    //   return exception.toString();
    // }
  }

  public static String Color(String color) { // Function of symbols of ANSI to change color of text in console
    switch(color) {
      case("red"):
        return "\u001B[31m";
      case("green"):
        return "\u001B[32m";
      case("blue"):
        return "\u001B[34m";
      case("reset"):
        return "\u001B[0m";
      case("yellow"):
        return "\u001B[33m";
      default:
        return "";
    }
  }

  static void  text_frequency_analysis(char[] text) { // Frequency analysis of the text
    char[] charArr = new char[text.length];
    int[] freqArr = new int[text.length];
    int idx = 0;

    for (int i = 0; i < text.length; i++) {
        char letter = text[i];
        boolean isFound = false;

        for (idx = 0; idx < text.length; idx++) {
            if (freqArr[idx] == 0) {
                break;
            }
            if (letter == charArr[idx]) {
                freqArr[idx]++;
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            charArr[idx] = letter;
            freqArr[idx]++;
        }
    }
    
    //Sort charArr and freqArr arrays
    char tempChar;
    int tempFreq;
    for (int i = 1; i < text.length; i++) {
        for (int j = i; j > 0; j--) {
            if (charArr[j] < charArr [j - 1]) {
                tempChar = charArr[j];
                charArr[j] = charArr[j - 1];
                charArr[j - 1] = tempChar;
    
                tempFreq = freqArr[j];
                freqArr[j] = freqArr[j - 1];
                freqArr[j - 1] = tempFreq;
             }
        }
    }

    for (int i = 0; i < text.length; i++) {
      if (freqArr[i] != 0) {
          System.out.printf("%s:%d", charArr[i], freqArr[i]);
          System.out.println();
      }
    }
  }

  static String randomly_text_generate() { // Random generate of text
    byte[] array = new byte[20]; // Length of generated text
    new Random().nextBytes(array);
    String generatedString = new String(array, Charset.forName("cp866"));

    System.out.println(generatedString);

    return generatedString;
  }
}
