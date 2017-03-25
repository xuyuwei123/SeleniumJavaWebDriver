package selenium;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class readdata {

	public static void main(String[] args)
	{
	    File csv = new File("F:\\大三下资料\\软件测试技术\\inputgit.csv");  // CSV文件路径
	    BufferedReader br = null;
	    try
	    {
	        br = new BufferedReader(new FileReader(csv));
	    } catch (FileNotFoundException e)
	    {
	        e.printStackTrace();
	    }
	    String line = "";
	    String everyLine[];
	    int i=1;
	    try {
	            while ((line = br.readLine()) != null)  //读取到的内容给line变量
	            {
	            	if(i==1){
	            	i++;
	            	continue;
	            	}
	            	else{
	                everyLine = line.split(",");
	                System.out.println(everyLine[0].substring(4,10));
	            	}
	            }  
	    } catch (IOException e)
	    {
	        e.printStackTrace();
	    }

	}
}
