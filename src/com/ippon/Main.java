package com.ippon;

import java.util.*;
import java.util.regex.Pattern;

public class Main {
    /**
     * Replace non alphabetical characters by a space.
     * Double quotes are kept because used for nicknames.
     *
     * @param text Text with punctuation.
     * @return Text with space.
     */
    public static String removePunctuation(String text) {
        return text.replaceAll("[^A-Za-z0-9\\\" ]", " ");

    }

    public static void main(String[] args) {
        class Solution {

            private String text;
            private Set<String> familyNames;

            public Solution(String text, Set<String> familyNames) {
                this.text = text;
                this.familyNames = familyNames;
            }

            public Collection<String> getFamilyNames() {
                Collection<String> res = new ArrayList<String>();
                for(String familyName : familyNames){
                    if(text.contains(familyName))
                        res.add(familyName);
                }
                return res;
            }
            public Collection<String> getFullNames() {
                Collection<String> res = new HashSet<>();
                Collection<String> fNames = getFamilyNames();
                List<String> arrayText = Arrays.asList(removePunctuation(text).split(" "));

                for(String fName: fNames) {
                    for(int i = 0; i< arrayText.size(); i++){
                        if(arrayText.get(i).equals(fName)){
                            int firstNameIndexOffset = 1;
                            while(i-firstNameIndexOffset > 0 && arrayText.get(i-firstNameIndexOffset).contains("\"")){
                                firstNameIndexOffset++;
                            }
                            res.add(arrayText.get(i-firstNameIndexOffset) + " " + arrayText.get(i));
                            System.out.println("i:" + i +" name:" + fName);
                        }
                    }
                }
                return res;
            }
        }

        String text = "Jon Stark se promenait avec Arya Stark et Claude \"Evil\" Baratheon. En croisant Jean Targaryen et Christine Frey, ils s'enquirent de l'état de Bernard Martell, en convalescence chez Francis \"Francis\" Tyrell. \n" +
                "Arya Stark et Chrstine Frey repartirent vers Port-Royal tandis que Jean Targaryen resta discuter avec Jon \"Sait-Rien\" Stark.";
        Set<String> names = new HashSet<>();
        names.add("Stark");
        names.add("Baratheon");
        names.add("Targaryen");
        names.add("Frey");
        names.add("Martell");
        names.add("Tyrell");
        Solution s = new Solution(text, names);
        System.out.println(s.getFullNames());
    }









//////////  ASCII ART

//    // Longueur d'une lettre en ASCII art
//    final static int length = 4;
//    // Hauteur d'une lettre en ASCII art
//    final static int height = 5;
//    // ABCDEFGHIJKLMNOPQRSTUVWXYZ? en ASCII art
//    final static String[] asciiAlphabet = {" #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ### ### ",
//            "# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   # ",
//            "### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   ## ",
//            "# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #       ",
//            "# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  #  "};
//
//
//    public static String convertToAscii (String word) {
//        String res = "";
//        for(int i = 0; i< height; i++){
//            for (char w : word.toUpperCase().toCharArray()) {
//                if(w == '?') {
//                    res += asciiAlphabet[i].substring(('['-65)*length, ('['-65)*length+length);
//                } else {
//                    res += asciiAlphabet[i].substring((w-65)*length, (w-65)*length+length);
//                }
//            }
//            res+="\n";
//        }
//
//        return res;
//    }
//    public static String normalize (String word) {
//        String res = "";
//        for (char a: word.toUpperCase().toCharArray()
//        ) {
//            boolean AtoZ = "abcdefghijklmnopqrstuvwxyz".toUpperCase().contains(String.valueOf(a));
//            if(!AtoZ) {
//                res += "?";
//            } else {
//                res += a;
//            }
//        }
//        return res;
//    }
}
