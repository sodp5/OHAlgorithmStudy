package week_15;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Programmers_CraneDollDraw {
    public static void main(String[] args) {
//        [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	[1,5,3,5,1,2,1,4]
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        int result = new Programmers_CraneDollDraw().solution(board, moves);
        System.out.println(result);
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Queue<Integer>[] lanes = new ArrayDeque[board.length];

        for (int i = 0; i < board.length; i++) {
            lanes[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 0) {
                    lanes[j].offer(board[i][j]);
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        int idx;
        int item;

        for (int i = 0; i < moves.length; i++) {
            idx = moves[i] - 1;

            if (lanes[idx].isEmpty()) {
                continue;
            }

            item = lanes[idx].poll();

            if (!stack.isEmpty() &&stack.peek() == item) {
                answer += 2;
                stack.pop();
            } else {
                stack.push(item);
            }
        }

        return answer;
    }
}
