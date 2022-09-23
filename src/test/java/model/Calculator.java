package model;

import service.InputAndResultCreator;

public class Calculator {
    private final InputAndResult numberOfInstances;
    private final InputAndResult vmClass;
    private final InputAndResult os;
    private final InputAndResult instanceType;
    private final InputAndResult region;
    private final InputAndResult localSSD;
    private final InputAndResult committedUsage;
    private final InputAndResult series;
    private final InputAndResult gpuType;
    private final InputAndResult gpuCount;

    public Calculator(InputAndResult numberOfInstances, InputAndResult vmClass, InputAndResult os, InputAndResult instanceType, InputAndResult region, InputAndResult localSSD, InputAndResult committedUsage, InputAndResult series, InputAndResult gpuType, InputAndResult gpuCount) {
        this.numberOfInstances = numberOfInstances;
        this.vmClass = vmClass;
        this.os = os;
        this.instanceType = instanceType;
        this.region = region;
        this.localSSD = localSSD;
        this.committedUsage = committedUsage;
        this.series = series;
        this.gpuType = gpuType;
        this.gpuCount = gpuCount;
    }

    public InputAndResult getNumberOfInstances() {
        return numberOfInstances;
    }

    public InputAndResult getVmClass() {
        return vmClass;
    }

    public InputAndResult getOs() {
        return os;
    }

    public InputAndResult getInstanceType() {
        return instanceType;
    }

    public InputAndResult getRegion() {
        return region;
    }

    public InputAndResult getLocalSSD() {
        return localSSD;
    }

    public InputAndResult getCommittedUsage() {
        return committedUsage;
    }

    public InputAndResult getSeries() {
        return series;
    }

    public InputAndResult getGpuType() {
        return gpuType;
    }

    public InputAndResult getGpuCount() {
        return gpuCount;
    }
}
