import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] student = new int[(n*n)+1][4];
        int[] order = new int[n*n];

        for (int i = 0; i < n*n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int stdNum = Integer.parseInt(st.nextToken());
            order[i] = stdNum;
            for (int j = 0; j < 4; j++) {
                student[stdNum][j] = Integer.parseInt(st.nextToken());
            }

        }

        int[][] seat = new int[n][n];

        seat[1][1] = order[0];

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 1; i < n*n; i++) { // 학생
            int tempX = 0;
            int tempY = 0;
            int maxHappy = -1;
            int empty = 0;

            for (int j = 0; j < n; j++) { // 자리 행
                for (int k = 0; k < n; k++) { // 자리 열
                    if (seat[j][k] != 0) continue;
                    int tempHappy = 0;
                    int tempEmpty = 0;

                    for (int l = 0; l < 4; l++) { // 인접 탐색
                        int x = j + dx[l];
                        int y = k + dy[l];

                        if (x < 0 || x >= n || y < 0 || y >= n) continue;
                        if (seat[x][y] == 0) {
                            tempEmpty++;
                            continue;
                        }
                        for (int m = 0; m < 4; m++) { // 선호 학생 4명
                            if (student[order[i]][m] == seat[x][y]) tempHappy++;
                        }
                    }
                    if(tempHappy>maxHappy){
                        tempX = j;
                        tempY = k;
                        maxHappy = tempHappy;
                        empty = tempEmpty;
                    }else if(tempHappy == maxHappy && tempEmpty>empty){
                        tempX = j;
                        tempY = k;
                        empty = tempEmpty;
                    }
                }
            }
            seat[tempX][tempY] = order[i];


        }
        int sum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                int check = 0;
                for(int k=0;k<4;k++){
                    int x = i+dx[k];
                    int y = j+dy[k];

                    if (x < 0 || x >= n || y < 0 || y >= n) continue;
                    for(int l = 0; l<4; l++){
                        if(seat[x][y] == student[seat[i][j]][l]){
                            check++;
                            break;
                        }
                    }

                }

                switch(check){
                    case 1 : sum+=1; break;
                    case 2 : sum+=10; break;
                    case 3 : sum+=100; break;
                    case 4 : sum+=1000; break;
                }

            }
        }
        System.out.println(sum);



    }


}
