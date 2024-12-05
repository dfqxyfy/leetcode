package com.temp;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @date 2024/10/22 11:33 AM
 */
public class Train {


    public int minTrain(int[] inboundList,int[] outboundList){

        int res = 0;
        for(int i=1;i<outboundList.length;i++){
            int minCount = 1;
            for(int j=0;j<i;j++){
//                if(inboundList[i] < outboundList[j] && inboundList[i] > inboundList[j] ){
//                    minCount++;
//                }
                if(inboundList[i] > inboundList[j] && inboundList[i] < outboundList[j] ){
                    minCount++;
                }
            }
            res = Math.max(minCount,res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] in = new int[]{800,900,940,950,1100,1500,1800};
        int[] out = new int[]{945,1000,1200,1120,1130,1900,2000};
        int i = new Train().minTrain(in, out);
        System.out.println(i);
        i = new Train().minTrain2(in, out);
        System.out.println(i);
        i = new Train().minTrain3(in, out);
        System.out.println(i);
    }

    public int minTrain2(int[] in,int[] out){

        PriorityQueue<TrainNode> heap = new PriorityQueue<>(
                (o1, o2) ->
                    o1.getOutTime()- o2.getOutTime()
        );
        int max = 0;
        for(int i=0;i<in.length;i++){
            TrainNode trainNode = new TrainNode(i, in[i], out[i]);
            //出队时间
            while(!heap.isEmpty() && heap.peek().getOutTime() <= in[i]){
                heap.poll();
            }
            heap.add(trainNode);
            max = Math.max(heap.size(),max);
        }
        return max;

    }



    public int minTrain3(int[] in,int[] out){

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int max = 0;
        for(int i=0;i<in.length;i++){
            //出队时间
            while(!heap.isEmpty() && heap.peek() <= in[i]){
                heap.poll();
            }
            heap.add(out[i]);
            max = Math.max(heap.size(),max);
        }
        return max;

    }


}

class TrainNode{

    private int idx;
    private int inTime;
    private int outTime;

    public TrainNode(int idx,int inTime, int outTime) {
        this.idx = idx;
        this.inTime = inTime;
        this.outTime = outTime;
    }

    public int getInTime() {
        return inTime;
    }

    public void setInTime(int inTime) {
        this.inTime = inTime;
    }

    public int getOutTime() {
        return outTime;
    }

    public void setOutTime(int outTime) {
        this.outTime = outTime;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }
}