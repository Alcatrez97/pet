import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import  java.util.*;

class Main {
    public static void main(String[] args) {
        //call the check case function  using the object for Main class
        Main mn = new Main();
        //mn.format();
    }
    static String checkCase(String word){
        if(isUpperCase(word)) return "UpperCase";
        else if(isLowerCase(word)) return  "LowerCase";
        else if(isTitleCase(word)) return  "TitleCase";
        return "No matching case!";
    }
    public static boolean isUpperCase(String s)
    {
        for (int i=0; i<s.length(); i++)
        {
            if (!Character.isUpperCase(s.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
    public static boolean isLowerCase(String s)
    {
        for (int i=0; i<s.length(); i++)
        {
            if (!Character.isLowerCase(s.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
    public static boolean isTitleCase(String s)
    {
        if(Character.isUpperCase(s.charAt(0))) {
            for (int i = 1; i < s.length(); i++) {
                if (!Character.isLowerCase(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        else return false;
    }

    Long format(String filePath, String[] wordsToFormat, String format) throws IOException {
        Long count = 0L;

        //file object from give file path
        File file = new File(filePath);

        //Buffered file for fast I/O
        BufferedReader br = new BufferedReader(new FileReader(file));


        //mapping each word to be formatted into a hash map to reduce complexity()
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : wordsToFormat) {
            map.put(word,0);
        }

        //processng file
        String str;
        while((str=br.readLine())!= null){
            String[] wordList =str.split(" ");
            for (String word : wordList) {
                if (map.containsKey(word) && checkCase(word).equals(format)) {
                    map.put(word,map.get(word)+1);
                    count++;
                }
                }
        }
        return count;
    }
}
