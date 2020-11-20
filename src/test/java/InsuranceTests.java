import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class InsuranceTests {

    @Test
    public void insuranceTest() {

        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
        Selenide.open("https://alfabank.ru/make-money/");

        $x("//button[contains(text(),'Подробные условия')]").click();
        $x("//h1").shouldHave(Condition.text("Страхование вкладов"));

    }

}
