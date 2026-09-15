public class Bsp03 {
    public static void main(String[] args) {

        // -------------PART 1---------------

        int i = 0, x = 0, y = 0, z = 0; // i => schleifenvariable; x, z und y sind für das mitzählen der verschiedenen
                                        // Ausgaben

        // Eingabe der Versuche
        System.out.print("? Maximale Anzahl der Wuerfe: ");
        int versuche = SavitchIn.readLineInt();

        // Schleife für die so oft durchlaufen wird wie es Versuche gibt
        while (i < versuche) {

            // zufällige Zahlen für Würfel eins und zwei werden mit der Methode rollDie()
            // generiert
            int dice1 = rollDie();
            int dice2 = rollDie();

            // if-else verzweigungen für die verschiedenen Fälle die beim Würfeln eintreten
            // können: eine 1 gewürfelt, zwei 1en gewürfelt und keine 1 gewürfelt
            if (hasSingleOne(dice1, dice2) == true) {

                x++;
                System.out.println("(" + dice1 + "," + dice2 + ") Einfache 1 (keine Punkte) #" + x);

            } else if ((hasDoubleOne(dice1, dice2) == true)) {

                y++;
                System.out.println("(" + dice1 + "," + dice2 + ") Doppelte 1 (Ruecksetzung) #" + y);

            } else {

                z++;
                System.out.println("(" + dice1 + "," + dice2 + ") Punkte #" + z);

            }

            i++;

        }

        // ------------------PART 2--------------------

        System.out.println();

        // Eingabe der Spieleranzahl
        System.out.print("? Anzahl der Spieler:innen: ");
        int a = SavitchIn.readLineInt();

        // Weitergabe der Spieleranzahl an die Methode pig()
        pig(a);

    }

    // PART 1
    // Computes a random number between 1 and 6.
    public static int rollDie() {

        return (PRNG.randomInt(6) + 1); // Die class PRNG und dessen Methode randomInt generieren eine Zahl zwischen 1
                                        // und 6 und diese wird zurückgeben von rollDie()
                                        // Methode randomiInt muss mit +1 gerechnet werden da die generierte Zahl bei 0
                                        // beginnt
    }

    // Returns whether exactly one of d1 or d2 (but not both!) is equal to 1.
    public static boolean hasSingleOne(int d1, int d2) {

        if (d1 == 1 && d2 != 1 || d1 != 1 && d2 == 1) {

            return true;

        } else {

            return false;

        }

    }

    // Returns whether both d1 and d2 are each equal to 1.
    public static boolean hasDoubleOne(int d1, int d2) {

        if (d1 == 1 && d2 == 1) {

            return true;

        } else {

            return false;

        }
    }

    // PART 2
    // Simulate the game Pig for `n` players; note that
    // `n` is always >= 1.
    public static int pig(int n) {

        // gewWuerfe => Würfe von Gewinner, gewPlayer => Gewinner, gewSum => Höchste
        // Punktezahl
        // spieler => Schleifenvariable, sum => Summe nach jedem versuch

        int spieler = 1, sum = 0, wuerfe = 0, playerSum = 0, gewWuerfe = 0, gewPlayer = 0, gewSum = 0;

        // While schleife für die Spieleranzahl
        while (spieler <= n) {

            System.out.println("##### Spieler:in: " + (spieler));

            boolean eins = true; // nach Spielerwechsel muss die Variable eins wieder auf true damit die while
                                 // schleife wieder betreten werden kann

            // While schleife für die Solange durchlaufen wird bis man mindestens eine eins
            // Würfelt
            while (eins == true) {

                wuerfe++;

                // generiert mit der Methode rollDie() zwei Würfelzahlen
                int dice3 = rollDie();
                int dice4 = rollDie();

                if (hasSingleOne(dice3, dice4) == true) { // Nächster spieler kommt bei einer eins dran: punkte bleiben
                                                          // gleich

                    eins = false;
                    System.out.println(wuerfe + ". Wurf: (" + dice3 + "," + dice4 + ") | " + playerSum);

                } else if ((hasDoubleOne(dice3, dice4) == true)) { // zwei einse: Punkte werden gelöscht => nächster
                                                                   // Spieler

                    playerSum = 0;
                    eins = false;
                    System.out.println(wuerfe + ". Wurf: (" + dice3 + "," + dice4 + ") | " + playerSum);

                } else {

                    sum = dice3 + dice4;
                    playerSum += sum;
                    System.out.println(wuerfe + ". Wurf: (" + dice3 + "," + dice4 + ") | " + playerSum);

                }

            }

            // Sobald jemand die gleiche Gesamtpunktzahl (gleich damit bei gleiche
            // Punktezahl der letzte Spieler gewinnt) oder eine höhere als die davor hat
            // werden die Variablen unten überschrieben
            if (gewSum <= playerSum) {

                gewPlayer = spieler;
                gewWuerfe = wuerfe;
                gewSum = playerSum;

            }

            spieler++;
            wuerfe = 0; // Wuerfe reset
            playerSum = 0; // Gesamtzahl für nächsten Spieler reset
        }

        System.out.println("##### Gewinner:in: Spieler:in " + gewPlayer);
        System.out.println("##### Anzahl der Wuerfe: " + gewWuerfe);
        System.out.print("##### Maximale Punktezahl: " + gewSum);

        return gewSum;

    }
}
