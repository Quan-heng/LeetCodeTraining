package 训练场;
/**
 * 我们知道高级编程语言中，有一种表达式叫三元表达式。比如 Java 语言中, 输入一个类似于 condition? 1:2。
 *
 * 如果 condition 为 true，那么返回 1，否则返回 2。
 *
 * 现在考虑设计一个类似的指令计算器，输入值为表达式，给定的表达式始终都是有效的并且只包含单个数字 0-9, ?, :, Y 和 N (Y 和 N 分别表示真和假）。
 *
 * 表达式支持复杂输入，解析顺序从右到左. 比如 "Y?1:N?2:3" 这种复杂表达式。那么请你设计一个算法支持计算类似指令，输出对应结果。
 *
 * 示例 1
 * 输入： “Y?0:9”
 * 输出： “0”
 * 解释： 如果条件为真，结果为 0；否则，结果为 9。
 *
 * 示例 2
 * 输入： “Y?1:N?2:3”
 * 输出： “1”
 */
public class 指令计算器设计12 {
    public static void main(String[] args) {
        String expression = "N?1:Y?4:5";
        System.out.println(computeTernary(expression));
    }

    public static String computeTernary(String expression) {
        if (expression.isEmpty()) {
            return "";
        }
        if (expression.length() == 5) {
            if (expression.charAt(0) == 'Y') {
                return String.valueOf(expression.charAt(2));
            } else {
                return String.valueOf(expression.charAt(4));
            }
        } else {
            String left = expression.substring(0, expression.length() - 5);
            String right = expression.substring(expression.length() - 5, expression.length());
            return computeTernary(left + computeTernary(right));
        }
    }
}
