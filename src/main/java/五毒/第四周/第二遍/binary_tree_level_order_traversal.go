package 第二遍

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func levelOrder(root *TreeNode) [][]int {
	result := [][]int{}
	if root == nil {
		return result
	}
	queue := []*TreeNode{root}

	for len(queue) > 0 {
		size := len(queue)
		var i int
		subList := make([]int, 0)
		for i = 0; i < size; i++ {
			curNode := queue[0]
			subList = append(subList, curNode.Val)
			queue = queue[1:]
			if curNode.Left != nil {
				queue = append(queue, curNode.Left)
			}
			if curNode.Right != nil {
				queue = append(queue, curNode.Right)
			}
		}
		result = append(result, subList)
	}
	return result
}
