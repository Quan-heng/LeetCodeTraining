public class 替换空格 {
    public static void main(String[] args) {
       String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.isEmpty()) {
            return "";
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=' '){
                sb.append(arr[i]);
            }else{
                sb.append('%');
                sb.append(20);
            }
        }
        return sb.toString();
    }
}
