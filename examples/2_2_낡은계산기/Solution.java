import java.io.FileInputStream;
import java.util.PriorityQueue;
import java.util.Scanner;


class Solution {

	static int N;
	static int Answer;
	static int[] A = new int[100];
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	
	public static void main(String args[]) throws Exception {
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		System.setIn(new FileInputStream("eval_input.txt"));

		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);

		/* �׽�Ʈ ���̽��� �� T */
		int T = sc.nextInt();
		
		/*
		   �׽�Ʈ ���̽� ������ ó���մϴ�.
		 */
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			
			pq.clear();
			for(int i = 0; i < N; i++) {
				//A[i] = sc.nextInt();
				pq.add(sc.nextInt());
			}
			
			Answer = 0;
			while(pq.isEmpty() == false) {
				int a = pq.poll();
				int b = pq.poll();
				
				Answer += a + b;
				if(pq.isEmpty() == false) {
					pq.add(a + b);
				}
			}
			
			System.out.println("#" + test_case + " " + Answer);
		}
	}
}
