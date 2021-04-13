package 第二遍

func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 || len(inorder) == 0 {
		return nil
	}
	var root = new(TreeNode)
	root.Val = preorder[0]
	var leftLen, rightLen, i int
	for i = 0; i < len(inorder); i++ {
		if inorder[i] == root.Val {
			leftLen = i
			break
		}
	}
	rightLen = len(preorder) - leftLen - 1
	if leftLen > 0 {
		root.Left = buildTree(preorder[1:1+leftLen], inorder[0:leftLen])
	}
	if rightLen > 0 {
		var length = len(preorder)
		root.Right = buildTree(preorder[length-rightLen:length], inorder[length-rightLen:length])
	}
	return root
}
