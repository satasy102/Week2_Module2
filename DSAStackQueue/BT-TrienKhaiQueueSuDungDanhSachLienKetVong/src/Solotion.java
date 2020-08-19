public class Solotion {
    public static void enQueue(Queue  queue, int value){
        Node  temp = new Node();
        temp.data = value;
        if (queue.front == null) queue.front = queue.rear =temp;
        else queue.rear.link = temp;

        queue.rear = temp;
        queue.rear.link = queue.front;
    }

    public static void deQueue(Queue  queue){
        if(queue.front==null) System.out.print("Queue trong");
        else if(queue.front== queue.rear) queue.front = queue.rear =null;
        else {
            Node  temp = queue.front;
            queue.front = temp.link;
            queue.rear.link= queue.front;
        }
    }

    static void displayQueue( Queue queue){
        Node  temp = queue.front;
        System.out.print("\nGia tri trong vong lap Queue: ");
        while (temp .link != queue.front){
            System.out.printf("%d ", temp.data);
            temp = temp.link;
        }
        System.out.printf("%d", temp.data);
    }
}
