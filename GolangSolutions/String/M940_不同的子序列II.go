package String

const MOD int = 1e9 + 7

func distinctSubseqII(s string) (ans int) {
	n := len(s)
	f, last := make([]int, n), make([]int, 26)
	for i := range f {
		f[i] = 1
	}
	for i := range last {
		last[i] = -1
	}

	for i := 0; i < n; i++ {
		for j := 0; j < 26; j++ {
			if last[j] != -1 {
				f[i] = (f[i] + f[last[j]]) % MOD
			}
		}
		last[s[i]-'a'] = i
	}

	for i := 0; i < 26; i++ {
		if last[i] != -1 {
			ans = (ans + f[last[i]]) % MOD
		}
	}

	return
}

func distinctSubseqII2(s string) (ans int) {
	n := len(s)
	f := make([]int, 26)

	for i := 0; i < n; i++ {
		t := 1
		for j := 0; j < 26; j++ {
			t = (t + f[j]) % MOD
		}
		f[s[i]-'a'] = t
	}

	for i := 0; i < 26; i++ {
		ans = (ans + f[i]) % MOD
	}

	return
}
