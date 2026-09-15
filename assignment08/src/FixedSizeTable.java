import java.util.Arrays;

public class FixedSizeTable extends Table {
    private int capacity;
    private int size;
    private Row[] rows;

    /**
     * Create a new fixed-size table.
     *
     * @param name     The name of the table
     * @param capacity How many rows this table should store.
     */
    public FixedSizeTable(String name, int capacity) {

        super(name);
        this.capacity = capacity;
        this.rows = new Row[capacity];

        for (int i = 0; i < capacity; i++) {

            this.rows[i] = null;
        }
    }

    /**
     * Returns the capacity of the table.
     */
    public int getCapacity() {

        return this.capacity;
    }

    /**
     * Returns the number of rows stored in the table.
     */
    public int getSize() {

        return this.size;
    }

    /**
     * Returns the rows stored in the table.
     */
    public Row[] getRows() {

        return this.rows;
    }

    /**
     * Sets the number of rows stored in the table.
     */
    public void setSize(int size) {

        this.size = size;
    }

    /**
     * Returns the row at the given index.
     *
     * @param index The index of the row to return.
     * @return The row at the given index or null if the index is out of bounds.
     */
    public Row getRow(int index) {

        if ((index < 0) || (index >= this.capacity)) {

            return null;
        }

        return rows[index];
    }

    /**
     * Sets the row at the given index.
     *
     * @param index The index of the row to set.
     * @param row   The new value of the row.
     * @return true if the row was set, false otherwise, including if the index
     *         is out of bounds.
     */
    public boolean setRow(int index, Row row) {

        if ((index < 0) || (index >= this.rows.length)) {

            return false;
        }

        this.rows[index] = row;
        return true;
    }

    /**
     * Resizes the table.
     *
     * If the new size is smaller than the old size, the table is truncated,
     * i.e. all rows with an index >= capacity are deleted; if the new size
     * is larger than the old size, the table is extended by adding new rows
     * that are initialized with `null`.
     *
     * @param capacity The new capacity of the table.
     * @return The new capacity of the table.
     */
    public int resize(int capacity) {

        if (capacity == this.capacity) {

            return this.capacity;
        }

        if (this.capacity < capacity) {

            rows = Arrays.copyOf(rows, capacity);
        } else {

            rows = Arrays.copyOf(rows, capacity);
        }

        this.capacity = capacity;

        return this.capacity;
    }

    /**
     * Adds a row to the table.
     *
     * @param row The row to add.
     * @return true if the row was added, false otherwise, i.e. if the table
     *         is full.
     */
    public boolean addRow(Row row) {

        if (this.size < this.capacity) {

            rows[size++] = row;
            return true;
        } else {

            return false;
        }
    }

    /**
     * Returns the maximum dimension amongst rows in the table.
     *
     * The dimension of a `null` row is 0.
     */
    public int getMaxDimension() {
        int dimension = 0, maxDimension = 0;

        for (int i = 0; i < capacity; i++) {

            if (this.rows[i] != null) {

                dimension = this.rows[i].getDimension();
            }
            if (dimension > maxDimension) {

                maxDimension = dimension;
            }
        }

        return maxDimension;
    }

    /**
     * Returns the average of each row.
     *
     * Empty (i.e. NaN) values are excluded from the calculation entirely.
     *
     * @return If the table is not empty, a new array containing the
     *         average of each row or 0 if a row is `null`. If the table is empty,
     *         `null` is returned.
     */
    public double[] getRowAverages() {

        if (this.rows == null || this.rows.length == 0) {

            return null;
        }

        double[] rowAverages = new double[this.rows.length];

        for (int i = 0; i < this.rows.length; i++) {

            if (this.rows[i] == null) {

                rowAverages[i] = 0;
            } else {

                rowAverages[i] = this.rows[i].getAverage();
            }
        }

        return rowAverages;
    }

    /**
     * Returns the average of each column.
     *
     * Empty (i.e. NaN) values are excluded from the calculation entirely.
     *
     * @return If the table is not empty, a new array containing the
     *         average of each column or 0 if a row is `null`. If the table
     *         is empty, `null` is returned.
     */
    public double[] getColumnAverages() {
        if (this.rows == null || this.rows.length == 0) {

            return null;
        }

        double[] columnAverage = new double[getMaxDimension()];
        double[] row2 = new double[capacity];

        for (int i = 0; i < columnAverage.length; i++) {

            for (int j = 0; j < row2.length; j++) {

                row2[j] = rows[j].getValue(i); // zeilen werden abgearbeitet während getValue gleich bleibt praktisch
                                               // ist das die Spalte
            }

            Row gesamt = new Row(row2.length);
            gesamt.setValues(row2);
            columnAverage[i] = gesamt.getAverage();
        }
        return columnAverage;

    }

    /**
     * Returns a string representation of the table.
     */
    @Override
    public String toString() {
        return null;
    }

    // Ignore this. It’s here for the tests to work properly.
    protected FixedSizeTable() {
    }
}
