public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        queue<Integer> q1 = new queue<>();

        q1.enqueue(5);
        q1.enqueue(10);
        q1.enqueue(20);

        System.out.println(
                "q1 after enqueue of 3 elements:\n" + q1);
        q1.dequeue();
        System.out.println("q1 after dequeue :\n" + q1);

        queue<String> q2 = new queue<>();

        q2.enqueue("hello");
        q2.enqueue("world");
        q2.enqueue("GFG");

        System.out.println(
                "\nq2 after enqueue of 3 elements:\n" + q2);

        System.out.println("q2 front = " + q2.front()
                + ", q2 rear = " + q2.rear());

        queue<Float> q3 = new queue<>();

        System.out.println(
                "\nCreated new Float type queue q3...");

        System.out.println(
                "Checking if queue is empty or not :\n"
                        + q3.empty());
    }
}