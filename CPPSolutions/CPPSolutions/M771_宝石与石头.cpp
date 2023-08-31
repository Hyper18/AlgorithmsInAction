#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
	int numJewelsInStones(string jewels, string stones) {
		int ans = 0;
		for (auto c : stones) 
			if (jewels.find(c) != jewels.npos) 
				ans++;

		return ans;
	}
};