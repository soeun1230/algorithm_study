import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int currentWeight = 0; // Current total weight on the bridge
        Queue<Integer> bridge = new LinkedList<>(); // Queue to hold trucks currently on the bridge
        Queue<Integer> truckQueue = new LinkedList<>(); // Queue for trucks waiting to get on the bridge

        // Initialize the truck queue
        for (int truck : truck_weights) {
            truckQueue.offer(truck);
        }

        // Initialize bridge queue with 0s representing empty spaces on the bridge
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (!bridge.isEmpty()) {
            // Time moves forward with each loop iteration
            time++;

            // Remove the truck that has finished crossing the bridge
            currentWeight -= bridge.poll();

            // Check if there is a truck waiting to get on the bridge and if it can be added
            if (!truckQueue.isEmpty()) {
                if (currentWeight + truckQueue.peek() <= weight) {
                    int truck = truckQueue.poll();
                    bridge.offer(truck);
                    currentWeight += truck;
                } else {
                    // If not, add a placeholder (0) to the bridge to move time forward
                    bridge.offer(0);
                }
            }
        }

        return time;
    }
}
