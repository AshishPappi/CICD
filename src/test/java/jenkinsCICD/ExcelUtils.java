package jenkinsCICD;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
public class ExcelUtils {
	
	
	public static Sheet ExcelWSheet;
	 
	public static Workbook ExcelWBook;

	public static Cell Cell;

	public static Row Row;
	
	
	public  String filePath;
	
	public  FileInputStream fin;
	public  FileOutputStream fout;
	public  Workbook workbook;
	
	
	public ExcelUtils(String strFilepth) {
		filePath=strFilepth;
		try {
			fin=new FileInputStream(filePath);
			workbook=new XSSFWorkbook(fin);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public  String readFromExcel(String sheetName,int rowNum,int colInd) 
	{
		String cellValue="";
		try {
			DataFormatter objFormater=new DataFormatter();
			Sheet sheet=workbook.getSheet(sheetName);
			Cell cell=sheet.getRow(rowNum).getCell(colInd);
			cellValue=objFormater.formatCellValue(cell);
			return cellValue;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return cellValue;
		}
		
		
	}
	public int getColCount(String sheetName,int rowNum)
	{
		int colCount=0;
		try {
			Sheet sheet=workbook.getSheet(sheetName);
			colCount=sheet.getRow(rowNum).getLastCellNum();
			return colCount;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return colCount;
		}
		
	}
	
	public int  numberOfRows(String fileName,String sheetName){
		
		FileInputStream fin=null;
		Workbook workbook=null;
		Sheet sheet= null;
		int rowCount=0;
		
		try{
			fin= new FileInputStream(fileName);
			workbook=new XSSFWorkbook(fin);
			sheet=workbook.getSheet(sheetName);
			rowCount=sheet.getPhysicalNumberOfRows();
			 
			
		}catch(Exception e){
			
			System.out.println("Error occured in number of rows"+ e.getMessage());
			
		}
		return rowCount;
		
	}
	/*public static void main(String[] args) {
		try {
			System.out.println(getTableArray("D:\\Project\\DataProvider\\Testdata\\AutomationDemoSite.xlsx","LOGIN"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	

public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   

   String[][] tabArray = null;

   try {

	   FileInputStream ExcelFile = new FileInputStream(FilePath);



	   ExcelWBook = new XSSFWorkbook(ExcelFile);

	   ExcelWSheet = ExcelWBook.getSheet(SheetName);

	   int startRow = 1;

	   int startCol = 0;

	   int ci,cj;

	   int totalRows = ExcelWSheet.getLastRowNum();
	   
	   System.out.println("totalrows"+totalRows);



	   int totalCols = ExcelWSheet.getRow(0).getLastCellNum();
	   System.out.println("totalcolumns"+totalCols);
	   
	   tabArray=new String[totalRows][totalCols];

	   ci=0;

	   for (int i=startRow;i<=totalRows;i++, ci++) {           	   

		  cj=0;

		   for (int j=startCol;j<=totalCols-1;j++, cj++){

			   tabArray[ci][cj]=getCellData(i,j);



				}

			}

		}

	catch (FileNotFoundException e){

		System.out.println("Could not read the Excel sheet");

		e.printStackTrace();

		}

	catch (IOException e){

		System.out.println("Could not read the Excel sheet");

		e.printStackTrace();

		}

	return(tabArray);

	}

public static String getCellData(int RowNum, int ColNum) throws Exception {
	String stringcelldata=" ";

	try{

		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

	if (Cell.getCellType()==CellType.STRING) {
		
		stringcelldata=Cell.getStringCellValue();
	}
	
	

		}catch (Exception e){

		System.out.println(e.getMessage());

		throw (e);

		}
	
	return stringcelldata;

	}

}
