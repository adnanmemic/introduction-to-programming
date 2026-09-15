public class Task {
    private String title;
    private boolean done;

    /**
     * Creates a new Task (which is not yet done) with the specified
     * title; the title string must not be null (but can be empty)
     */
    public Task(String title) {

        this.title = title;
        this.done = false;
    }

    /** returns the title of the task */
    public String getTitle() {

        return this.title;
    }

    /** returns true if the task is done already; otherwise returns false */
    public boolean isDone() {

        if (this.done) {

            return true;
        } else {

            return false;
        }
    }

    /** sets the 'done'-status of the task */
    public void setDone(boolean done) {

        this.done = done;

    }

    /** returns the title of the task */
    public String toString() {

        return this.title;
    }

    // Ignore this. It’s just here for the tests to work properly.
    protected Task() {
    }
}
