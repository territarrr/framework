package service;

import model.Calculator;
import model.InputAndResult;

public class CalculatorCreator {
    public static final InputAndResult NUMBER_OF_INSTANCES = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.numberofinstances.input", "testdata.inputandresult.numberofinstances.result");
    public static final InputAndResult VM_CLASS = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.vmclass.input", "testdata.inputandresult.vmclass.result");
    public static final InputAndResult OS = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.os.input", "testdata.inputandresult.os.result");
    public static final InputAndResult INSTANCE_TYPE = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.instancetype.input", "testdata.inputandresult.instancetype.result");
    public static final InputAndResult REGION = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.region.input", "testdata.inputandresult.region.result");
    public static final InputAndResult LOCAL_SSD = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.localssd.input", "testdata.inputandresult.localssd.result");
    public static final InputAndResult COMMITTED_USAGE = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.committedusage.input", "testdata.inputandresult.committedusage.result");
    public static final InputAndResult SERIES = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.series.input", "testdata.inputandresult.series.result");
    public static final InputAndResult GPU_TYPE = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.gputype.input", "testdata.inputandresult.gputype.result");
    public static final InputAndResult GPU_COUNT = InputAndResultCreator.withCredentialsFromProperty("testdata.inputandresult.gpucount.input", "testdata.inputandresult.gpucount.result");

    public static Calculator withCredentialsFromProperty(){
        return new Calculator(NUMBER_OF_INSTANCES, VM_CLASS, OS, INSTANCE_TYPE, REGION, LOCAL_SSD, COMMITTED_USAGE, SERIES, GPU_TYPE, GPU_COUNT);
    }
}