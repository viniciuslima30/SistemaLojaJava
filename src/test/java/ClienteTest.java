import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class ClienteTest {
    @Test
    void testarNomeCliente() {
        UUID id = UUID.randomUUID();
        Cliente cliente = new Cliente("Vinicius", id);

        assertTrue(cliente.getNome() != null, "Nome deveria retornar!");
        assertFalse(cliente.getNome().isEmpty(), "Nome vazio!");
        assertEquals(id, cliente.getId());
    }

}

