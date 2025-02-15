package tarefa.src;

public class Tarefa {
    private final String descricao;
    private int prioridade = 0;

    public Tarefa(String descricao) throws IllegalArgumentException {
        if (descricao == null || descricao.isBlank())
            throw new IllegalArgumentException("Descrição não pode ser vazia.");

        this.descricao = descricao;
    }

    public Tarefa(String descricao, int prioridade) throws IllegalArgumentException {
        this(descricao);
        this.prioridade = prioridade;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Tarefa: " + getDescricao();
    }

    public int getPrioridade() {
        return prioridade;
    }
}
