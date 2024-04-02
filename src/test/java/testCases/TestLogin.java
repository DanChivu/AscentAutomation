package testCases;

import dev.failsafe.internal.util.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.PageFactory;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static pageObjects.Page.getDriver;
import static pageObjects.Page.getOptions;

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

    @BeforeClass

    public static void createAndStartService() throws IOException {


        service = new ChromeDriverService.Builder().usingDriverExecutable(new File("C:\\Users\\dan.chivu\\IdeaProjects\\AscentAutomation\\src\\main\\resources\\chromedriver.exe"))

                .usingAnyFreePort()

                .build();

        service.start();

    }

    @Test
    public void testLogin() throws InterruptedException {
        PageFactory.initElements(driver, loginPage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Page.openURL(Page.getDriver(), PassSignIn.getEnvironmentName(), "");
        loginPage.login();
        PageFactory.initElements(driver, homePage);
        homePage.clickCloseButton();
        driver.quit();
    }


}
