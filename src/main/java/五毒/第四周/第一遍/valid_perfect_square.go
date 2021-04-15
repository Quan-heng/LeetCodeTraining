package main

func isPerfectSquare(num int) bool {
	r := num
	for r*r > num {
		r = (r + num/r) / 2
	}
	return r*r == num
}
