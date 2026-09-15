public class Row {
    private int dimension;
    private double[] values;

    /**
     * Creates a new row.
     *
     * All entries are initially set to `Double.NaN`.
     *
     * @param dimension The number of elements of that this row contains.
     */
    public Row(int dimension) {

        this.dimension = dimension;
        this.values = new double[dimension];

        for (int i = 0; i < values.length; i++) {

            values[i] = Double.NaN;
        }
    }

    /**
     * Get the dimension of this row.
     */
    public int getDimension() {

        return this.dimension;
    }

    /**
     * Get the values stored in this row.
     */
    public double[] getValues() {

        return this.values; // TODO: implement.
    }

    /**
     * Set the values of this row.
     *
     * This replaces the entire array, not just its elements,
     */
    public void setValues(double[] values) {

        this.values = values;
    }

    /**
     * Get a value in this row.
     *
     * @param index The index of the value to get.
     * @return If the index is invalid (that is, negative or our of bounds),
     *         `Double.NaN`; otherwise, the value at that index (which may also be
     *         `Double.NaN`).
     */
    public double getValue(int index) {

        if (index < 0 || index >= values.length) {

            return Double.NaN;
        } else {

            return values[index];
        }
    }

    /**
     * Set a value in this row.
     *
     * @param index The index of the value to set.
     * @param value The value to set the element at that index to.
     * @return `false` if the index is invalid (that is, negative or our of
     *         bounds), or if the element at that index already has the value
     *         `value`;
     *         `true` otherwise.
     */
    public boolean setValue(int index, double value) {

        if ((index < 0) || (index >= values.length) || (Double.isNaN(value))) {

            return false;
        }
        if ((this.values[index] == value)) {

            return false;
        }
        this.values[index] = value;
        return true;
    }

    /**
     * Get the average of all values in this row.
     *
     * @return The arithmetic mean of all non-NaN entries in this row; note that
     *         NaN entries are to be excluded entirely; e.g. if a row has 10
     *         entries;
     *         only three of which—`a`,`b`, `c`—are not NaN, then this should return
     *         `(a + b + c) / 3`.
     */
    public double getAverage() {
        double arithmeticMiddle = 0;
        int number = 0;

        for (int i = 0; i < this.values.length; i++) {

            if (Double.isNaN(values[i])) {

            } else {

                arithmeticMiddle += this.values[i];
                number++;
            }
        }

        return arithmeticMiddle / (double) number;
    }

    /**
     * Convert a row to a string.
     */
    @Override
    public String toString() {
        String s = new String();
        double vs[] = getValues();

        s += "|";

        for (int i = 0; i < vs.length; ++i) {
            s += String.format(" %5.3f ", vs[i]);
            s += (i < vs.length ? "|" : "");
        }

        s += String.format(" %5.3f ", getAverage());
        s += "|";

        return s;
    }
}
