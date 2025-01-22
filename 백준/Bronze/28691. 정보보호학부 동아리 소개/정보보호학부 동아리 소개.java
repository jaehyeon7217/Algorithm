import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char a = br.readLine().toCharArray()[0];

        switch(a){
            case 'M' : sb.append("MatKor");
                break;
            case 'W' : sb.append("WiCys");
                break;
            case 'C' : sb.append("CyKor");
                break;
            case 'A' : sb.append("AlKor");
                break;
            case '$' : sb.append("$clear");
                break;
        }

        System.out.println(sb.toString());


    }

}
