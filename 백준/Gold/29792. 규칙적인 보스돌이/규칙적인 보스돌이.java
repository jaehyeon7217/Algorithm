import java.io.*;
import java.util.*;

public class Main {

    public static int n, m, k;
    public static long character[];
    public static final int sec = 900;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        character = new long[n];
        for(int i=0;i<n;i++){
            character[i] = Long.parseLong(br.readLine());
        }

        ArrayList<boss> list = new ArrayList<>();

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine(), " ");
            long p = Long.parseLong(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            list.add(new boss(p,q));
        }

        int[][] time;

        ArrayList<Integer> best = new ArrayList<>();

        for(int i=0;i<n;i++){
            time = new int[k+1][901];

            for(int j=0;j<k;j++){
                boss temp = list.get(j);

                if( !(temp.p/character[i] < 900 || (temp.p/character[i]==900 && temp.p%character[i]==0) )) {

                    for(int l=1;l<901;l++){
                        time[j+1][l] = time[j][l];
                    }
                    continue;
                }
                int count = (int)(temp.p%character[i] == 0 ? temp.p/character[i] : temp.p/character[i] + 1);

                for(int l=1;l<count;l++){
                    time[j+1][l] = time[j][l];
                }
                for(int l=count; l<901; l++){
                    time[j+1][l] = Math.max(time[j][l-count] + temp.q , time[j][l]);
                }
            }
            best.add(time[k][900]);
        }

        Collections.sort(best, Collections.reverseOrder());

        long ans = 0;
        for(int i=0;i<m;i++){
            ans+=best.get(i);
        }

        System.out.println(ans);

    }

    public static class boss {
        long p;
        int q;

        public boss(long p, int q) {
            this.p = p;
            this.q = q;
        }

    }

}
