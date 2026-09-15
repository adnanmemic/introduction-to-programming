public class Bsp04 {
    public static void main(String[] args) {

        String password; // password dient als String hilfsvariable zum weitergeben des Passwortes

        password = createPassword();

        System.out.println();

        // Alle Bedingungen passen
        if (fitFirstCharacter(password) == true && minLength(password, 8) == true && minUpperCase(password, 2) == true
                && minLowerCase(password, 2) == true && minDigit(password, 2) == true && minSpecial(password, 1) == true
                && isolatedSpecial(password) == true) {

            System.out.println("Passwort gültig.");

        } else {
            // Zu kurzes Passwort
            if (minLength(password, 8) == false) {

                System.out.println("Passwort zu kurz!");

            }
            // Erstes Zeichen ist kein Buchstabe
            if (fitFirstCharacter(password) == false) {

                System.out.println("Erstes zeichen kein Buchstabe!");

            }
            // Zu wenige Großbuchstaben
            if (minUpperCase(password, 2) == false) {

                System.out.println("Zu wenige Großbuchstaben!");

            }
            // Zu wenige Kleinbuchstaben
            if (minLowerCase(password, 2) == false) {

                System.out.println("Zu wenige Kleinbuchstaben!");

            }
            // Zu wenige Ziffern
            if (minDigit(password, 2) == false) {

                System.out.println("Zu wenige Ziffern!");

            }
            // Zu wenige Sonderzeichen
            if (minSpecial(password, 1) == false) {

                System.out.println("Zu wenige Sonderzeichen!");

            }
            // Sonderzeichen nebeneinander
            if (isolatedSpecial(password) == false) {

                System.out.println("Sonderzeichen nebeneinander!");

            }

        }
    }

    // ============================= PART 1 =============================
    // Prompt the user for a password.
    public static String createPassword() {

        // String initialisierung
        String passwd = "", bestaetigung = "";

        // Schleife für erneute Eingabe falls Passwörter nicht übereinstimmen
        while (true) {

            // Erstes Passwort
            System.out.print("Passwort eingeben / stop für Abbruch: ");
            passwd = SavitchIn.readLine();
            // Eingabe: stop
            if (passwd.compareTo("stop") == 0) {

                System.out.println();
                System.out.println("Eingabe Abgebrochen!");
                passwd = ""; // bei Stop leeres String rückgabe

                break; // verlässt die Schleife

            }

            else {
                // Passwort bestätigen mittels Eingabe
                System.out.print("Passwort wiederholen: ");
                bestaetigung = SavitchIn.readLine();

            }
            // Bestätigung ist erfolgreich
            if (passwd.compareTo(bestaetigung) == 0) {

                break;

            }
            // Eingabe von stop in der Bestätigung: Abbruch
            else if (bestaetigung.compareTo("stop") == 0) {

                System.out.println();
                System.out.println("Eingabe Abgebrochen!");
                passwd = "";
                break;

            } else {

                System.out.println(" Verschieden - neuer Versuch");

            }

        }

        return passwd;

    }

    // Check whether `pwd` contains at least `min` characters.
    public static boolean minLength(String pwd, int min) {

        if (pwd.length() >= min) {

            return true;

        } else {

            return false;

        }

        // Character.isLetter(pwd.charAt(0))
    }

    // Check whether the first character of `pwd` is a letter.
    public static boolean fitFirstCharacter(String pwd) {

        char k = pwd.charAt(0);

        if ((k >= 'A' && k <= 'Z') || (k >= 'a' && k <= 'z')) { // Die null dient dazu um das erste Zeichen des
                                                                // Passwortes zu überprüfen

            return true;

        } else {

            return false;

        }

    }

    // ============================= PART 2 =============================
    // Check whether `pwd` contains at least `min` uppercase characters.
    public static boolean minUpperCase(String pwd, int min) {

        int i = 0, upper = 0; // i ist die Hilfsvariable und zugleich die aktuelle Stelle vom Passwort, upper
                              // ist die Anzahl an Großbuchstaben

        // Schleife wird so oft durchlaufen wie das Passwort lang ist
        while (i < pwd.length()) {

            char k = pwd.charAt(i); // Das i dient hier das bei jedem durch der nächste character geprüft wird
            if (k >= 'A' && k <= 'Z') // Variable k muss zwischen den Großbuchstaben A und K liegen

                upper++; // Anzahl der Großbuchstaben wird inkrementiert

            i++;

        }

        if (upper >= min) {

            return true;

        } else {

            return false;

        }
    }

    // Check whether `pwd` contains at least `min` lowercase characters.
    public static boolean minLowerCase(String pwd, int min) {

        int i = 0, lower = 0; // lower: Anzahl an Kleinbuchstaben

        while (i < pwd.length()) {

            char k = pwd.charAt(i);
            if (k >= 'a' && k <= 'z') // character k muss zwischen a und z sein

                lower++;

            i++;

        }

        if (lower >= min) {

            return true;

        } else {

            return false;

        }
    }

    // Check whether `pwd` contains at least `min` digits.
    public static boolean minDigit(String pwd, int min) {

        int i = 0, digits = 0; // digits: Anzahl der Ziffern

        while (i < pwd.length()) {

            char k = pwd.charAt(i);
            if (k >= '0' && k <= '9') // character muss zwischrn 1 und 9 sein

                digits++;

            i++;

        }

        if (digits >= min) {

            return true;

        } else {

            return false;

        }

    }

    // Check whether `pwd` contains at least `min` of any of the following
    // characters (in any combination):
    //
    // ! " # % & ' ( ) * + , - . / @
    //
    public static boolean minSpecial(String pwd, int min) {

        int i = 0, special = 0; // special: Anzahl der Sonderzeichen

        while (i < pwd.length()) {

            char k = pwd.charAt(i);
            if ((k >= '!' && k <= '#') || (k >= '%' && k <= '/') || k == '@') // die Zeichen befinden sich nicht alle
                                                                              // nebeneinander in der ascii-tabelle
                                                                              // deswegen mit "und" und "oder"

                special++;

            i++;

        }

        if (special >= min) {

            return true;

        } else {

            return false;

        }

    }

    // Check whether `pwd` contains only isolated special characters.
    public static boolean isolatedSpecial(String pwd) {

        // es werden hier immer die zwei characters nebeneinander verglichen ob beide
        // Sonderzeichen sind
        int i = 0, z = 1; // i: Hilfsvariable der 1ten Schleife, z: Hilfsvariable der zweiten, isolated

        boolean erste = false, zweite = false; // dienen zur überprüfung ob eine der beiden stellen ein Sonderzeichen
                                               // enthält

        // Schleifenvariable ist z weil es um 1 größer ist als i und deswegen als ersten
        // den letzten Character des Passwortes erreicht
        while (z < (pwd.length())) {

            // müssen jedes mal erneut auf false gesetzt werden sonst bleiben die durchgehen
            // auf true
            erste = false;
            zweite = false;

            char k = pwd.charAt(i);
            char k1 = pwd.charAt(z);
            // Schleifen zur überprüfung der beiden Stellen
            if ((k >= '!' && k <= '#') || (k >= '%' && k <= '/') || k == '@') {

                erste = true;

            }

            if ((k1 >= '!' && k1 <= '#') || (k1 >= '%' && k1 <= '/') || k1 == '@') {

                zweite = true;

            }
            // wenn nur einer der beiden Stellen ein Sonderzeichen läuft die Schleife weiter
            // ansonstensten nicht mittels break
            if (erste == true && zweite == true) {

                break;

            }

            i++;
            z++;

        }

        if (erste == true && zweite == true) {

            return false;

        } else {

            return true;

        }

    }
}
