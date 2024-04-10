package testCases;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.PageFactory;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import static net.bytebuddy.matcher.ElementMatchers.is;

import pageObjects.*;
import helper.PassSignIn;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestLogin {
    //       @Test
//        public void testLogin() {
//            HomePage homePage = signInPage.loginValidUser("userName", "password");
//            Assertions.assertArrayEquals(homePage.(), is("Hello userName");
//        }
    private static ChromeDriverService service;

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    WebDriver driver = Page.getDriver();

    @BeforeAll
    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder().usingDriverExecutable(new File("C:\\Users\\dan.chivu\\IdeaProjects\\AscentAutomation\\src\\main\\resources\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @Test
    public void testLogin() throws InterruptedException {
        PageFactory.initElements(driver, loginPage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Page.openURL(Page.getDriver(), PassSignIn.getEnvironmentName(), "");
        loginPage.login();
        PageFactory.initElements(driver, homePage);
        homePage.clickCloseButton();
    }
}
