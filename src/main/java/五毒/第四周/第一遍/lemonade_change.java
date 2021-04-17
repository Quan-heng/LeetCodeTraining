package 五毒.第四周.第一遍;

public class lemonade_change {
    /**
     * 贪心算法，先还大的
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        if (bills.length == 0) {
            return false;
        }
        int fiveCount = 0;
        int tenCount = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCount++;
            } else if (bills[i] == 10) {
                if (fiveCount < 1) {
                    return false;
                } else {
                    fiveCount--;
                    tenCount++;
                }
            } else {
                if (tenCount > 0 && fiveCount > 0) {
                    tenCount--;
                    fiveCount--;
                } else if (tenCount == 0 && fiveCount >= 3) {
                    fiveCount -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
