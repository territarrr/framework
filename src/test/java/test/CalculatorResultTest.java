package test;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorResultTest extends CommonConditions {
    @Test
    public void compareVmClass() {
        assertEquals(calculatorPage.getResultVM(), vmClass.getResult());
    }

    @Test
    public void compareOs() {
        assertEquals(calculatorPage.getResultOS(), os.getResult());
    }

    @Test
    public void compareInstanceType() {
        assertEquals(calculatorPage.getResultInstanceType(), instanceType.getResult());
    }

    @Test
    public void compareRegion() {
        assertEquals(calculatorPage.getResultRegion(), region.getResult());
    }

    @Test
    public void compareLocalSSD() {
        assertEquals(calculatorPage.getResultLocalSSD(), localSSD.getResult());
    }

    @Test
    public void compareCommittedUsage() {
        assertEquals(calculatorPage.getResultCommitmentTerm(), committedUsage.getResult());
    }
}
