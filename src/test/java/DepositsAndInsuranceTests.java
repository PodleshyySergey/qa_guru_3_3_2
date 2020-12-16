import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepositsAndInsuranceTests {

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Selenide.open("https://alfabank.ru/make-money/");
    }

    @Test
    @Order(0)
    public void depositTest() {
        $x("//h1[contains(text(),'Накопительные продукты')]").shouldBe(Condition.text("Накопительные продукты"));
        $x("//p[contains(text(),'Депозиты')]/..").click();
        $x("//button[contains(text(),'Архивные счета и депозиты')]").click();
        $x("//span[contains(text(),'Депозиты')]").click();
        $$x("//div[@data-widget-name='CatalogCard']").shouldHaveSize(5);
    }

    @Test
    @Order(1)
    public void siblingTest() {
        $("[title=Вклады]").parent().click();
        $(byText("Описание")).parent().sibling(0).click();
        $(byText("Полезно знать")).parent().scrollTo().shouldBe(Condition.text("Страхованию подлежат"));
    }

    @Test
    @Order(2)
    public void precedingTest() {
        $("[title=Вклады]").parent().click(); //Что такое вклад?
        $(byText("Что такое вклад?")).parent().preceding(0).click();
        $(byText("Полезно знать")).parent().scrollTo().shouldBe(Condition.text("Страхованию подлежат"));
    }

    @Test
    @Order(3)
    public void parentTest() {
        $("[title=Вклады]").parent().click();
        $(byText("Страхование вкладов")).parent().click();
        $(byText("Полезно знать")).parent().scrollTo().shouldBe(Condition.text("Страхованию подлежат"));
    }

    @Test
    @Order(4)
    public void closestTest() {
        $("[title=Вклады]").parent().click();
        $(byText("Страхование вкладов")).closest("button").click();
        $(byText("Полезно знать")).parent().scrollTo().shouldBe(Condition.text("Страхованию подлежат"));
    }

}
