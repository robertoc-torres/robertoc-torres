package leetcode.random;

class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("2", "3"));
        System.out.println(new MultiplyStrings().multiply("3", "21"));
        System.out.println(new MultiplyStrings().multiply("10", "30"));
        System.out.println(new MultiplyStrings().multiply("123", "23"));
        System.out.println(new MultiplyStrings().multiply("123456789", "987654321")); //121932631112635269
        System.out.println(new MultiplyStrings().multiply("498828660196","840477629533")); //419254329864656431168468
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        if (num1.equals("1")) return num2;
        if (num2.equals("1")) return num1;

        int num1Len = num1.length();
        int num2Len = num2.length();
        int[] res = new int[num1Len + num2Len];

        int n2PowCtn = 0;
        for (int i1 = num1.length() - 1; i1 >= 0; i1--) {
            int n1PowCtn = 0;
            for (int i2 = num2.length() - 1; i2 >= 0; i2--) {
                int pos = (n1PowCtn + n2PowCtn);
                int r = ((num1.charAt(i1) - 48) * ((num2.charAt(i2) - 48)));

                if(r + res[pos] > 9) {
                    res[pos + 1] += ((res[pos] + r) - ((res[pos] + r) % 10)) / 10;
                    res[pos] = (res[pos] + r) % 10;
                } else {
                    res[pos] += r;
                }

                n1PowCtn += 1;
            }
            n2PowCtn += 1;
        }
        StringBuilder sb = new StringBuilder();

        for(int i = res.length - 1; i >= 0; i--) {
            if(i == res.length - 1 && res[i] == 0)
                continue;
            sb.append(res[i]);
        }
        return sb.toString();
    }
};