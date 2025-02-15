package tarefa.src;

public class Tarefa {
    private final String descricao;

    public Tarefa(String descricao) throws IllegalArgumentException {
        if (descricao == null || descricao.isBlank())
            throw new IllegalArgumentException("Descrição não pode ser vazia.");

        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Tarefa: " + getDescricao();
    }
}
