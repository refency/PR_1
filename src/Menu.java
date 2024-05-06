class Menu {
  static void all_menu() { // Main menu call function
    main_menu();
    menu_type_defifinition();
  }

  static void main_menu() { // Output in console all points of menu
    System.out.println(Functions.Color("yellow") + "Input the command" + Functions.Color("reset"));
    System.out.println(Functions.Color("green") + "1" + Functions.Color("reset") + " - " + Functions.Color("blue")
                      + "Insert the data manually" + Functions.Color("reset"));
    System.out.println(Functions.Color("green") + "2" + Functions.Color("reset") + " - " + Functions.Color("blue")
                      + "Insert the data randomly" + Functions.Color("reset"));
    System.out.println(Functions.Color("green") + "3" + Functions.Color("reset") + " - " + Functions.Color("red")
                      + "exit" + Functions.Color("reset"));
  }

  static void menu_type_defifinition() { // Menu item call
    String input = Functions.input_text("Input menu item: ");
    String text = "";

    switch (input) {
      case "1":
        text = Functions.input_text("Insert your text: ");
        Functions.text_frequency_analysis(text.toCharArray());
        all_menu();
      case "2":
        text = Functions.randomly_text_generate();
        Functions.text_frequency_analysis(text.toCharArray());
        all_menu();
      case "3":
        System.exit(0);
      default:
        input = "";
        all_menu();
    }
  }
}