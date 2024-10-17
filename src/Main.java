import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cria a fila de pedidos pendentes e a pilha de pedidos cancelados
        Fila filaPedidos = new Fila();
        Pilha pilhaCancelados = new Pilha();

        // Loop do sistema de gerenciamento
        int opcao;
        do {
            System.out.println("\n=== Sistema de Gerenciamento de Pedidos ===");
            System.out.println("1. Adicionar Novo Pedido");
            System.out.println("2. Atender Pedido");
            System.out.println("3. Cancelar Pedido");
            System.out.println("4. Restaurar Pedido Cancelado");
            System.out.println("5. Exibir Pedidos Pendentes");
            System.out.println("6. Exibir Pedidos Cancelados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar buffer

            switch (opcao) {
                case 1:  // Adicionar Novo Pedido
                    System.out.print("Informe a descrição do pedido: ");
                    String descricao = scanner.nextLine();
                    filaPedidos.enqueue(descricao);
                    System.out.println("Pedido adicionado: " + descricao);
                    break;

                case 2:  // Atender Pedido
                    String pedidoAtendido = filaPedidos.dequeue();
                    if (pedidoAtendido != null) {
                        System.out.println("Pedido atendido: " + pedidoAtendido);
                    }
                    break;

                case 3:  // Cancelar Pedido
                    String pedidoCancelado = filaPedidos.dequeue();
                    if (pedidoCancelado != null) {
                        pilhaCancelados.push(pedidoCancelado);
                        System.out.println("Pedido cancelado: " + pedidoCancelado);
                    }
                    break;

                case 4:  // Restaurar Pedido Cancelado
                    String pedidoRestaurado = pilhaCancelados.pop();
                    if (pedidoRestaurado != null) {
                        filaPedidos.enqueue(pedidoRestaurado);
                        System.out.println("Pedido restaurado: " + pedidoRestaurado);
                    }
                    break;

                case 5:  // Exibir Pedidos Pendentes
                    System.out.println("\nFila de Pedidos Pendentes:");
                    filaPedidos.printQueue();
                    break;

                case 6:  // Exibir Pedidos Cancelados
                    System.out.println("\nPilha de Pedidos Cancelados:");
                    pilhaCancelados.printStack();
                    break;

                case 0:  // Sair
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
