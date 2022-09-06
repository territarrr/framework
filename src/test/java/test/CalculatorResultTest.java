package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.CalculatorPage;
import page.EmailListPage;
import page.MainPage;
import page.GenerateTmpEmailPage;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CalculatorResultTest extends CommonConditions {
    class TestValue {
        final private String input;
        final private String result;

        public TestValue(String input, String result) {
            this.input = input;
            this.result = result;
        }
    }
    TestValue numberOfInstances;
    TestValue vmClass;
    TestValue os;
    TestValue instanceType;
    TestValue region;
    TestValue localSSD;
    TestValue committedUsage;
    TestValue series;
    TestValue gpuType;
    TestValue gpuCount;
    CalculatorPage calculatorPage;
    GenerateTmpEmailPage generateTmpEmail;

    public void driverSetup() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        calculatorPage = mainPage.startSearch("Google Cloud Pricing Calculator").goToResult("Google Cloud Pricing Calculator");
        calculatorPage.switchToContentFrame();
        calculatorPage.clickComputeEngineTab();

        numberOfInstances = new TestValue("4", "4");
        vmClass = new TestValue("Regular", "Provisioning model: Regular");
        os = new TestValue("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)", "Operating System / Software: Free");
        instanceType = new TestValue("n1-standard-8 (vCPUs: 8, RAM: 30GB)", "Instance type: n1-standard-8\nCommitted Use Discount applied");
        region = new TestValue("Frankfurt (europe-west3)", "Region: Frankfurt");
        localSSD = new TestValue("2x375 GB", "Local SSD: 2x375 GiB\nCommitted Use Discount applied");
        committedUsage = new TestValue("1 Year", "Commitment term: 1 Year");
        series = new TestValue("N1", "N1");
        gpuType = new TestValue("NVIDIA Tesla V100", "NVIDIA Tesla V100");
        gpuCount = new TestValue("1", "1");

        calculatorPage.enterNumberOfInstances(numberOfInstances.input);
        calculatorPage.enterOS(os.input);
        calculatorPage.enterVMClass(vmClass.input);
        calculatorPage.enterSeries(series.input);
        calculatorPage.enterMachineType(instanceType.input);
        calculatorPage.setCheckedAddGPUCheckbox();
        calculatorPage.enterGPUType(gpuType.input);
        calculatorPage.enterGPUCount(gpuCount.input);
        calculatorPage.enterLocalSSD(localSSD.input);
        calculatorPage.enterDatacenterLocation(region.input);
        calculatorPage.enterCommittedUsage(committedUsage.input);
        calculatorPage.clickButtonAddToEstimte();
        calculatorPage.sendEstimateToEmailButtonClick();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        generateTmpEmail = new GenerateTmpEmailPage(driver);
        generateTmpEmail.openPage();
        generateTmpEmail.copyEmailButtonClick();

        driver.switchTo().window(tabs.get(0));
        calculatorPage.pasteEmailToSendEstimateToEmailForm();
        calculatorPage.setSendEstimateToEmailPopupButtonClick();
    }

    @Test
    public void compareVmClass() {
        driverSetup();
        String calculatorEstimateCost = calculatorPage.getResulltCalculatorEstimateCost();
        String emailEstimateCost;

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        EmailListPage emailListPage = generateTmpEmail.checkEmailButtonClick();
        emailListPage.openEmail();
        emailEstimateCost = emailListPage.getEstimateEmailCost();
        assertEquals(emailEstimateCost, calculatorEstimateCost);
    }
}
