import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCount = new HashMap<>();
        Map<String,PriorityQueue<Song>> songs = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            genreCount.put(genres[i],genreCount.getOrDefault(genres[i],0)+plays[i]);
            songs.putIfAbsent(genres[i],new PriorityQueue<>());
            songs.get(genres[i]).add(new Song(i,plays[i])); // 고유번호 삽입
        }
        List<Integer> answerList = new ArrayList<>();
        // 재생 횟수 순으로 정렬 후, 상위 2곡 추출 후 list에 삽입
        genreCount.entrySet().stream().sorted((a,b)->b.getValue().compareTo(a.getValue())).forEach(entry->{
            PriorityQueue<Song> queue = songs.get(entry.getKey());
            for(int i=0;i<2&&!queue.isEmpty();i++)
            {
                answerList.add(queue.poll().index);
            }
        });
        return answerList.stream().mapToInt(i->i).toArray();
    }
    public class Song implements Comparable<Song>{
        int index;
        int play;
        public Song(int index,int play)
        {
            this.index =index;
            this.play=play;
        }
        @Override
        public int compareTo(Song other){
            // 재생 횟수가 큰 순서로 저장
            if(this.play==other.play){
                return Integer.compare(this.index,other.index);
            }
            return Integer.compare(other.play,this.play); 
        }
    }
}