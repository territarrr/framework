package model;

import java.util.Objects;

public class InputAndResult {
    private String input;
    private String result;

    public InputAndResult(String input, String result) {
        this.input = input;
        this.result = result;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "InputAndResult{" +
                "input='" + input + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputAndResult that = (InputAndResult) o;
        return Objects.equals(input, that.input) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input, result);
    }
}
