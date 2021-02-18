package week_15;

public class Programmers_KeyPad {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        String result = new Programmers_KeyPad().solution(numbers, hand);
        System.out.println(result);
    }

    class Hand {
        int level = 0;
        boolean isCenter = false;
    }

    Hand rightHand = new Hand();
    Hand leftHand = new Hand();

    String mainHand;

    StringBuilder sb = new StringBuilder();

    public String solution(int[] numbers, String hand) {
        mainHand = hand;

        for (int i : numbers) {
            if (i == 0) {
                clickCenter(0);
                continue;
            }

            int rest = i % 3;
            int div = i / 3;

            if (rest == 2) {
                clickCenter(3 - div);
            } else if (rest == 1) {
                clickLeft(3 - div);
            } else {
                clickRight(4 - div);
            }
        }

        return sb.toString();
    }

    void clickLeft(int level) {
        leftHand.level = level;
        leftHand.isCenter = false;

        sb.append("L");
    }

    void clickRight(int level) {
        rightHand.level = level;
        rightHand.isCenter = false;

        sb.append("R");
    }

    void clickCenter(int level) {
        String result;

        int left = getDistance(leftHand, level);
        int right = getDistance(rightHand, level);

        if (left == right) {
            if (mainHand.equals("right")) {
                result = "R";
            } else {
                result = "L";
            }
        } else if (left < right) {
            result = "L";
        } else {
            result = "R";
        }

        if (result.equals("R")) {
            rightHand.level = level;
            rightHand.isCenter = true;
        } else {
            leftHand.level = level;
            leftHand.isCenter = true;
        }

        sb.append(result);
    }

    int getDistance(Hand hand, int level) {
        int dist = Math.abs(hand.level - level);
        if (!hand.isCenter) {
            dist++;
        }

        return dist;
    }
}
