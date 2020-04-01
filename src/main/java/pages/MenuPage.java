package pages;

import core.BasePage;

public class MenuPage extends BasePage {

    public void acessarTelaIncerirConta(){
        clicarLink("Contas");
        clicarLink("Adicionar");
    }

    public void acessarTelaListarConta(){
        clicarLink("Contas");
        clicarLink("Listar");
    }
}
