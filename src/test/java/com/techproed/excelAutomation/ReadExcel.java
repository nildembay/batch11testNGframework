package com.techproed.excelAutomation;

import com.github.javafaker.File;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {
    @Test
    public void readExcel() throws IOException {
        String path="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet=workbook.getSheetAt(0);
        Row row=sheet.getRow(0);
        Cell cell=row.getCell(0);
        System.out.println(cell);
        String hucre=cell.toString();
        System.out.println(hucre);


    }

    @Test
    public void readExcel2() throws IOException {
        /*
        - 1.satirdaki 2.hucreye gidelim ve yazdiralim
        - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        - Satir sayisini bulalim
        - Fiziki olarak kullanilan satir sayisini bulun
        - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

         */

        String path="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        System.out.println(workbook.getSheetAt(0).getRow(0).getCell(1));

        String birinciSatirIkinciHucre=workbook.getSheetAt(0).getRow(0).getCell(1).toString();
        System.out.println(birinciSatirIkinciHucre);

        String ikinciSatirDorduncuHucre=workbook.getSheetAt(0).getRow(1).getCell(3).toString().toLowerCase();
        Assert.assertEquals(ikinciSatirDorduncuHucre,"kabil");

        System.out.println(workbook.getSheetAt(0).getLastRowNum());

        System.out.println(workbook.getSheetAt(1).getLastRowNum());
        System.out.println(workbook.getSheetAt(1).getPhysicalNumberOfRows());

        String ulkeAdi="";
        String baskentAdi="";
        Map<String,String> baskentler=new HashMap<>();
        for (int i=1; i<=workbook.getSheetAt(0).getLastRowNum(); i++){

            ulkeAdi=workbook.getSheetAt(0).getRow(i).getCell(0).toString();
            baskentAdi=workbook.getSheetAt(0).getRow(i).getCell(1).toString();
            baskentler.put(ulkeAdi,baskentAdi);

        }
        System.out.println(baskentler);


    }
}
