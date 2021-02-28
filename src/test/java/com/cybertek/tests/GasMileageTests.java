package com.cybertek.tests;

import com.cybertek.pages.GasMileageCalculatorPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GasMileageTests {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;
    GasMileageCalculatorPage gasMileageCalculatorPage = new GasMileageCalculatorPage();

    @Test
    public void gas_mileage_calculation() throws IOException {

        Driver.getDriver().get("https://www.calculator.net/gas-mileage-calculator.html");

        String path = "src/test/resources/testData/GasMileageTestData.xlsx";
        fileInputStream = new FileInputStream(path);
        workbook = new XSSFWorkbook(fileInputStream);

        sheet = workbook.getSheet("Sheet1");

        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {


            XSSFRow currentRow = sheet.getRow(rowNum);

            if (!currentRow.getCell(0).toString().equals("Y")) {
                if (currentRow.getCell(6) == null) {
                    currentRow.createCell(6);
                }
                currentRow.getCell(6).setCellValue("Skip Requested!");
                continue;
            }
            //=====================================================================

            //double current = 123000;
            double current = currentRow.getCell(1).getNumericCellValue();

            gasMileageCalculatorPage.inputCurrentOdo.clear();
            gasMileageCalculatorPage.inputCurrentOdo.sendKeys(String.valueOf(current));

            //double previous = 122000;
            double previous = currentRow.getCell(2).getNumericCellValue();

            gasMileageCalculatorPage.inputPreviousOdo.clear();
            gasMileageCalculatorPage.inputPreviousOdo.sendKeys(String.valueOf(previous));

            //double gas = 70;
            double gas = currentRow.getCell(3).getNumericCellValue();

            gasMileageCalculatorPage.inputGas.clear();
            gasMileageCalculatorPage.inputGas.sendKeys(String.valueOf(gas));
            BrowserUtils.sleep(1);
            gasMileageCalculatorPage.calculateButton.click();

            //How does the calculation of AVG/MPG work
            // (current-previous)/gallons --> avg MPG

            double expectedResult = (current - previous) / gas;
            //BrowserUtils.waitForVisibility(gasMileageCalculatorPage.resultInGas, 10);

            String[] actualResultArr = gasMileageCalculatorPage.resultInGas.getText().split(" ");

            System.out.println("actualResultArr = " + actualResultArr[0]);

            String actual = actualResultArr[0];
            String expected = String.valueOf(expectedResult);

            DecimalFormat df = new DecimalFormat("#0.00");
            String formattedExpected = df.format(expectedResult);

            System.out.println("expectedResult = " + formattedExpected);

            if (currentRow.getCell(4) == null) {
                currentRow.createCell(4);
            }

            currentRow.getCell(4).setCellValue(formattedExpected);

            if (currentRow.getCell(5) == null) {
                currentRow.createCell(5);
            }

            currentRow.getCell(5).setCellValue(actual);

            if (currentRow.getCell(6) == null) {
                currentRow.createCell(6);
            }
            if (actual.equals(formattedExpected)) {
                currentRow.getCell(6).setCellValue("PASS");
                System.out.println("PASS!");
            } else {
                currentRow.getCell(6).setCellValue("FAIL");
                System.out.println("FAIL!");
            }

            if (currentRow.getCell(7) == null) {
                currentRow.createCell(7);
            }

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss a");
            currentRow.getCell(7).setCellValue(LocalTime.now().format(dtf));

        }

        fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        workbook.close();
        fileInputStream.close();
        fileOutputStream.close();





    }
}
