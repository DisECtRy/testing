import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        
        int[][] ride = {
            { 80, 60, 70, 50, 0, 0, 0, 0, 0, 0 }, // Floor 0
            { 60, 70, 80, 0, 0, 0, 0, 0, 0, 0 }, // Floor 1
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // Floor 2
            { 80, 500, 500, 500, 500, 500, 1, 1 , 1} // Floor 3
        };

        List<Integer> peopleCount = getPeopleCount(ride);
        System.out.println("People count: " + peopleCount);

        List<Integer> weightList = getWeightList(ride);
        System.out.println("Weight list: " + weightList);

        int maxCapacityExceededFloor = getMaxCapacityExceededFloor(ride, 1020, 13);
        System.out.println("Max capacity exceeded floor: " + maxCapacityExceededFloor);

        int maxWeightExceededFloor = getMaxWeightExceededFloor(ride, 1020);
        System.out.println("Max weight exceeded floor: " + maxWeightExceededFloor);

        int maxPeopleCountExceededFloor = getMaxPeopleCountExceededFloor(ride, 13);
        System.out.println("Max people count exceeded floor: " + maxPeopleCountExceededFloor);

    }


    /* Part of Function 1 */
    public static List<Integer> getPeopleCount(int[][] ride) {
        List<Integer> peopleCount = new ArrayList<>();
        int currentWeight = 0;
        int currentPeopleCount = 0;
        for (int[] floor : ride) {
            currentWeight += getFloorWeightChange(floor);
            /*
            if (currentWeight > 1020) {
                System.out.println("Maximum weight exceeded!");
                break;
            }
            */
            currentPeopleCount += getFloorPeopleChange(floor);
            /*
            if (currentPeopleCount > 13) {
                System.out.println("Maximum people count exceeded!");
                break;
            }
            */
            peopleCount.add(currentPeopleCount);
        }
        return peopleCount;
    }

    /* Part of Function 1 */
    private static int getFloorWeightChange(int[] floor) {
        int weightChange = 0;
        for (int weight : floor) {
            weightChange += weight;
        }
        return weightChange;
    }

    /* Part of Function 1 */
    private static int getFloorPeopleChange(int[] floor) {
        int peopleChange = 0;
        for (int weight : floor) {
            if (weight > 0) {
                peopleChange++;
            } else if (weight < 0) {
                peopleChange--;
            }
        }
        return peopleChange;
    }

    /* Part of function 2 */
    public static List<Integer> getWeightList(int[][] ride) {
        List<Integer> weightList = new ArrayList<>();
        int currentWeight = 0;
        for (int[] floor : ride) {
            currentWeight += getFloorWeightChange(floor);
            weightList.add(currentWeight);
        }
        return weightList;
    }

    /* Part of function 3 */
    public static int getMaxCapacityExceededFloor(int[][] ride, int maxWeight, int maxPeopleCount) {
        int currentWeight = 0;
        int currentPeopleCount = 0;
        for (int i = 0; i < ride.length; i++) {
            int[] floor = ride[i];
            currentWeight += getFloorWeightChange(floor);
            if (currentWeight > maxWeight) {
                System.out.println("Maximum weight exceeded!");
                return i;
            }
            currentPeopleCount += getFloorPeopleChange(floor);
            if (currentPeopleCount > maxPeopleCount) {
                System.out.println("Maximum people count exceeded!");
                return i;
            }
        }
        return -1;
    }

    /* Part of function 4 */

    public static int getMaxWeightExceededFloor(int[][] ride, int maxWeight) {
        int currentWeight = 0;
        for (int i = 0; i < ride.length; i++) {
            int[] floor = ride[i];
            currentWeight += getFloorWeightChange(floor);
            if (currentWeight > maxWeight) {
                return i;
            }
        }
        return -1;
    }

    /* Part of function 5 */
    public static int getMaxPeopleCountExceededFloor(int[][] ride, int maxPeopleCount) {
        int currentPeopleCount = 0;
        for (int i = 0; i < ride.length; i++) {
            int[] floor = ride[i];
            currentPeopleCount += getFloorPeopleChange(floor);
            if (currentPeopleCount > maxPeopleCount) {
                return i;
            }
        }
        return -1;
    }

}