import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class Tests extends MyTest {
    private static ChromeDriver driver;
    @BeforeClass
    public void start(){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test(priority = 0)
    public void login(){
        //Логинация в почте
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.gmail.com/");
        String mylogin = "testbyzayats@gmail.com";
        String mypassword = "135792468QA";
        WebElement username = driver.findElementByXPath("//*[@id=\"identifierId\"]");
        username.sendKeys(mylogin);
        WebElement ButtonNext = driver.findElementByXPath("//*[@id=\"identifierNext\"]/content/span");
        ButtonNext.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement password = driver.findElementByXPath("//*[@name=\"password\"]");
        password.sendKeys(mypassword);
        WebElement ButtonNext2 = driver.findElementByXPath("//*[@id=\"passwordNext\"]/content");
        ButtonNext2.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Проверка URL
        String needUrl = "https://accounts.google.com/signin/v2/sl/pwd?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin&cid=1&navigationDirection=forward";
        if(needUrl.equals(driver.getCurrentUrl())){
            System.out.println("Получим true");
        }else {
            System.out.println("Получим false");
        }
        //Отправление сообщения
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        String myemail = "sipyrkh@yahoo.com";
        WebElement compose = driver.findElementByXPath("//*[@class=\"T-I J-J5-Ji T-I-KE L3\"]");
        compose.click();
        WebElement to = driver.findElementByXPath("//*[@name=\"to\"]");
        to.sendKeys(myemail);
        WebElement subject = driver.findElementByXPath("//*[@name=\"subjectbox\"]");
        subject.sendKeys("Test");
        WebElement message = driver.findElementByXPath("//*[@class=\"Am Al editable LW-avf\"]");
        message.sendKeys("Hello, world!");
        WebElement buttonSend = driver.findElementByXPath("//*[@class=\"T-I J-J5-Ji aoO T-I-atl L3\"]");
        buttonSend.click();
        //Удаление последнего сообщения
        driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
        WebElement check = driver.findElementByXPath("//tr[@class='zA yO']");
        check.click();
        driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
        WebElement buttonDelete = driver.findElementByXPath("//div[@aria-label='Delete']");
        buttonDelete.click();
    }
    @AfterClass
    public void quit(){
        driver.quit();
    }
}
