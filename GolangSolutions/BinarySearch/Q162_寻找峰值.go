package BinarySearch

func findPeakElement(nums []int) int {
	n := len(nums)
	low, high := 0, n-1
	for low < high {
		mid := low + (high-low)/2
		if nums[mid] > nums[mid+1] {
			high = mid
		} else {
			low = mid + 1
		}
	}

	return low
}

func findPeakElement2(nums []int) int {
	n := len(nums)
	low, high := 0, n-1
	for low < high {
		mid := low + (high-low+1)/2
		if nums[mid] > nums[mid-1] {
			low = mid
		} else {
			high = mid - 1
		}
	}

	return high
}
