package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {

    /*
    In this test we will read from excel file
     */

    @Test
    public void excel_read_test() throws IOException {

        String path = "SampleData.xlsx";

        //To be able to read from Excel we need to load the file
        FileInputStream fileInputStream = new FileInputStream(path);

        //workbook > sheet > row > cell

        //We created workbook instance and loaded with "SampleData" file
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //Create the sheep and pass the name of the sheet we want to work on
        XSSFSheet sheet = workbook.getSheet("Employees");

        //ROW --> SHEET
        //Print out "Steven" from excel sheet
        System.out.println(sheet.getRow(1).getCell(0));

        //Print out "Singer" from excel sheet
        System.out.println(sheet.getRow(3).getCell(2));

        //Returns the count of used cells only
        //If there are cells not used they will not be counted
        //Starts from counting 1
        int usedRows = sheet.getPhysicalNumberOfRows();

        //Returns the count from top to bottom
        //Even counts if there are empty cells
        //this starts counting from 0
        int lastUseRow = sheet.getLastRowNum();

        //TODO: 1- CREATE A LOGIC TO PRINT OUT NEENA'S NAME DYNAMICALLY

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            XSSFCell currentCell = sheet.getRow(rowNum).getCell(0);

            if (currentCell.toString().equals("Neena")){
                System.out.println("CurrentCell = " + currentCell);
            }
        }

        //TODO: 2- CREATE A LOGIC TO PRINT OUT ADAM'S LAST NAME DYNAMICALLY

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            if(sheet.getRow(rowNum).getCell(1).toString().equals("Sandler"))
            System.out.println("Adam's last name = " + sheet.getRow(rowNum).getCell(1));
        }

        //TODO: 3- CREATE A LOGIC TO PRINT OUT STEVEN KING'S JOB ID DYNAMICALLY
        // CHECK FOR LAST NAME, IF IT IS KING, PRINT OUT JOB_ID

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            if(sheet.getRow(rowNum).getCell(1).toString().equals("King"))
                System.out.println("Steven King's Job ID = " + sheet.getRow(rowNum).getCell(2));
        }

    }
}
