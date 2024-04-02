package com.example.myapplication;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Instagram> instagrams = generateDummyInstagrams();

    private static ArrayList<Instagram> generateDummyInstagrams() {
        ArrayList<Instagram> instagrams1 = new ArrayList<>();
        instagrams1.add(new Instagram("sisfouh22", "SIBER 2024", R.drawable.logosisfo, R.drawable.sisfo, R.drawable.coding,"5000", 5));
        instagrams1.add(new Instagram("mahaliniraharja", "Selamat Hari Raya Galungan Semeton!", R.drawable.profilmahalini, R.drawable.postmahalini, R.drawable.hansohe, "10JT", 6452));
        instagrams1.add(new Instagram("ayuwdnti____", "Langit kalah terang sama baju 3 wanita ini", R.drawable.profilayu1, R.drawable.postayu, R.drawable.code1, "997", 500));
        instagrams1.add(new Instagram("ayNails___", "Maroon Kecintaan Sejuta Umat", R.drawable.logonail, R.drawable.nail3, R.drawable.coding, "1JT", 172));
        instagrams1.add(new Instagram("ronyparulian_", "Bandung Petcahh", R.drawable.rony, R.drawable.postrony, R.drawable.hansohe, "2,7JT", 1000));
        instagrams1.add(new Instagram("andinyzzz", "With 150 cm;) ", R.drawable.din, R.drawable.postdin, R.drawable.coding, "2000", 5));
        instagrams1.add(new Instagram("elva_timang", "Selamat Minggu Paskah All", R.drawable.elva, R.drawable.postelpa, R.drawable.coding, "700", 500));
        instagrams1.add(new Instagram("salmasalsabil12", "With PANAROMA", R.drawable.salma, R.drawable.postsalma, R.drawable.hansohe, "1,4JT", 550));
        instagrams1.add(new Instagram("khalisky_", "Cowookuu", R.drawable.el, R.drawable.postel, R.drawable.coding, "600", 134));
        instagrams1.add(new Instagram("izztaclrssa", "Nyebur seruu keknya ", R.drawable.zata, R.drawable.postzata, R.drawable.coding, "840", 500));
        return instagrams1;
    }
}
