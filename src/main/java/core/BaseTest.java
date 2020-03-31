package core;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

public class BaseTest {
    private LoginPage page = new LoginPage();

    @Rule
    public TestName testName = new TestName();

    @Before
    public void inicializar(){
        page.acessarTelaInicial();

        page.setEmail("wagner@costa");
        page.setSenha("123456");
        page.entrar();
    }

    @After
    public void finaliza() throws IOException {
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot"+ File.separator + testName.getMethodName() + ".jpg"));
        if(Propriedades.FECHAR_BROWSER){
            killDriver();
        }
    }
}
