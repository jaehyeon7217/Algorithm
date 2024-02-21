import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<ArrayList<XY>> go, back;
    public static int[] goCheck, backCheck;
    public static int N,M,X;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1;

        go = new ArrayList<>();
        back = new ArrayList<>();

        goCheck = new int[N];
        backCheck = new int[N];

        for(int i=0;i<N;i++){
            goCheck[i] = Integer.MAX_VALUE;
            backCheck[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<N;i++){
            go.add(new ArrayList<>());
            back.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            go.get(start).add(new XY(end, cost));
            back.get(end).add(new XY(start, cost));

        }

        func(go, goCheck);
        func(back, backCheck);

        int max = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            max = Math.max(max, goCheck[i] + backCheck[i]);
        }

        System.out.println(max);
    }

    public static void func(ArrayList<ArrayList<XY>> arr, int[] check){
        for(int i=0;i<N;i++){
            check[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<XY> list = new PriorityQueue<>();
        list.add(new XY(X, 0));
        check[X] = 0;

        while(!list.isEmpty()){
            XY temp = list.poll();


            for(int i=0;i<arr.get(temp.x).size(); i++){
                XY getTemp = arr.get(temp.x).get(i);

                if(check[getTemp.x] > getTemp.cost + temp.cost){
                    check[getTemp.x] = getTemp.cost + temp.cost;
                    list.add(new XY(getTemp.x, getTemp.cost + temp.cost));
                }

            }
        }
    }


    public static class XY implements Comparable<XY> {
        int x;
        int cost;

        public XY(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }


        @Override
        public int compareTo(XY o) {
            return this.cost - o.cost;
        }
    }

}