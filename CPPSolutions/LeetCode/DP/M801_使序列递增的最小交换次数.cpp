#include <cstdio>
#include <vector>

using namespace std;

const int N = 1e5 + 10;

class Solution {
public:
	int f[N][2];

	int minSwap(vector<int>& nums1, vector<int>& nums2) {
		int n = nums1.size();
		f[0][1] = 1;
		for (int i = 1; i < n; i++) {
			f[i][0] = f[i][1] = n;
			if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
				f[i][0] = f[i - 1][0];
				f[i][1] = f[i - 1][1] + 1;
			}
			if (nums2[i - 1] < nums1[i] && nums1[i - 1] < nums2[i]) {
				f[i][0] = min(f[i][0], f[i - 1][1]);
				f[i][1] = min(f[i][1], f[i - 1][0] + 1);
			}
		}

		return min(f[n - 1][0], f[n - 1][1]);
	}

	int minSwap2(vector<int>& nums1, vector<int>& nums2) {
		int n = nums1.size(), cnt1 = 0, cnt2 = 1;
		for (int i = 1; i < n; i++) {
			int ns = n, s = n;
			if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i])
				ns = cnt1, s = cnt2 + 1;
			if (nums2[i - 1] < nums1[i] && nums1[i - 1] < nums2[i])
				ns = min(ns, cnt2), s = min(s, cnt1 + 1);
			cnt1 = ns, cnt2 = s;
		}

		return cnt1 < cnt2 ? cnt1 : cnt2;
	}
};
