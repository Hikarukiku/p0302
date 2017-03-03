package pr3;


import sun.plugin2.applet.context.InitialJNLPExecutionContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by admin on 03.03.2017.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        HashMap<String, Integer> hashMap = new HashMap<>();



        try(Scanner s=new Scanner(new File("1.txt"), "Cp1251")){
            while (s.hasNext()){
                String word = s.next().toLowerCase();
                if (!hashMap.containsKey(word)){
                    hashMap.put(word, 1);
                } else {
                    int i = 0;
                    i = hashMap.get(word)+1;
                    hashMap.put(word,i);
                }
            }
        }

        ArrayList<Map.Entry<String,Integer>> top = new ArrayList<>(hashMap.entrySet());
        top.sort((e1,e2)->-e1.getValue().compareTo(e2.getValue()));
        for (Map.Entry entry : top) {
            System.out.println(entry.getKey() + ": "
                    + entry.getValue());
        }

    }

}
