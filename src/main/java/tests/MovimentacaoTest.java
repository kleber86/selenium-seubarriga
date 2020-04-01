package tests;

import core.BasePage;
import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.MenuPage;
import pages.MovimentacaoPage;

import java.util.Arrays;
import java.util.List;

public class MovimentacaoTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();

    @Test
    public void testInserirMovimentacao(){
        menuPage.acessarTelaInserirMovimentacao();

        movimentacaoPage.setDataMovimentacao("01/01/2000");
        movimentacaoPage.setDataPagamento("01/01/2000");
        movimentacaoPage.setDescricao("Movimentação do Teste");
        movimentacaoPage.setInteressado("Interessado Qualquer");
        movimentacaoPage.setValor("500");
        movimentacaoPage.setConta("Conta do Teste Alterada");
        movimentacaoPage.setStatusPago();
        movimentacaoPage.salvar();

        Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obterMensagemSucesso());
    }

    @Test
    public void testCamposObrigatorios(){
        menuPage.acessarTelaInserirMovimentacao();

        movimentacaoPage.salvar();

        List<String> erros = movimentacaoPage.obterErros();
        //Assert.assertEquals("Data de movimentação é obrigatório", erros.get(0));
        //Assert.assertTrue(erros.contains("Data de movimentação é obrigatório"));
        Assert.assertTrue(erros.containsAll(Arrays.asList(
                "Data da Movimentação é obrigatório", "Data do pagamento é obrigatório", "Descrição é obrigatório", "Interessado é obrigatório", "Valor é obrigatório", "Valor deve ser um número"
        )));
    }
}
