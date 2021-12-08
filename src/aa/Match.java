package aa;

import java.util.*;

/*
给定n行字符s，每行是游逗号分隔的名词组合，中英文任意。现给定一个模式M，M有A-Z 26个字符标识，找出包含该模式的所有行。
例如：
string []s = {
"猴子，猴子，长颈鹿，长颈鹿，兔子",
"深圳，杭州，杭州，北京，北京",
"杭州，北京，深圳，广州",
"monkey，monkey，rabbit，dog，dog"，
}

string M = "AABB"
则
"猴子，猴子，长颈鹿，长颈鹿，兔子","深圳，杭州，杭州，北京，北京" 会被匹配


@param s 待匹配字符数组
@param M 匹配模式
@return s 中包含M模式的子集

 */

public class Match {
    static String model = "ABA";

    public static void main(String[] args) {
        String[] params = new String[]{
                "猴子，猴子，长颈鹿，长颈鹿，兔子",
                "深圳，杭州，杭州，北京，北京",
                "杭州，北京，杭州，深圳，广州",
                "monkey，monkey，rabbit，dog，dog",
                "wuq，wuq，xuh，xuh，wuq"
        };
        System.out.println(Arrays.toString(match(params, model)));
    }

    private static String[] match(String[] params, String model) {
        List<String> s = new ArrayList<>();
        if (model == null || model.length() == 0) return params;
        List<Character> modelList = optModel(model);
        for (String curr : params) {
            String[] currs = curr.split("，");
            //model的长度大于，字符串的长度，直接不符合，取下一个
            if (currs.length < modelList.size()) continue;
            int begin = 0;
            int end = 0;
            while (end < currs.length) {
                end = begin + modelList.size();
                //从长的数组里截取model长度，比如model长度为4，首先截取0-4符合就退出，判断下一个，否则截取1-5个字符。当end的长度 大于等于currs的总长度，则退出while循环
                String[] t = Arrays.copyOfRange(currs, begin, end);
                List<Character> res = optString(t);
                System.out.println(Arrays.asList(t));
                if (res.equals(modelList)) {
                    s.add(curr);
                    break;
                }
                begin++;
            }

        }
        return s.toArray(new String[s.size()]);
    }

    /**
     * 考虑到model可能无序（AABB,BBAA），把他变成有序的[a,a,b,b]
     * @param model
     * @return
     */
    private static List<Character> optModel(String model) {
        List<Character> model_list = new ArrayList<>();
        Map<Character, Character> maps = new HashMap<>();
        maps.put(model.charAt(0), 'a');
        model_list.add('a');
        int max = 'a';
        for (int i = 1; i < model.length(); i++) {
            if (maps.containsKey(model.charAt(i))) {
                model_list.add(maps.get(model.charAt(i)));
            } else {
                ++max;
                maps.put(model.charAt(i), (char) (max));
                model_list.add((char) (max));
            }
        }
        return model_list;
    }

    //按照model的思路，把字符数组也变成[a,a,b,b]类型的,传递进来的长度，仅为model的长度
    private static List<Character> optString(String[] model) {
        List<Character> model_list = new ArrayList<>();
        Map<String, Character> maps = new HashMap<>();
        maps.put(model[0], 'a');
        model_list.add('a');
        int max = 'a';
        for (int i = 1; i < model.length; i++) {
            if (maps.containsKey(model[i])) {
                model_list.add(maps.get(model[i]));
            } else {
                ++max;
                maps.put(model[i], (char) (max));
                model_list.add((char) (max));
            }
        }
        return model_list;
    }
}
