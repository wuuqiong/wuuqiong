package test;

public class Convert {

    public static void main(String[] args) {
        String ss = "PAYPALISHIRING";
        int nums = 3;
        System.out.println(convert(ss,nums));
    }


    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] sb = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        int currRows = 0;
        boolean down = false;
        for (int i = 0; i < s.length(); i++) {
            sb[currRows].append(s.charAt(i));
            //在行的顶点和终点的时候转换方向
            if (currRows == 0 || currRows == numRows - 1) {
                down = !down;
            }
            currRows += down ? 1 : -1;
        }
        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }

        return sb[0].toString();
    }

}
