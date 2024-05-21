import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static Star[] stars;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        n = Integer.parseInt(br.readLine());
        stars = new Star[n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            stars[i] = new Star(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        boolean[] check = new boolean[n];

        PriorityQueue<Line> q = new PriorityQueue<>();
        q.offer(new Line(0,0.0));

        double sum = 0.0;

        while(!q.isEmpty()){
            Line temp = q.poll();

            if(check[temp.to]) continue;
            check[temp.to] = true;
            sum += temp.value;

            for(int i=0;i<n;i++){
                if(check[i]) continue;
                q.offer(new Line(i, calc(stars[temp.to],stars[i])));
            }

        }

        System.out.printf("%.2f", sum);


    }

    public static class Line implements Comparable<Line>{
        int to;
        double value;
        Line(int to, double value){
            this.to = to;
            this.value = value;
        }
        @Override
        public int compareTo(Line o){
            return (int)(this.value-o.value);
        }
    }

    public static class Star{
        double x;
        double y;
        Star(double x, double y){
            this.x= x;
            this.y =y;
        }
    }

    public static double calc(Star a, Star b){
        double A = b.x - a.x;
        double B = b.y - a.y;

        return Math.sqrt( ( A*A ) + (B*B));
    }


}
