

class TimeMap {

    /*
     * This class stores one value together with its timestamp.
     *
     * Example:
     * value = "happy"
     * timestamp = 1
     */
    private static class TimeValue {
        String value;
        int timestamp;

        TimeValue(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    /*
     * For every key, we store a list of values ordered by timestamp.

     * Example:
     *
     * "alice" -> [
     *              ("happy", 1),
     *              ("sad",   3)
     *            ]
     */
    private Map<String, List<TimeValue>> map = new HashMap<>();


    /*
     * Stores the value and timestamp for the given key.
     *
     * Since timestamps are strictly increasing,
     * we can simply add the new TimeValue at the end
     * of the list.
     */
    public void set(String key, String value, int timestamp) {

        /*
         * If the key does not exist, create a new ArrayList
         * for that key.
         */
        map.putIfAbsent(key, new ArrayList<>());

        /*
         * Add the value and timestamp to the list.
         */
        map.get(key).add(new TimeValue(value, timestamp));
    }

    /*
     * Returns the value whose timestamp is:
     *
     * 1. Less than or equal to the requested timestamp
     * 2. The largest possible timestamp satisfying condition 1
     *
     * If no such value exists, return an empty string.
     */
    public String get(String key, int timestamp) {

        /*
         * If the key does not exist,
         * no value can be returned.
         */
        if (!map.containsKey(key)) {
            return "";
        }

        /*
         * Get all values stored for this key.
         *
         * The list is sorted by timestamp because
         * timestamps are inserted in increasing order.
         */
        List<TimeValue> values = map.get(key);

        int start = 0;
        int end = values.size() - 1;

        /*
         * This stores the best answer found so far.
         */
        String answer = "";

        /*
         * Binary search for the largest timestamp
         * that is less than or equal to the requested timestamp.
         */
        while (start <= end) {

            int mid = start + (end - start) / 2;

            /*
             * If the current timestamp is valid,
             * save its value as a possible answer.

             * We continue searching to the right because
             * there may be a larger valid timestamp.
             */
            if (values.get(mid).timestamp <= timestamp) {
                answer = values.get(mid).value;
                start = mid + 1;
            }

            /*
             * If the current timestamp is too large,
             * search in the left half.
             */
            else {
                end = mid - 1;
            }
        }

        /*
         * Return the value with the closest valid timestamp.
         * If no valid timestamp was found, answer remains "".
         */
        return answer;
    }
}