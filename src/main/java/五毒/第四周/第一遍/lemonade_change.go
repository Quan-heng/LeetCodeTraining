package main

func lemonadeChange(bills []int) bool {
	if len(bills) == 0 {
		return false
	}
	fiveCount := 0
	tenCount := 0
	var i int
	for i = 0; i < len(bills); i++ {
		if bills[i] == 5 {
			fiveCount++
		} else if bills[i] == 10 {
			if fiveCount > 0 {
				fiveCount--
				tenCount++
			} else {
				return false
			}
		} else {
			if tenCount > 0 && fiveCount > 0 {
				tenCount--
				fiveCount--
			} else if fiveCount >= 3 {
				fiveCount -= 3
			} else {
				return false
			}
		}
	}
	return true
}
