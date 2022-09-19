/*
    Copyright (C) 2022  Val_Mobile

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
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
