package week_15;

public class Programmers_BiggestExpression {
    public static void main(String[] args) {
        String expression = "100*500+20-200*300";

        long result = new Programmers_BiggestExpression().solution(expression);
        System.out.println(result);
    }

    char[][] priorityCase = {
            {'*', '+', '-'},
            {'*', '-', '+'},
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '*', '+'},
            {'-', '+', '*'}
    };

    StringBuilder reader = new StringBuilder();

    long firNum;
    long secNum;
    long curr;

    public long solution(String expression) {
        long max = 0;
        char[] arr;
        boolean isMeetCurrOper;
        boolean isFirstCharSub;
        String orgExpression = expression;

        for (int t = 0; t < priorityCase.length; t++) {
            curr = 0;
            expression = orgExpression;
            arr = expression.toCharArray();

            for (int k = 0; k < priorityCase[0].length; k++) {
                clearReader();
                clearNum();
                isMeetCurrOper = false;
                isFirstCharSub = false;
                for (int i = 0; i < arr.length; i++) {
                    if (i == 0 && arr[0] == '-') {
                        isFirstCharSub = true;
                        continue;
                    }

                    if (isOperator(arr[i])) {
                        if (reader.length() == 0 && arr[i] == '-') {
                            isFirstCharSub = true;
                            continue;
                        }

                        if (isMeetCurrOper) {
                            secNum = getReaderNum();
                            if (isFirstCharSub) {
                                secNum *= -1;
                                isFirstCharSub = false;
                            }
                            expression = calcExpression(expression, priorityCase[t][k]);
                            arr = expression.toCharArray();
                            i = -1;
                            isMeetCurrOper = false;
                        } else {
                            firNum = getReaderNum();
                            if (isFirstCharSub) {
                                firNum *= -1;
                                isFirstCharSub = false;
                            }
                            if (arr[i] == priorityCase[t][k]) {
                                isMeetCurrOper = true;
                            }
                        }
                    } else {
                        reader.append(arr[i]);
                    }
                }

                if (isMeetCurrOper) {
                    secNum = getReaderNum();
                    if (isFirstCharSub) {
                        secNum *= -1;
                    }
                    expression = calcExpression(expression, priorityCase[t][k]);
                    arr = expression.toCharArray();
                }
            }
            max = Math.max(Math.abs(Long.parseLong(expression)), max);
        }

        return max;
    }

    private boolean isOperator(char c) {
        return c == '*' || c == '-' || c == '+';
    }

    private void clearNum() {
        firNum = 0;
        secNum = 0;
    }

    private void clearReader() {
        reader.delete(0, reader.length());
    }

    private long getReaderNum() {
        long l = Long.parseLong(reader.toString());
        clearReader();
        return l;
    }

    private String calcExpression(String org, char oper) {
        long value = 0;
        switch (oper) {
            case '*':
                value = firNum * secNum;
                break;
            case '-':
                value = firNum - secNum;
                break;
            case '+':
                value = firNum + secNum;
                break;
        }

        String result = org.replace(String.format("%d%c%d", firNum, oper, secNum), String.valueOf(value));
        System.out.println(result);
        clearNum();

        return result;
    }

}
