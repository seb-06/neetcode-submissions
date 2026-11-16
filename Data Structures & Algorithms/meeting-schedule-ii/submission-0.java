/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int len = intervals.size();
        int[] starts = new int[len];
        int[] ends = new int[len];

        for (int i = 0; i<len;i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int j=0, rooms=0, max=0;
        for (int s : starts) {
            while (ends[j] <=s) {
                rooms--;
                j++;
            }
            rooms++;
            max = Math.max(max, rooms);
        }

        return max;
    }
}
