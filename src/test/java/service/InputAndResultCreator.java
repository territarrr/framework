package service;

import model.InputAndResult;

public class InputAndResultCreator {
    public static InputAndResult withCredentialsFromProperty(String input, String result){
        return new InputAndResult(TestDataReader.getTestData(input),
                TestDataReader.getTestData(result));
    }
}
