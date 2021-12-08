package leet.stack.middel;

import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 1) return asteroids;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];
            if (!stack.isEmpty()) {
                int pop = stack.peek();
                if (pop < 0) {
                    stack.push(curr);
                } else {
                    if (curr > 0) {
                        stack.push(curr);
                    } else {
                        if (Math.abs(curr) == stack.peek()){
                            stack.pop();
                        }else{
                            if (Math.abs(curr) > stack.peek()) {
                                while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(curr) > stack.peek()) {
                                    stack.pop();
                                }
                                if (!stack.isEmpty()){
                                    if (stack.peek() == Math.abs(curr)){
                                        stack.pop();
                                    }else{
                                        if (stack.peek()<Math.abs(curr)){
                                            stack.push(curr);
                                        }
                                    }
                                }else{
                                    stack.push(curr);
                                }

                            }
                        }

                    }
                }
            } else {
                stack.push(curr);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length-1; i >=0 ; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
