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
    @DisplayName("Tarefa com maior prioridade deve ser a primeira da lista após adicionar")
    void AdicionaEOrdenaPorPrioridade() {
        String tarefaSemPrioridade = "Tarefa sem prioridade";
        String tarefaComPrioridade = "Tarefa com prioridade";
        String tarefaComPrioridadeMaior = "Tarefa com prioridade maior";

        listaTarefas.adicionarTarefa(tarefaSemPrioridade);
        listaTarefas.adicionarTarefa(tarefaComPrioridade, 1);
        listaTarefas.adicionarTarefa(tarefaComPrioridadeMaior, 2);

        assertEquals(tarefaComPrioridadeMaior, listaTarefas.obterDescricoesTarefas().get(0));
    }

    @Test
    @DisplayName("Tarefas incluídas com prioridade 0 não alteram ordem de exibição")
    void AdicionarSemPrioridadeNaoAfetaOrdenacao() {
        String tarefaSemPrioridade = "Tarefa sem prioridade";
        String tarefaSemPrioridadeDois = "Tarefa sem prioridade 2";

        listaTarefas.adicionarTarefa(tarefaSemPrioridade, 0);
        listaTarefas.adicionarTarefa(tarefaSemPrioridadeDois, 0);

        assertEquals(tarefaSemPrioridade, listaTarefas.obterDescricoesTarefas().get(0));
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

    @Test
    @DisplayName("obterTarefaPorDescricao retorna tarefa se existir")
    void ObterTarefaDeveRetornarObjetoSeExistir() {
        String descricaoTeste = "Descrição de teste";
        listaTarefas.adicionarTarefa(descricaoTeste);

        Tarefa resultado = listaTarefas.obterTarefaPorDescricao(descricaoTeste);

        assertNotNull(resultado);
    }

    @Test
    @DisplayName("obterTarefaPorDescricao retorna null se tarefa não existir")
    void ObterTarefaDeveRetornarNullSeNaoExistir() {
        listaTarefas.adicionarTarefa("Descrição de teste");

        Tarefa resultado = listaTarefas.obterTarefaPorDescricao("Obter teste");

        assertNull(resultado);
    }
}
