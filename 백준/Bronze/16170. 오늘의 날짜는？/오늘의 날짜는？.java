import java.time.LocalDateTime;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(LocalDateTime.now().toLocalDate().toString(), "-");
        StringBuilder sb = new StringBuilder();
        sb.append(st.nextToken()+"\n"+st.nextToken()+"\n"+st.nextToken());
        System.out.println(sb);
    }

}
