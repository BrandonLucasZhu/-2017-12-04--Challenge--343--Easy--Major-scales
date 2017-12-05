package major_scales;
import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;

public class major_scale {
	static int new_index;
	static int index_calc;
	public static final String[] major_scale = {"C","C#", "D", "D#","E", "F","F#","G","G#","A","A#",
							"B"};
	
	//Initialize CONST Major key 
	private static final Map<String,Integer> CONST_MAJOR_KEY =
		Collections.unmodifiableMap(new HashMap<String, Integer>(){{
		put("Do",0);
		put("Re",2);
		put("Mi",4);
		put("Fa",5);
		put("So",7);
		put("La",9);
		put("Ti",11);
	}});
	
	public static int get_CONST_MAJOR_INDEX(String solfege) {
		return CONST_MAJOR_KEY.get(solfege);
	}
	
	public static String get_desired_scale_key(String note, int maj_key_index) {
		for (int i=0; i < major_scale.length; i++) {
			if (note.equals(major_scale[i]) && major_scale.length<(i+maj_key_index)) {
				index_calc = major_scale.length - i;//Check if index addition goes over array "Major Scale"
				new_index = maj_key_index - index_calc;
			}
			else if (note.equals(major_scale[i]) && major_scale.length>(i+maj_key_index)) {
				new_index = i + maj_key_index;
			}
		}
		
		return major_scale[new_index];
	}
	
	
	public static void main(String args[]) {
		
		Scanner reader1 = new Scanner(System.in);
		System.out.println("Please enter the name of a major scale.");
		String input1 = reader1.nextLine(); //Scale value
		Scanner reader2 = new Scanner(System.in);
		System.out.println("Please enter the solfège name of a note.");
		String input2 = reader2.nextLine(); //Solfege value
		int get_majorkey_ind = get_CONST_MAJOR_INDEX(input2);
		String corresponding_note = get_desired_scale_key(input1, get_majorkey_ind);
		System.out.println("note("+input1+", "+input2+") -> "+corresponding_note);
		
	}
	
	
	

}
