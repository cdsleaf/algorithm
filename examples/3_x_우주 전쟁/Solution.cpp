#include <cstdio>
#include <cstring>    // memset
#include <algorithm>  // max, min

using namespace std;

int main() {
	int test_case, T;
	int N, M, B;  // N : �ܰ� ���ּ��� �� , M : �̻��� ������ �� , B : �ܰ� ���ּ��� �� ����
	int H[20001]; // H[i] : ���� i �� �̻��� ����
	int tmp1, tmp2;

	int Bmax; // ������ �̻��� ������ �ִ밪
	int Answer;
	
	//freopen("sample_input.txt", "r", stdin);

	scanf("%d", &T);

	for (test_case = 1; test_case <= T; ++test_case) {
		// �ʱ�ȭ
		Bmax = 0;
		scanf("%d %d %d", &N, &M, &B);
		memset(H, 0, sizeof H);
		for (int i = 0; i < M; ++i) {
			scanf("%d %d", &tmp1, &tmp2);
			H[tmp1] = tmp2;
			Bmax = max(Bmax, tmp1);
		}
		Answer = 0;
		Bmax = max(Bmax, 2 * B);

		// �˰��� ����
		// �ı� �ʿ� ���� : B, ���ּ� ���� : N
		int bearing_power; // �߻��� �̻����� ����
		for (bearing_power = B; bearing_power <= Bmax; ++bearing_power) {
			// �̻��� 1�� �߻��� ���
			if (N > H[bearing_power]) {
				Answer += bearing_power * H[bearing_power];
				N -= H[bearing_power];
				H[bearing_power] = 0;
			}
			else {
				Answer += bearing_power * N;
				goto DONE;
			}

			if (bearing_power > 2 * B) continue;

			// �̻��� 2�� �߻��� ���
			int b1, b2;
			for (b1 = bearing_power - B + 1, b2 = B - 1; b1 <= b2; ++b1, --b2) {
				int h = min(H[b1], H[b2]);
				if (h == 0) continue;
				if (b1 == b2) {
					if (N > h / 2) {
						Answer += bearing_power * (h / 2);
						N -= (h / 2);
						H[b1] = h % 2;
					}
					else {
						Answer += bearing_power * N;
						goto DONE;
					}
				}
				else {
					if (N > h) {
						Answer += bearing_power * h;
						N -= h;
						H[b1] -= h;
						H[b2] -= h;
					}
					else {
						Answer += bearing_power * N;
						goto DONE;
					}
				}
			}
		}
		Answer = -1;
	DONE:
		printf("#%d %d\n", test_case, Answer);
	}
	fclose(fp);
	return 0;
}
