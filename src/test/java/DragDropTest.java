import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DragDropTest {
    @BeforeAll
    static void BeforeAll(){
        Configuration.browserSize = "1920 х 1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        //Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void dragDropTest (){


//Откройте https://the-internet.herokuapp.com/drag_and_drop
        open ("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

//Перенесите прямоугольник А на место В

// вариант 1
        //$("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b"))); //вариант 1

// вариант 2
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();

//Проверьте, что прямоугольники действительно поменялись
       $("#column-a").shouldHave(text("B"));
    }
}
