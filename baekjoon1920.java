package baekjoon1920_my;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class baekjoon1920 {

	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		Set<Integer> s = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			s.add(Integer.parseInt(st.nextToken()));
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < m ; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			if(s.contains(x)) {
				bw.write("1\n");
			} else {
				bw.write("0\n");
			}
		}
		
		bw.flush();
		br.close();
		bw.close();
	}

}
