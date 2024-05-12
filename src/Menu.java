class Menu {
  static void all_menu() { // Main menu call function
    main_menu();
    menu_type_defifinition("", new String[0][2]);
  }

  static void all_menu(String text, String[][] array_of_frequency) { // Overloading method for output text
    main_menu();
    menu_type_defifinition(text, array_of_frequency);
  }

  static void main_menu() { // Output in console all points of menu
    System.out.println(Functions.Color("yellow") + "Input the command" + Functions.Color("reset"));

    System.out.println(Functions.Color("green") + "1" + Functions.Color("reset") + " - " + Functions.Color("blue")
                      + "Insert the data manually" + Functions.Color("reset"));

    System.out.println(Functions.Color("green") + "2" + Functions.Color("reset") + " - " + Functions.Color("blue")
                      + "Insert the data randomly" + Functions.Color("reset"));

    System.out.println(Functions.Color("green") + "3" + Functions.Color("reset") + " - " + Functions.Color("blue")
                      + "Frequency analysis of your text" + Functions.Color("reset"));

    System.out.println(Functions.Color("green") + "4" + Functions.Color("reset") + " - " + Functions.Color("blue")
                      + "Output your text in console" + Functions.Color("reset"));

    System.out.println(Functions.Color("green") + "5" + Functions.Color("reset") + " - " + Functions.Color("red")
                      + "exit" + Functions.Color("reset"));
  }

  static void menu_type_defifinition(String text, String[][] array_of_frequency) { // Menu item call
    String input = Functions.input_text("Input menu item: ");

    switch (input) {
      case "1":
        text = Functions.input_text("Insert your text: ");
        all_menu(text, array_of_frequency);
      case "2":
        text = Functions.randomly_text_generate();
        all_menu(text, array_of_frequency);
      case "3":
        array_of_frequency = Functions.text_frequency_analysis(text.toCharArray(), array_of_frequency);
        all_menu(text, array_of_frequency);
      case "4":
        Functions.output_text(array_of_frequency);
        all_menu(text, array_of_frequency);
      case "5":
        System.exit(0);
      default:
        input = "";
        all_menu();
    }
  }
}