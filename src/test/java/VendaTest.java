import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VendaTest {

    private Loja loja;

    @BeforeEach
    void configurar() {
        loja = new Loja();
        loja.cadastrarProduto("Bola", 10, 20);
        loja.cadastrarCliente("Vinicius");
        loja.criarVenda("Bola", 10, "Vinicius");
    }
    @Test
    void testarCompradorIdItems() {
        Venda venda = loja.getListaDeVendas().get(0);
        
        assertEquals("Vinicius", venda.getComprador().getNome());
        assertEquals("Bola", venda.getItems().get(0).getNome());
        assertEquals(10, venda.getItems().get(0).getQuantidade());
    }
}
