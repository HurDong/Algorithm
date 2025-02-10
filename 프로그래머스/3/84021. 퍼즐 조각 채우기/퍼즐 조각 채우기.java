import java.util.*;

class Solution {
    // 방향 벡터    
    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};
    
    class Point implements Comparable<Point>{
        int x,y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        // x 오름차순 같으면 y 오름차순
        public int compareTo(Point o){
            if(this.x == o.x){
                return this.y - o.y;
            } else{
                return this.x - o.x;
            }
        }
        
        // Object o가 Point인지 확인하고 x,y좌표를 비교 후 같은 지 반환
        @Override
        public boolean equals(Object o){
            if(o instanceof Point){
                Point p = (Point) o;
                return this.x == p.x && this.y == p.y;
            } else{
                return false;
            }
        }
        
       @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        int n = game_board.length;
        // Step 1 : 빈 영역 추출
        List<List<Point>> boardShapes = extractShapes(game_board,0);
        List<List<Point>> tableShapes = extractShapes(table,1);
        // 중복 방지 used 배열 사용
        boolean[] used = new boolean[tableShapes.size()];
        // Step 2 : board의 구멍과 table을 맞춰보기.
        for(List<Point> boardShape : boardShapes){
            boolean matched = false;
            for(int i=0;i<tableShapes.size();i++)
            {
                // 사용 했으면 다음 table으로
                if(used[i]) continue;
                List<Point> piece = tableShapes.get(i);
                // 기저 조건으로 크기가 맞는 지 부터
                if(piece.size() != boardShape.size()) continue;
                // Step 3 : 해당 조각을 90도씩 돌려서 검사
                for(int r = 0; r<4;r++)
                {
                    if(areEqual(boardShape,piece)){
                        answer += boardShape.size();
                        used[i] = true;
                        matched = true;
                        break;
                    }
                    piece = rotate90(piece);
                }
                // 돌려서 됐으면 다음 table로
                if(matched) break;
            }
        }
        return answer;
    }
    // target의 값에 따라 grid에서 모양을 추출하여 일반화 시킨 후 저장하는 메서드
    private List<List<Point>> extractShapes(int[][] grid, int target){
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        List<List<Point>> shapes = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == target && !visited[i][j]){
                    List<Point> shape = new ArrayList<>();
                    // dfs를 통해 해당 모양을 파악
                    dfs(grid,visited,i,j,target,shape);
                    // 모양을 일반화하여 저장
                    shapes.add(normalize(shape));
                }
            }
        }
        return shapes;
    }
    // 모양을 파악
    private void dfs(int[][] grid, boolean[][] visited, int x, int y, int target, List<Point> shape){
        int n = grid.length;
        visited[x][y] = true;
        shape.add(new Point(x,y));
        for(int d = 0; d < 4 ; d++)
        {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx >= 0 && nx <n && ny>=0 && ny<n){
                if(!visited[nx][ny] && grid[nx][ny] == target){
                    dfs(grid,visited,nx,ny,target,shape);
                }
            }
        }
    }
    private List<Point> normalize(List<Point> shape){
        List<Point> normalized = new ArrayList<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        // 가장 왼쪽 아래에 있는 점을 찾아 그 점을 0,0으로 이동시켜 일반화
        for(Point p : shape){
            minX = Math.min(minX,p.x);
            minY = Math.min(minY,p.y);
        }
        for(Point p : shape)
        {
            normalized.add(new Point(p.x-minX,p.y-minY));
        }
        // 오름차순 정렬
        Collections.sort(normalized);
        return normalized;
    }
    // 90도 회전하는 메서드
    private List<Point> rotate90(List<Point> shape){
        List<Point> rotated = new ArrayList<>();
        for(Point p : shape){
            rotated.add(new Point(p.y,-p.x));
        }
         return normalize(rotated);
    }
    // 모양이 일치하는지 확인하는 메서드
    private boolean areEqual(List<Point> s1, List<Point> s2){
        if(s1.size() != s2.size()) return false;
        for(int i=0;i<s1.size();i++)
        {
            Point p1 = s1.get(i);
            Point p2 = s2.get(i);
            if(p1.x != p2.x || p1.y != p2.y) return false;
        }
        return true;
    }
}