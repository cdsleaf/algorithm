#include <iostream>
#include <cstdio>
#include <queue>
#include <functional>

using namespace std;

int N;      // �ڿ����� ����
int A[100];
int Answer;

int main() {

	int test_case, T;

	/*
	�Ʒ��� freopen �Լ��� sample_input.txt �� read only �������� �� ��,
	������ ǥ�� �Է�(Ű����) ��� sample_input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
	�������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� sample_input.txt�� �Է��� ������ ��,
	freopen �Լ��� �̿��ϸ� ���� scanf �� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
	���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �Լ��� ����ϼŵ� �����ϴ�.
	freopen �Լ��� ����ϱ� ���ؼ��� #include <cstdio>, Ȥ�� #include <stdio.h> �� �ʿ��մϴ�.
	��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� freopen �Լ��� ����ų� �ּ� ó�� �ϼž� �մϴ�.
	*/
	//freopen("C:\\sample_input.txt", "r", stdin);

	/*
	�Ʒ��� setbuf �Լ��� �� ���α׷��� ���۸� unbuffered ��Ʈ������ �����մϴ�.
	�� ���α׷��� ���� �ð� �ʰ��� ���� ������ ����Ǵ� ��������
	���ۿ� ����� �����Ͱ� ���� ��µ��� ���� �� �����Ƿ�, �Ʒ��� �ڵ带 �������� ���ñ� �ٶ��ϴ�.
	*/
	setbuf(stdout, NULL);

	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case) {
		priority_queue<int, std::vector<int>, greater<int>> pq;

		cin >> N;
		for (int i = 0; i<N; i++) {
			cin >> A[i];
			pq.push(A[i]);
		}

		/******************************************************/
		// �� ���� �˰����� �����մϴ�.
		// ������ Answer �� �����ϴ� ���� �����մϴ�.
		/******************************************************/
		Answer = 0;

		int first, second;
		while (pq.size() > 0)
		{
			first = pq.top();
			pq.pop();
			second = pq.top();
			pq.pop();

			Answer += first + second;
			if (pq.size() > 0)
			{
				pq.push(first + second);
			}
		}

		cout << "#" << test_case << " " << Answer << endl;
	}
	return 0;
}
