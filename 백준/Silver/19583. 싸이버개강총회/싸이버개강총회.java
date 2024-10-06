import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String str = st.nextToken();
        int startHour = Integer.parseInt(str.substring(0, 2));
        int startMinuite = Integer.parseInt(str.substring(str.indexOf(':')+1));
        int startTime = (startHour * 60) + startMinuite;

        str = st.nextToken();
        int endHour = Integer.parseInt(str.substring(0, 2));
        int endMinuite = Integer.parseInt(str.substring(str.indexOf(':')+1));
        int endTime = (endHour * 60) + endMinuite;

        str = st.nextToken();
        int streamHour = Integer.parseInt(str.substring(0, 2));
        int streamMinuite = Integer.parseInt(str.substring(str.indexOf(':')+1));
        int streamTime = (streamHour * 60) + streamMinuite;

        HashMap<String, String> hm = new HashMap<>();

        while(true){
            String input = br.readLine();
            if (input == null || input.equals("")){
                break;
            }

            st = new StringTokenizer(input, " ");
            String myTime = st.nextToken();
            String name = st.nextToken();

            int myHour = Integer.parseInt(myTime.substring(0, 2));
            int myMinuite = Integer.parseInt(myTime.substring(myTime.indexOf(':')+1));
            int myRealTime = (myHour*60) + myMinuite;

            if (myRealTime <= startTime){
                hm.put(name, "시작 전 체크");
            }

            if (hm.containsKey(name) && hm.get(name).equals("시작 전 체크")) {
                if (endTime <= myRealTime && myRealTime <= streamTime) {
                    hm.put(name, "출석확인");
                }
            }
        }

        int ans = 0;
        for (String key : hm.keySet()){
            if (hm.get(key).equals("출석확인")){
                ans += 1;
            }
        }
        System.out.println(ans);


    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
