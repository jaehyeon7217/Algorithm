import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int[][] xy = new int [2][3];
		
		for(int a=0 ; a<T ; a++) {
			
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<2;i++) {
				xy[i][0] = Integer.parseInt(st.nextToken());
				xy[i][1] = Integer.parseInt(st.nextToken());
				xy[i][2] = Integer.parseInt(st.nextToken());
			}
			
			int dx = (int)Math.pow(xy[0][0] - xy[1][0], 2.0); 
			int dy = (int)Math.pow(xy[0][1] - xy[1][1], 2.0);
			int dr = (int)Math.pow(xy[0][2] + xy[1][2], 2.0);
			
			int d = dx + dy;
			
			
			if(d < dr) { // 두 점의 거리가 반지름 합보다 작을 때
				if( d==0) { // 두 점이 같을 때
					if(xy[0][2] != xy[1][2]) { // 반지름이 다르면
						sb.append("0\n"); // 접점이 없다.
					}
					else { 
						sb.append("-1\n"); // 반지름이 같으면 모든 점이 접점이다.
					}
				}
				else { // 두 점이 같지 않을 때
					int temp = (int)Math.pow(xy[0][2] - xy[1][2], 2.0); // 큰 반지름에서 작은 반지름을 뺌
					
					if( temp == d) { // 큰 반지름에서 작은 반지름을 뺀 나머지 결과가 두 점의 거리와 같다면 내접
						sb.append("1\n");
					}
					
					else if( temp > d) { // 큰 반지름에서 작은 반지름을 뺀 나머지 결과가 두 점의 거리보다 크면 접점 없음 
						sb.append("0\n");
					}
					else { // 큰 반지름에서 작은 반지름을 뺀 나머지 결과가 두 점의 거리보다 작으면 접점 2개
						sb.append("2\n");
					}
				}
			}
			
			else if(d > dr) { // 두 점의 거리가 반지름의 합보다 크면 멀리 떨어져 있음
				sb.append("0\n");
			}
			else if(d == dr) { // 두 점의 거리와 반지름의 합이 같으면 외접 
				sb.append("1\n");
			}
					
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}

}
