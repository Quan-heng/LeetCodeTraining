package main

import "fmt"

func generateParenthesis(n int) []string {
	result := []string{}
	dfs(&result, 0, 0, "", n)
	return result
}

func dfs(result *[]string, left int, right int, s string, n int) {
	if left == n && right == n {
		*result = append(*result, s)
		return
	}
	if left < n {
		dfs(result, left+1, right, s+"(", n)
	}
	if right < left {
		dfs(result, left, right+1, s+")", n)
	}
}

func main() {
	generateParenthesis(3)
}
