package tarefa.src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListaTarefas {
    private final List<Tarefa> lista;

    public ListaTarefas() {
        this.lista = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        this.lista.add(criarTarefa(descricao));
    }

    public void adicionarTarefa(String descricao, int prioridade) {
        this.lista.add(criarTarefa(descricao, prioridade));
        if (prioridade > 0) { this.ordenarPorPrioridade(); }
    }

    private void ordenarPorPrioridade() {
        this.lista.sort(Comparator.comparing(Tarefa::getPrioridade).reversed());
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

    public Tarefa obterTarefaPorDescricao(String descricao) {
        return this.lista
                .stream()
                .filter(x -> x.getDescricao().equalsIgnoreCase(descricao))
                .findFirst().orElse(null);
    }

    private Tarefa criarTarefa(String descricao) {
        return new Tarefa(descricao);
    }

    private Tarefa criarTarefa(String descricao, int prioridade) {
        return new Tarefa(descricao, prioridade);
    }
}
