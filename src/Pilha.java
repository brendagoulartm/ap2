class Pilha {
    private Node top;

    public Pilha() {
        this.top = null;
    }

    public void push(String pedido) {
        Node newNode = new Node(pedido);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia.");
            return null;
        }
        String pedidoRemovido = top.data;
        top = top.next;
        return pedidoRemovido;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia.");
            return;
        }
        Node current = top;
        System.out.println("Pedidos Cancelados (do mais recente ao mais antigo):");
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
