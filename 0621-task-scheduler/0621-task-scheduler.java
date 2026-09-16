class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        // Count frequency of each task
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find the maximum frequency
        int maxFreq = 0;
        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }

        // Number of tasks having the maximum frequency
        int maxCount = 0;
        for (int count : freq) {
            if (count == maxFreq) {
                maxCount++;
            }
        }

        /*
         * Arrange the most frequent tasks first.
         *
         * Example:
         * A A A, n = 2
         *
         * A _ _ A _ _ A
         *
         * Required intervals:
         * (maxFreq - 1) * (n + 1) + maxCount
         */
        int result = (maxFreq - 1) * (n + 1) + maxCount;

        // We cannot have fewer intervals than the number of tasks.
        return Math.max(result, tasks.length);
    }
}
