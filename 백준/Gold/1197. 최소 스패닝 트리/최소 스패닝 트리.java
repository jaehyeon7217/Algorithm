import java.io.*;
import java.util.*;

public class Main {

    public static int v, e;
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());


        arr = new int[v];
        make();

        LinkedList<Line> list = new LinkedList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int value = Integer.parseInt(st.nextToken());

            list.add(new Line(from, to, value));

        }

        Collections.sort(list);

        int lineCount = 0;
        int sum = 0;

        while(!list.isEmpty()){
            Line temp = list.poll();

            int x = find(temp.from);
            int y = find(temp.to);

            if(x==y) continue;

            sum += temp.value;
            lineCount ++;
            union(temp.from,temp.to);

            if(lineCount == v-1){
                break;
            }
        }

        System.out.println(sum);


    }

    public static void make(){
        for(int i=0;i<v;i++){
            arr[i] = i;
        }
    }

    public static int find(int x){
        if(arr[x] == x){
            return x;
        }
        return arr[x] = find(arr[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x<y){
            arr[y] = x;
        }else{
            arr[x] = y;
        }

    }


    public static class Line implements Comparable<Line>{
        int from;
        int to;
        int value;

        Line(int from, int to, int value){
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Line o){
            return this.value - o.value;
        }
    }


}
