package com.guga.algs2princ;

/**
 * Created by gvaldes
 */
public class KMP {

    int[] finite;
    char[] letters;

    public KMP(String word) {
        int length = word.length();
        letters = word.toCharArray();
        finite = new int[length];
        int i = 1;
        int j = 0;
        while (i < length) {
            if (letters[i] == letters[j]) {
                finite[i] = j + 1;
                i++;
                j++;
            } else {
                j--;
                if (j >= 0) {
                    j = finite[j];
                } else {
                    j = 0;
                    finite[i] = 0;
                    i++;
                }
            }
        }
    }


    public static void main(String[] args) {
        KMP kmp = new KMP("acacabacacabacacacdaca");

        for (int i : kmp.finite) {
            System.out.println(i);
        }

        System.out.println(kmp.match("XXdssdalksjfalkjsflkjalkfjaslkfjaslkfj"));
        System.out.println(kmp.match("XXdssdalksjacacabacacabacacacdacafalkjsflkjalkfjaslkfjaslkfj"));
        System.out.println(kmp.match("XXdssdalksjacacabacacablkjalkfjsjacacabacaaslkfjaslkfj"));
    }

    public boolean match(String text) {

        char[] input = text.toCharArray();
        int length = input.length;
        int last = finite.length - 1;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (input[i] == letters[count]) {
                if (last == count) return true;
                count++;
            } else {
                count = finite[count];
            }
        }
        return false;
    }
}
