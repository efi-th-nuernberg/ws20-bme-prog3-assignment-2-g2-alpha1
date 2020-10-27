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
    int previousLineStart = 0;
    for (int currentPosition = 0; currentPosition < aText.length(); currentPosition++){
      if (currentPosition-previousLineStart > 30){
        int blankPosition = currentPosition;
        while ((aText.charAt(blankPosition) != ' ') && blankPosition > previousLineStart){
           blankPosition = blankPosition-1;
        }
        if(blankPosition <= previousLineStart){
          blankPosition = currentPosition;
        }
        if(previousLineStart > 0){
          formattedString += "\n" ;
          previousLineStart +=1;
        }
        formattedString +=  aText.substring(previousLineStart, blankPosition);
        previousLineStart = blankPosition;
      }
    
      
      
    }
    formattedString += "\n" + aText.substring(previousLineStart +1, aText.length());
    System.out.println(formattedString);
  }

}
