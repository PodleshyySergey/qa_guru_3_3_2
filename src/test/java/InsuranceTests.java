import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class InsuranceTests {

    @Test
    public void insuranceTest() {

        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
        Selenide.open("https://alfabank.ru/");

        $("[title=\"Малому бизнесу и ИП\"]").click(); // Переход на вкладку "Малому бизнесу и ИП"
        $(byText("Малому бизнесу и ИП")).parent().parent().$("[title=\"Частным лицам\"]").click(); // Обратный переход

        $("[href=\"/make-money/\"]").click();
        $("[data-test-id=\"tabs-list\"]").$(byText("Страхование вкладов")).click();
        $(byText("Полезно знать")).parent().shouldBe(Condition.text("Страхованию подлежат"));
        
    }

}
