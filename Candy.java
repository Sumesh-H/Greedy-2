// Time Complexity : O(n)
// Space Complexity : O(n)

class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] result = new int[n];

        Arrays.fill(result, 1);

        // Forward pass
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                result[i] = result[i-1] + 1;
            }
        }

        // Backward pass
        for(int i = n-2; i >=0; i--){
            if(ratings[i] > ratings[i+1] && result[i] <= result[i+1]){
                result[i] = result[i+1] + 1;
            }
        }

        int output = 0;
        for(int i : result){
            output += i;
        }

        return output;
    }
}
