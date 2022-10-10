package Array

func search(nums []int, target int) int {
	low, high := 0, len(nums)-1
	for low <= high {
		mid := low + (high-low)/2
		if nums[mid] == target {
			return mid
		}
		if nums[mid] >= nums[low] {
			if target >= nums[low] && nums[mid] > target {
				high = mid - 1
			} else {
				low = mid + 1
			}
		} else {
			if target > nums[mid] && nums[high] >= target {
				low = mid + 1
			} else {
				high = mid - 1
			}
		}
	}

	return -1
}

func search2(nums []int, target int) int {
	low, high := 0, len(nums)-1
	for low <= high {
		mid := low + (high-low)/2
		if nums[mid] == target {
			return mid
		}
		if nums[mid] < nums[high] {
			if nums[mid] < target && target <= nums[high] {
				low = mid + 1
			} else {
				high = mid - 1
			}
		} else {
			if nums[low] <= target && target < nums[mid] {
				high = mid - 1
			} else {
				low = mid + 1
			}
		}
	}

	return -1
}
