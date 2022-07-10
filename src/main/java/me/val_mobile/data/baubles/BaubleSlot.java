package me.val_mobile.data.baubles;

public enum BaubleSlot {

    HEAD(12, "Head"),
    AMULET(21, "Amulet"),
    BODY(30, "Body"),
    FIRST_RING(14, "Ring"),
    SECOND_RING(23, "Ring"),
    CHARM(32, "Charm"),
    BELT(31, "Belt");

    private int val;
    private String tag;

    BaubleSlot(int val, String tag) {
        this.val = val;
        this.tag = tag;
    }

    public int getValue() {
        return val;
    }

    public String getTag() {
        return tag;
    }
}
