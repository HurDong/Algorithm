import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] friends;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine()); 
        int m = Integer.parseInt(br.readLine()); 

        friends = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        System.out.println(bfs());
    }

    static int bfs() {
        int count = 0;
        visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{1, 0}); // 시작 노드와 거리
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentFriend = current[0];
            int distance = current[1];

            if (distance == 2) continue;

            for (int friend : friends[currentFriend]) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    queue.add(new int[]{friend, distance + 1});
                    count++;
                }
            }
        }

        return count;
    }
}
