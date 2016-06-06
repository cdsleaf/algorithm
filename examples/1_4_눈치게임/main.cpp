#include <cstdio>

int N, K; // N : ����� ���, K : �θ� �� �ִ� ��
int W[501][500]; // [N][K], [i][j] i�� ����� j�� �θ� �� ���� ��, j�� �θ� ������ ��ٸ��� �ð�
int Answer[501]; // Answer[i] : i�� ����� ���� - 0 : ���� �Ⱥθ�  1 : �θ�  -1 : �ɸ�

int main() {
	int test_case, T;

	int tmpArr[500], itmp;
	int timemin;
	freopen("sample_input.txt", "r", stdin);
	scanf("%d", &T);

	for (test_case = 1; test_case <= T; ++test_case) {
		// �Է�
		scanf("%d %d", &N, &K);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				scanf("%d", &W[i][j]);
			}
			Answer[i] = 0;
		}

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
				goto ANS;
			}
		}
		for (int i = 1; i <= N; i++) {
			if (Answer[i] == 0) Answer[i] = -1;
		}

		// ���
	ANS:
		//printf("#%d", test_case);
		for (int i = 1; i <= N; i++) {
			if (Answer[i] == -1) printf("%d ", i);
		}
		putchar('\n');
	}

	return 0;
}