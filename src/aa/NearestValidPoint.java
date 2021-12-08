package aa;


import java.util.ArrayList;
import java.util.List;

public class NearestValidPoint {

    /**
     * 给你两个整数x 和y，表示你在一个笛卡尔坐标系下的(x, y)处。同时，在同一个坐标系下给你一个数组points，其中points[i] = [ai, bi]表示在 (ai, bi) 处有一个点。当一个点与你所在的位置有相同的 x 坐标或者相同的 y 坐标时，我们称这个点是 有效的 。
     * 请返回距离你当前位置 曼哈顿距离 最近的 有效 点的下标（下标从 0 开始）。如果有多个最近的有效点，请返回下标 最小 的一个。如果没有有效点，请返回 -1 。
     * 两个点 (x1, y1) 和 (x2, y2) 之间的 曼哈顿距离 为 abs(x1 - x2) + abs(y1 - y2) 。
     *
     * 输入：x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]
     * 输出：2
     * 解释：所有点中，[3,1]，[2,4] 和 [4,4] 是有效点。有效点中，[2,4] 和 [4,4] 距离你当前位置的曼哈顿距离最小，都为 1 。[2,4] 的下标最小，所以返回 2 。
     */

    public static void main(String[] args) {
        int[][] points = new int[4][];
        points[0] = new int[]{1,1};
        points[1] = new int[]{6,2};
        points[2] = new int[]{1,5};
        points[3] = new int[]{3,1};
//        points[4] = new int[]{4,4};
        System.out.println(nearestValidPoint(5,1,points));
    }

    public static int nearestValidPoint(int x, int y, int[][] points) {
        //没有找到就返回-1
        int result = -1;
        int distance = -1;
        //找到有效的点
        for (int i = 0; i < points.length; i++) {
            //与x,y有相同的点，为有效点
            if (points[i][0] == x || points[i][1] ==y){
                //首次没有赋值的时候，position 就是返回值,或者，后面的距离比前面的小也是返回值/
                if (distance == -1 || distance > computerDistance(x,y,points[i])){
                    distance = computerDistance(x,y,points[i]);
                    result = i;
                }
                //distance = 0 ，是最小的距离，直接返回
                if (distance == 0)break;
            }
        }
        return result;
    }

    //计算两点的距离
    public static int computerDistance(int x, int y,int[] target){
       return Math.abs(x - target[0]) + Math.abs(y - target[1]);
    }
}
