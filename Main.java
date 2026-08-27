import java.util.Scanner;

public class Main {

    // FUNÇÃO CORRETA
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

    // FUNÇÃO CORRETA
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

    // FUNÇÃO CORRETA
    public static void chamarCadastrarProduto(Scanner scanner, Loja loja) {
        String nomeProduto = "";
        String preco = "";
        String quantidade = "";
        
        while (nomeProduto.isEmpty()) {
            System.out.print("Digite o nome do produto: ");
            String nomeTemp = "";
            nomeTemp = scanner.nextLine().trim();
            if (nomeTemp.matches("^\\p{L}+$")) {
                nomeProduto = nomeTemp;
            } else {
                System.out.println("Digite apenas letras!");
            }
            System.out.println();
        }

        while (preco.isEmpty()) {
            System.out.print("Digite o preço do produto: ");
            String precoTemp = "";
            precoTemp = scanner.nextLine().trim();
            if (precoTemp.matches("^[+-]?(\\d+(\\.\\d*)?|\\.\\d+)([eE][+-]?\\d+)?$")) {
                preco = precoTemp;
            } else {
                System.out.println("Digite ume entrada válida somente com números!");
            }
            System.out.println();
        }

        while (quantidade.isEmpty()) {
            System.out.print("Digite a quantidade de produtos: ");
            String qntTemp = "";
            qntTemp = scanner.nextLine().trim();
            if (qntTemp.matches("^-?\\d+$")) {
                quantidade = qntTemp;
            } else {
                System.out.println("Digite uma quantidade válida somente com números!");
            }
            System.out.println();
        }

        loja.cadastrarProduto(nomeProduto, Double.parseDouble(preco), Integer.parseInt(quantidade));
    }

    // FUNÇÃO CORRETA
    public static void chamarCadastrarCliente(Scanner scanner, Loja loja) {
        String nomeCliente = "";

        while (nomeCliente.isEmpty()) {
            System.out.print("Digite o nome do cliente: ");
            String nomeTemp = scanner.nextLine().trim();
            if (nomeTemp.matches("^\\p{L}+$")) {
                nomeCliente = nomeTemp;
            } else {
                System.out.println("Digite apenas letras!");
            }
            System.out.println();
        }

        loja.cadastrarCliente(nomeCliente);
    }

    public static void chamarCriarVenda(Scanner scanner, Loja loja) {
        String nomeProduto = "";
        String quantidade = "";
        String nomeCliente = "";

        while (nomeProduto.isEmpty()) {
            System.out.print("Digite o nome do produto que deseja comprar:  ");
            String nomeTemp = scanner.nextLine().trim();
            if (nomeTemp.matches("^\\p{L}+$")) {
                nomeProduto = nomeTemp;
            } else {
                System.out.println("Digite um nome válido somente com letras!");
            }
            System.out.println();
        }

        while (quantidade.isEmpty()) {
            System.out.print("Digite a quantidade que deseja comprar: ");
            String qntTemp = scanner.nextLine().trim();
            if (qntTemp.matches("^-?\\d+$")) {
                quantidade = qntTemp;
            } else {
                System.out.println("Digite uma quantidade válida somente com números!");
            }
            System.out.println();
        }

        while (nomeCliente.isEmpty()) {
            System.out.print("Digite o nome do cliente: ");
            String nomeTemp = scanner.nextLine().trim();
            if (nomeTemp.matches("^\\p{L}+$")) {
                nomeCliente = nomeTemp;
            } else {
                System.out.println("Digite um nome válido somente com letras!");
            }
            System.out.println();
        }

        loja.criarVenda(nomeProduto, Integer.parseInt(quantidade), nomeCliente);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja();

        boolean logado = true;
        while (logado) {
            menu();

            int escolha = escolherOpcao(scanner);

            switch (escolha) {
                case 0 -> {
                    System.err.println("Progama fechando...");
                    logado = false;
                }
                case 1 -> { // CADASTRAR PRODUTO
                    System.out.println("Você escolheu a opção de cadastrar produto!\n");
                    chamarCadastrarProduto(scanner, loja);
                }
                case 2 -> { // CADASTRAR CLIENTE
                    System.out.println("Você escolheu a opção de cadastrar cliente!\n");
                    chamarCadastrarCliente(scanner, loja);
                }
                case 3 -> { // LISTAR PRODUTOS
                    System.out.println("Você escolheu a opção de listar produtos!\n");
                    loja.listarProdutos();
                }
                case 4 -> { // LISTAR CLIENTES
                    System.out.println("Você escolheu a opção de listar clientes!\n");
                    loja.listarClientes();
                }
                case 5 -> { // CRIAR VENDA
                    System.out.println("Você escolheu a opção de criar uma venda!\n");
                    chamarCriarVenda(scanner, loja);
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