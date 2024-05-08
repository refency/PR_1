class Menu {
  static void all_menu() { // Main menu call function
    main_menu();
    menu_type_defifinition("");
  }

  static void all_menu(String text) { // Overloading method for output text
    main_menu();
    menu_type_defifinition(text);
  }

  static void main_menu() { // Output in console all points of menu
    System.out.println(Functions.Color("yellow") + "Input the command" + Functions.Color("reset"));
    System.out.println(Functions.Color("green") + "1" + Functions.Color("reset") + " - " + Functions.Color("blue")
                      + "Insert the data manually" + Functions.Color("reset"));
    System.out.println(Functions.Color("green") + "2" + Functions.Color("reset") + " - " + Functions.Color("blue")
                      + "Insert the data randomly" + Functions.Color("reset"));
    System.out.println(Functions.Color("green") + "3" + Functions.Color("reset") + " - " + Functions.Color("blue")
                      + "Output in console our text" + Functions.Color("reset"));
    System.out.println(Functions.Color("green") + "4" + Functions.Color("reset") + " - " + Functions.Color("red")
                      + "exit" + Functions.Color("reset"));
  }

  static void menu_type_defifinition(String text) { // Menu item call
    String input = Functions.input_text("Input menu item: ");

    switch (input) {
      case "1":
        text = Functions.input_text("Insert your text: ");
        all_menu(text);
      case "2":
        text = Functions.randomly_text_generate();
        all_menu(text);
      case "3":
        Functions.text_frequency_analysis(text.toCharArray());
        all_menu(text);
      case "4":
        System.exit(0);
      default:
        input = "";
        all_menu();
    }
  }
}