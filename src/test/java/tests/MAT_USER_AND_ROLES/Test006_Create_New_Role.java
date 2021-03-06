package tests.MAT_USER_AND_ROLES;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;
import utils.RandomName;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Test006_Create_New_Role extends GSTAbstractClass {

    @Features("User management")
    @Test
    @Title("Create new role")
    public void testCreateNewRole() throws Exception {

        OpenView.openExtras(RoleAdministration);

        //Click Add button
        $("#addElementEnabled").click();

        String roleName = RandomName.getRandomRoleName();
        String description = "This is description for autotest role";

        //Enter rolename and description
        $(By.xpath(".//*[@id='roleAdministrationForm:name']")).val(roleName);
        $(By.xpath(".//*[@id='roleAdministrationForm:description']")).val(description);

        //Click Save button
        $("#saveEnabled").waitUntil(enabled, 6000).click();
        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(present, 8000).shouldHave(text("Successfully saved")).shouldHave(text(roleName));


    }
}
