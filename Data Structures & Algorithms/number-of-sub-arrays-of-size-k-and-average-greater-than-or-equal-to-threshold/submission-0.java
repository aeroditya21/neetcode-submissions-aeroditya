class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l=0, r=k-1;
        int sum=0;
        int res=0;
        
        // Calculate avg of initial window
        for(int i=0; i<k; i++) {
            sum += arr[i];
        }
        float avg = (float)sum / (float)k;
        System.out.println("Avg = " + avg + ", hence " + (avg >= (float)threshold));
        if (avg >= (float)threshold) {
            res += 1;
        }

        // keep moving window forward till r reaches arr length
        while (r < arr.length-1) {
            // adjust sum and check avg
            sum -= arr[l];
            l++;
            r++;
            sum += arr[r];
            avg = (float)sum / (float)k;
            System.out.println("Avg = " + avg + ", hence " + (avg >= (float)threshold));

            if (avg >= (float)threshold) {
                res += 1;
            }
        }

        return res;
    }
}