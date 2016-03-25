package tests.MAT_Risk_Analysis;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.GSTAbstractClass;
import utils.OpenPluses;
import utils.OpenView;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Try extends GSTAbstractClass{

    @Test
    public void testTestTO() throws Exception {

        OpenView.NavigateTO(Grundschutz, InventoryAnalysis);

        OpenPluses.ExpandAll();

        $(By.xpath(".//*[@id='to_dataList_datalistScrollableContainer']//a[contains(text(), 'PC')]")).shouldBe(visible);
        $(By.partialLinkText("PC")).shouldBe(visible, present);

    }
}
