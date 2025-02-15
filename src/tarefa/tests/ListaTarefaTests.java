package tarefa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import tarefa.src.ListaTarefas;
import tarefa.src.Tarefa;

import java.util.List;

public class ListaTarefaTests {
    private ListaTarefas listaTarefas;

    @BeforeEach
    void setUp() {
        listaTarefas = new ListaTarefas();
    }

    @Test
    @DisplayName("Joga exceção se descrição for vazia")
    void JogaExceptionSeDescricaoVazia() {
        assertThrows(
                IllegalArgumentException.class, () -> listaTarefas.adicionarTarefa("")
        );
    }

    @Test
    @DisplayName("Joga exceção se descrição for null")
    void JogaExceptionSeDescricaoNull() {
        assertThrows(
                IllegalArgumentException.class, () -> listaTarefas.adicionarTarefa(null)
        );
    }

    @Test
    @DisplayName("Adiciona tarefa se descrição preenchida")
    void AdicionaTarefaSeDescricaoPreenchida() {
        listaTarefas.adicionarTarefa("Tarefa teste");
        assertEquals(1, listaTarefas.obterNumeroTotalTarefas());
    }

    @Test
    @DisplayName("Remove tarefa da lista se existir")
    void RemoveTarefaDaListaSeExistir() {
        String descricao = "Descricao teste";

        listaTarefas.adicionarTarefa(descricao);

        int quantidadeInicial = listaTarefas.obterNumeroTotalTarefas();

        listaTarefas.removerTarefa(descricao);

        assertNotEquals(quantidadeInicial, listaTarefas.obterNumeroTotalTarefas());
    }

    @Test
    @DisplayName("Ao remover, lista permanece a mesma se tarefa não existir")
    void EstadoListaNaoAlteradoSeTarefaNaoExiste() {
        listaTarefas.adicionarTarefa("Descricao teste");

        int quantidadeInicial = listaTarefas.obterNumeroTotalTarefas();

        listaTarefas.removerTarefa("Descricao teste inexistente");

        assertEquals(quantidadeInicial, listaTarefas.obterNumeroTotalTarefas());
    }

    @Test
    @DisplayName("obterDescricoesTarefas retorna lista com descrição correta conforme criação")
    void ListaComDescricoesRetornadasComSucesso() {
        String descricaoTeste = "Descricao teste";

        Tarefa tarefaTeste = new Tarefa(descricaoTeste);
        listaTarefas.adicionarTarefa(descricaoTeste);

        List<String> stringList = listaTarefas.obterDescricoesTarefas();

        assertEquals(tarefaTeste.getDescricao(), stringList.get(0));
    }
}
