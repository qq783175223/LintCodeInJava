public class Solution {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public static List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair.
        List<Map.Entry<Integer, Double>> results = 
                new ArrayList<Map.Entry<Integer, Double>>();
        
        double[][] probabilities = new double[2][6 * n + 1];
        int flag=0;
        for (int i = 1; i <= 6; ++i)
            probabilities[flag][i] = 1.0;

        for (int i = 2; i <= n; ++i){
            for (int j = 1; j <= 6 * i; ++j) {
                probabilities[1-flag][j]=0.0;
                for (int k = 1; k <= 6; ++k){
                    if (j >= k)
                        probabilities[1-flag][j] += probabilities[flag][j - k];
                }
            }
            flag=1-flag;
        }
        double total=Math.pow(6,n);
        for (int i = n; i <= 6 * n; ++i){
            results.add(new AbstractMap.SimpleEntry<Integer, Double>(i, probabilities[flag][i]/total));
        }
        return results;
    }
}