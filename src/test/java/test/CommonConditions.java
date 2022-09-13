package test;

import driver.DriverSingleton;
import model.InputAndResult;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import page.CalculatorPage;
import page.GenerateTmpEmailPage;
import page.MainPage;
import service.InputAndResultCreator;


public class CommonConditions {
    protected WebDriver driver;
    CalculatorPage calculatorPage;
    GenerateTmpEmailPage generateTmpEmail;
    InputAndResult numberOfInstances = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.numberofinstances.input", "testdata.inputandresult.numberofinstances.result");
    InputAndResult vmClass = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.vmclass.input", "testdata.inputandresult.vmclass.result");
    InputAndResult os = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.os.input", "testdata.inputandresult.os.result");
    InputAndResult instanceType = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.instancetype.input", "testdata.inputandresult.instancetype.result");
    InputAndResult region = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.region.input", "testdata.inputandresult.region.result");
    InputAndResult localSSD = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.localssd.input", "testdata.inputandresult.localssd.result");
    InputAndResult committedUsage = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.committedusage.input", "testdata.inputandresult.committedusage.result");
    InputAndResult series = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.series.input", "testdata.inputandresult.series.result");
    InputAndResult gpuType = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.gputype.input", "testdata.inputandresult.gputype.result");
    InputAndResult gpuCount = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.gpucount.input", "testdata.inputandresult.gpucount.result");

    @BeforeClass(alwaysRun = true)
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

        calculatorPage.enterNumberOfInstances(numberOfInstances.getInput());
        calculatorPage.enterOS(os.getInput());
        calculatorPage.enterVMClass(vmClass.getInput());
        calculatorPage.enterSeries(series.getInput());
        calculatorPage.enterMachineType(instanceType.getInput());
        calculatorPage.setCheckedAddGPUCheckbox();
        calculatorPage.enterGPUType(gpuType.getInput());
        calculatorPage.enterGPUCount(gpuCount.getInput());
        calculatorPage.enterLocalSSD(localSSD.getInput());
        calculatorPage.enterDatacenterLocation(region.getInput());
        calculatorPage.enterCommittedUsage(committedUsage.getInput());
        calculatorPage.clickButtonAddToEstimte();
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
