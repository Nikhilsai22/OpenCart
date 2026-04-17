package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

    // DataProvider 1
    @DataProvider(name = "LoginData")
    public String[][] getLoginData() throws IOException {

        String path = ".\\testData\\OpenCart_LoginData.xlsx";

        ExcelUtility xlutil = new ExcelUtility(path); // creating an object for XLUtility

        int totalRows = xlutil.getRowCount("Sheet1");
        int totalCols = xlutil.getCellCount("Sheet1", 1);

        String loginData[][] = new String[totalRows][totalCols]; 
        // created for two dimensional array which can store data from excel

        for (int i = 1; i <= totalRows; i++) { // read the data from excel storing in two dimensional array
            for (int j = 0; j < totalCols; j++) {
                loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
            }
        }

        return loginData; // returning two dimensional array
    }
}
