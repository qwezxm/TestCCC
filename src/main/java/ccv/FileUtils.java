package ccv;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    
	//����һ�����ļ�
	public static void createFile(String filePath) {
		try {

			File file = new File(filePath);
			// ����һ�����ļ�
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
	//�ƶ��ļ�
	public static void moveFile(String fromPath, String toPath) {
        System.out.println("�ƶ��ļ�����·�� " + fromPath + " �ƶ���·�� " + toPath);
        File file = new File(fromPath);
            if (file.isFile()){  
                File toFile=new File(toPath+"\\"+file.getName());  
                if (toFile.exists()){  
                   System.out.println("�ļ��Ѵ���");
                }
                else{
                    file.renameTo(toFile); 
                    System.out.println("�ƶ��ļ��ɹ�");
                } 
           }         
     }
	
}



