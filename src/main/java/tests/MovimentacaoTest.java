package tests;

import core.BasePage;
import core.BaseTest;
import core.Propriedades;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.MenuPage;
import pages.MovimentacaoPage;
import utils.DataUtils;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();

    @Test
    public void test1_InserirMovimentacao(){
        menuPage.acessarTelaInserirMovimentacao();

        movimentacaoPage.setDataMovimentacao(DataUtils.obertDataFormatada(new Date()));
        movimentacaoPage.setDataPagamento(DataUtils.obertDataFormatada(new Date()));
        movimentacaoPage.setDescricao("Movimentação do Teste");
        movimentacaoPage.setInteressado("Interessado Qualquer");
        movimentacaoPage.setValor("500");
        movimentacaoPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
        movimentacaoPage.setStatusPago();
        movimentacaoPage.salvar();

        Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obterMensagemSucesso());
    }

    @Test
    public void test2_CamposObrigatorios(){
        menuPage.acessarTelaInserirMovimentacao();

        movimentacaoPage.salvar();

        List<String> erros = movimentacaoPage.obterErros();
        //Assert.assertEquals("Data de movimentação é obrigatório", erros.get(0));
        //Assert.assertTrue(erros.contains("Data de movimentação é obrigatório"));
        Assert.assertTrue(erros.containsAll(Arrays.asList(
                "Data da Movimentação é obrigatório", "Data do pagamento é obrigatório", "Descrição é obrigatório", "Interessado é obrigatório", "Valor é obrigatório", "Valor deve ser um número"
        )));
    }

    @Test
    public void inserir3_MovimentacaoFutura(){
        menuPage.acessarTelaInserirMovimentacao();

        Date dataFutura = DataUtils.obterDataComDiferencaDias(5);

        movimentacaoPage.setDataMovimentacao(DataUtils.obertDataFormatada(dataFutura));
        movimentacaoPage.setDataPagamento(DataUtils.obertDataFormatada(dataFutura));
        movimentacaoPage.setDescricao("Movimentação do Teste");
        movimentacaoPage.setInteressado("Interessado Qualquer");
        movimentacaoPage.setValor("500");
        movimentacaoPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
        movimentacaoPage.setStatusPago();
        movimentacaoPage.salvar();

        List<String> erros = movimentacaoPage.obterErros();
        Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
    }
}
