package core;

import org.junit.Assert;
import org.junit.Test;
import pages.ContasPage;
import pages.MenuPage;

public class ContaTest extends BaseTest{

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void test(){
        menuPage.acessarTelaIniciarConta();

        contasPage.setNome("Conta do Teste");
        contasPage.salvar();

        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void testAlterarConta(){
        menuPage.acessarTelaListarConta();

        contasPage.clicarAlterarConta("Conta do Teste");
        contasPage.setNome("Conta do Teste Alterada");
        contasPage.salvar();

        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }


}
