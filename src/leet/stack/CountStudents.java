package leet.stack;

public class CountStudents {
    /**
     * https://leetcode-cn.com/problems/number-of-students-unable-to-eat-lunch/
     * @param args
     */
    public static void main(String[] args) {
        int[] student = new int[]{1,1,0,0};
        int[] sandwiches = new int[]{0,1,0,1};
        System.out.print(countStudents(student,sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int[] studLike = new int[2];
        //获取喜欢0的有几人，喜欢1的有几人
        for (int i = 0; i < students.length; i++) {
            studLike[students[i]]++;
        }
        for (int i = 0; i < sandwiches.length; i++) {
            if (studLike[sandwiches[i]] ==0){
                break;
            }
            //喜欢的人拿走相应的三明治。剩下的就是没有找到喜欢的
            studLike[sandwiches[i]]--;
        }
        return studLike[0] + studLike[1];
    }
}
