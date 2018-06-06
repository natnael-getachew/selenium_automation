import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONObject;

public class NewsWebsite {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        fetchNews();
    }
    public static void fetchNews(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://edition.cnn.com/");
        List<WebElement> posts = driver.findElements(By.className("cd__content"));
        String allPosts = "";
        JSONObject obj = new JSONObject();
        int count = 0;

        for (WebElement post : posts) {
            count++;
            allPosts = post.getText();
            obj.put(count, allPosts);
//                System.out.println(allPosts);

        }
        String Header, Body;

        //writing to the json file
        try( FileWriter file = new FileWriter("news_content.json")) {
            file.append(obj.toJSONString());
            file.flush();
            System.out.println("Successfully written to JSON file!");

        }
        catch (IOException e){
            e.printStackTrace();
        }

        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
    }

}
