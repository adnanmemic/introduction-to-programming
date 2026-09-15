public class Bsp06 {
    public static void main(String[] args) {

        // Main Method only for testing of the other Methods
        // SearchPattern
        char[] dnaEingabe = new char[] { 'A', 'G', 'A', 'C', 'G', 'A', 'G', 'C' };
        char[] patternEingabe = new char[] { 'G', 'C' };

        // Wilcard-Method
        char[] wildcard = new char[] { 'C', '*', 'A' };

        // Promoter Terminator
        char[] dna2 = new char[] { 'G', 'T', 'C', 'T', 'A', 'T', 'C', 'C', 'A', 'T', 'A', 'G' };
        char[] prom = new char[] { 'C', '*', 'A' };
        char[] term = new char[] { 'T', '*', 'G' };

        // Output Searchpattern
        System.out.print("DNA: [");

        for (int i = 0; i < dnaEingabe.length; i++) {

            System.out.print(dnaEingabe[i]);

            if (i < dnaEingabe.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
        System.out.print("Pattern: [");

        for (int i = 0; i < patternEingabe.length; i++) {

            System.out.print(patternEingabe[i]);

            if (i < patternEingabe.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        int Ausgabe1 = searchPattern(patternEingabe, dnaEingabe);

        System.out.println("Match position = " + Ausgabe1);

        // create random BaseSequence
        System.out.println();
        char[] randomSequence = createSequence(10);
        System.out.println(randomSequence);

        // Number of Pattern in one DNA
        System.out.println();
        System.out.println("Match count: " + getNumberOfMatches(patternEingabe, randomSequence));

        // cutTailAt
        System.out.println();
        System.out.println(cutTailAt(Ausgabe1, dnaEingabe));

        // Wildcardpattern
        System.out.println();
        System.out.println(searchWildCardPattern(wildcard, dnaEingabe));

        // Promoter Terminator
        System.out.println();
        System.out.println(searchGeneSequence(prom, term, dna2));

    }

    /**
     * Searches the first occurrence of a pattern in the DNA.
     *
     * @param pattern the pattern to be searched
     * @param dna     the DNA sequence
     *
     * @return the position of the first character of the first pattern
     *         found in the DNA; -1, if pattern is not found
     */
    public static int searchPattern(char[] pattern, char[] dna) {

        int b = 0, sameChar = 0;
        while (b <= dna.length - pattern.length) {

            sameChar = 0;

            for (int i = 0; i < pattern.length; i++) {

                if (pattern[i] == dna[i + b])

                    sameChar++;

            }

            if (sameChar == pattern.length)
                return b;

            b++;
        }

        return -1;
    }

    /**
     * Returns a random base sequence of given length.
     *
     * @return a random base sequence (containing the four DNA bases)
     */
    public static char[] createSequence(int length) {

        char[] base = { 'A', 'C', 'G', 'T' };
        char[] random = new char[length];

        for (int i = 0; i < length; i++) {

            random[i] = base[PRNG.randomInt(4)];

        }

        return random;
    }

    /**
     * Returns the number of occurrences of a pattern in the DNA.
     *
     * @param pattern the pattern to be searched
     * @param dna     the DNA sequence
     *
     * @return the number of occurrences
     */
    public static int getNumberOfMatches(char[] pattern, char[] dna) {

        int b = 0, sameChar = 0, number = 0;
        while (b <= dna.length - pattern.length) {

            sameChar = 0;

            for (int i = 0; i < pattern.length; i++) {

                if (pattern[i] == dna[i + b])

                    sameChar++;

            }

            if (sameChar == pattern.length)

                number++;

            b++;
        }

        return number; // TODO: implement;
    }

    /**
     * Returns the remainder (tail) of the array from the given position.
     *
     * @return the tail array (index 0 is at position 'pos' of 'sequence')
     */
    public static char[] cutTailAt(int pos, char[] sequence) {

        char[] tail = new char[sequence.length - pos];

        if (sequence.length - pos < 0) {

            return null;

        }

        for (int i = 0; i < tail.length; i++) {

            tail[i] = sequence[pos + i];

        }

        return tail;
    }

    // =========================================================================
    // Part 2
    // =========================================================================

    /**
     * Searches the first occurrence of a wildcard pattern in the DNA.
     *
     * The wildcard pattern may include the wildcard character '*', which
     * matches any base.
     *
     * @param pattern the wildcard pattern to be searched
     * @param dna     the DNA sequence
     *
     * @return the position of the first character of the first wildcard
     *         pattern found in the DNA; -1, if pattern is not found
     */
    public static int searchWildCardPattern(char[] pattern, char[] dna) {

        int b = 0, sameChar = 0;
        while (b <= dna.length - pattern.length) {

            sameChar = 0;
            for (int i = 0; i < pattern.length; i++) {

                if (pattern[i] == dna[i + b] || pattern[i] == '*')

                    sameChar++;

            }

            if (sameChar == pattern.length)
                return b;

            b++;
        }

        return -1;
    }

    /**
     * Searches the first gene sequence in the DNA with the given promoter
     * and terminator.
     *
     * @param promoter   the start wildcard pattern of a gene
     * @param terminator the end wildcard pattern of a gene
     *
     * @return the gene sequence between promoter and terminator (may be
     *         empty); null, if promoter or terminator not found
     */
    public static char[] searchGeneSequence(char[] promoter, char[] terminator, char[] dna) {

        // Beginn des gens
        char[] cutPromoter, gene;
        int start = searchWildCardPattern(promoter, dna);

        if (start < 0) {

            return null;

        }

        cutPromoter = cutTailAt(promoter.length + start, dna); // Diese Methode dient um den Promoterteil wegzuschneiden
                                                               // damit das gen an der nicht abgeschnittenen ersten
                                                               // Stelle beginnt

        // Ende vom gen
        int end = searchWildCardPattern(terminator, cutPromoter);

        if (end < 0) {

            return null;

        }

        // Werte zuweisung vom Genarray
        gene = new char[end];

        for (int i = 0; i < end; i++) {

            gene[i] = cutPromoter[i];

        }

        return gene;
    }
}