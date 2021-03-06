package tests.MAT_Security_Analysis;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenPluses;
import utils.OpenView;
import utils.TargetObject;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Test001_Select_Created_TO extends GSTAbstractClass{

    @Features("Security Analysis")
    @Test
    @Title("Test create new user")
    public void testSelectCreatedTO() throws Exception {

        OpenView.NavigateTO(Grundschutz, InventoryAnalysis);

        String TOname = "testBuilding";
        TargetObject.CreateNew("Building", TOname, "Lawyer Agency");

        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(visible, 10000).shouldHave(text("Successfully saved")).shouldHave(text(TOname));

        OpenView.NavigateTO(Grundschutz, SecurityAnalysis);
        OpenPluses.ExpandAll();
        $(By.partialLinkText(TOname)).shouldBe(visible).shouldHave(text(TOname));

    }
}
