import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int T, N, ans;
    static int[] arr, home, company;
    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            list = new ArrayList<>(N);

            StringTokenizer st = new StringTokenizer(br.readLine());

            company = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            home = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            for(int i = 0; i < N; i++) {
                arr[i] = i;
                list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            ans = Integer.MAX_VALUE;
            per(0);

            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    public static void per(int depth) {
        if(depth == N) {
            int sum = dist(company, list.get(arr[0]));
            for(int i = 1; i < N; i++)
                sum += dist(list.get(arr[i]), list.get(arr[i-1]));
            sum += dist(list.get(arr[N-1]), home);
            ans = Math.min(ans, sum);
            return;
        }

        for(int i = depth; i < N; i++) {
            swap(i, depth);
            per(depth + 1);
            swap(i, depth);
        }
    }

    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int dist(int[] first, int[] second) {
        return Math.abs(first[0] - second[0]) + Math.abs(first[1] - second[1]);
    }
}