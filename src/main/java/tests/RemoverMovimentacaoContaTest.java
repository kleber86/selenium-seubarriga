package tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.ContasPage;
import pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void testExcluirContaComMovimentacao(){
        menuPage.acessarTelaListarConta();

        contasPage.clicarExcluirConta("Conta do Teste Hoje1");

        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemSemSucesso());
    }
}
