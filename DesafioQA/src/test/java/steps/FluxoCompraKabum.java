package steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class FluxoCompraKabum {
	
	@Before
	public void inicio() {
		System.out.println("Começando o Cenário Aqui!");
	}
	
	@After
	public void fecharBrowser() {
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ATENDIMENTO'])[1]/following::img[1]")).click();
		driver.quit();
		System.out.println("Fechou o Browser após Execução!");
	}
	
	public void sleep() throws Throwable {
	Thread.sleep(1000);
	}
	
	
	private WebDriver driver;
	
	
	@Dado("^que eu faça o login no sistema$")
	public void queEuFaçaOLoginNoSistema() throws Throwable {
		driver = new ChromeDriver();
	    driver.get("https://www.kabum.com.br/");
		driver.findElement(By.linkText("LOGIN | CADASTRE-SE")).click();
	    driver.findElement(By.id("textfield12")).click();
	    driver.findElement(By.id("textfield12")).clear();
	    driver.findElement(By.id("textfield12")).sendKeys("jonathandesafioqa@gmail.com");
	    driver.findElement(By.id("textfield15")).click();
	    driver.findElement(By.id("textfield15")).clear();
	    driver.findElement(By.id("textfield15")).sendKeys("desafioqa");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Entrar com sua conta do Facebook ou Google'])[1]/preceding::input[1]")).click();
	}
	
	
	@Dado("^compre o produto de minha escolha$")
	public void compreOProdutoDeMinhaEscolha() throws Throwable {
		//Preenche o nome do produto na pesquisa
		sleep();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='POLÍTICAS DO SITE'])[1]/following::input[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='POLÍTICAS DO SITE'])[1]/following::input[1]")).clear();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='POLÍTICAS DO SITE'])[1]/following::input[1]")).sendKeys("SSD WD Green 2.5´ 240GB SATA III 6Gb/s");
	    	    
	    //clica na Lupa Buscar
	    sleep();
	    driver.findElement(By.id("bt-busca")).click();
	    
	    //**clica no botão Comprar *achar outra forma para clicar na imagem ao inves de pegar o preço que muda toda vez.
	    sleep();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='R$ 304,90'])[1]/following::img[1]")).click();
	}
	
	
	@Quando("^adicionar uma unidade do produto em minha cesta de compra$")
	public void adicionarUmaUnidadesDoProdutoEmMinhaCestaDeCompra() throws Throwable {
		//clica no botão Ir para o carrinho
		sleep();
		driver.findElement(By.linkText("IR PARA O CARRINHO")).click();
		
		//clica no botão Finalizar Compra
		sleep();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CARRINHO DE COMPRAS'])[1]/following::a[2]")).click();
	}
	
	
	@Quando("^adicionar duas unidades do produto em minha cesta de compra$")
	public void adicionarDuasUnidadesDoProdutoEmMinhaCestaDeCompra() throws Throwable {
		//clica no botão Ir para o carrinho
		sleep();
		driver.findElement(By.linkText("IR PARA O CARRINHO")).click();
		
	    //selecionar 2 unidades do produto
	    driver.findElement(By.id("produto_quantidade")).click();
	    driver.findElement(By.id("produto_quantidade")).clear();
	    driver.findElement(By.id("produto_quantidade")).sendKeys("2");
	    driver.findElement(By.linkText("Atualizar")).click();
	    
		//clica no botão Finalizar Compra
	    sleep();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CARRINHO DE COMPRAS'])[1]/following::a[2]")).click();
	}
	
	
	@Quando("^remover um item do carrinho$")
	public void removerUmItemDoCarrinho() throws Throwable {
		driver.findElement(By.linkText("Excluir")).click();
	}

	
	@Então("^não deve haver produtos na cesta$")
	public void nãoDeveHaverProdutosNaCesta() throws Throwable {
		sleep();
	    driver.get("https://www.kabum.com.br/cgi-local/site/carrinho/carrinho.cgi");
	    assertEquals("SEU CARRINHO ESTÁ VAZIO", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Total'])[1]/following::h4[1]")).getText());		
	}
	
	
	@Quando("^finalizar a compra com cartão de crédito$")
	public void finalizarACompraComCartãoDeCrédito() throws Throwable {
	   // Thread.sleep(2000);
		sleep();
	    driver.findElement(By.linkText("Cartão de Credito")).click();

	    //Forma de pagamento:
//	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Dados do Cartão'])[1]/following::select[1]")).click();
//	    new Select(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Dados do Cartão'])[1]/following::select[1]"))).selectByVisibleText("2x com desconto de até 5% - R$ 621,48");
	    
	    //Nome (escrito no cartão):
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Dados do Cartão'])[1]/following::option[2]")).click();
	    driver.findElement(By.name("cartao_nome")).click();
	    driver.findElement(By.name("cartao_nome")).clear();
	    driver.findElement(By.name("cartao_nome")).sendKeys("Jose Silva");
	    
	    //Número do cartão:
	    driver.findElement(By.name("cartao_numero")).click();
	    driver.findElement(By.name("cartao_numero")).clear();
	    driver.findElement(By.name("cartao_numero")).sendKeys("5227154240113838");
	    
	    //Validade (mm/aa):
	    driver.findElement(By.name("cartao_mes")).click();
	    new Select(driver.findElement(By.name("cartao_mes"))).selectByVisibleText("10");
	    driver.findElement(By.xpath("//option[@value='10']")).click();
	    driver.findElement(By.name("cartao_ano")).click();
	    new Select(driver.findElement(By.name("cartao_ano"))).selectByVisibleText("30");
	    driver.findElement(By.xpath("//option[@value='30']")).click();
	    
	    //Código de segurança:
	    driver.findElement(By.name("cartao_codigoseguranca")).click();
	    driver.findElement(By.name("cartao_codigoseguranca")).clear();	    
	    driver.findElement(By.name("cartao_codigoseguranca")).sendKeys("147");
	    
	    //CPF do proprietário do cartão:
	    driver.findElement(By.name("cartao_cpf")).click();
	    driver.findElement(By.name("cartao_cpf")).clear();
	    driver.findElement(By.name("cartao_cpf")).sendKeys("51221827871");
	    
	    //Data de nascimento:	    
	    driver.findElement(By.name("cartao_dia_nascimento")).click();
	    new Select(driver.findElement(By.name("cartao_dia_nascimento"))).selectByVisibleText("01");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Boleto Bancário'])[1]/preceding::option[134]")).click();
	    driver.findElement(By.name("cartao_mes_nascimento")).click();
	    new Select(driver.findElement(By.name("cartao_mes_nascimento"))).selectByVisibleText("02");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Boleto Bancário'])[1]/preceding::option[101]")).click();
	    driver.findElement(By.name("cartao_ano_nascimento")).click();
	    new Select(driver.findElement(By.name("cartao_ano_nascimento"))).selectByVisibleText("1984");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Boleto Bancário'])[1]/preceding::option[65]")).click();
	 
	    //Botão Pagar com Cartão
	    driver.findElement(By.name("CARTAO")).click();
	}

	
	@Então("^devo ver o campo observações presente na tela antes de confirmar meu pedido$")
	public void devoVerAMensagem() throws Throwable {
		driver.findElement(By.name("pedido_observacao")).click();
	}

}