package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
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
}
