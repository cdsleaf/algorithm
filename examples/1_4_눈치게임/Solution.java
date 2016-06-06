import java.io.FileInputStream;
import java.util.Scanner;

class Solution {

	static int N, K; // N : ����� ���, K : �θ� �� �ִ� ��
	static int W[][] = new int[501][500]; // [N][J], [i][j] i�� ����� j�� �θ� �� ���� ��, j�� �θ� ������ ��ٸ��� �ð�
	static int Answer[] = new int[501]; // Answer[i] : i�� ����� ���� - 0 : ���� �Ⱥθ�  1 : �θ�  -1 : �ɸ�
	
	public static void main(String args[]) throws Exception {

		int test_case, T;
		int tmpArr[] = new int[500];
		int itmp;
		int timemin;
		
		boolean flag;

		/*
		  �Ʒ��� ȣ���� ǥ�� �Է� ��� sample input ���Ϸκ��� �о���ڴٴ� �ǹ��Դϴ�.
		  �������� �ۼ��� �ڵ带 �׽�Ʈ�� �� �� ���� �Է��� ������ �� �� �ڵ带 �߰��Ͽ�
		  ���� �Է��� ǥ�� �Է� ��� �� ���Ϸκ��� �޾ƿ� �� �ֽ��ϴ�. 
		  ���� �׽�Ʈ ���� �ÿ��� �� �ڵ带 ����ϼŵ� �����ϴ�.
		  ��, �ڵ带 �����Ͻ� ������ �ݵ�� �� �ڵ带 ����ų� �ּ�ó�� �ϼž� �մϴ�.
		*/
		System.setIn(new FileInputStream("sample_input.txt"));
	
		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		*/
		Scanner sc = new Scanner(System.in);
	
		// �׽�Ʈ ���̽��� �� T 
		T = sc.nextInt();

		for (test_case = 1; test_case <= T; ++test_case) {
			// �Է�
			N = sc.nextInt();
			K = sc.nextInt();
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= K; j++) {
					W[i][j] = sc.nextInt();
				}
				Answer[i] = 0;
			}
			flag = false;

			// ó��
			for (int j = 1; j <= K; j++) {
				itmp = 0;
				timemin = 100; // �ִ� 60
				for (int i = 1; i <= N; i++) {
					if (Answer[i] == 1) continue; // �̹� �θ� ����� ���
					if (W[i][j] < timemin) {
						itmp = 1;
						tmpArr[0] = i; // i�� ����� ����ϰ� ������ ����
						timemin = W[i][j];
					}
					else if (W[i][j] == timemin) {
						tmpArr[itmp++] = i; // �ߺ��� ��� ���
					}
				}
				// �� �������� itmp �� �ݵ�� 1 �̻��̾�� ��.
				if (itmp == 1) {
					Answer[tmpArr[0]] = 1;
				}
				else { // itmp �� 2 �̻��� ���
					for (int t = 0; t < itmp; t++) {
						Answer[tmpArr[t]] = -1;
					}
					flag = true;
					break;
				}
			}
			if(flag == false) {
				for (int i = 1; i <= N; i++) {
					if (Answer[i] == 0) Answer[i] = -1;
				}
			}
			// ���
			for (int i = 1; i <= N; i++) {
				if (Answer[i] == -1) {
					System.out.print(i+" ");
				}
			}
			System.out.println();
		}
	}
}		
		
