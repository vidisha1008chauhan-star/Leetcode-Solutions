1. Brute Force

class Solution {
    public int trap(int[] height) {
        int i = 0, sum = 0;
        while(i < height.length && height[i] == 0) i++;

        while(i < height.length - 1){
            int j = i + 1;
            if(height[i] == height[j]){
                while(j < height.length && height[i] == height[j]) j++;
                if(j == height.length) break;
                if(height[i] < height[j]){
                    i = j;
                }
                else{
                    i = j - 1;
                }
            }

            if(height[i] <= height[j]){
                if(j - i > 1){
                    for(int k = i + 1; k < j; k++){
                        sum += (height[i] - height[k]);
                    }
                }
                i = j;
                continue;
            }

            if(height[i] > height[j]){
                int max = -1, pointer = -1;
                int next = j;
                while(next < height.length && height[i] > height[next]){
                    if(max < height[next]){
                        max = height[next];
                        pointer = next;
                    }
                    next++;
                }
                if(next != height.length){
                    j = next;
                    for(int k = i + 1; k < j; k++){
                        sum += (height[i] - height[k]);
                    }
                    i = j;
                    continue;
                }
                if(pointer != -1){
                    for(int k = i + 1; k < pointer; k++){
                        sum += (height[pointer] - height[k]);
                    }
                    i = pointer;
                    continue;
                }
            }
            i++;
        }
        return sum;
    }
}