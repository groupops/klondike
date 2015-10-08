package com.epam.training;

import java.util.ArrayList;
import java.util.List;


public final class GamingTable {
    private final AcePile hearts = new AcePile();
    private final AcePile diamonds = new AcePile();
    private final AcePile clubs = new AcePile();
    private final AcePile spades = new AcePile();
    private final Deck deck = new Deck();
    private final List<Pile> piles = new ArrayList<>(7);

    public GamingTable() {
        initTable();
    }

    private void initTable() {
        deck.shuffle();
        for (int i = 0; i < 7; i++) {
            piles.add(new Pile());
            for (int j = i; j < 7; j++) {
                piles.get(i).putCard(deck.getNext());
            }
        }
    }
}
