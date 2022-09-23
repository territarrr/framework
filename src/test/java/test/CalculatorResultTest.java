package test;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorResultTest extends CommonConditions {
    @Test
    public void compareVmClass() {
        assertEquals(calculatorPage.getResultVM(), calculatorData.getVmClass().getResult());
    }

    @Test
    public void compareOs() {
        assertEquals(calculatorPage.getResultOS(), calculatorData.getOs().getResult());
    }

    @Test
    public void compareInstanceType() {
        assertEquals(calculatorPage.getResultInstanceType(), calculatorData.getInstanceType().getResult());
    }

    @Test
    public void compareRegion() {
        assertEquals(calculatorPage.getResultRegion(), calculatorData.getRegion().getResult());
    }

    @Test
    public void compareLocalSSD() {
        assertEquals(calculatorPage.getResultLocalSSD(), calculatorData.getLocalSSD().getResult());
    }

    @Test
    public void compareCommittedUsage() {
        assertEquals(calculatorPage.getResultCommitmentTerm(), calculatorData.getCommittedUsage().getResult());
    }
}
