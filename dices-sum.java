public class Solution {
    private int g_maxVlaue=6;
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        List<Map.Entry<Integer, Double>> result=new ArrayList<Map.Entry<Integer, Double>>();
        if(n<1){
            return result;
        }
        double[][] probabilities=new double[2][n*g_maxVlaue+1];
        int flag=0;
        for(int i=1;i<=g_maxVlaue;i++){
            probabilities[flag][i]=1;
        }
       flag=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i*g_maxVlaue;j++){
                int p=j;
                for(int k=0;k<6&&p>=1;k++){
                    probabilities[flag][j] +=probabilities[1-flag][--p];
                }
            }
            flag=1-flag;
        }
        double total=Math.pow(g_maxVlaue,n);
        for(int i=n;i<=n*g_maxVlaue;i++){
            result.add(new AbstractMap.SimpleEntry<Integer, Double>(i,probabilities[1-flag][i]/total));
        }
        return result;
    }
}