package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class ceshi {
 
public static void main(String[] args) {
// TODO Auto-generated method stub
WebDriver dr =  new FirefoxDriver();

dr.get("http://121.193.130.195:8080/");

dr.findElement(By.id("name")).clear();
dr.findElement(By.id("name")).sendKeys("3014218054");
dr.findElement(By.id("pwd")).clear();
dr.findElement(By.id("pwd")).sendKeys("218054");
dr.findElement(By.id("submit")).click();
System.out.println(dr.findElement(By.xpath("//tbody[@id='table-main']/tr[3]/td[2]")).getText());
try {
Thread.sleep(3000);
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
      
dr.quit();
}
 
}