public class ProdutoService {

    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto buscarPorId(int id) {
        return repository.buscarPorId(id);
    }
}