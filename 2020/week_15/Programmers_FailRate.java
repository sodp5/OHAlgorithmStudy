package week_15;

import java.util.*;

public class Programmers_FailRate {
    public static void main(String[] args) {
        int N = 4;
        int[] stages = {4,4,4,4};

        new Programmers_FailRate().solution(N, stages);
    }

    int peopleCnt;

    class FailRateInfo {
        int stage;
        double rate;

        FailRateInfo(int stage, int amount) {
            this.stage = stage;
            if (peopleCnt != 0) {
                rate = amount / (double)peopleCnt;
            } else {
                rate = 0;
            }
        }
    }

    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Integer> map = new HashMap<>();
        peopleCnt = stages.length;

        for (int i : stages) {
            if (i == N + 1) {
                continue;
            }

            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<FailRateInfo> queue = new PriorityQueue<>(new Comparator<FailRateInfo>() {
            @Override
            public int compare(FailRateInfo o1, FailRateInfo o2) {
                if (o1.rate == o2.rate) {
                    return o1.stage - o2.stage;
                } else {
                    if (o2.rate - o1.rate > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });

        int amount = 0;
        for (int i = 1; i <= N; i++) {
            amount = map.getOrDefault(i, 0);
            queue.add(new FailRateInfo(i, amount));
            peopleCnt -= amount;
        }

        int[] answer = new int[queue.size()];

        for (int i = 0; !queue.isEmpty(); i++) {
            answer[i] = queue.poll().stage;
        }

        return answer;
    }
}
