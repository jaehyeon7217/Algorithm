import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 814; i++) {
            sb.append((int)((Math.random() * 16280) - 8140) + " " + ((int)(Math.random() * 16280) - 8140)).append("\n");
        }

        System.out.println(sb.toString());

    }


}