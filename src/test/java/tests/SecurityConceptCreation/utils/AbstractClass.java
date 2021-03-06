package tests.SecurityConceptCreation.utils;

import com.codeborne.selenide.Configuration;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Login;
import utils.Property_Loader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AbstractClass {

    public String Grundschutz = "IT-Grundschutz";
    public String Security_Check = "Security Check";
    public String Inventory_Analysis = "Inventory Analysis";

    public String normal = "normal";
    public String high = "high";
    public String veryHigh = "very high";

    @BeforeClass
    public static void setUpClass() throws Exception {

        String URL = Property_Loader.loadProperty("site.url") + "/targetObject.jsf";
        Configuration.browser = "chrome";
        open(URL);

        if ($(By.xpath(".//*[@id='loginForm']/table")).isDisplayed()) {
            Login.LoginProperly();
            SelectConcept.selectDefaultConcept();
        }
    }

    @AfterClass
    public static void tearDownClass() {

    }
}
