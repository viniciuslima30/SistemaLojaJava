import java.util.ArrayList;
import java.util.UUID;

public class Loja {
    
    private ArrayList<Produto> listaDeProdutos = new ArrayList<>();
    private ArrayList<Cliente> listaDeClientes = new ArrayList<>();

    // MÉTODO AUXILIAR CORRETO

    public Produto procurarProduto(String nomeProduto) {
        Produto objProduto = null;
        
        for (Produto produto : listaDeProdutos) {
            if (nomeProduto.equalsIgnoreCase(produto.getNome())) {
                objProduto = produto;
                break;
            }
        }

        return objProduto;
    }

    public Cliente procurarCliente(String nomeCliente) {
        Cliente objCliente = null;

        for (Cliente cliente : listaDeClientes) {
            if (nomeCliente.equalsIgnoreCase(cliente.getNome())) {
                objCliente = cliente;
                break;
            }
        }

        return objCliente;
    }

    // MÉTODO CORRETO
    public void cadastrarProduto(String nome, double preco, int estoque) {
        Produto novoProduto = new Produto(nome, preco, estoque);
        listaDeProdutos.add(novoProduto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    // MÉTODO CORRETO
    public void cadastrarCliente(String nome) {
        UUID id = UUID.randomUUID();
        Cliente novoCliente = new Cliente(nome, id);
        listaDeClientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    // MÉTODO CORRETO
    public void listarProdutos() {
        int i = 0;
        for (Produto produto : listaDeProdutos) {
            System.out.println();
            System.out.printf("Produto número %d\n", i);
            System.out.println("Nome do produto: " + produto.getNome());
            System.out.println("Preço do produto: " + produto.getPreco());
            System.out.println("Estoque do produto: " + produto.getEstoque());
            System.out.println();
            i++;
        }
    }

    // MÉTODO CORRETO
    public void listarClientes() {
        int i = 0;
        for (Cliente cliente : listaDeClientes) {
            System.out.println();
            System.out.printf("Cliente número %d\n", i);
            System.out.println("Nome do cliente: " + cliente.getNome());
            System.out.println("ID do cliente: " + cliente.getId());
            i++;
        }
    }

    // EM PRODUÇÃO; FALTA REGISTRAR VENDA PARA CLIENTE
    public void criarVenda(String nomeProduto, int quantidadeProduto, String nomeComprador) {
        Produto produto = procurarProduto(nomeProduto);
        
        if (produto == null) {
            System.out.println("Produto não encontrado!");
            return;
        }

        Cliente cliente = procurarCliente(nomeComprador);

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        if (quantidadeProduto <= produto.getEstoque()) {
            produto.retirarEstoque(quantidadeProduto);
            
        } else {
            System.out.println("Quantidade negativa ou maior que o estoque atual!");
        }
    }

    public void verVendas() {
        
    }
}
