package random;

public class StringToIntegerAtoi {

    public static void main(String[] args) {
        System.out.println(912834723 * 10);

        System.out.println("result:" + new StringToIntegerAtoi().myAtoi("      -42"));
        System.out.println("result:" + new StringToIntegerAtoi().myAtoi("4193 with words"));
        System.out.println("result:" + new StringToIntegerAtoi().myAtoi("words and 987"));
        System.out.println("result:" + new StringToIntegerAtoi().myAtoi("-91283472332"));
        System.out.println("result:" + new StringToIntegerAtoi().myAtoi("-4 325 "));
    }

    public int myAtoi(String s) {
        int number = 0;
        s = s.trim();
        int sign = 1;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(i ==0) {
                if(c == '-') {
                    sign = -1;
                    continue;
                }
                if(c == '+') {
                    continue;
                }
            }
            if(c >= '0' && c <= '9') {
                int tempNumber = number*10 + (c-48);
                System.out.println("tempNumber:" + tempNumber + ",number:" + number);
                if(tempNumber/10 != number) {
                    number = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    return number;
                }
                number = tempNumber;
            } else {
                break;
            }

        }
        return sign*number;
    }



}
