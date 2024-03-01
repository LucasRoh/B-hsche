package net.ict.campus.boesche;


import net.ict.campus.boesche.model.models.Bohnen;
import net.ict.campus.boesche.model.models.Fraktion;
import net.ict.campus.boesche.model.models.Abilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TestDataUtil {
    public static List<Fraktion> getTestFraktionen(){
        List<Fraktion> fraktionen = new ArrayList<>();
        HashSet<Abilities> abilities = new HashSet<>();

        Fraktion fraktion = new Fraktion();
        fraktion.setId_Fraktion(1);
        fraktion.setName("Fraktion");


        for (int i = 1; i <= 3; i++) {
            fraktion.setId_Fraktion(i);
            fraktion.setName("Fraktion"+i);
            fraktionen.add(fraktion);
        }

        return fraktionen;
    }
}
