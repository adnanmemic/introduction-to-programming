import java.util.Arrays;

public class TaskList {
    private int capacity;
    final Task[] tasks;

    /**
     * creates a new TaskList with the given maximum capacity;
     * if capacity is smaller than zero, the capacity is set to 0
     */
    public TaskList(int capacity) {

        if (capacity < 0) {

            this.capacity = 0;
        } else {

            this.capacity = capacity;
        }

        this.tasks = new Task[capacity];
    }

    /**
     * returns the maximum capacity
     */
    public int getCapacity() {

        return this.capacity;
    }

    /**
     * returns the number of actual (non-null) Task objects managed by the tasks
     * array
     */
    public int getCount() {

        int counter = 0;

        for (int i = 0; i < tasks.length; i++) {

            if (tasks[i] != null) {

                counter++;
            }
        }

        return counter;
    }

    /**
     * Adds the given task to the tasks array at the first free position;
     * returns true if the task was added successfully; otherwise returns false
     * (i.e., the list has already reached the maximum capacity, or another task
     * with the same title already exists, or task is `null` or the task's title
     * is `null`)
     */
    public boolean addTask(Task task) {

        for (int i = 0; i < tasks.length; i++) {

            if ((tasks[i] != null && tasks[i].getTitle().equals(task.getTitle())) || getCount() == capacity
                    || task == null || task.getTitle() == null) {

                return false;
            }
            if (tasks[i] == null) {

                tasks[i] = task;
                return true;
            }
        }

        return false;
    }

    /**
     * adds a newly created `Task` with the given title to the tasks array at
     * the first free position; returns the created task if the task was added
     * successfully; otherwise returns null (i.e., the list has already reached
     * the maximum capacity, or another task with the same title already exists,
     * or the title is `null`)
     */
    public Task addTask(String title) {

        for (int i = 0; i < tasks.length; i++) {

            if ((tasks[i] != null && tasks[i].getTitle().equals(title)) || getCount() == this.capacity
                    || title == null) {

                return null;
            }
            if (tasks[i] == null) {

                tasks[i] = new Task(title);
                return tasks[i];
            }
        }

        return null;
    }

    /**
     * adds all given tasks to the tasks array (the order is retained; every
     * task is added at the first free position); returns true if all the tasks
     * were added successfully; otherwise returns false
     * (see `addTask(Task task)`)
     */
    public boolean addTasks(Task[] tasks) {

        for (int i = 0; i < this.tasks.length; i++) {

            if (getCount() == this.capacity) {

                return false;
            }

            for (int a = 0; a < tasks.length; a++) {

                if (this.tasks[a] == null) {

                    this.tasks[a] = tasks[i];
                    break;
                }
            }
        }

        return true;
    }

    /**
     * returns the task with the specified title, or `null` if no such task
     * was found
     */
    public Task getTask(String title) {

        for (int i = 0; i < this.tasks.length; i++) {

            if (this.tasks[i] != null && this.tasks[i].getTitle().equals(title)) {

                return this.tasks[i];
            }
        }

        return null;
    }

    /**
     * returns the task at the specified index in the tasks array;
     * returns null if there is no task at this index, or the index is invalid
     * (i.e., out-of-bounds).
     */
    public Task getTask(int idx) {

        if (idx >= 0 && idx < this.tasks.length && this.tasks[idx] != null) {

            return this.tasks[idx];
        } else {

            return null;
        }
    }

    /**
     * prints the string representation (as obtained by `toString()`) of all
     * tasks in the order of the tasks array; null-values are ignored. Tasks
     * that are marked as done are only printed if `includeDone` is `true`
     */
    public void printTasks(boolean includeDone) {

        for (int i = 0; i < this.tasks.length; i++) {

            if (this.tasks[i] != null && (!this.tasks[i].isDone() || includeDone)) {

                System.out.println(this.tasks[i]);
            }
        }
    }

    /**
     * returns all elements in the array tasks (including null) as a list in
     * [...] (see example):
     * [task0, task1, null, ....]
     */
    public String toString() {

        return Arrays.toString(tasks);
    }

    /**
     * removes the task with the given title; returns the removed task or null
     * if no task with that title was found
     */
    public Task removeTask(String title) {

        for (int i = 0; i < this.tasks.length; i++) {

            if (this.tasks[i] != null && this.tasks[i].getTitle().equals(title)) {

                Task removedTask = this.tasks[i];
                this.tasks[i] = null;
                return removedTask;
            }
        }
        return null;
    }

    /**
     * returns a `TaskList` that contains all tasks which are not yet done
     * (in the original order);
     *
     * if the task is a `TimedTask` it is only part of
     * the returned list, if its deadline has not yet passed;
     *
     * the capacity of the returned list must be equal to the number of tasks in the
     * list (i.e.
     * it must not contain `null` values).
     */
    public TaskList getTODOsDueUntil(Date deadline) {
        TaskList newList = new TaskList(getCount() - 1);

        for (int i = 0; i < this.tasks.length; i++) {

            if (this.tasks[i] != null && !this.tasks[i].isDone()) {

                if (tasks[i] instanceof TimedTask) {

                    TimedTask timedTask = (TimedTask) this.tasks[i];

                    if (timedTask.getDeadline() != null && timedTask.getDeadline().compareTo(deadline) <= 0
                            && timedTask != null) {

                        newList.addTask(timedTask);
                    }

                } else if (this.tasks[i] != null) {

                    newList.addTask(tasks[i]);
                }
            }
        }

        return newList;
    }

    /**
     * changes the tasks array to a compact representation by avoiding null
     * values between individual tasks; this is achieved by shifting tasks to
     * the leftmost free position while retaining the order of tasks; returns
     * true only if at least one task changed its position
     */
    public boolean compact() {

        boolean moved = false;
        int counter = 0;
        for (int i = 0; i < this.tasks.length; i++) {

            if (this.tasks[i] != null) {

                if (i != counter) {

                    this.tasks[counter] = this.tasks[i];
                    this.tasks[i] = null;
                    moved = true;
                }
                counter++;
            }
        }
        return moved;
    }
}
