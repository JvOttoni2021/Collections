package tarefa.src;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    private final List<Tarefa> lista;

    public ListaTarefas() {
        this.lista = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        this.lista.add(criarTarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        this.lista.removeIf(x -> x.getDescricao().equalsIgnoreCase(descricao));
    }

    public int obterNumeroTotalTarefas() {
        return lista.size();
    }

    public List<String> obterDescricoesTarefas() {
        return this.lista.stream().map(Tarefa::getDescricao).toList();
    }

    private Tarefa criarTarefa(String descricao) {
        return new Tarefa(descricao);
    }
}
