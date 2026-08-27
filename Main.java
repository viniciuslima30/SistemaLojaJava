import java.util.Scanner;

public class Main {

    // MÉTODO CORRETO
    public static void menu() {
        System.out.println("""
        ======== LOJA ========

        1 - Cadastrar produto
        2 - Cadastrar cliente
        3 - Listar produtos
        4 - Listar clientes
        5 - Criar venda
        6 - Ver vendas
        7 - Cancelar venda
        0 - Sair
        """);
    }

    // MÉTODO CORRETO
    public static int escolherOpcao(Scanner scanner) {
        String escolha = "";
        int escolhaInt = 0;

        System.out.print("Digite a opção de 0 a 7: ");
        while (escolha.isEmpty()) {
            escolha = scanner.nextLine().trim();
            try {
                escolhaInt = Integer.parseInt(escolha);
            } catch (NumberFormatException e) {
                System.out.print("Digite apenas números de 0 a 7: ");
                escolha = "";
            }
        }

        return escolhaInt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja();

        boolean logado = true;
        while (logado) {
            menu();

            int escolha = escolherOpcao(scanner);
            System.out.println(escolha);

            switch (escolha) {
                case 0 -> {
                    System.err.println("Progama fechando...");
                    logado = false;
                }
                case 1 -> { // CADASTRAR PRODUTO
                    loja.cadastrarProduto("Bola", 19.99, 20);
                }
                case 2 -> {
                    loja.cadastrarCliente("Vinicius");
                }
                case 3 -> {
                    loja.listarProdutos();
                }
                case 4 -> {
                    loja.listarClientes();
                }
                case 5 -> {
                    loja.criarVenda("Bola", 10, "Vinicius");
                }
                case 6 -> {
                    loja.verVendas();
                }
                case 7 -> {
                    loja.cancelarVenda("Vinicius");
                }
                default -> {
                    System.out.println("Escolha uma opção entre 0 e 7!");
                }
            }
        }
    }
}