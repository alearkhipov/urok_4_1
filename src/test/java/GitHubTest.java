import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {
  @BeforeAll
  static void BeforeAll(){
      Configuration.browserSize = "1920 х 1080";
      Configuration.baseUrl = "https://github.com";
      Configuration.pageLoadStrategy = "eager";
      Configuration.holdBrowserOpen = false;
  }

 @Test
 void gitHubTest (){
 // открыть GitHub
      open ("");

//На главной странице GitHub выберите:
//Меню -> Solutions -> Enterprize (с помощью команды hover для Solutions).
     $(".HeaderMenu-nav").$(byText("Solutions")).hover();
     $(".HeaderMenu").$(byText("Enterprises")).click();
     sleep(2500);

//Убедитесь, что загрузилась нужная страница (например, что заголовок: "The AI-powered developer platform.").
     $("#hero-section-brand-heading").shouldHave (text("The AI-powered\n" + "developer platform."));
    }
}
