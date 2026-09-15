public class Bsp08 {

    public static void main(String[] args) {

        //Class Row
        Row row = new Row(5);

        // prints the dimension of our row and the row as specified by toString()
        // at this point, the row does not contain any value but only NaNs
        System.out.println("Dimensionen: " + row.getDimension());
        System.out.println(row);

        // changes the third and the fifth value to 4.24 and 5.25, respectively
        // succeeds, and thus prints true
        System.out.println(row.setValue(2, 4.24));
        System.out.println(row.setValue(4, 5.25));

        // tries to change the eighth value to 6.26 of our row
        // fails due to an invalid index, and thus prints false
        System.out.println(row.setValue(7, 6.26));

        // prints the row as specified by toString()
        System.out.println(row);

        // tries to retrieve and print the eighth value of our row
        // but fails due to an invalid index
        System.out.println(row.getValue(7));

        // tries to retrieve and print the second value of our row
        // but fails due to it being NaN
        System.out.println(row.getValue(1));

        // successfully retrieves and prints the third and fifth value
        // of our row, respectively
        System.out.println(row.getValue(2));
        System.out.println(row.getValue(4));

        // computes and prints the average of our row (excl. NaNs)
        System.out.println(row.getAverage());

        //Class Table

        //Absätze
        System.out.println();
        System.out.println();

        // creates a new table that is named "My Table"
        Table table = new Table("My Table");

        // prints the name of our table as specified by toString()
        System.out.println(table);

        // updates the name of our table to "Another Name"
        table.setName("Another Name");

        // prints the name of our table without curly braces
        System.out.println("Name per getName(): " + table.getName());

        // prints the name of our table as specified by toString()
        System.out.println(table);

        //Class FixedSizeTable

        //Absätze
        System.out.println();
        System.out.println();

        // creates a new fixed size table named "F1", which can hold up to five rows
        FixedSizeTable fst = new FixedSizeTable("F1", 5);

        // for reference, i.e., to check the behavior of the addRow() method
        int insertions = 0;
        // every row contains exactly ten values
        int dimension = 10;

        // inserts five rows into our fixed size table
        for (int i = 0; i < 5; ++i) {
            // creates a new Row object that can hold 10 values
            row = new Row(dimension);

            // assigns a random value to each entry in our Row object
            for (int j = 0; j < dimension; ++j) {
                row.setValue(j, PRNG.randomDouble());
            }

            // adds our Row object to our fixed size table and increments a counter for
            // every successful insertion (i.e., if we insert more than five rows, this
            // counter should stop at five).
            if (fst.addRow(row)) {
                ++insertions;
            }
        }

        // prints some statistics about our fixed size table
        System.out.println("Tabelle " + fst.getName() + ":");
        System.out.println("  * Erfolgreich eingefügte Einträge: " + insertions);
        System.out.println("  * Dimensionen: " + fst.getMaxDimension());
        System.out.println("  * Kapazität: " + fst.getCapacity());
        System.out.println("  * Größe: " + fst.getSize());
        System.out.println();

        // prints the second row (i.e., the corresponding Row object)
        System.out.println("Zeile 2: " + fst.getRow(1));
        System.out.println();

        // prints our fixed size table in its initial state, including how many entries
        // are used from the overall capacity in the format "<size> / <max. capacity>"
        System.out.println(fst);
        System.out.println(fst.getSize() + " / " + fst.getCapacity());
        System.out.println();

        // shrinks our fixed size table to store at most three rows, i.e., the last two
        // rows are lost in the process
        fst.resize(3);

        // prints our fixed size table after shrinking it
        System.out.println(fst);
        System.out.println(fst.getSize() + " / " + fst.getCapacity());
        System.out.println();

        // grows our fixed size table to store at most ten rows, i.e., there are seven
        // unused rows (i.e., they are null)
        fst.resize(10);

        // prints our fixed size table after growing it
        System.out.println(fst);
        System.out.println(fst.getSize() + " / " + fst.getCapacity());
        System.out.println();

        // shrinks our fixed size table to store at most eight rows, i.e., no rows
        // are lost in the process
        fst.resize(8);

        // prints our fixed size table after shrinking it again
        System.out.println(fst);
        System.out.println(fst.getSize() + " / " + fst.getCapacity());
        System.out.println();
        /*
        // prints the averages of all row of our fixed size table
        // Hint: import java.util.Arrays; and you are allowed to use Arrays.toString()
        System.out.println(Arrays.toString(fst.getRowAverages()));

        // prints the averages of all column of our fixed size table
        // Hint: import java.util.Arrays; and you are allowed to use Arrays.toString()
        System.out.println(Arrays.toString(fst.getColumnAverages()));
        */
    }
}
