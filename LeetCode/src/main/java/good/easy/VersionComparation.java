package good.easy;

import java.util.Arrays;

public class VersionComparation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String version1 = "3.6";
		String version2 = "3.6.0";
		System.out.println(new VersionComparation().compareVersion(version1, version2));
	}

	public int compareVersion(String version1, String version2) {
		String[] v1_strs = version1.split("\\.");
		String[] v2_strs = version2.split("\\.");
		int len1 = v1_strs.length,
					len2 = v2_strs.length;
		
		if (len1 > len2) 
			v2_strs = regenerate(v2_strs, len1);
		else if (len1 < len2)
			v1_strs = regenerate(v1_strs, len2);
		
		int len = Math.max(len1, len2);
		for (int i = 0; i < len; i++) {
			int v1_int = Integer.parseInt(v1_strs[i]);
			int v2_int = Integer.parseInt(v2_strs[i]);
			if (v1_int < v2_int)
				return -1;
			else if (v1_int > v2_int)
				return 1;
		}
		
		return 0;
    }

	private String[] regenerate(String[] strs, int final_len) {
		String[] final_str = new String[final_len];
		int i = 0;
		for (; i < strs.length; i++)
			final_str[i] = strs[i];
		
		for (; i < final_len; i++)
			final_str[i]="0";
		
		return final_str;
	}
}
