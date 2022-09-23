package test;

import driver.DriverSingleton;
import model.Calculator;
import model.InputAndResult;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import page.CalculatorPage;
import page.GenerateTmpEmailPage;
import page.MainPage;
import service.CalculatorCreator;
import service.InputAndResultCreator;
import utils.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;
    protected CalculatorPage calculatorPage;
    protected GenerateTmpEmailPage generateTmpEmail;

    protected Calculator calculatorData = CalculatorCreator.withCredentialsFromProperty();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = DriverSingleton.getDriver();
        driverSetup();
    }

    public void driverSetup() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        calculatorPage = mainPage.startSearch("Google Cloud Pricing Calculator").goToResult("Google Cloud Pricing Calculator");
        calculatorPage.switchToContentFrame();
        calculatorPage.clickComputeEngineTab();
        calculatorPage.enterNumberOfInstances(calculatorData.getNumberOfInstances().getInput());
        calculatorPage.enterOS(calculatorData.getOs().getInput());
        calculatorPage.enterVMClass(calculatorData.getVmClass().getInput());
        calculatorPage.enterSeries(calculatorData.getSeries().getInput());
        calculatorPage.enterMachineType(calculatorData.getInstanceType().getInput());
        calculatorPage.setCheckedAddGPUCheckbox();
        calculatorPage.enterGPUType(calculatorData.getGpuType().getInput());
        calculatorPage.enterGPUCount(calculatorData.getGpuCount().getInput());
        calculatorPage.enterLocalSSD(calculatorData.getLocalSSD().getInput());
        calculatorPage.enterDatacenterLocation(calculatorData.getRegion().getInput());
        calculatorPage.enterCommittedUsage(calculatorData.getCommittedUsage().getInput());
        calculatorPage.clickButtonAddToEstimte();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
