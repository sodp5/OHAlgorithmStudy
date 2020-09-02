package week_15T;

public class Programmers_2016 {
    public static void main(String[] args) {
        String result = new Programmers_2016().solution(5, 24);
        System.out.println(result);
    }


    int[] daysOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String[] dayOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

    public String solution(int a, int b) {
        int dayCnt = 0;

        for (int i = 1; i < a; i++) {
            dayCnt += daysOfMonth[i - 1];
        }

        dayCnt += b - 1;

        return dayOfWeek[dayCnt % 7];
    }
}
