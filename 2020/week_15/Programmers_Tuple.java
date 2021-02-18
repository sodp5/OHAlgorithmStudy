package week_15;

import java.util.ArrayList;
import java.util.Comparator;

public class Programmers_Tuple {
    public static void main(String[] args) {
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        int[] result = new Programmers_Tuple().solution(s);

        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int idx = 0;

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '{') {
                list.add(new ArrayList<>());
            } else if (c == '}') {
                list.get(idx++).add(Integer.parseInt(sb.toString()));
                sb.delete(0, sb.length());
            } else if (c == ',') {
                if (sb.length() != 0) {
                    list.get(idx).add(Integer.parseInt(sb.toString()));
                    sb.delete(0, sb.length());
                }
            } else {
                sb.append(c);
            }
        }

        list.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.size() - o2.size();
            }
        });

        ArrayList<Integer> tuple = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < tuple.size(); j++) {
                list.get(i).remove(tuple.get(j));
            }
            tuple.add(list.get(i).get(0));
        }

        int[] answer = new int[tuple.size()];

        for (int i = 0; i < tuple.size(); i++) {
            answer[i] = tuple.get(i);
        }

        return answer;
    }
}
