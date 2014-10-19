package test.java.medium;

import static org.junit.Assert.*;
import main.java.medium.ReverseWords;

import org.junit.Test;

public class ReverseWordsTest {

	@Test
	public void testReverseWords() {
		String[] cons=new String[6];
		cons[0]=null;
		cons[1]="";
		cons[2]="  ";
		cons[3]=" 	 ";
		cons[4]="  a	bbb ke  c  ";
		cons[5]="as a good girl	";
		
		assertEquals(null,ReverseWords.reverseWords(cons[0]));
		assertEquals("",ReverseWords.reverseWords(cons[1]));
		assertEquals("",ReverseWords.reverseWords(cons[2]));
		assertEquals("",ReverseWords.reverseWords(cons[3]));
		assertEquals("c ke bbb a",ReverseWords.reverseWords(cons[4]));
		assertEquals("girl good a as",ReverseWords.reverseWords(cons[5]));

	}

}
