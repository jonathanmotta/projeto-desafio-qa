# projeto-desafio-qa
Fluxo de Compra na Kabum

Realizei a Automação de Testes com Cucumber + Selenium, pois da a liberdade de escrever os cenários em BDD além da organização da estrutura em pastas/pacotes.

Passos para executar os cenários de teste

1.	Instalar o eclipse e configurar as variáveis de ambiente;  (JAVA (JDK) e Apache Maven e Driver)

Referências:

Tutorial: Instalação do JAVA (JDK) e Eclipse no Windows
http://www.matera.com/br/2015/05/12/tutorial-instalacao-do-java-jdk-e-eclipse-no-windows/

Tutorial: Instalação do Apache Maven e Configuração no Eclipse
http://matera.com/br/2015/06/30/tutorial-instalacao-apache-maven-configuracao-eclipse/

1.1	Para a configuração do driver,  baixar o chromedriver no link abaixo:
https://chromedriver.storage.googleapis.com/index.html?path=2.41/

Nas variáveis de ambiente adicionar o caminho para o arquivo baixado: chromedriver.exe
EXEMPLO: DRIVER_HOME: C:\Users\Documents\driver e depois chame ele no PATH. %DRIVERS_HOME%

Ou se preferiri adicionar o comando no @Before:
Exemplo:
System.setProperty("webdriver.chrome.drive", "D:\\drivers\\chromedriver.exe.exe");
WebDriver driver = new ChromeDriver();

1.2 Em Clone or download, faça o Download ZIP.

2.	Criar uma pasta "workspace" no D:\\ por exemplo e colar o projeto "DesafioQA" lá dentro.

2.1 Em seguida abrir o eclipse e localizar a pasta "workspace" para inicializar o projeto.

2.2 Fazer a importação do projeto "DesafioQA" através do maven no eclipse.
 
3.	Necessário instalar os plugins do Cucumber e JUnit caso não possua.

4.	Mudar o Text file encoding para UTF: 8. 

5.	Por fim executar a classe "RunnerTest" no pacote runners.
