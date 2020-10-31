import java.util.HashMap;

public class UserMainCode
{

    public static String isPermutition(String input1, String input2) throws UnsupportedOperationException {
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        if (input1.length() != input2.length()) return "No";
        foo(input1, map1);
        foo(input2, map2);
        if(map1.equals(map2)) return "Yes"; else return "False";




    }

    static void foo(String s, HashMap<Character, Integer> map){

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer val = map.get(c);
            if (val != null) {
                map.put(c, new Integer(val + 1));
            }
            else {
                map.put(c, 1);
            }
        }
    }
}
