package selenium;
import java.io.BufferedReader;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class usetest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://121.193.130.195:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUsecase() throws Exception {
	  File csv = new File("inputgit.csv");  // CSV文件路径
	    BufferedReader br = null;
	    try
	    {
	        br = new BufferedReader(new FileReader(csv));
	    } catch (FileNotFoundException e)
	    {
	        e.printStackTrace();
	    }
	    String line = "";
	    String everyLine[];
	    int i=1;
	    try {
	            while ((line = br.readLine()) != null)  //读取到的内容给line变量
	            {
	            	if(i==1){//忽略文件头	
            	          i++;
	            	  continue;
	            	}
	            	else{
	                everyLine = line.split(",");
	                driver.get(baseUrl);
	                driver.findElement(By.id("name")).clear();
	                driver.findElement(By.id("name")).sendKeys(everyLine[0]);//获得用户名
			driver.findElement(By.id("pwd")).clear();
	                driver.findElement(By.id("pwd")).sendKeys(everyLine[0].substring(4,10));//获取密码	
                        driver.findElement(By.id("submit")).click();
	                //比较网页内容与实际地址是否一致     
	                assertEquals(everyLine[2], driver.findElement(By.xpath("//tbody[@id='table-main']/tr[3]/td[2]")).getText());
	               
	                System.out.println(everyLine[1]+" is OK!");
	            	}
	            }  
	    } catch (IOException e)
	    {
	        e.printStackTrace();
	    }

	

  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
