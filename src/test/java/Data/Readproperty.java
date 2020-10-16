package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readproperty {


	//to get path of the config file
	public static Properties UserData = 
			LoadProperties(System.getProperty(("user.dir")+"\\src\\test\\java\\com\\jiracreate\\configuration\\config.properties"));

	public static  Properties LoadProperties(String path) //method to load data from config.properities file
	{
		Properties pro=new Properties();
		try {
			FileInputStream stream=new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {

			System.out.println("Error :" +e.getMessage());
		} catch (IOException e) {

			System.out.println("Error :" +e.getMessage());
		}
		return pro;
	}

}
