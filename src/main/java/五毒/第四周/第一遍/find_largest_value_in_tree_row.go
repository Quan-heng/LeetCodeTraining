package 第一遍

import "math"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func largestValues(root *TreeNode) []int {
	result := []int{}
	if root == nil {
		return result
	}
	queue := []*TreeNode{root}

	for len(queue) > 0 {
		var i int
		max := math.MinInt64
		size := len(queue)
		for i = 0; i < size; i++ {
			curNode := queue[i]
			if curNode.Val > max {
				max = curNode.Val
			}
			if curNode.Left != nil {
				queue = append(queue, curNode.Left)
			}
			if curNode.Right != nil {
				queue = append(queue, curNode.Right)
			}
		}
		result = append(result, max)
		queue = queue[size:]
	}

	return result
}
