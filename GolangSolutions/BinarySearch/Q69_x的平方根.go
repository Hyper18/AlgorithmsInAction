package BinarySearch

import "math"

func mySqrt(x int) int {
	if x == 0 {
		return 0
	}
	ans := int(math.Exp(0.5 * math.Log(float64(x))))

	if (ans+1)*(ans+1) <= x {
		return ans + 1
	}
	return ans
}

func mySqrt2(x int) int {
	low, high := 0, x
	ans := -1
	for low <= high {
		mid := low + (high-low)/2
		if mid*mid <= x {
			ans = mid
			low = mid + 1
		} else {
			high = mid - 1
		}
	}

	return ans
}
