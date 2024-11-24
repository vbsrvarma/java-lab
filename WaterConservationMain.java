//step 1:define the waterconservationsystem interface
interface WaterConservationSystem {
    int calculateTrappedWater(int[] blockHeights);
}

//step 2: Create an abstract class implementing the interface
abstract class RainySeasonConservation implements WaterConservationSystem {
    //the abstract class does not define the method implementation
}

//step 3: Create a concrete class extending the abstract class
class CityBlockConservation extends RainySeasonConservation {
    //implement the method to calculate trapped water
    public int calculateTrappedWater(int[] blockHeights) {
        int n = blockHeights.length;

//base case: If there are less than 3 blocks, no water can be trapped
        if (n < 3) {
            return 0;
        }

//arrays to store the maximum heights from the left and right
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

//fill leftMax array
        leftMax[0] = blockHeights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blockHeights[i]);
        }

//fill rightMax array
        rightMax[n - 1] = blockHeights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blockHeights[i]);
        }

//calculate the total trapped water
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - blockHeights[i];
        }

        return totalWater;
    }
}

//main class to test the functionality
public class WaterConservationMain {
    public static void main(String[] args) {
//create an instance of the CityBlockConservation class
        WaterConservationSystem system = new CityBlockConservation();

//example block heights
        int[] blockHeights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

//calculate and display the trapped water
        int trappedWater = system.calculateTrappedWater(blockHeights);
        System.out.println("Total trapped water: " + trappedWater + " units");
    }
}
