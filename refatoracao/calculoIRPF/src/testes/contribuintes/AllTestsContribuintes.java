package testes.contribuintes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TesteCadastroContribuintes.class, TesteCrudContribuinte.class, TesteDelecaoContribuinte.class,
		TestePesquisarContribuinte.class })
public class AllTestsContribuintes {

}
