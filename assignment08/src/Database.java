public class Database {
    /**
     * Create a new database with the given capacity.
     */
    public Database(int capacity) {
        // TODO: implement.
    }

    /**
     * Return the tables in this database.
     */
    public VariableSizeTable[] getTables() {

        return null; // TODO: implement.
    }

    /**
     * Return the capacity of this database.
     */
    public int getCapacity() {
        return -1; // TODO: implement.
    }

    /**
     * Return the number of tables in this database.
     */
    public int getSize() {
        return -1; // TODO: implement.
    }

    /**
     * Add the given table to this database.
     *
     * If the database is full, double the capacity of the database.
     *
     * @return the index of the table in this database.
     */
    public int addTable(VariableSizeTable table) {
        return -1; // TODO: implement.
    }

    /**
     * Find a table by name.
     *
     * @return the table with the given name, or null if no such table exists.
     */
    public VariableSizeTable findTable(final String name) {
        return null; // TODO: implement.
    }

    /**
     * Compute the union of two tables.
     *
     * Find two tables A and B by name and combine them into a new table. The
     * capacity of the resulting table is the sum of the capacities of A and B,
     * and the *values* of A and B are copied into the new table; i.e. a *new*
     * row is created for each row in A and B, and the values of the old rows
     * are copied into the new rows. The size of each of the new rows is the
     * maximum size amongst all rows in A and B.
     *
     * @param nameA     the name of the first table.
     * @param nameB     the name of the second table.
     * @param nameUnion the name of the new table.
     * @return the union table of A and B, or `null` if either table does
     *         not exist.
     */
    public VariableSizeTable union(String nameA, String nameB, String nameUnion) {
        return null; // TODO: implement.
    }

    /**
     * Return a string representation of this database.
     */
    @Override
    public String toString() {
        return null; // TODO: implement.
    }
}
