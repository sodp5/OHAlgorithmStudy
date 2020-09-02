package week_15T;

import java.util.ArrayList;

public class Programmers_DevelopFunction {
    public static void main(String[] args) {
        int[] progresses = {95, 95, 95, 95};
        int[] speeds = {4, 3, 2, 1};

        int[] result = new Programmers_DevelopFunction().solution(progresses, speeds);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> progress = new ArrayList<>();
        ArrayList<Integer> speed = new ArrayList<>();
        ArrayList<Integer> answerList = new ArrayList<>();

        for (int i : progresses) {
            progress.add(i);
        }

        for (int i : speeds) {
            speed.add(i);
        }

        while (!progress.isEmpty()) {
            int cnt = 0;

            for (int i = 0; i < progress.size(); i++) {
                progress.set(i, progress.get(i) + speed.get(i));
            }

            if (progress.get(0) >= 100) {
                while (true) {
                    if (progress.get(0) >= 100) {
                        cnt++;
                        progress.remove(0);
                        speed.remove(0);
                    }

                    if (progress.isEmpty() || progress.get(0) < 100) {
                        break;
                    }
                }

                answerList.add(cnt);
            }
        }

        int[] result = new int[answerList.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = answerList.get(i);
        }

        return result;
    }
}
