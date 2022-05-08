using namespace std;
#include <iostream>
#include <vector>

/**
 * @author Hyperspace
 * @date 2022/05/07
 * ˼· ��λdp
 * 1. ״̬��ʾ
 * ���ϣ�[a, b]�ڵ���������
 * f[n][i]��ʾ�ü�����i�ĸ���
 * ����ÿһ��i�����԰��Ƿ�Ϊ���λ��Ϊ��λ
 * 1�� �����λ�ϵ�i
 * ���λһ������10^(n-1)��
 * 2�� �������λ�ϵ�i
 * ����λһ������10��0~9һ��10������� * f[n - 1][i]��
 * <p>
 * ���ؿ�
 */
int get(vector<int> num, int l, int r) {
	int ans = 0;
	for (int i = l; i >= r; i--) {
		ans = ans * 10 + num[i];
	}

	return ans;
}

int power(int base, int exp) {
	int ans = 1;
	while (exp--) {
		ans *= base;
	}

	return ans;
}

int count(int n, int x) {
	if (!n) {
		return 0;
	}

	vector<int> num;
	while (n) {
		num.push_back(n % 10);
		n /= 10;
	}
	n = num.size();

	int ans = 0;
	for (int i = n - 1 - !x; i >= 0; i--) {
		if (i < n - 1) {
			ans += get(num, n - 1, i + 1) * power(10, i);
			if (!x) {
				ans -= power(10, i);
			}
		}
		if (num[i] == x) {
			ans += get(num, i - 1, 0) + 1;
		}
		else if (num[i] > x) {
			ans += power(10, i);
		}
	}

	return ans;
}

int main() {
	int a, b;
	while (scanf("%d%d", &a, &b), a) {
		if (a > b) {
			swap(a, b);
		}
		for (int i = 0; i < 10; i++) {
			printf("%d ", count(b, i) - count(a - 1, i));
		}
		puts("");
	}
}