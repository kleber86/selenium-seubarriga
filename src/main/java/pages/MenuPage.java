package pages;

import core.BasePage;

public class MenuPage extends BasePage {
    public void acessarTelaIniciarConta(){
        clicarLink("Contas");
        clicarLink("Adicionar");
    }
}
