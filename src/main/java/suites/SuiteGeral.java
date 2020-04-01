package suites;

import core.DriverFactory;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import pages.LoginPage;
import tests.ContaTest;
import tests.MovimentacaoTest;
import tests.RemoverMovimentacaoContaTest;
import tests.ResumoTest;
import tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {

	private static LoginPage page = new LoginPage();

	@BeforeClass
	public static void reset(){
		page.acessarTelaInicial();
		page.setEmail("wagner@costa");
		page.setSenha("123456");
		page.entrar();

		page.resetar();

		DriverFactory.killDriver();
	}
}
