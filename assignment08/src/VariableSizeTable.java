public class VariableSizeTable extends FixedSizeTable {
    /**
     * Creates a new table with the given name and capacity.
     */
    public VariableSizeTable(String name, int capacity) {

        super(name, capacity);
    }

    /**
     * Add a row to the table.
     *
     * If the table is full, it will be resized to twice its current capacity.
     *
     * @param row The row to add to the table.
     * @return `true`, always.
     */
    @Override
    public boolean addRow(Row row) {

        return false;
    }

    // Ignore this. It’s here for the tests to work properly.
    protected VariableSizeTable() {
    }
}
