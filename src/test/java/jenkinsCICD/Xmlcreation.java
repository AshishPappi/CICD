package jenkinsCICD;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Xmlcreation extends Global {
	
	
	
	
	public static void runner() {
		
		try {
			
		
		TestNG testng =new TestNG();
		XmlSuite xmlsuite;
		
		XmlTest xmltest;
		xmlsuite= new XmlSuite();
		xmlsuite.setName("suite2");
		xmlsuite.setParallel("false");
		xmlsuite.setVerbose(3);	
		xmltest= new XmlTest(xmlsuite);
		xmltest.setName("Test");
		xmltest.setPreserveOrder("true");
		List<XmlSuite> xmlsuites= new ArrayList<XmlSuite>();
		List<XmlClass> xmlclasses= new ArrayList<XmlClass>();
		xmlsuites.add(xmlsuite);
		testng.setXmlSuites(xmlsuites);
		
		int rowcount=0;

		ExcelUtils excelUtils= new ExcelUtils(ControllersheetPath);
		int icstart=0;int icend=0;
		for (int ictrstart=0;ictrstart<=excelUtils.numberOfRows(ControllersheetPath,"Executionsheet");ictrstart++) {
			String xlsScrName=excelUtils.readFromExcel("Executionsheet", ictrstart, 0).trim().toLowerCase();
			String xlsclassname=excelUtils.readFromExcel("Executionsheet", ictrstart, 1).trim();
			String Executionstatus=excelUtils.readFromExcel("Executionsheet", ictrstart, 2).trim().toLowerCase();
			System.out.println("property"+System.getProperty("automation.name"));
			if (System.getProperty("automation.name")==null) {
								if(Executionstatus.toLowerCase().equals("yes") ) {
													
													Global.gblTCScenarioName=xlsScrName;			
													Class c=Class.forName(xlsclassname);
													Global.gblTCSclass=c;
													XmlClass xmlclass= new XmlClass(gblTCSclass);			
													xmlclasses.add(xmlclass);
													xmltest.setClasses(xmlclasses);					
											
												}else							 {
													System.out.println("Skipped");
																				}				
			}else {
				String value=	System.getProperty("automation.name");
				String [] arr=value.split("-");
				int count=arr.length;
						for (int j=0;j<count;j++) {
										if( count==1 &&arr[j].equalsIgnoreCase(xlsclassname)) {
											
											Class c=Class.forName(arr[j]);
											Global.gblTCSclass=c;
											XmlClass xmlclass= new XmlClass(gblTCSclass);			
											xmlclasses.add(xmlclass);
											xmltest.setClasses(xmlclasses);	
											
																								}
										else if(count>1&&arr[j].equalsIgnoreCase(xlsclassname)) {
											Class c=Class.forName(arr[j]);
											Global.gblTCSclass=c;
											XmlClass xmlclass= new XmlClass(gblTCSclass);			
											xmlclasses.add(xmlclass);
											xmltest.setClasses(xmlclasses);
											break;
																								}
												}
				}
			
			System.out.println("nextiteration");
																	}	
	
		testng.run();
		
	
		}catch(Exception e) {
			
		}
	
	
	}
	
	
	
}
