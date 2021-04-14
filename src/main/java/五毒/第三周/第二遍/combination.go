package main

import "fmt"

func combine(n int, k int) [][]int {
	result := make([][]int, 0)
	list := make([]int, 0)
	depth := 1
	dfs(&result, &list, depth, n, k) //传地址才能深拷贝
	return result
}

func dfs(result *[][]int, list *[]int, depth int, n int, k int) {
	if len(*list) == k {
		newList := make([]int, 2)
		copy(newList, *list)
		fmt.Println(newList)
		*result = append(*result, newList)
		return
	}
	var i int
	for i = depth; i <= n; i++ {
		*list = append(*list, i)
		dfs(result, list, i+1, n, k)
		*list = (*list)[0 : len(*list)-1]
	}
}

func main() {
	fmt.Println(combine(4, 2))
}
