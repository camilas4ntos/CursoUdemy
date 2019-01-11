import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	@Test
	public void testeTextField() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste Escrita");
		Assert.assertEquals("Teste Escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		// driver.quit();
	}

	@Test
	public void testeTextArea() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste Sugestões\nNovoTeste");
		// Assert.assertEquals("Teste Sugestões",
		// driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

	}

	@Test
	public void testeRadioButton() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());
		// driver.quit();
	}

	@Test
	public void testeCheckBox() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		// driver.quit();
	}

	@Test
	public void testeComboBox() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		WebElement lista = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(lista);
		// combo.selectByIndex(4);
		// combo.selectByValue("superior");
		combo.selectByVisibleText("Mestrado");
		Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());
		// driver.quit();
	}

	@Test
	public void testeValoresComboBox() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		WebElement lista = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(lista);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		// driver.quit();

		boolean encontrou = false;
		for (WebElement option : options) {
			if (option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}

		}
		Assert.assertTrue(encontrou);
	}

	@Test
	public void testeValoresComboBoxMultiplaEscolha() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		WebElement lista = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(lista);
		combo.selectByVisibleText("Futebol");
		combo.selectByVisibleText("Corrida");

		List<WebElement> allSelectOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectOptions.size());

		combo.deselectByVisibleText("Corrida");

		allSelectOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(1, allSelectOptions.size());

		// driver.quit();
	}

	@Test
	public void testeBotoes() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}

	@Test
	public void testeLink() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		WebElement linkVoltar = driver.findElement(By.linkText("Voltar"));
		linkVoltar.click();
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
	}

	@Test
	public void testeBuscaTestoNaPagina() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		Assert.assertEquals("Campo de Treinamento", 
				driver.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", 
				driver.findElement(By.className("facilAchar")).getText());
	}
}