import java.util.ArrayList;
import java.util.UUID;

public class Venda {
    private Cliente comprador;
    private ArrayList<Item> items = new ArrayList<>();
    private UUID id;

    public Venda(Cliente comprador, UUID id) {
        this.comprador = comprador;
        this.id = id;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public UUID getId() {
        return id;
    }

    public void mostrarItems() {
        for (Item item : items) {
            System.out.println("Nome: " + item.getNome());
            System.out.println("Preço: " + item.getPreco());
            System.out.println("Quantidade: " + item.getQuantidade());
            System.out.println("ID da compra: " + this.id);
            System.out.println();
        }
    }

}
