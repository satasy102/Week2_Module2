public class MainTest {
    public static void main(String args[]) {

        Queue q = new Queue();
        q.front = q.rear = null;

        Solotion.enQueue(q, 10);
        Solotion.enQueue(q, 7);
        Solotion.displayQueue(q);

        Solotion.deQueue(q);
        Solotion.displayQueue(q);

        Solotion.enQueue(q, 40);
        Solotion.enQueue(q, 74);
        Solotion.enQueue(q, 0);
        Solotion.displayQueue(q);

        Solotion.deQueue(q);
        Solotion.displayQueue(q);

    }
}

