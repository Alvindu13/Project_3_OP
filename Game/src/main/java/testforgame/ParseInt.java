package testforgame;

import javax.sound.midi.Soundbank;

public class ParseInt {

    public static void main(String[] args) {

        String str = "0125";
        int i = Character.digit(str.charAt(3), 10);
        System.out.println(i);
    }
}
