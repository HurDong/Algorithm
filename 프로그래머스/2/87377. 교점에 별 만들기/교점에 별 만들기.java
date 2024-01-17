import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        ArrayList<long[]> list = new ArrayList<>();
        ArrayList<long[]> ansList = new ArrayList<>();
        long maxX = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        for(int i=0;i<line.length-1;i++){
            for(int j=i+1;j<line.length;j++)
            {
                long a = (long) line[i][0], b = (long) line[i][1], e = (long) line[i][2];
                long c = (long) line[j][0], d = (long) line[j][1], f = (long) line[j][2];
                long denominator = a * d - b * c;
                 if (denominator != 0) {
                    double x = (double) (b * f - e * d) / denominator;
                    double y = (double) (e *c - a * f) / denominator;
                    if(x==Math.floor(x) && y == Math.floor(y)){
                        list.add(new long[]{(long)x,(long)y});
                        maxX = Math.max(maxX,(long)x);
                        maxY = Math.max(maxY,(long)y);
                        minX = Math.min(minX,(long)x);
                        minY = Math.min(minY,(long)y);
                    }
                }
            }
        }
        long y = (long) (maxY - minY + 1);
        long x = (long) (maxX - minX + 1);
        char[][] grid= new char[(int)y][(int)x];
        for(int i=0;i<y;i++)
        {
            for(int j=0;j<x;j++)
            {
                grid[i][j] = '.';
            }
        }
        for(long[] arr : list){
            long ansX = (long) (arr[0] - minX);
            long ansY = (long) (maxY - arr[1]);
            grid[(int)ansY][(int)ansX] = '*';
        }
        String[] answer = new String[(int)y];
        for(int i=0;i<y;i++)
        {
            answer[i] = new String(grid[i]);
        }
        
        return answer;
    }
}