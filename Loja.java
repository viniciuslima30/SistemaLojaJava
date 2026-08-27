import java.util.ArrayList;
import java.util.UUID;

public class Loja {
    
    private ArrayList<Produto> listaDeProdutos = new ArrayList<>();
    private ArrayList<Cliente> listaDeClientes = new ArrayList<>();
    private ArrayList<Venda> listaDeVendas = new ArrayList<>();

    public ArrayList<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public ArrayList<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }

    public ArrayList<Venda> getListaDeVendas() {
        return listaDeVendas;
    }

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

    // MÉTODO AUXILIAR CORRETO
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
        Produto produtoExiste = procurarProduto(nome);

        if (produtoExiste != null) { // se produto existe
            produtoExiste.aumentarEstoque(estoque);
            System.out.println("Produto já existe, quantidade aumentada!\n");
        } else {
            Produto novoProduto = new Produto(nome, preco, estoque);
            listaDeProdutos.add(novoProduto);
            System.out.println("Produto cadastrado com sucesso!\n");
        }
    }

    // MÉTODO CORRETO OBS: ACEITA NOME DUPLICADO; N TEM BANCO 
    public void cadastrarCliente(String nome) {
        UUID id = UUID.randomUUID();
        Cliente novoCliente = new Cliente(nome, id);
        listaDeClientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!\n");
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

    // MÉTODO CORRETO
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
            Item item = new Item(produto.getNome(), produto.getPreco(), quantidadeProduto);
            Venda venda = new Venda(cliente);
            venda.getItems().add(item);
            listaDeVendas.add(venda);
            
        } else {
            System.out.println("Quantidade negativa ou maior que o estoque atual!\n");
        }
    }

    // MÉTODO CORRETO
    public void verVendas() {
        for (Venda venda : listaDeVendas) {
            System.out.println("Comprador: " + venda.getComprador().getNome());
            System.out.println("Id do comprador: " + venda.getComprador().getId());
            venda.mostrarItems();
        }
    }

    // MÉTODO CORRETO
    public void cancelarVenda(String nomeCliente) {
        Cliente cliente = procurarCliente(nomeCliente);
        int qnt = 0;
        String nome = "";

        if (cliente != null) {
            for (Venda venda : listaDeVendas) {
                if (venda.getComprador().equals(cliente)) {
                    ArrayList<Item> items = venda.getItems();

                    for (Item item : items) {
                        qnt = item.getQuantidade();
                        nome = item.getNome();
                        break;    
                    }

                    venda.getItems().clear();
                    getListaDeVendas().remove(venda);
                    System.out.println("Compra cancelada!\n");

                    for (Produto produto : listaDeProdutos) {
                        if (produto.getNome().equalsIgnoreCase(nome)) {
                            produto.aumentarEstoque(qnt);
                            break;
                        }
                    }
                    break;
                }
            }
        }
        
    }
}
