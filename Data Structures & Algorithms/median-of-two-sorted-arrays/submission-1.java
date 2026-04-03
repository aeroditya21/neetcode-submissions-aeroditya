class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0, j=0, k=0;
        List<Integer> merged = new ArrayList<>();
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i] <= nums2[j]) {
                merged.add(nums1[i]);
                i++;
            } else {
                merged.add(nums2[j]);
                j++;
            }
        }
        int[] rem;
        int remIndex;
        if (i == nums1.length) {
            rem = nums2;
            remIndex = j;
        } else {
            rem = nums1;
            remIndex = i;
        }
        while (remIndex < rem.length) {
            merged.add(rem[remIndex]);
            remIndex++;
        }
        merged.forEach(x -> System.out.print(x + ","));

        return findMedian(merged);
    }

    double findMedian(List<Integer> list) {
        if (list.size()%2 == 0) {
            int left = list.size()/2;
            int right = left-1;
            return Double.valueOf(list.get(left) + list.get(right)) / 2.0;
        } else {
            return Double.valueOf(list.get(list.size()/2));
        }
    }
}
