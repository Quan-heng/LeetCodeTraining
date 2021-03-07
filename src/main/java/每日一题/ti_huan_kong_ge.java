package 每日一题;

public class ti_huan_kong_ge {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == ' '){
                sb.append("%20");
            }else{
                sb.append(charArray[i]);
            }
        }
        return sb.toString();
    }
}
