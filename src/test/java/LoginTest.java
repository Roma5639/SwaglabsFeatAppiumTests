import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {



    @Test
    public void validLogin() throws MalformedURLException {

        ad.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        MobileElement userId = ad.findElementByAccessibilityId("test-Username");
        MobileElement password = ad.findElementByAccessibilityId("test-Password");
        MobileElement login_Button = ad.findElementByAccessibilityId("test-LOGIN");


        userId.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        login_Button.click();

        ad.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String actualString  = ad.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView").getText();
        String expectedString = "PRODUCTS";
        Assert.assertEquals(actualString, expectedString);

    }

}
