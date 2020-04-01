package tests;

import core.BaseTest;
import core.DriverFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.MenuPage;
import pages.ResumoPage;

import java.sql.Driver;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private ResumoPage resumoPage = new ResumoPage();

    @Test
    public void test1_ExcluirMovimentacao(){
        menuPage.acessarTelaResumo();

        resumoPage.excluirMovimentacao();

        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
    }

    @Test
    public void test2_ResumoMensal(){
        menuPage.acessarTelaResumo();

        Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());

        List<WebElement> elementosEncontrados =
                DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
        Assert.assertEquals(0, elementosEncontrados.size());
    }
}
