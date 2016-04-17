package algorithm.sds;
import java.io.FileInputStream;
import java.util.Scanner;

// ��ǰ�� �Ϸù�ȣ
public class productSerialNumber {
	
	static int T, N; //T�� ��ü �׽�Ʈ ���̽��� ��, N�� �Ϸù�ȣ�� ���Ǵ� ���ĺ��� ����
	static String A, B; //A�� ù���� �Ϸù�ȣ, B�� �ι�° �Ϸù�ȣ
	static long result; //�����. �������� 64��Ʈ �������� ��������Ƿ� long Ÿ������ ����

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("C:/Users/cho/git/algorithmStudy/input_txt/sds/productSerialNumber_input.txt"));

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			A = sc.next();
			B = sc.next();
			
			//�־��� �Ϸù�ȣ A B �߿� ��� ���� �� ���߿� ����Ǿ����� �� �� ���� ������ Math.abs �Լ��� Ȱ���ؼ� ���밪�� ���Ѵ�.
			result = Math.abs(returnSerialNumber(A) - returnSerialNumber(B))-1; //�� ��ǰ������ ����� ��ǰ �� �̹Ƿ� �ڱ��ڽ��� �߰��� ������.

			System.out.println("#"+test_case+" "+result);
		}
	}
	
	public static long returnSerialNumber(String serial){
		
		long serialNumber = 0; //�Է¹��� ���ڿ��� ��ǰ �����ȣ.
		int[] abc = new int[N]; //����� ���ĺ��� üũ �� �迭.

		for(int i = 0; i < N; i++){
			abc[i] = 0; // i��  ����-'a' �� ������ ����ȯ ���� �ǹ�. ��, a=0, b=1 ... ������� ���� ���ĺ��� ���� 0���� �Է� 
		}
		
		for(int i = 0; i < N; i++){
			
			int charNum = (int)(serial.charAt(i)- 'a');
			
			int count = 0; //�̹� ����� ���ĺ��� ������ ���. 
			for(int j=0; j<charNum; j++){ //���� ���ĺ��� �ι� ���� �� �����Ƿ�, for ������ charNum �������� �˻� 
				if(abc[j] == 0){
					count++;
				}
			}
			
			//count�� charNum ���� ���ڸ��� ���ĺ��� �̹� ���� ���ĺ��� ������ �������� ����.
			serialNumber = serialNumber + count * factorial(N-i-1);
			
			abc[charNum] = 1; //���Ǿ����Ƿ� ������ 1�� �Է�;
		}
		
		return serialNumber;
	}
	
	public static long factorial(long val){
		
		if(val == 0) return 1;
		return val * factorial(val-1);
	}
}
