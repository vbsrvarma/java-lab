import java.util.*;
public class NumberFrequency1 {
    private static int[] numbersArray = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
    // Method to find top K frequent numbers
    public static void findTopKFrequentNumbers(int K) {
    // Build frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : numbersArray) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
 // Max-heap sorted by frequency, then by number value if frequencies are equal
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return b[1] - a[1];
            } else {
                return b[0] - a[0];
            }
        });
 // Insert all frequency map entries into the heap
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            heap.offer(new int[]{entry.getKey(), entry.getValue()});
        }
// Retrieve top K frequent numbers
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < K && !heap.isEmpty(); i++) {
            result.add(heap.poll()[0]);
        }
// Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int K = 4;
        System.out.print("Top " + K + " frequent numbers: ");
        findTopKFrequentNumbers(K);
    }
}

