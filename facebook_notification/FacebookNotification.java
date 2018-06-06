import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookNotification {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        getNotifications();
    }
    public static void getNotifications(){
        WebDriver portal = new ChromeDriver();
        portal.get("https://www.facebook.com/?stype=lo&jlou=AfeXPCbaYRncyobf0TJ0_KPXsAqIlJDP0UXSoO2Ydtlic5bnh7zVtwTfPRlYV-pyfG8miMczoAdtG8Nvbyf0pQ5hmvgF4F6-t8MC5uGRmRbmPA&smuh=784&lh=Ac9X59WboPFGwf3a");

        WebElement id =  portal.findElement(By.id("email"));
        id.sendKeys(" ");
        WebElement password =  portal.findElement(By.id("pass"));
        password.sendKeys(" ");
        WebElement submit =  portal.findElement(By.id("u_0_2"));
        submit.click();
        WebElement noti =  portal.findElement(By.id("notificationsCountValue"));
        String notvalue = noti.getText();
        System.out.println("You have " + notvalue + " new notifications");
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            portal.close();


    }
}
