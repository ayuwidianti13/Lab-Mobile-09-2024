package com.example.praktikum_4;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Instagram> instagrams = generateDummyInstagrams();

    private static ArrayList<Instagram> generateDummyInstagrams() {
        ArrayList<Instagram> instagrams1 = new ArrayList<>();
        instagrams1.add(new Instagram("milik.senja", "Miliksenj.a"
                ,"My Favorite Ending :)"
                ,R.drawable.profile2, R.drawable.gambar2));
        instagrams1.add(new Instagram("swansss","SwanWhispers"
                ,"The swans' dance along the lake's edge bring a touch of magic to the tranquil morning."
                ,R.drawable.profil1,R.drawable.gambar1));

        instagrams1.add(new Instagram("sun.flower", "SUNFLOWERS"
                ,"Sunflowers and a cup tea : 'Warmth and tranquility in a moment'"
                ,R.drawable.profile3,R.drawable.gambar3));

        instagrams1.add((new Instagram("nail.murce","ayNailss"
                ,"Maroon"
                ,R.drawable.logonail,R.drawable.nail3)));

        instagrams1.add(new Instagram("rony", "ronyparulian_"
                ,"Bandung petcahh"
                ,R.drawable.rony,R.drawable.postrony));
        return instagrams1;
    }
}
