import java.io.File;
import java.io.IOException;

public class IOTest1{
	public static void main(String[] args) {
		File dir = new File("C:\\testDir");
		System.out.println("존재하면 true:"+dir.exists());
		System.out.println("파일이면 true:"+dir.isFile());
		System.out.println("디렉토리면 true:"+dir.isDirectory());
		System.out.println("경로 반환:"+dir.getPath());

		
		File dir2 = new File(dir.getPath()+File.separator+"test"+File.separator+"test1"+File.separator+"test2");
		//시스템마다 경로 표현이 다름 > 자바에서는 File.separator으로 구분 
		//dir.mkdir(); 해당 폴더만 생성
		//dir2.mkdirs(); 상위 폴더도 생성
		boolean flag = dir2.mkdirs();
		System.out.println("디렉토리 생셩 여부 :" + flag);
		
		File file1 = new File(dir.getPath()+File.separator+"a.xlsx");
		System.out.println("파일 경로:"+file1.getPath());
		System.out.println("파일 존재하면 true:"+file1.exists());
		System.out.println("파일이면 true:"+file1.isFile());
		
		//파일 생성 시, 입출력 예외처리 필요.
		try {
			boolean fileFlag = file1.createNewFile();
			System.out.println("파일 이름:"+file1.getName()+"파일 생성여부:"+fileFlag);
		}catch (IOException e) {
			e.printStackTrace();
		}
			System.out.println("파일이면 true:"+file1.isFile());
			System.out.println("파일 이름 :"+file1.getName());
			System.out.println("해당 파일을 가지고 있는 디렉토리 경로"+file1.getParent());
			System.out.println("해당 파일을 가지고 있는 디렉토리 명을 확인"+file1.getParentFile().getName());
	}
		
		//폴더에 있는 파일들을 배열에 담아 출력해본다.
		File dir = new File("C:\\testDir");
		String info[] = dir.list();
		for(int i=0; i<info.length;i++) {
			System.out.println("파일 정보"+i+":"+info[i]);
		}
		File [] info2 = dir.listFiles();
		for(int i=0;i<info2.length;i++)
			System.out.println(info2[i].getName());
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class FileService {
	/*
	 * path 정보 파일과 동일한 위치에 있는 파일명만 출력한다 
	 * (디렉토리는 제외) 
	 */
	public void printFileNames(String path) {	
		File file=new File(path);
		File dir=file.getParentFile();
		File list[]=dir.listFiles();
		for(int i=0;i<list.length;i++) {
			if(list[i].isFile()&&!list[i].getName().equals(file.getName())) {
				System.out.println(list[i].getName());
			}//if
		}//for
	}//method
}//class

public class IOTest2{
	public static void main(String[] args) {
		FileService service=new FileService();
		String path=
	    "C:\\java\\util\\eclipse-jee-oxygen-R-win32-x86_64\\eclipse\\eclipse.exe";
		service.printFileNames(path);
	}
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class FileService {
	//throws 
	// path 에 해당되는 파일을 생성 ( 디렉토리가 없으면 디렉토리도 생성)
	public void makeFile(String path) throws IOException {
		File file=new File(path);
		file.getParentFile().mkdirs();
		file.createNewFile();
	}
}
public class IOTest3 {
	public static void main(String[] args) {
		String path="C:\\testDir\\media\\movie\\video.mp4";
		FileService service=new FileService();
		//try catch 
		try {
			service.makeFile(path);
			System.out.println(path+" 파일 생성");
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class FileService {
	public void makeFiles(String dir, String songInfo) throws IOException {
		//폴더 정보를 가져와서 폴더를 생성해준다.
		new File(dir).mkdirs(); 
		//음악 정보를 , 로 나눠 배열에 넣어준다.
		String names[]=songInfo.split(","); 
		//배열에 담긴 음악 정보를 생성한 폴더에 생성해준다.
		for(int i=0;i<names.length;i++) {
			new File(dir+File.separator+names[i]).createNewFile();
		}
	}
}
public class IOTest4 {
	public static void main(String[] args) {
		FileService service=new FileService();
		String dir="C:\\testDir\\media\\music";
		String songInfo="1.mp3, 2.mp3, 3.mp3, 4.mp3";
		try {
			service.makeFiles(dir,songInfo);
			System.out.println("작업완료");
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 파일 이동 : renameTo() 
public class IOTest5 {
	public static void main(String[] args) {
		String orgPath="C:\\orgPathDir\\a.xlsx";
		String destPath="C:\\destPathDir\\a.xlsx";
		File orgFile=new File(orgPath);
		File destFile=new File(destPath);
		boolean moveFlag=orgFile.renameTo(destFile);
		System.out.println("이동:"+moveFlag);
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class FileMoveService {
	public void moveFiles(String orgDir, String destDir) {
		//파일이 있는 경로와 옮길 경로를 파라미터를 받는다.
		//옮길 경로의 폴더를 생성해준다.
		new File(destDir).mkdirs();
		//파일이 있는 경로에 파일들을 배열에 넣어준다.
		File[] orgList=new File(orgDir).listFiles();
		//renameTo 함수를 이용하여 파일을 옮겨준다.
		for(int i=0;i<orgList.length;i++) {
			orgList[i].renameTo(new File(destDir+File.separator+orgList[i].getName()));
		}
	}
}

public class IOTest6 {
	public static void main(String[] args) {
		String orgDir="C:\\orgPathDir";
		String destDir="C:\\destPathDir";
		FileMoveService service=new FileMoveService();
		service.moveFiles(orgDir,destDir);
		System.out.println("작업완료");
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
