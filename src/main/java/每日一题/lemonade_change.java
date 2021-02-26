package 每日一题;

public class lemonade_change {
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
                if (fiveCount > 0) {
                    fiveCount--;
                    tenCount++;
                } else {
                    return false;
                }
            } else {
                if (tenCount > 0 && fiveCount < 0) {
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
