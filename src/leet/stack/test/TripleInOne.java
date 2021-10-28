package leet.stack.test;

import java.util.Arrays;

public class TripleInOne {

    /**
     * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/three-in-one-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
     */
    int [] one;
    int lastIndexForOne;
    int lastIndexForTwo;
    int lastIndexForThree;
    int stackSize;
    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(1);
        tripleInOne.push(0,1);
        tripleInOne.push(0,2);

        tripleInOne.pop(0);
        tripleInOne.pop(0);
        tripleInOne.pop(0);

        tripleInOne.isEmpty(0);

    }


    public TripleInOne(int stackSize) {
        one = new int[stackSize*3];
        Arrays.fill(one, -1);
        lastIndexForOne = -1;
        lastIndexForTwo = stackSize-1;
        lastIndexForThree = stackSize*2 -1;
        this.stackSize = stackSize;
    }

    public void push(int stackNum, int value) {
        if (stackNum == 0){
            if (lastIndexForOne!= stackSize-1){
                lastIndexForOne++;
                one[lastIndexForOne] = value;
            }
        }else if(stackNum == 1){
            if (lastIndexForTwo!= stackSize*2 -1){
                lastIndexForTwo++;
                one[lastIndexForTwo] = value;
            }
        }else if(stackNum == 2){
            if (lastIndexForThree!= stackSize*3-1){
                lastIndexForThree++;
                one[lastIndexForThree] = value;
            }
        }
    }
    public int pop(int stackNum) {
        int value = -1;
        if (stackNum == 0){
            if (lastIndexForOne>-1){
                value = one[lastIndexForOne];
                lastIndexForOne--;
            }
        }else if(stackNum == 1){
            if (lastIndexForTwo>stackSize-1){
                value = one[lastIndexForTwo];
                lastIndexForTwo--;
            }
        }else if(stackNum == 2){
            if (lastIndexForThree>stackSize*2 -1){
                value = one[lastIndexForThree];
                lastIndexForThree--;
            }
        }
        return value;
    }

    public int peek(int stackNum) {
        int value = -1;
        if (stackNum == 0){
            if (lastIndexForOne>-1){
                value = one[lastIndexForOne];
            }
        }else if(stackNum == 1){
            if (lastIndexForTwo>stackSize-1){
                value = one[lastIndexForTwo];
            }
        }else if(stackNum == 2){
            if (lastIndexForThree>stackSize*2 -1){
                value = one[lastIndexForThree];
            }
        }
        return value;
    }

    public boolean isEmpty(int stackNum) {
        if (stackNum == 0){
            return lastIndexForOne == -1;
        }else if (stackNum == 1){
            return lastIndexForTwo == stackSize-1;
        }else if (stackNum == 2){
            return lastIndexForThree == stackSize*2 -1;
        }
        return true;
    }

}
