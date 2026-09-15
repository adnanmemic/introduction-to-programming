import java.util.Arrays;

public class Bsp09 {
    public static void main(String[] args) {

        Task t0 = new Task("ExampleTask0");
        Date deadline1 = Date.createDate(2024, 1, 31);
        Task t1 = new TimedTask("ExampleTask1", deadline1);

        System.out.println(t0); // outputs: ExampleTask0
        System.out.println(((TimedTask) t1).getDeadline()); // outputs: 2024-01-31
        System.out.println(t1); // outputs: ExampleTask1 (2024-01-31)

        TaskList tlist = new TaskList(5);
        tlist.addTask(t0); // returns true
        System.out.println(Arrays.toString(tlist.tasks)); // outputs: [ExampleTask0, null, null, null, null]
        tlist.addTask(t1); // returns: true
        Task t2 = tlist.addTask("ExampleTask2");
        System.out.println(tlist.getCount() + "/" + tlist.getCapacity()); // outputs: 3/5
        tlist.addTask("ExampleTask1"); // returns: false
        System.out.println(tlist.getCount() + "/" + tlist.getCapacity()); // outputs: 3/5
        System.out.println(tlist.getTask(0)); // outputs: ExampleTask0

        Date d2 = Date.createDate(2024, 2, 12);
        System.out.println(deadline1.compareTo(d2)); // outputs: -1 (or any other negative value)

        t0.setDone(true);
        tlist.printTasks(false); // outputs: ExampleTask1 (2024-01-31)\nExampleTask2
        TaskList todos = tlist.getTODOsDueUntil(deadline1);
        System.out.println(todos.getCapacity()); // outputs: 2

        System.out.println(Arrays.toString(tlist.tasks)); // outputs: [ExampleTask0, ExampleTask1 (2024-01-31),
                                                          // ExampleTask2, null, null]
        tlist.removeTask(t1.getTitle());
        System.out.println(Arrays.toString(tlist.tasks)); // outputs: [ExampleTask0, null, ExampleTask2, null, null]
        System.out.println(Arrays.toString(tlist.tasks)); // outputs: [ExampleTask0, ExampleTask3, ExampleTask2, null,
                                                          // null]
        tlist.removeTask(t0.getTitle());
        tlist.removeTask(t2.getTitle());
        System.out.println(Arrays.toString(tlist.tasks)); // outputs: [null, ExampleTask3, null, ExampleTask4, null]
        tlist.compact();
        System.out.println(Arrays.toString(tlist.tasks)); // outputs: [ExampleTask3, ExampleTask4, null, null, null]

    }
}
