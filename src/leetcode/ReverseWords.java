package leetcode;

public class ReverseWords {

	/**
	 * @param args
	 * @author hellouniverse
	 * @date 2014-5-9 下午8:56:39
	 */
	public static void main(String[] args) {
		String t = "as a good girl	";
		System.out.println(reverseWords(t));
	}

	public static String reverseWords(String s) {
		if (s == null) {
//			System.out.println("null string...");
			return null;
		}
		String[] strArray = s.trim().split(" ");
		int length = strArray.length;
		if (length == 0) {
			return "";
		}		 
			
		StringBuffer sb = new StringBuffer();
		for (int i = length - 1; i >= 0; i--){
			String temp=strArray[i].trim();
			if(!temp.equals("")){
				String[] tabSplitStrArray=temp.split("	");
				if(tabSplitStrArray.length==1){
//					System.out.println(strArray[i].trim() + "号");
					sb.append(temp+ " ");
				}else
					for (int j = tabSplitStrArray.length - 1; j >= 0; j--){
//						System.out.println(tabSplitStrArray[j].trim() + "号");
						sb.append(tabSplitStrArray[j].trim() + " ");
					}
				
			}
		}
		return sb.toString().trim();
	}

}
