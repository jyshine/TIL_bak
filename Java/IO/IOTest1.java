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
}
