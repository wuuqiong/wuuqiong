package leet.stack.middel;

import java.util.*;


/**
 * https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 * 扁平化嵌套列表迭代器
 *
 * 给你一个嵌套的整数列表 nestedList 。每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。请你实现一个迭代器将其扁平化，使之能够遍历这个列表中的所有整数
 *
 * 你的代码将会用下述伪代码检测：
 */

/**
 *  提示初始化的时候，需要使用到iterator。所以要用到Iterator<Integer>。从而使用List -> Iterator
 *  * initialize iterator with nestedList
 *  * res = []
 *  * while iterator.hasNext()
 *  *     append iterator.next() to the end of res
 *  *
 *  * return res
 */
public class NestedIterator implements Iterator<Integer> {

   public interface NestedInteger{
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }

    private Iterator<Integer> cur;
    private List<Integer> vals;
    public NestedIterator(List<NestedInteger> nestedList) {
        vals = new ArrayList<>();
        extractData(nestedList);
        cur = vals.iterator();
    }

    @Override
    public Integer next() {
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }

    private void extractData(List<NestedInteger> nestedList){
        for (int i = 0;i<nestedList.size();i++){
            NestedInteger nestedInteger = nestedList.get(i);
            if (nestedInteger.isInteger()){
                vals.add(nestedInteger.getInteger());
            }else{
                extractData(nestedInteger.getList());
            }
        }
    }

}
