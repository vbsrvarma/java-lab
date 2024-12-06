import java.util.HashMap;
interface TransactionAnalyzer
{
    int countPairs(int[] prices, int target);
}

class RetailTransactionAnalyzer implements TransactionAnalyzer
{
    public int countpairs(int[] prices, int target)
    {
        HashMap<Integer, Integer> frequencymMap = new HashMap<>();
        int pairCount= 0;
     
        for ( int price : prices)
        {
            int complement= target-price;
            if(frequencymMap.getOrDefault(complement, defaultValue:0) > 0)
        {
            pairCount++;
            frequencymMap.put(complement, frequencymMap.get(complement) - 1);
        }
        else
        {
            frequencymMap.put(price, frequencymMap.getOrDefault(price, defaultValue:0) + 1);
        }
        }
        return pairCount;
        }
    }
    public class RetailStoreTransaction
    {
        public static void main(String[] args)
        {
            int[] arr1 = {1,5,7,-1,5};
            int target1 = 6;

            int[] arr2 ={2,4,3,5,6};
            int target2 = 8;

            TransactionAnalyzer analyzer = new RetailTransactionAnalyzer();

            System.out.println("example 1 output:" + analyzer.countPairs(arr1, target1));
            System.out.println("example 2 output:" + analyzer.countPairs(arr2, target2));
        }
}