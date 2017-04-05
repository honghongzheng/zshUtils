package excel;

import java.io.File;
import java.io.FileInputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


/**
 * @since zshUtils
 * @author Ö£Ë®ºé  
 */
public class TestReader {
	public static String xls2String(File file){
		String result = "";
		try{
			FileInputStream fis = new FileInputStream(file);   
			StringBuilder sb = new StringBuilder();   
			jxl.Workbook rwb = Workbook.getWorkbook(fis);   
			Sheet[] sheet = rwb.getSheets();   
			for (int i = 0; i < sheet.length; i++) {   
				Sheet rs = rwb.getSheet(i);   
				for (int j = 0; j < rs.getRows(); j++) {   
					Cell[] cells = rs.getRow(j);   
					for(int k=0;k<cells.length;k++)   
						sb.append(cells[k].getContents());   
				}   
			}   
			fis.close();   
			result += sb.toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args){
		File file = new File("C:/demo.xlsx");
//		File file = new File("C:/demo.xlsx");
		System.out.println(xls2String(file));
	}
}
