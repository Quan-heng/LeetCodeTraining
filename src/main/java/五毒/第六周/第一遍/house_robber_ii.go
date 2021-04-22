package 第一遍

func robii(nums []int) int {
	length := len(nums)
	if length == 1 {
		return nums[0]
	}
	return max(maxRob(nums[:length-1]), maxRob(nums[1:]))
}

func maxRob(nums []int) int {
	length := len(nums)
	dp := make([][]int, length)
	var i int
	for i = 0; i < length; i++ {
		dp[i] = make([]int, 2)
	}
	dp[0][0] = 0
	dp[0][1] = nums[0]
	for i = 0; i < length; i++ {
		dp[i][0] = max(dp[i-1][0], dp[i-1][1])
		dp[i][1] = dp[i-1][0] + nums[i]
	}
	return max(dp[length-1][0], dp[length-1][1])
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
