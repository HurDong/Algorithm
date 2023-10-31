class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i = 0; i < babbling.length; i++) {
            int aya = 0, ye = 0, woo = 0, ma = 0;
            int length=0;
            for(int j = 0; j < babbling[i].length(); j++) {
                if(j + 2 < babbling[i].length() && babbling[i].substring(j, j + 3).equals("aya")) {
                    aya++;
                    length +=3;
                    j += 2;
                } else if(j + 1 < babbling[i].length() && babbling[i].substring(j, j + 2).equals("ye")) {
                    ye++;
                    length+=2;
                    j += 1;
                } else if(j + 2 < babbling[i].length() && babbling[i].substring(j, j + 3).equals("woo")) {
                    woo++;
                    length+=3;
                    j += 2;
                } else if(j + 1 < babbling[i].length() && babbling[i].substring(j, j + 2).equals("ma")) {
                    ma++;
                    length+=2;
                    j += 1;
                }
            }
            if(aya <= 1 && ye <= 1 && woo <= 1 && ma <= 1&&length==babbling[i].length()) {
                answer++;
            }
        }
        return answer;
    }
}
