import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    private Loja loja;
    
    @BeforeEach
    void configurar() {
        loja = new Loja();
    }

    @Test
    void testarNomeCorreto() {
        Produto produto = new Produto("Bola", 10, 20);

        assertEquals("Bola", produto.getNome());
    }

    @Test
    void testarPrecoCorreto() {
        Produto produto = new Produto("Carro", 10000, 3);

        assertEquals(10000, produto.getPreco());
    }

    @Test
    void testarEstoqueInicialCorreto() {
        Produto produto = new Produto("Moto", 5000, 10);

        assertEquals(10, produto.getEstoque());
    }

    @Test
    void testarRetirarEstoqueProduto() {
        Produto produto = new Produto("Celular", 1800, 10);

        produto.retirarEstoque(5);

        assertEquals(5, produto.getEstoque());
    }

    @Test
    void testarAumentarEstoqueProduto() {
        Produto produto = new Produto("Porta", 200, 20);

        produto.aumentarEstoque(10);

        assertEquals(30, produto.getEstoque());
    }

    @Test
    void testarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException();
        });

    }

    @Test
    void testarProdutoNaoEncontrado() {
        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            throw new ProdutoNaoEncontradoException("Produto não encontrado");
        });
    }

    @Test
    void testarQuantidadeProdutoInvalida() {
        Loja loja = new Loja();

        QuantidadeProdutoInvalidaException excecao =
            assertThrows(QuantidadeProdutoInvalidaException.class, () -> {
                loja.cadastrarProduto("Bola", 10, 0);
            });

        assertEquals(
            "Quantidade igual ou menor que zero",
            excecao.getMessage()
        );
    }

    @Test
    void testarQuantidadeZero() {
        assertThrows(QuantidadeProdutoInvalidaException.class, () -> {
            loja.cadastrarProduto("Mouse", 50, 0);
        });
    }
}