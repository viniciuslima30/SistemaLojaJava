
import java.util.ArrayList;

public class Venda {
    private Cliente comprador;
    private ArrayList<Produto> produtos = new ArrayList<>();

    public Venda(Cliente comprador) {
        this.comprador = comprador;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    
}
