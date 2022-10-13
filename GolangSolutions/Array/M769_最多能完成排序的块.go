package Array

func maxChunksToSorted(arr []int) (ans int) {
	t := 0
	for i, a := range arr {
		if t < a {
			t = a
		}
		if t == i {
			ans++
		}
	}

	return
}
