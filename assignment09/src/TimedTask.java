public class TimedTask extends Task {

    private Date deadline;

    /**
     * Creates a new TimedTask (which is not yet done) with the
     * specified title and deadline; the title string must not
     * be null (but can be empty)
     */
    public TimedTask(String title, Date deadline) {

        super(title);
        this.deadline = deadline;
    }

    /** returns the deadline of the task */
    public Date getDeadline() {

        return this.deadline;
    }

    /**
     * Returns the title of the task followed by a blank and the string
     * representation of the deadline enclosed in parenthesis; e.g.
     * "ExampleTask1 (2022-01-08)"
     */
    public String toString() {

        return getTitle() + " (" + this.deadline + ")";
    }
}
