
import java.util.ArrayList;

public class Venda {
    private Cliente comprador;
    private ArrayList<Item> items = new ArrayList<>();

    public Venda(Cliente comprador) {
        this.comprador = comprador;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void mostrarItems() {
        for (Item item : items) {
            System.out.println("Nome: " + item.getNome());
            System.out.println("Preço: " + item.getPreco());
            System.out.println("Quantidade: " + item.getQuantidade());
            System.out.println();
        }
    }
}
