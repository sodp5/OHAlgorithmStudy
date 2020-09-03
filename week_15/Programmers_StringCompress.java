package week_15;

import java.util.HashMap;
import java.util.Iterator;

public class Programmers_StringCompress {
    public static void main(String[] args) {
        String s = "aabbaccc";

        int result = new Programmers_StringCompress().solution(s);

        System.out.println(result);
    }

    StringBuilder sb = new StringBuilder();

    public int solution(String s) {
        int min = 2147483647;
        String beforeValue = "";
        int beforeCnt = 1;
        int curr = 0;
        StringBuilder reader = new StringBuilder();

        char[] arr = s.toCharArray();
        for (int u = 1; u < arr.length; u++) {
            for (int r = 0; r <= u; r++) {
                reader.append(arr[r]);
            }
            beforeValue = read(reader);

            for (int i = u; i < arr.length; i += u) {
                for (int k = i; k < i + u; k++) {
                    if (i + u >= arr.length) {
//                        curr += (i + u) - arr.length;
                        break;
                    }
                    reader.append(arr[k]);
                }

                if (beforeValue.equals(reader.toString())) {
                    beforeCnt++;
                } else {
                    if (beforeCnt > 1) {
                        sb.append(beforeCnt);
                    }
                    sb.append(beforeValue);
                    beforeCnt = 1;
                    beforeValue = read(reader);
                }
            }

            if (beforeCnt > 0) {
                if (beforeCnt > 1) {
                    sb.append(beforeCnt);
                }
                sb.append(beforeValue);
            }

            System.out.println(sb.toString());
            min = Math.min(sb.length(), min);
            clearSb(sb);
        }
        return min;
    }

    private void clearSb(StringBuilder b) {
        b.delete(0, b.length());
    }

    private String read(StringBuilder b) {
        String s = b.toString();
        clearSb(b);

        return s;
    }
}
