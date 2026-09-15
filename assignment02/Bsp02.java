public class Bsp02 {
  public static void main(String[] args) {

    // ---------------------------Teil 1---------------------------

    int cake = 0; // Hilfsvariable für Anzahl von Kuchen

    // Zutaten eingeben

    System.out.print("? Mehl: ");
    int flour = SavitchIn.readLineInt();

    System.out.print("? Zucker: ");
    int sugar = SavitchIn.readLineInt();

    System.out.print("? Eier: ");
    int eggs = SavitchIn.readLineInt();

    // Schleife wiederholt sich wenn alle Zutaten vorhanden sind

    while (flour >= 200 && sugar >= 100 && eggs >= 2) {

      cake += 1; // Ein Kuchen wird dazu gerechnet
      flour -= 200; // 200g Mehl wird von der vorhandenen Menge abgezogen
      sugar -= 100; // 100g Zucker wird von der vorhandenen Menge abgezogen
      eggs -= 2; // 2 Eier werden abgezogen

    }

    // Ausgabe: Anzahl der Kuchen sowie übrige Zutaten

    System.out.println("Anzahl der Kuchen: " + cake);
    System.out.println("Rest: " + flour + "g Mehl, " + sugar + "g Zucker, " + eggs + " Ei(er)");

    // ---------------------------Teil 2---------------------------

    int i = 0; // Hilfsvariable für die derzeitigen Personen
    double x = 0; // Hilfsvariable für die derzeitigen Spenden
    boolean win = false; // Hilfsvariable damit if-Bedingung in der Schleife nur einmal ausgeführt wird

    // Eingabe: Kosten und Abnehmer

    System.out.print("? Kosten: ");
    double cost = SavitchIn.readLineDouble();

    System.out.print("? Anzahl der Abnehmer: ");
    int people = SavitchIn.readLineInt();

    // Schleife wiederholt sich solange bis alle Spenden eingegeben wurden

    while (i < people) {

      System.out.print("? Spende: ");
      double donation = SavitchIn.readLineDouble();

      x += donation; // Bei jedem durchlauf wird der aktuelle Wert der Spenden in "x" gespeichert

      if (x >= cost && win == false) { // Gewinnzone wird nur einmal ausgeben und das auch nur sobald Gewinn erreicht wurde

        System.out.println("--- Gewinnzone ---");
        win = true; // Hilfsvariable "win" wird true damit nicht wieder Gewinnzone ausgegeben wird sobald es einmal erreicht wurde

      }

      i++; // eine Abnehmer wird für die Schleife dazu gezählt

    }

    // Ausgabe: Gesamtspenden sowie ob Verlust oder nicht

    System.out.println("Gesamtspenden: " + x);

    if (x < cost) { // wenn die Gesamtspenden weniger als die Kosten sind wird Verlust ausgegeben

      System.out.print("Verlust");

    }

  }
}
