import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Random;

class Functions {
  public static String input_text(String label) {
    try {
      System.out.print(Color("yellow") + label + Color("reset"));
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Call of system.in to read input from console by bufferedreader
      String text = reader.readLine(); // Write string with stream from buffer

      return text;
    } catch (IOException exception) {
      exception.printStackTrace();
      return exception.toString();
    }
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
      case("purple"):
        return "\u001B[35m";
      default:
        return "";
    }
  }

  static String[][] text_frequency_analysis(char[] text, String[][] array_of_frequency) { // Frequency analysis of the text
    if (text.length == 0) {
      System.out.println(Functions.Color("red") + "Your text is empty" + Functions.Color("reset"));
      return array_of_frequency;
    }

    char[] charArr = new char[text.length];
    int[] freqArr = new int[text.length];
    int idx = 0;
    int charcters_length = 0;

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
        charcters_length++;
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

    array_of_frequency = new String[charcters_length][2];

    for (int i = 0, j = 0; i < text.length; i++) {
      if (freqArr[i] != 0) {
        array_of_frequency[j][0] = String.valueOf(charArr[i]);
        array_of_frequency[j][1] = String.valueOf(freqArr[i]);
        j++;
      }
    }

    System.out.println(Functions.Color("green") + "Text succesfully analysed" + Functions.Color("reset"));
    return array_of_frequency;
  }

  static void output_text(String[][] array_of_frequency) { // Output analysed text in console
    if (array_of_frequency.length == 0) {
      System.out.println(Functions.Color("red") + "Your text is empty" + Functions.Color("reset"));
      return;
    }

    for (int i = 0; i < array_of_frequency.length; i++) {
      System.out.println(Functions.Color("green") + array_of_frequency[i][0] + Functions.Color("reset") + " : " +
                        Functions.Color("yellow") + array_of_frequency[i][1] + Functions.Color("reset"));
    }
  }

  static String randomly_text_generate() { // Random generate of text
    byte[] array = new byte[20]; // Length of generated text
    new Random().nextBytes(array);
    String generatedString = new String(array, Charset.forName("cp866"));

    return generatedString;
  }
}
