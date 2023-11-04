public class Main {
    public static void main(String[] args) {
        boolean[] isSelfNumber = new boolean[10001]; // 1부터 10000까지의 숫자를 체크하기 위한 배열

        for (int i = 1; i <= 10000; i++) {
            int d = getD(i);
            if (d <= 10000) {
                isSelfNumber[d] = true; // 생성자가 있는 숫자를 체크
            }
        }

        // 셀프 넘버 출력
        for (int i = 1; i <= 10000; i++) {
            if (!isSelfNumber[i]) {
                System.out.println(i);
            }
        }
    }

    // 생성자를 찾는 함수
    public static int getD(int number) {
        int sum = number;
        while (number != 0) {
            sum += number % 10; // 각 자리수를 더함
            number /= 10;
        }
        return sum;
    }
}
