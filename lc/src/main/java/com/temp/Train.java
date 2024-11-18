package temp;

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
    }
}
