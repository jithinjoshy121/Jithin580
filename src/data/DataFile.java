package data;

import utilities.Xls_Reader;

public class DataFile {
	
	Xls_Reader d=new Xls_Reader("C:\\testing\\NikulTest.xlsx");
	public String correctEmail=d.getCellData("Data2", "Username", 2);
	public String emptyEmail="";
	public String wrongEmail=d.getCellData("Data2", "Username", 3);
	public String wrongPassword=d.getCellData("Data2", "Password", 2);
	public String passwdErrMsg=d.getCellData("Data2", "PasswordError", 2);
	public String emailErrMsg=d.getCellData("Data2", "UsernameError", 3);

}
