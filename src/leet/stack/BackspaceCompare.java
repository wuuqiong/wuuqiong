package leet.stack;

public class BackspaceCompare {
    /**
     * 一个字符是否会被删掉，只取决于该字符后面的退格符。所以需要倒叙遍历字串
     *https://leetcode-cn.com/problems/backspace-string-compare/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "#ad#c"));
    }

    private static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {
            //找到i需要比较的字串。
            while (i >= 0) {
                //如果是#，则需要删除前面的字串
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;//当前是#，比较前一个值去吧。
                } else if (skipS > 0) {
                    skipS--;//有需要退格的传。先复位
                    i--;//当前需要退格，比较前面的串吧
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            //如果i和j都大于0。所以找到了需要比较的值。相等就遍历下一个，如果不等直接返回false；
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                //其中有一个需要比较，肯定是不相等的，直接返回false
                if (i >= 0 || j >= 0) {
                    return false;
                }

                //都小于0的表示都去掉了
            }

            i--;
            j--;
        }
        //前面都没有找到不相等的字串，返回true
        return true;
    }


}
