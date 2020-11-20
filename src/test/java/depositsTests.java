import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;

public class depositsTests {

    @Test
    public void depositTest() {
//        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Selenide.open("https://alfabank.ru/make-money/");
        $x("//h1[contains(text(),'Накопительные продукты')]").shouldBe(Condition.text("Накопительные продукты"));
        $x("//p[contains(text(),'Депозиты')]/..").click();
        $x("//button[contains(text(),'Архивные счета и депозиты')]").click();
        $x("//span[contains(text(),'Депозиты')]").click();
        $$x("//div[@data-widget-name='CatalogCard']").find(Condition.visible).getSize().equals(5);


    }

}
