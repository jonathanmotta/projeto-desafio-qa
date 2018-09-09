package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/kabum.feature",
		glue = "steps",
		tags = {"~@ignore"},
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = true, //true retira os caracteres especiais e formata o texto melhor no console
		snippets = SnippetType.CAMELCASE,
		dryRun = false, //true roda somente os cenário sem abrir o navegador
		strict = false
		)

public class RunnerTest {

}