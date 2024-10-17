class Fila {
    private Node front;
    private Node rear;

    public Fila() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(String pedido) {
        Node newNode = new Node(pedido);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("A fila está vazia.");
            return null;
        }
        String pedidoRemovido = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return pedidoRemovido;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("A fila está vazia.");
            return;
        }
        Node current = front;
        System.out.println("Pedidos Pendentes:");
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
