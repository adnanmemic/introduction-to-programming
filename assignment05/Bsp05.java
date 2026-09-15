public class Bsp05 {
    public static void main(String[] args) {

        System.out.println("Alle Primzahlen <= n");
        System.out.print("?n: ");
        int zahl = SavitchIn.readLineInt();

        boolean[] z = new boolean[zahl];

        System.out.println("Alle Primzahlen <= " + zahl);

        z = firstPrimes(zahl);

        int primzahlen = printFirstPrimes(z);

        System.out.println();
        System.out.println("Insgesamt: " + primzahlen + " Primzahlen <= " + zahl);

        System.out.println();
        System.out.print("?Iterationen: ");
        int iteration = SavitchIn.readLineInt();
        System.out.println("Zahl -> nächstliegende Primzahl");

        for (int k = 0; k < iteration; k++) {

            int random = PRNG.randomInt(zahl) - 1;
            closestPrime(z, random);

        }

    }

    /**
     * Checks whether a number is prime.
     * 
     * @return true if n is positive and prime, false otherwise.
     */
    public static boolean isPrime(int n) {

        int x = 0;

        for (int i = 1; i <= n; i++) {

            if (n % i == 0) {

                x++;

            }

        }

        if (x > 2 || n == 0 || n == 1 || n < 0) {

            return false;

        } else {

            return true;

        }

    }

    /**
     * Checks which natural numbers from 0 to n are primes
     * 
     * @param n maximum number to check
     * @return array with n+1 elements with value true at index i if i is a prime
     *         and false otherwise
     */
    public static boolean[] firstPrimes(int n) {

        boolean[] prim = new boolean[n + 1];

        for (int i = 0; i < prim.length; i++) {

            if (isPrime(i) == true) {

                prim[i] = true;

            } else {

                prim[i] = false;

            }

        }

        return prim;
    }

    /**
     * Prints prime numbers
     * 
     * @param firstPrimes array indicating which numbers are prime
     * @return number of primes in the array
     */
    public static int printFirstPrimes(boolean[] firstPrimes) {

        int numbers = 0;
        for (int i = 0; i < firstPrimes.length; i++) {

            if (firstPrimes[i] == true) {

                System.out.print(i + " ");
                numbers++;

            }

        }

        return numbers;
    }

    /**
     * Finds the prime number closest to m.
     * 
     * That is, the smallest prime number bigger than m or the biggest
     * prime number smaller than m, whichever is closest to m. If both
     * are equally distanced from m, return the *smaller* value.
     * 
     * @param firstPrimes array indicating which numbers are prime and which not
     * @param m           index into array
     * @return as above, or -1 if m is not an index in firstPrimes or there's no
     *         prime there
     */
    public static int closestPrime(boolean[] firstPrimes, int m) {

        int naechste = 0;
        int hoeher = m;
        int kleiner = m;

        if (m >= firstPrimes.length || m < 0) {

            return -1;

        }

        else {

            if (firstPrimes[m]) {

                System.out.println(m + " -> " + m);
                naechste = m;

            } else {

                while (hoeher < firstPrimes.length && kleiner >= 0) {

                    if (firstPrimes[kleiner]) {

                        System.out.println(m + " -> " + kleiner);
                        naechste = kleiner;
                        break;

                    }

                    else if (firstPrimes[hoeher]) {

                        System.out.println(m + " -> " + hoeher);
                        naechste = hoeher;
                        break;

                    }
                    kleiner--;

                    hoeher++;
                }

            }

        }
        return naechste;
    }

}
