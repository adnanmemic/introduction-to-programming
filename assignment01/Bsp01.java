public class Bsp01 {
     public static void main(String[] args) {

          System.out.print("Monat:"); // Monat soll geschrieben stehen
          int month = SavitchIn.readLineInt(); // Monat soll eingegeben werden und Variable Monat deklariert

          System.out.print("Tag:"); // Tag soll geschrieben stehen
          int day = SavitchIn.readLineInt(); // Tag soll eingegeben werden und Variable Tag deklariert

          if (month < 10 && month > 3) { // jeder Monat der kleiner als 10 ist und groeßer als 3 ist --> Sommerzeit
               System.out.print("Sommerzeit");
          }

          else if (month < 3 || month > 10) { // jeder Monat der kleiner ist als 3 oder groeßer als 10 ist -->
                                              // Winterzeit
               System.out.print("Winterzeit");
          }

          else if (month == 3 || month == 10) { // Monat 3 oder 10 --> Winterzeit oder Sommerzeit mithilfe vom Tag

               if (month == 3 && day > 26) { // Wenn Monat gleich 3 und Tag groeßer gleich 26 --> Sommerzeit
                    System.out.print("Sommerzeit");
               }

               else if (month == 3 && day < 26) { // Wenn Monat gleich 3 und Tag kleiner 26 --> Winterzeit
                    System.out.print("Winterzeit");
               }

               else if (month == 10 && day < 29) { // Wenn Monat 10 und Tag kleiner 29 --> Sommerzeit
                    System.out.print("Sommerzeit");
               }

               else if (month == 10 && day > 29) { // Wenn Monat 10 und Tag groeßer gleich 29 --> Winterzeit
                    System.out.print("Winterzeit");
               }

               else if ((month == 3 && day == 26) || (month == 10 && day == 29)) { // Wenn Monat 3 und Tag 26 -->
                                                                                   // Schalttag oder wenn Monat 10 und
                                                                                   // Tag 29 --> Schalttag
                    System.out.print("Schalttag");
               }
          }
     }
}
