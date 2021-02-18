package week_15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Programmers_OpenChatRoom {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        String[] result = new Programmers_OpenChatRoom().solution(record);
    }

    private static final String ENTER = "Enter";
    private static final String LEAVE = "Leave";
    private static final String CHANGE = "Change";

    public String[] solution(String[] record) {
        ArrayList<String> commandList = new ArrayList<>();
        ArrayList<String> uidList = new ArrayList<>();
        HashMap<String, String> nameMap = new HashMap<>();


        for (String s : record) {
            StringTokenizer st = new StringTokenizer(s);
            String command = st.nextToken();
            String uid = st.nextToken();

            if (!command.equals(CHANGE)) {
                commandList.add(command);
                uidList.add(uid);
            }

            if (!command.equals(LEAVE)) {
                String name = st.nextToken();
                nameMap.put(uid, name);
            }

        }

        String[] answer = new String[commandList.size()];

        for (int i = 0; i < answer.length; i++) {
            if (commandList.get(i).equals(ENTER)) {
                answer[i] = nameMap.get(uidList.get(i)) + "님이 들어왔습니다.";
            } else {
                answer[i] = nameMap.get(uidList.get(i)) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
