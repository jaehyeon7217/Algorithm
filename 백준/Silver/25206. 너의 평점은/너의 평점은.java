import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double sum =  0.0;
        double all = 0.0;
        for(int i=0;i<20;i++){
            st= new StringTokenizer(br.readLine(), " ");

            st.nextToken(); // 과목명
            double score = Double.parseDouble(st.nextToken());

            String s = st.nextToken();

            switch(s){
                case "A+" :
                    sum += score*4.5;
                    all += score;
                    break;
                case "A0" :
                    sum += score*4.0;
                    all += score;
                    break;
                case "B+" :
                    sum += score*3.5;
                    all += score;
                    break;
                case "B0" :
                    sum += score*3.0;
                    all += score;
                    break;
                case "C+" :
                    sum += score*2.5;
                    all += score;
                    break;
                case "C0" :
                    sum += score*2.0;
                    all += score;
                    break;
                case "D+" :
                    sum += score*1.5;
                    all += score;
                    break;
                case "D0" :
                    sum += score*1.0;
                    all += score;
                    break;
                case "F" :
                    all += score;
                    break;
                default:
                    break;
            }

        }

        System.out.println(sum/all);


    }



}