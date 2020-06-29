package org.titanium.intermediate;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]{
                {"Grover", "Google"},
                {"Luis", "Yahoo"},
                {"Pedro", "Gmail"},
                {"Lorena", "Amazon"},
        };
    }
}
