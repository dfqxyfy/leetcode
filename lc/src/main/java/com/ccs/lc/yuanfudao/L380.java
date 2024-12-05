package com.ccs.lc.yuanfudao;

import java.util.*;

/**
 * @date 2024/12/3 00:52
 *
 * 实现RandomizedSet 类：
 *
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 *
 * 解题思路：变长数组 （ArrayList实现）和 哈希表
 */
public class L380 {



    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
//        System.out.println(randomizedSet.insert(0));;
//        System.out.println(randomizedSet.insert(1));;
//        System.out.println(randomizedSet.remove(0));
//        System.out.println(randomizedSet.insert(2));;
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));;
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));;
//        System.out.println(randomizedSet.insert(0));;
//        System.out.println(randomizedSet.getRandom());;
    }
}

class RandomizedSet {
    private List<Integer> list = new ArrayList<>();
    private Map<Integer,Integer> map = new HashMap<>();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        int last = list.get(list.size()-1);

        list.set(index,last);
        map.put(last,index);

        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}
