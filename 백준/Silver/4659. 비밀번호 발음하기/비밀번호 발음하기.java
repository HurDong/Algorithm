import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        StringBuilder sb = new StringBuilder();
        // end를 입력받을때까지 실행
        while (!(input = sc.nextLine()).equals("end")) {
            sb.append("<" + input + ">" + " is " + (isValidPassword(input) ? "acceptable.\n" : "not acceptable.\n"));
        }
        System.out.println(sb.toString());
    }

    public static boolean isValidPassword(String password) {
        boolean containsVowel = false; // 모음 포함 여부
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            // 모음 체크
            if (isVowel(c)) {
                containsVowel = true;
            }

            // 연속된 모음 혹은 자음 체크
            if (i >= 2 && (isVowel(c) == isVowel(password.charAt(i - 1))
                    && isVowel(c) == isVowel(password.charAt(i - 2)))) {
                return false;
            }

            // 같은 글자 연속 체크 (ee, oo 제외)
            if (i >= 1 && c == password.charAt(i - 1) && c != 'e' && c != 'o') {
                return false;
            }
        }

        return containsVowel;
    }

    public static boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true; // c가 위의 모음 중 하나와 일치하면 true 반환
            default:
                return false; // 그 외의 경우에는 false 반환
        }
    }

}
