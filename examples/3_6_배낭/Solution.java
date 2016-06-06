
class Solution {
	
	// ������ ����
	static int N = 6;
	
	// �賶�� �뷮
	static int W = 17;
	
	// ������ ��ġ �迭
	//static int[] ci = { 2, 1, 10, 2, 4 };
	static int[] ci = { 7, 10, 6, 7, 5, 4 };
	
	// ������ ���� �迭
	//static int[] wi = { 2, 1, 4, 1, 12 };
	static int[] wi = { 4, 2, 6, 4, 2, 10 };
	
	// �޸������̼��� ���� �迭
	static int[][] M = new int[N + 1][W + 1];
	
	
	public static void main(String args[]) {
		// �ʱ�ȭ
		for(int i = 0; i < N + 1; i++) {
			for(int j = 0; j < W + 1; j++) {
				M[i][j] = -1;
				S[i][j] = 0;
			}
		}
	
		// �ִ� ��ġ�� ���
		System.out.println(ks(N, W));
		
		// �ַ�� ���
		printSolution(N, W);
		System.out.println();
	}
	
	static int[][] S = new int[N + 1][W + 1];

	public static int ks(int i, int w) {
		// ���� ������ �����Ƿ� 0�� ����
		if(i == 0) {
			return 0;
		}
		
		// �迭�� ������ ����� ���� ����
		if(M[i][w] != -1) {
			return M[i][w];
		}
		
		// �κй����� ����� ���� ���� ���
		// i��° ������ ���� �ʴ� ���
		M[i][w] = ks(i - 1, w);
		
		// i��° ������ ��� ��� �賶�� ���� �뷮�� ������ ���Ժ��� ũ�ų� ���ƾ� �Ѵ�.
		if(w - wi[i - 1] >= 0) {
			M[i][w] = Math.max(M[i][w], ks(i - 1, w - wi[i - 1]) + ci[i - 1]);
			
			// �賶�� ���� i��° ������ ǥ��
			if(ks(i - 1, w) < M[i][w]) {
				S[i][w] = 1;
			}
		}
	
		return M[i][w];
	}
	
	public static void printSolution(int i, int w) {
		if(i == 0) {
			return;
		}
		
		if(S[i][w] == 1) {
			printSolution(i - 1, w - wi[i - 1]);
			System.out.print(i + " ");
		} else {
			printSolution(i - 1, w);
		}
	}
}
