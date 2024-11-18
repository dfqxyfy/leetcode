package com.temp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MinPlatforms {
    
    // 定义一个事件类，包含时间和事件类型（到达或离开）
    static class Event implements Comparable<Event> {
        int time;
        String type; // "arrive" 或 "depart"
        int trainIndex; // 列车索引，用于后续匹配到达和离开时间（可选）

        public Event(int time, String type, int trainIndex) {
            this.time = time;
            this.type = type;
            this.trainIndex = trainIndex;
        }

        @Override
        public int compareTo(Event other) {
            if (this.time != other.time) {
                return Integer.compare(this.time, other.time);
            } else if (this.type.equals("arrive") && other.type.equals("depart")) {
                return 1; // 到达事件排在离开事件之后（因为离开事件会释放站台）
            } else if (this.type.equals("depart") && other.type.equals("arrive")) {
                return -1; // 离开事件排在到达事件之前
            } else {
                // 如果两个事件都是到达或都是离开，则它们应该已经通过时间排序好了
                // 这里我们不需要处理这种情况，因为时间已经相同，并且我们不会比较两个到达或两个离开事件
                return 0;
            }
        }
    }

    public static int minPlatforms(int[] arr, int[] dep) {
        // 创建一个事件数组，并填充到达和离开事件
        Event[] events = new Event[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            events[2 * i] = new Event(arr[i], "arrive", i);
            events[2 * i + 1] = new Event(dep[i], "depart", i);
        }

        // 对事件进行排序
        Arrays.sort(events);

        // 使用PriorityQueue来跟踪当前正在使用的站台的离开时间
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int currentPlatforms = 0;
        int maxPlatforms = 0;

        for (Event event : events) {
            if (event.type.equals("arrive")) {
                // 有列车到达，需要一个新的站台（如果当前最早释放的站台还在使用中）
                heap.offer(event.time + (dep[event.trainIndex] - arr[event.trainIndex])); // 这里计算的是离开时间
                currentPlatforms++;
            } else {
                // 有列车离开，更新最小堆（堆顶始终是最早释放的站台）
                if (!heap.isEmpty() && heap.peek() <= event.time) {
                    heap.poll(); // 最早释放的站台现在已经释放了
                    currentPlatforms--;
                }
                // 注意：我们不需要显式地从堆中删除该列车的离开时间，因为我们通过时间顺序和堆的性质来处理它
            }

            // 更新所需的最大站台数量
            maxPlatforms = Math.max(maxPlatforms, currentPlatforms);
        }

        return maxPlatforms;
    }

    public static void main(String[] args) {
        int[] arr = {904, 946, 952, 1100, 1508, 1806};
        int[] dep = {915, 1202, 1128, 1135, 1900, 2001};

        // 计算最小站台数量
        int result = minPlatforms(arr, dep);
        System.out.println("所需的最小站台数量: " + result); // 输出结果
    }
}