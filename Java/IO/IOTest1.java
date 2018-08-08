import java.io.File;
import java.io.IOException;

public class IOTest1{
	public static void main(String[] args) {
		File dir = new File("C:\\testDir");
		System.out.println("�����ϸ� true:"+dir.exists());
		System.out.println("�����̸� true:"+dir.isFile());
		System.out.println("���丮�� true:"+dir.isDirectory());
		System.out.println("��� ��ȯ:"+dir.getPath());

		
		File dir2 = new File(dir.getPath()+File.separator+"test"+File.separator+"test1"+File.separator+"test2");
		//�ý��۸��� ��� ǥ���� �ٸ� > �ڹٿ����� File.separator���� ���� 
		//dir.mkdir(); �ش� ������ ����
		//dir2.mkdirs(); ���� ������ ����
		boolean flag = dir2.mkdirs();
		System.out.println("���丮 ���� ���� :" + flag);
		
		File file1 = new File(dir.getPath()+File.separator+"a.xlsx");
		System.out.println("���� ���:"+file1.getPath());
		System.out.println("���� �����ϸ� true:"+file1.exists());
		System.out.println("�����̸� true:"+file1.isFile());
		
		//���� ���� ��, ����� ����ó�� �ʿ�.
		try {
			boolean fileFlag = file1.createNewFile();
			System.out.println("���� �̸�:"+file1.getName()+"���� ��������:"+fileFlag);
		}catch (IOException e) {
			e.printStackTrace();
		}
			System.out.println("�����̸� true:"+file1.isFile());
			System.out.println("���� �̸� :"+file1.getName());
			System.out.println("�ش� ������ ������ �ִ� ���丮 ���"+file1.getParent());
			System.out.println("�ش� ������ ������ �ִ� ���丮 ���� Ȯ��"+file1.getParentFile().getName());
	}
}
