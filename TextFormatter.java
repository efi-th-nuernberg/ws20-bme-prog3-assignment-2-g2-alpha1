class TextFormatter {
  private int maxLineLength;

  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);
    formatter.print(text);
  }

  // Konstruktor
  public TextFormatter(int maxLineLength) {
    this.maxLineLength = maxLineLength;
  }

  // Ausgabe
  public void print(String aText) {
   String formattedString = "";

    for (int currentPosition = 0; currentPosition < aText.length(); currentPosition++){
      if (currentPosition % 30 == 0){
        if(aText.charAt(currentPosition) != ' '){
          formattedString += "-";
        }
        formattedString += "\n";
      }
      formattedString += aText.charAt(currentPosition);
      
    }
    System.out.println(formattedString);
  }

}