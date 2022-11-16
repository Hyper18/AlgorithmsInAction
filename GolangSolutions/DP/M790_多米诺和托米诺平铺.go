/*
   @author Hyperspace
   @date 2022/11/12
   @file M790_多米诺和托米诺平铺.go
*/

package DP

const mod int = 1e9 + 7

func numTilings(n int) int {
	//f := make([][]int, n+1)
	//for i := range f {
	//	f[i] = make([]int, 4)
	//}
	f := make([][4]int, n+1)
	f[0][3] = 1
	for i := 1; i <= n; i++ {
		f[i][0] = f[i-1][3]
		f[i][1] = (f[i-1][0] + f[i-1][2]) % mod
		f[i][2] = (f[i-1][0] + f[i-1][1]) % mod
		f[i][3] = (((f[i-1][0]+f[i-1][1])%mod+f[i-1][2])%mod + f[i-1][3]) % mod
	}

	return f[n][3]
}
