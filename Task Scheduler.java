// Time Complexity : O(n)
// Space Complexity : O(1)

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {

        /*// normal case, freq are diff
        int partitions = maxFreq - 1;
        int emptySpots = n * partiions;
        int remainingTasks = tasks.length - maxFreq;
        int idleSpots = emptySpots - remainingTasks;
        return tasks.length + idleSPots;
        */

        /*// special case, freq are same for any two
        int partitions = maxFreq - 1;
        int emptySpots = (n - (maxCount - 1)) * partiions;
        int remainingTasks = tasks.length - (maxFreq * maxCount);
        int idleSpots = max(0, emptySpots - remainingTasks);
        return tasks.length + idleSpots;
        */

        int maxFreq = 0;
        int maxCount = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < tasks.length; i++){
            char c = tasks[i];
            map.put(c, map.getOrDefault(c,0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
        }

        for(int val : map.values()){
            if(val == maxFreq){
                maxCount++;
            }
        }

        int partitions = maxFreq - 1;
        int emptySpots = (n - (maxCount - 1)) * partitions;
        int remainingTasks = tasks.length - (maxCount * maxFreq);
        int idleSpots = Math.max(0, emptySpots - remainingTasks);

        return tasks.length + idleSpots;

    }