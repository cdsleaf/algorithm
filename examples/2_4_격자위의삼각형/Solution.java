import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;



public class Solution {

	static int[] x = new int[3];
	static int[] y = new int[3];
	static int Answer;
	
	static int[] dir = new int[3];
	static int[] a = new int[3];
	static int[] b = new int[3];
	static int[] c = new int[3];
	
	public static void main(String args[]) throws Exception {
		/*
		 * �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�. ��������
		 * �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��, �� �ڵ带 ���α׷��� ó�� �κп�
		 * �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�. ���� �׽�Ʈ�� ������ ������ �Ʒ�
		 * �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�. ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ�
		 * ó�� �ϼž� �մϴ�.
		 */
		//System.setIn(new FileInputStream("sample_input.txt"));

		/*
		 * ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int minX, maxX;
		
		for(int test_case = 1; test_case <= T; test_case ++) {
			minX = Integer.MAX_VALUE;
			maxX = Integer.MIN_VALUE;
			
			for(int i = 0; i < 3; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
				
				if(x[i] < minX) {
					minX = x[i];
				}
				
				if(x[i] > maxX) {
					maxX = x[i];
				}
			}
			
			// �ﰢ���� �� ������ �������� ���
			int cnt = 0;
			for(int i = 0; i < 2; i++) {
				for(int j = 1; j < 3; j++) {
					if(i == j) {
						continue;
					}
					
					calc(i, j, cnt++);
				}
			}
			
			double[] py = new double[3];
			Integer maxY, minY;
			Answer = 0;
			
			for(int px = minX + 1; px < maxX; px++) {
				// x = px �� �ﰢ���� �� ������ ������ ������ y ��ǥ�� ���
				for(int i = 0; i < 3; i++) {
					if(b[i] == 0) {
						// y�࿡ ������ ����
						py[i] = Double.MAX_VALUE;
					} else {
						// py�� ���(���� �߻� ����)
						py[i] = ((double) - a[i] / (double) b[i]) * px - ((double) c[i] / (double) b[i]);
					}
				}
				
				// y�� �������� ����
				Arrays.sort(py);
				
				for(int i = 0; i < 2; i++) {
					// y��� ������ ��� �ǳ� ��
					if(py[i + 1] == Double.MAX_VALUE) {
						continue;
					}
					
					// �߾����� �ﰢ�� ���ο� �ִ� �� �Ǵ�
					if(check(px, (py[i] + py[i + 1]) / 2d) == true) {
						// x = px �� ������ ���� ���� �ﰢ�� ���ο� �ִ�
						// ���� ū y���� ���� ���� y���� Ž��
						maxY = getMaxY(px, (int)Math.max(py[i], py[i + 1]));
						minY = getMinY(px, (int)Math.min(py[i], py[i + 1]));
						
						if(maxY != null && minY != null) {
							Answer += maxY - minY + 1;
						}
						break;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + Answer);
		}
	}
	
	// px �������� �ﰢ�� ���ο� �ִ� ���� ū y���� ã��
	public static Integer getMaxY(int px, int py) {
		int max = py - 1;
		boolean found = false;
		
		for(int i = -2; i <= 2; i++) {
			if(checki(px, py + i) == true) {
				max = py + i;
				found = true;
			}
		}
		
		if(found) {
			return Integer.valueOf(max);
		} else {
			return null;
		}
	}
	
	// px �������� �ﰢ�� ���ο� �ִ� ���� ���� y���� ã��
	public static Integer getMinY(int px, int py) {
		int min = py + 1;
		boolean found = false;
		
		for(int i = 2; i >= -2; i--) {
			if(checki(px, py + i) == true) {
				min = py + i;
				found = true;
			}
		}
		
		if(found) {
			return Integer.valueOf(min);
		} else {
			return null;
		}
	}
	
	// (px, py) �� �ﰢ�� ���ο� �ִ��� �Ǵ�
	public static boolean checki(int px, int py) {
		boolean result = true;
		
		for(int i = 0; i < 3; i++) {
			if((a[i] * px + b[i] * py + c[i]) * dir[i] <= 0) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	// (px, py) �� �ﰢ�� ���ο� �ִ��� �Ǵ�
	public static boolean check(double px, double py) {
		boolean result = true;
		
		for(int i = 0; i < 3; i++) {
			if((a[i] * px + b[i] * py + c[i]) * dir[i] <= 0) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	// ������ ������ ���
	public static void calc(int p1, int p2, int idx) {
		a[idx] = y[p1] - y[p2];
		b[idx] = x[p2] - x[p1];
		c[idx] = y[p2] * x[p1] - y[p1] * x[p2];
		
		int pIdx = 3 - (p1 + p2);
		
		// �ﰢ�� ������ ���� ���
		dir[idx] = a[idx] * x[pIdx] + b[idx] * y[pIdx] + c[idx] > 0 ? 1 : -1;
	}
}
