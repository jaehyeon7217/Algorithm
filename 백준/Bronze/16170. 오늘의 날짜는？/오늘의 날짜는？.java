import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Date d = new Date();
        SimpleDateFormat year = new SimpleDateFormat("yyyy");
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat day = new SimpleDateFormat("dd");

        StringBuilder sb = new StringBuilder();

        sb.append(year.format(d)+"\n" + month.format(d) + "\n" + day.format(d));
        System.out.println(sb);
    }

}
