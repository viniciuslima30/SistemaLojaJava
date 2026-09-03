import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MockitoTest {

    @Test
    void testarMock() {

        Produto produto = mock(Produto.class);

        when(produto.getNome()).thenReturn("Bola");

        assertEquals("Bola", produto.getNome());
    }

    @Test
    void testarVerificacao() {
        Produto produto = mock(Produto.class);

        produto.getNome();

        verify(produto).getNome();

    }

    @Test
    void testarBuscaProduto() {

        ProdutoRepository repository = mock(ProdutoRepository.class);

        Produto produto = new Produto("Bola", 10, 20);

        when(repository.buscarPorId(1)).thenReturn(produto);

        ProdutoService service = new ProdutoService(repository);

        Produto resultado = service.buscarPorId(1);

        assertEquals("Bola", resultado.getNome());

        verify(repository).buscarPorId(1);
}
}