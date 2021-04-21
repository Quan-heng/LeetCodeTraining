package 第一遍

func rob(nums []int) int {

	dp := make([][]int, len(nums))
	var i int
	for i = 0; i < len(nums); i++ {
		dp[i] = make([]int, 2)
	}
	dp[0][0] = 0
	dp[0][1] = nums[0]

	for i = 1; i < len(nums); i++ {
		dp[i][0] = Max(dp[i-1][0], dp[i-1][1])
		dp[i][1] = dp[i-1][0] + nums[i]
	}
	return Max(dp[len(nums)-1][0], dp[len(nums)-1][1])
}

func Max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
