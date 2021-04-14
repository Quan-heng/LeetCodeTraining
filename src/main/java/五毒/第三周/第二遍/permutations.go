package permutations

func permute(nums []int) [][]int {
	result := make([][]int, 0)
	if len(nums) == 0 {
		return result
	}
	list := make([]int, 0)
	visited := make([]bool, len(nums))
	depth := 0
	dfs(&result, &list, &visited, depth, nums)
	return result

}

func dfs(result *[][]int, list *[]int, visited *[]bool, depth int, nums []int) {
	if depth == len(nums) {
		newList := make([]int, len(nums))
		copy(newList, *list)
		*result = append(*result, newList)
		return
	}

	var i int
	for i = 0; i < len(nums); i++ {
		if !(*visited)[i] {
			(*visited)[i] = true
			*list = append(*list, nums[i])
			dfs(result, list, visited, depth+1, nums)
			(*visited)[i] = false
			*list = (*list)[0 : len(*list)-1]
		}
	}
}
