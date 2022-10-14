package Array

func findLength(nums1 []int, nums2 []int) (ans int) {
	n1, n2 := len(nums1), len(nums2)
	f := make([][]int, n1+1)
	for i := 0; i < len(f); i++ {
		f[i] = make([]int, n2+1)
	}

	for i := n1 - 1; i >= 0; i-- {
		for j := n2 - 1; j >= 0; j-- {
			if nums1[i] == nums2[j] {
				f[i][j] = f[i+1][j+1] + 1
			}
			if ans < f[i][j] {
				ans = f[i][j]
			}
		}
	}

	return
}
