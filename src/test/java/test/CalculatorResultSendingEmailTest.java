package test;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import page.EmailListPage;
import page.GenerateTmpEmailPage;
import java.util.ArrayList;
import static org.testng.Assert.assertEquals;

public class CalculatorResultSendingEmailTest extends CommonConditions {
    @Test
    public void compareEmailResultAndCalcResult() {
        calculatorPage.sendEstimateToEmailButtonClick();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        generateTmpEmail = new GenerateTmpEmailPage(driver);
        generateTmpEmail.openPage();
        generateTmpEmail.copyEmailButtonClick();

        driver.switchTo().window(tabs.get(0));
        calculatorPage.pasteEmailToSendEstimateToEmailForm();
        calculatorPage.setSendEstimateToEmailPopupButtonClick();
        String calculatorEstimateCost = calculatorPage.getResulltCalculatorEstimateCost();
        calculatorEstimateCost = calculatorEstimateCost.substring(calculatorEstimateCost.indexOf("USD") + "USD".length(), calculatorEstimateCost.indexOf("per")).trim();
        String emailEstimateCost;

        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        EmailListPage emailListPage = generateTmpEmail.checkEmailButtonClick();
        emailListPage.openEmail();
        emailEstimateCost = emailListPage.getEstimateEmailCost();
        emailEstimateCost = emailEstimateCost.substring(emailEstimateCost.indexOf("USD") + new String("USD").length()).trim();
        assertEquals(calculatorEstimateCost, emailEstimateCost);
    }
}
