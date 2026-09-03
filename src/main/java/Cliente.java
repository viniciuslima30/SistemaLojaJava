import java.util.UUID;

public class Cliente {
    private String nome;
    private UUID id;

    public Cliente(String nome, UUID id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public UUID getId() {
        return id;
    }

}
