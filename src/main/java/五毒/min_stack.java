package 五毒;
/**
 * 解题思路：用辅助栈保存最小元素
 */

import java.util.*;

/*class MinStack {
    private int[] _arr;
    private int _size;


    public MinStack() {
        _size = 0;
        _arr = new int[1];
    }

    public void push(int x) {
        if (_size>0&&_size == _arr.length) {
            int[] newArr = new int[_size * 2 + 1];
            System.arraycopy(_arr, 0, newArr, 0, _size);
            _arr = newArr;
        }
        _arr[_size++] = x;
    }

    public void pop() {
        if (_size > 0) {
            _arr[_size - 1] = Integer.MAX_VALUE;
            _size--;
        }
    }

    public int top() {
        if (_size > 0) {
            return _arr[_size - 1];
        } else {
            return -1;
        }
    }

    public int getMin() {
        if (_size > 0) {
            int[] sortArr = Arrays.copyOf(_arr,_size);
            Arrays.sort(sortArr);
            return sortArr[0];
        } else {
            return -1;
        }
    }
}*/
class MinStack {
    private Deque<Integer> _stack;
    private Deque<Integer> _minStack;
    public MinStack() {
        _stack = new LinkedList<>();
        _minStack = new LinkedList<>();
        _minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        _stack.push(x);
        _minStack.push(Math.min(x,_minStack.peek()));
    }

    public void pop() {
        _stack.pop();
        _minStack.pop();
    }

    public int top() {
        return _stack.peek();
    }

    public int getMin() {
        return _minStack.peek();
    }
}