package ccv;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    
	//创建一个新文件
	public static void createFile(String filePath) {
		try {

			File file = new File(filePath);
			// 创建一个新文件
			boolean fvar = file.createNewFile();
			if (fvar) {
				System.out.println("File has been created successfully");
			}
			else {
				System.out.println("File already present at the specified location");
			}
		} catch (IOException e) {
			System.out.println("Exception Occurred:");
			e.printStackTrace();
		}
	}
	//移动文件
	public static void moveFile(String fromPath, String toPath) {
        System.out.println("移动文件：从路径 " + fromPath + " 移动到路径 " + toPath);
        File file = new File(fromPath);
            if (file.isFile()){  
                File toFile=new File(toPath+"\\"+file.getName());  
                if (toFile.exists()){  
                   System.out.println("文件已存在");
                }
                else{
                    file.renameTo(toFile); 
                    System.out.println("移动文件成功");
                } 
           }         
     }
	
}



