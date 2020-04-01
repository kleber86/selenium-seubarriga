package suites;

import core.DriverFactory;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pages.LoginPage;
import tests.ContaTest;
import tests.MovimentacaoTest;
import tests.RemoverMovimentacaoContaTest;
import tests.ResumoTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContaTest.class,
        MovimentacaoTest.class,
        RemoverMovimentacaoContaTest.class,
        ResumoTest.class
})

public class SuiteGeral {
    private static LoginPage page = new LoginPage();

    @BeforeClass
    public static void inicializar(){
        page.acessarTelaInicial();

        page.setEmail("wagner@costa");
        page.setSenha("123456");
        page.entrar();
    }

    @AfterClass
    public static void finaliza(){
        DriverFactory.killDriver();
    }
}