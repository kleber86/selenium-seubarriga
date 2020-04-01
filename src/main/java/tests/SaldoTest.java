package tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;

public class SaldoTest extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    public void testSaldoConta(){
        Assert.assertEquals("500.00", homePage.obterSaldoConta("Conta do Teste Hoje1"));
    }
}
