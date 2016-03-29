package personal;

/**
 * Created by jzhou on 16-3-25.
 */
public class StringToIntegerTransformer {
    public static void main(String[] args) {

    }

    public Integer transformToInt(String target) {
        if (target == null)
            return null;

        int len = target.length();
        if (len == 0 || target.contains("."))
            return null;

        boolean isNegative = false;
        int index = 0;
        char firstChar = target.charAt(0);
        if (firstChar == '-') {
            isNegative = true;
            index = 1;
        }
        else if (firstChar == '+') {
            index = 1;
        }

        long res = 0;
        for (; index < len; index++) {
            Character ch = target.charAt(index);
            if (Character.isDigit(ch)) {
                res += Integer.parseInt(ch.toString()) * Math.pow(10, len - index - 1);
            } else {
                System.out.println(String.format("String %s has non-number character", target));
                return null;
            }
        }

        if (res > Integer.MAX_VALUE) {
            System.out.println(String.format("String %s is out of integer range", target));
            return null;
        }

       return isNegative ? -(int)res : (int)res;
    }
}
