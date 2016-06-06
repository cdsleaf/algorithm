import java.io.FileInputStream;
import java.util.Scanner;


class Solution {

	static int N, M;
	static int[] A = new int[100];
	
	static int NC;
	
	// �޸������̼� �迭
	static int[][] f = new int[100][15625];
	
	// �ַ�� ���� �迭
	static int[][] s = new int[100][15625];
	
	static int radix, num;
	
	static int Answer = 0;
	
	public static void main(String args[]) throws Exception {
		/*
		 * �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�. ��������
		 * �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��, �� �ڵ带 ���α׷��� ó�� �κп�
		 * �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�. ���� �׽�Ʈ�� ������ ������ �Ʒ�
		 * �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�. ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ�
		 * ó�� �ϼž� �մϴ�.
		 */
		System.setIn(new FileInputStream("eval_input02.txt"));
		
		Scanner sc = new Scanner(System.in);

		/*
		�׽�Ʈ ���̽��� ���� �Է� �޽��ϴ�.
		*/
		int T = sc.nextInt();

		/*
		T ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			
			// �� ĭ�� ����
			NC = (N - 1) * 4; 
			
			for(int i = 0; i < NC; i++) {
				A[i] = sc.nextInt();
			}
			
			// ����(M�� 2�� ��� 3����)
			radix = M + 1;
			
			// ���� ���� ī���� ���� �ϳ��� 10������ ǥ�� 
			num = (int)Math.pow(radix, 6) - 1;
			
			// �ʱ�ȭ
			for(int i = 0; i < NC + 6; i++) {
				for(int j = 0; j <= num; j++) {
					f[i][j] = -1;
					s[i][j] = 0;
				}
			}
			
			Answer = Integer.MAX_VALUE;
			f[0][0] = A[0];
			f[1][1] = A[1];
			s[1][1] = 1;
			
			int p = 0;

			// ���������� ������ �� �� �ִ� ������ ���� �� �������� ����
			for(int i = NC; i < NC + 6; i++) {
				if(Answer > dp(i, num)) {
					Answer = dp(i, num);
					p = i;
				}
			}
			
			// �ַ�� ���
			//printSolution(p, num - 1);
			//System.out.println();
			System.out.println("#" + test_case + " " + Answer);
		}
	}
	
	// ���� ��ȹ�� ���� �޼ҵ�
	public static int dp(int p, int m) {
		int tmp, sum;
		
		if(p == 0) {
			return 0;
		}
		
		// ������ ���� ���� �ִ� ���
		if(f[p][m] != -1) {
			return f[p][m];
		}
		
		f[p][m] = 1000000;

		// ���� ��ġ���� 1 ~ 6 ������ ī�带 ����� �� �� �ִ� ������ ����
		for(int k = 0; k < 6; k++) {
			tmp = (int)Math.pow(radix, k);
			
			// ���� (k + 1) ī���� ���� 0���� Ŀ�� �ϰ�
			// ������ ��ġ���� 0 �̻��̾�� �Ѵ�.
			if((m / tmp) % radix > 0 && p - (k + 1) >= 0) {
				sum = dp(p - (k + 1), m - tmp) + A[p % NC];
				
				// ���� ������ ��������� ����� ������ ������ �����Ѵ�.
				if(f[p][m] > sum) {
					f[p][m] = sum;
					
					// �ַ�� ����
					s[p][m] = k + 1;
				}
			}
		}
		
		return f[p][m];
	}

	// �ַ�� ��� �޼ҵ�
	public static void printSolution(int p, int m) {
		if(p - s[p][m] >= 0 && s[p][m] > 0) {
			printSolution(p - s[p][m], m - (int)Math.pow(radix, s[p][m] - 1));
		}
		
		if(s[p][m] != 0) {
			System.out.print(s[p][m] + " ");
		}
	}
}
