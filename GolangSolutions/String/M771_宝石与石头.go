/*
	@author Hyper
	@date 2023/07/24
	@file M771_宝石与石头.go
*/

package String

func numJewelsInStones(jewels string, stones string) (ans int) {
	for _, s := range stones {
		for _, j := range jewels {
			if s == j {
				ans++
			}
		}
	}

	return
}

func numJewelsInStones2(jewels string, stones string) (ans int) {
	mp := make(map[rune]bool)
	for _, j := range jewels {
		mp[j] = true
	}
	for _, s := range stones {
		if mp[s] {
			ans++
		}
	}

	return
}
