class TextFormatter {
  private int maxLineLength;

  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy "
      + "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et "
      + "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem "
      + "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod "
      + "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et "
      + "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est "
      + "Lorem ipsum dolor sit amet.";

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);

    formatter.print(text, "rightbound");
    formatter.print(text, "leftbound");
  }

  private void print(String text, String formateType) {
    if (formateType == "leftbound") {
      formateLeftbound(text);
    } else {
      formateRightbound(text);
    }
  }

  // Konstruktor
  public TextFormatter(int maxLineLength) {
    this.maxLineLength = maxLineLength;
  }

  private String fillWithBlanks(String line) {
    int length = line.length();
    for (int i = 0; i < (maxLineLength - length); i++) {
      line = " " + line;
    }
    return line;
  }

  public void formateRightbound(String aText) {
    String formattedString = "";
    String currentLine = "";
    int previousLineStart = 0;
    for (int currentPosition = 0; currentPosition < aText.length(); currentPosition++) {
      if (currentPosition - previousLineStart >= maxLineLength) {
        int breakPosition = currentPosition;
        while ((aText.charAt(breakPosition) != ' ') && breakPosition >= previousLineStart) {
          breakPosition = breakPosition - 1;
        }
        if (previousLineStart > 0) {
          formattedString += fillWithBlanks(currentLine) + "\n";
          currentLine = "";
        }

        // Kein vorheriges Blank gefunden. In diesem
        // Fall kopieren wir von previousLineStart bis currentPosition

        if (breakPosition <= previousLineStart) {
          breakPosition = currentPosition;
          currentLine += aText.substring(previousLineStart, breakPosition + 1);
        }

        // Ein Blank gefunden. Wir müssen von previousLineStart bis breakPosition,
        // also bis vor dem Blank kopieren
        else {
          currentLine += aText.substring(previousLineStart, breakPosition);
        }

        // das nächste mal starten wir ein Zeichen nach der letzten Kopieraktion

        previousLineStart = breakPosition + 1;

      }

    }

    // Den letzten Teil des Textes kopieren, falls es noch welchen gibt

    if (previousLineStart < aText.length() - 1) {
      formattedString += fillWithBlanks(aText.substring(previousLineStart, aText.length())) + "\n";
    }

    System.out.print(formattedString);
  }

  public void formateLeftbound(String aText) {
    String formattedString = "";
    int previousLineStart = 0;
    for (int currentPosition = 0; currentPosition < aText.length(); currentPosition++) {
      if (currentPosition - previousLineStart + 1 > maxLineLength) {
        int breakPosition = currentPosition;
        while ((aText.charAt(breakPosition) != ' ') && breakPosition >= previousLineStart) {
          breakPosition = breakPosition - 1;
        }
        if (previousLineStart > 0) {
          formattedString += "\n";
        }

        // Kein vorheriges Blank gefunden. In diesem
        // Fall kopieren wir von previousLineStart bis currentPosition

        if (breakPosition <= previousLineStart) {
          breakPosition = currentPosition;
          formattedString += aText.substring(previousLineStart, breakPosition + 1);
        }

        // Ein Blank gefunden. Wir müssen von previousLineStart bis breakPosition,
        // also bis vor dem Blank kopieren
        else {
          formattedString += aText.substring(previousLineStart, breakPosition);
        }

        // das nächste mal starten wir ein Zeichen nach der letzten Kopieraktion

        previousLineStart = breakPosition + 1;

      }

    }

    // Den letzten Teil des Textes kopieren, falls es noch welchen gibt

    if (previousLineStart < aText.length() - 1) {
      formattedString += "\n" + aText.substring(previousLineStart, aText.length());
    }

    System.out.print(formattedString);
  }
}