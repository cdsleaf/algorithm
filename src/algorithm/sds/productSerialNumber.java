package algorithm.sds;

import java.io.FileInputStream;
import java.util.Scanner;

public class productSerialNumber {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("C:/Users/cho/git/algorithmStudy/input_txt/sds/productSerialNumber_input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		//ǥ���Է� System.in ���� ���� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		System.out.println("#"+sc.nextInt());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			/*
						�� �׽�Ʈ ���̽��� ǥ�� �Է¿��� �о�ɴϴ�.
			 */

			int N = sc.nextInt();

			char[][] map = new char[N][N];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					String tmp = sc.next();
					map[i][j] = tmp.charAt(0);
				}
			}




		//	System.out.println("#"+test_case+" "+AnswerN);
		}
	}
}
