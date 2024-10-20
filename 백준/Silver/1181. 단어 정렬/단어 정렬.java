import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        List<String> li = new LinkedList<>();
        for (int i=0; i<n; i++){
            set.add(br.readLine());
        }
        for (String s : set){
            li.add(s);
        }

        Collections.sort(li, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                int s1 = o1.length();
                int s2 = o2.length();
                if (s1>s2) return 1;
                else if(s1<s2) return -1;
                else{
                    int headValue = o1.compareTo(o2);
                    return headValue;
                }
            }
        });

        for(String word : li){
            System.out.println(word);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
