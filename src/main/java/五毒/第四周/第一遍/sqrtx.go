package main

import "fmt"

func mySqrt(x int) int {
	c := x
	for c*c > x {
		c = (c + x/c) / 2
	}
	return c
}

func main() {
	fmt.Println(mySqrt(8))
}
