package Array

func intersection(nums1 []int, nums2 []int) []int {
	res := []int{}
	hashMap := make(map[int]int)
	for i := range nums1 {
		hashMap[nums1[i]]++
	}
	for i := range nums2 {
		if _, ok := hashMap[nums2[i]]; ok {
			res = append(res, nums2[i])
			delete(hashMap, nums2[i])
		}
	}

	return res
}
