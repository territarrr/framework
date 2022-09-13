package test;

import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorResultTest extends CommonConditions{
    @Test
    public void compareVmClass() {
        assertEquals(vmClass.getResult(), calculatorPage.getResultVM());
    }

    @Test
    public void compareOs() {
        assertEquals(os.getResult(), calculatorPage.getResultOS());
    }

    @Test
    public void compareInstanceType() {
        assertEquals(instanceType.getResult(), calculatorPage.getResultInstanceType());
    }

    @Test
    public void compareRegion() {
        assertEquals(region.getResult(), calculatorPage.getResultRegion());
    }

    @Test
    public void compareLocalSSD() {
        assertEquals(localSSD.getResult(), calculatorPage.getResultLocalSSD());
    }

    @Test
    public void compareCommittedUsage() {
        assertEquals(committedUsage.getResult(), calculatorPage.getResultCommitmentTerm());
    }
}
