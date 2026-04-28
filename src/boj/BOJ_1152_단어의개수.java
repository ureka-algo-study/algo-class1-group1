package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1152_단어의개수 {
			
//	static List<String> strArr = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str = new String(br.readLine());
		
//		str = str.trim();
//		StringTokenizer st = new StringTokenizer(str, " ");
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		br.close();
		
//		while (st.hasMoreTokens()) {			
//			strArr.add(st.nextToken());
//		}
		
//		System.out.println(strArr.size());		
		System.out.println(st.countTokens());
	} //main
} //class