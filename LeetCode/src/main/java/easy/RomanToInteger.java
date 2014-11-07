package easy;

public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(new RomanToInteger().romanToInt("MCMLIV"));
	}

	public int romanToInt(String s) {
	    int len = s.length();
	    int result = 0;
	    for (int i = 0; i < len; i++) {
	    	RomanUnitEnum unit = RomanUnitEnum.valueOf(String.valueOf(s.charAt(i)));
	    	switch(unit) {
	    		case I:
	    			if (i < len - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X'))
	    				result -= unit.value;
	    			else 
	    				result += unit.value;
	    			break;
	    		case X:
	    			if (i < len - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C'))
	    				result -= unit.value;
	    			else 
	    				result += unit.value;
	    			break;
	    		case C:
	    			if (i < len - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M'))
	    				result -= unit.value;
	    			else 
	    				result += unit.value;
	    			break;
	    		default:
	    			result += unit.value;
	    			break;
	    	}
	    	System.out.println(result);
	    }
		
		return result;
	}
	
	public enum RomanUnitEnum {
		I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
		
		private int value;
		private RomanUnitEnum(int value) {
			this.value = value;
		}
		
		public String toString() {
			return String.valueOf(this.value);
		}
	}
}
