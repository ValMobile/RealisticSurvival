package me.val_mobile.baubles;

public enum Bauble {

    SCARLITE_RING("scarlite_ring");

    private String name;

    Bauble(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
