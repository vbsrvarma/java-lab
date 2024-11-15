//abstract class representing a generic robber
abstract class Robber {
//abstract methods
    public abstract int RowHouses(int[] money);
    public abstract int RoundHouses(int[] money);
    public abstract int SquareHouse(int[] money);
    public abstract int MultiHouseBuilding(int[]... money);

//default method
public void MachineLearning() {
System.out.println("I love MachineLearning.");
}

//method to represent the class with its specialty
public void RobbingClass() {
System.out.println("MScAI&ML");
}
}

//concrete class implementing the abstract methods from robber
class JAVAProfessionalRobber extends Robber {

//calculate maximum loot for row houses without triggering alarms
public int RowHouses(int[] money) {
    if (money == null || money.length == 0) {
    return 0;
    }
    if (money.length == 1) {
        return money[0];
    }

    int previousTwo = 0, previousOne = 0;
        for (int value : money) {
        int current = Math.max(previousOne, previousTwo + value);
            previousTwo = previousOne;
            previousOne = current;
        }
        return previousOne;
    }

//calculate maximum loot for round houses considering the circular nature
public int RoundHouses(int[] money) {
    if (money == null || money.length == 0) {
    return 0;
   }
   if (money.length == 1) {
        return money[0];
    }

//exclude the first house and calculate
int excludeFirst = RowHouses(java.util.Arrays.copyOfRange(money, 1, money.length));

//exclude the last house and calculate
int excludeLast = RowHouses(java.util.Arrays.copyOfRange(money, 0, money.length - 1));

//return the better of the two scenarios
    return Math.max(excludeFirst, excludeLast);
    }

//calculate maximum loot for square houses (same as row houses)
public int SquareHouse(int[] money) {
    return RowHouses(money);
    }

//calculate maximum loot for multi-type houses, summing up loot from all types
public int MultiHouseBuilding(int[]... money) {
    int totalLoot = 0;
    for (int[] houseType : money) {
        totalLoot += RowHouses(houseType);
        }
        return totalLoot;
    }

//main function
    public static void main(String[] args) {
        JAVAProfessionalRobber robber = new JAVAProfessionalRobber();

//test RobbingClass and MachineLearning methods
    robber.RobbingClass();
    robber.MachineLearning();

//test cases for abstract methods
    System.out.println("RowHouses([1,2,3,0]): " + robber.RowHouses(new int[]{1, 2, 3, 0})); // Output: 4
    System.out.println("RoundHouses([1,2,3,4]): " + robber.RoundHouses(new int[]{1, 2, 3, 4})); // Output: 6
    System.out.println("SquareHouse([5,10,2,7]): " + robber.SquareHouse(new int[]{5, 10, 2, 7})); // Output: 17
    System.out.println("MultiHouseBuilding(): " + robber.MultiHouseBuilding(
        new int[]{5, 3, 8, 2},
        new int[]{10, 12, 7, 6},
        new int[]{4, 9, 11, 5},
        new int[]{8, 6, 3, 7}
        ));
    }
}
