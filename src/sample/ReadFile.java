package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Lina on 2017.06.15.
 */
public class ReadFile {

    private Map<String, List<String>> engMap;
    private Map<String, List<String>> ltMap;

    public ReadFile(Map<String, List<String>> engMap, Map<String, List<String>> ltMap) {
        this.engMap = engMap;
        this.ltMap = ltMap;
    }

    public void read() {

        try {
            BufferedReader bf = new BufferedReader(new FileReader(new File("duomenys.txt")));

            String line = null;
            //skaito po eilute
            while ((line = bf.readLine()) != null) {
                String[] elements = line.split("-"); // elemntai iskirti bruksneliu
                if (elements.length == 2) {

                 addItemToMap(elements[0], elements[1], engMap);
                 addItemToMap(elements[1], elements[0], ltMap);
                   /* List<String> ltList = engMap.get(elements[0]);
                    if (ltList != null) {
                        ltList.add(elements[1]);
                        engMap.put(elements[0], ltList);
                    }
                    List<String> engList = ltMap.get(elements[1]);
                    if (engList != null) {
                        ltList.add(elements[1]);
                        engMap.put(elements[0], engList);*/
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addItemToMap(String key, String value, Map<String, List<String>> map) {
        List<String> words = map.get(key);
        if (words == null) {
            words = new ArrayList<>();
        }
        words.add(value);
        map.put(key, words);
    }
}
