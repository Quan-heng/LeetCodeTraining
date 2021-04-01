package main

import "fmt"

func climbStairs(n int) int {
	var cur int = 2
	var prev int = 1
	if n <= 2 {
		return n
	}
	for i := 3; i <= n; i++ {
		var temp int = cur
		cur = cur + prev
		prev = temp
	}
	return cur
}

func main() {
	fmt.Println(climbStairs(4))
}
