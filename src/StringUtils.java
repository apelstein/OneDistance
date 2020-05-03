
public class StringUtils {
	
	public static boolean isDistanceOne(String s1, String s2, int length){
		int count = 0;
		for(int i =0; i<length; i++){
			if(s1.charAt(i) != s2.charAt(i)){
				count++;
			}
		}
		return count == 1;
	}
}
