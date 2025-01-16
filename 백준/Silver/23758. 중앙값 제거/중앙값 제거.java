import java.io.*;
import java.util.*;


public class Main {

    public static int[] compareNum = new int[31];

    private static FastIO io = new FastIO(500000, 10);

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;

        compareNum[1] = 2;

        for (int i = 2; i <= 30; i++) {
            compareNum[i] = compareNum[i - 1] * 2;
        }

        int n = io.nextInt();

//        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[30];

        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = io.nextInt();

            arr[count(num[i])]++;

        }

        int center = (n + 1) / 2;
        int countCheck = 0;
        int sum = 0;

        for (int i = 0; i < 30; i++) {
            if(countCheck + arr[i] > center){
                int temp = center - countCheck;
                sum += i*temp;
                break;
            }
            countCheck+=arr[i];
            sum += i*arr[i];
            if(countCheck == center) break;
        }

        System.out.println(sum +1);


    }

    public static int count(int num) {
        int ans = 0;
        for (int i = 1; i < 31; i++) {
            if (compareNum[i] > num) {
                ans = i - 1;
                break;
            }
        }
        return ans;

    }

    private static class FastIO {
        private static final int DEFAULT_BUFFER_SIZE = 65536;
        private static final int DEFAULT_LONG_SIZE = 20;

        private static final int EOF = -1;

        private static final byte ASCII_space = 32;
        private static final byte ASCII_minus = 45;
        private static final byte ASCII_0 = 48;
        private static final byte ASCII_9 = 57;

        private final DataInputStream din;
        private final DataOutputStream dout;

        private byte[] inbuffer;
        private int inbufferpointer, bytesread;
        private byte[] outbuffer;
        private int outbufferpointer;

        private byte[] bytebuffer;

        private FastIO(int inbuffersize, int outbuffersize) {
            this.din = new DataInputStream(System.in);
            this.dout = new DataOutputStream(System.out);

            this.inbuffer = new byte[inbuffersize];
            this.inbufferpointer = 0;
            this.bytesread = 0;
            this.outbuffer = new byte[outbuffersize];
            this.outbufferpointer = 0;

            this.bytebuffer = new byte[DEFAULT_LONG_SIZE];
        }

        private FastIO() {
            this(DEFAULT_BUFFER_SIZE, DEFAULT_BUFFER_SIZE);
        }

        private byte read() {
            if (inbufferpointer == bytesread)
                fillbuffer();
            return bytesread == EOF ? EOF : inbuffer[inbufferpointer++];
        }

        private void fillbuffer() {
            try {
                bytesread = din.read(inbuffer, inbufferpointer = 0, inbuffer.length);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private void write(byte b) {
            if (outbufferpointer == outbuffer.length)
                flushbuffer();
            outbuffer[outbufferpointer++] = b;
        }

        private void flushbuffer() {
            if (outbufferpointer != 0) {
                try {
                    dout.write(outbuffer, 0, outbufferpointer);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                outbufferpointer = 0;
            }
        }

        private int nextInt() {
            byte b;
            while(isSpace(b = read()))
                ;
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = read();
            }
            int result = b - '0';
            while (isDigit(b = read()))
                result = result * 10 + b - '0';
            return negative ? -result : result;
        }

        private void print(int i) {
            if (i == 0) {
                write(ASCII_0);
            } else {
                if (i < 0) {
                    write(ASCII_minus);
                    i = -i;
                }
                int index = 0;
                while (i > 0) {
                    bytebuffer[index++] = (byte) ((i % 10) + ASCII_0);
                    i /= 10;
                }
                while (index-- > 0) {
                    write(bytebuffer[index]);
                }
            }
        }

        private boolean isSpace(byte b) {
            return b <= ASCII_space && b >= 0;
        }

        private boolean isDigit(byte b) {
            return b >= ASCII_0 && b <= ASCII_9;
        }
    }


}
