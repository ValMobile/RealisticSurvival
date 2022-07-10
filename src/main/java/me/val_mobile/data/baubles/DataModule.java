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

import me.val_mobile.data.RSVDataModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.UUID;

public class DataModule implements RSVDataModule {

    private UUID uuid;
    private BaubleInventory baubleBag;
    private final RealisticSurvivalPlugin plugin;
    private final Utils util;

    private int potionResRings;
    private int potionStrRings;
    private int potionRegenRings;
    private int potionSpeedRings;
    private int potionHasteRings;
    private int potionJumpRings;
    private int dragonsEye;
    private boolean scarliteRing;
    private int shieldHonor;
    private int minersRing;
    private int phantomPrism;

    public DataModule(RealisticSurvivalPlugin plugin, Player player) {
        this.plugin = plugin;
        this.util = new Utils(plugin);
        this.uuid = player.getUniqueId();
        baubleBag = new BaubleInventory(player);
        retrieveData();
    }

    public BaubleInventory getBaubleBag() {
        return baubleBag;
    }

    public int getPotionResRings() {
        return potionResRings;
    }

    public int getPotionStrRings() {
        return potionStrRings;
    }

    public int getPotionRegenRings() {
        return potionRegenRings;
    }

    public int getPotionSpeedRings() {
        return potionSpeedRings;
    }

    public int getPotionHasteRings() {
        return potionHasteRings;
    }

    public int getPotionJumpRings() {
        return potionJumpRings;
    }

    public int getDragonsEye() {
        return dragonsEye;
    }

    public boolean getScarliteRing() {
        return scarliteRing;
    }

    public int getShieldHonor() {
        return shieldHonor;
    }

    public int getMinersRing() {
        return minersRing;
    }

    public int getPhantomPrism() {
        return phantomPrism;
    }

    public void setPotionResRings(int potionResRings) {
        this.potionResRings = potionResRings;
    }

    public void setPotionStrRings(int potionStrRings) {
        this.potionStrRings = potionStrRings;
    }

    public void setPotionRegenRings(int potionRegenRings) {
        this.potionRegenRings = potionRegenRings;
    }

    public void setPotionSpeedRings(int potionSpeedRings) {
        this.potionSpeedRings = potionSpeedRings;
    }

    public void setPotionHasteRings(int potionHasteRings) {
        this.potionHasteRings = potionHasteRings;
    }

    public void setPotionJumpRings(int potionJumpRings) {
        this.potionJumpRings = potionJumpRings;
    }

    public void setDragonsEye(int dragonsEye) {
        this.dragonsEye = dragonsEye;
    }

    public void setScarliteRing(boolean scarliteRing) {
        this.scarliteRing = scarliteRing;
    }

    public void setShieldHonor(int shieldHonor) {
        this.shieldHonor = shieldHonor;
    }

    public void setMinersRing(int minersRing) {
        this.minersRing = minersRing;
    }

    public void setPhantomPrism(int phantomPrism) {
        this.phantomPrism = phantomPrism;
    }

    @Override
    public void retrieveData() {

    }

    @Override
    public void updateData() {
        potionResRings = 0;
        potionStrRings = 0;
        potionRegenRings = 0;
        potionSpeedRings = 0;
        potionHasteRings = 0;
        potionJumpRings = 0;
        dragonsEye = 0;
        scarliteRing = false;
        shieldHonor = 0;

        Collection<ItemStack> items = baubleBag.getBaubles().values();

        for (ItemStack item : items) {
            switch (RSVItem.getModuleNameFromItem(item, util)) {
                case "potion_ring_resistance":
                    potionResRings += item.getAmount();
                    break;
                case "potion_ring_strength":
                    potionStrRings += item.getAmount();
                    break;
                case "potion_ring_regeneration":
                    potionRegenRings += item.getAmount();
                    break;
                case "potion_ring_speed":
                    potionSpeedRings += item.getAmount();
                    break;
                case "potion_ring_haste":
                    potionHasteRings += item.getAmount();
                    break;
                case "potion_ring_jump_boost":
                    potionJumpRings += item.getAmount();
                    break;
                case "dragons_eye":
                    dragonsEye += item.getAmount();
                    break;
                case "scarlite_ring":
                    scarliteRing = true;
                    break;
                case "shield_honor":
                    shieldHonor += item.getAmount();
                    break;
                case "miners_ring":
                    minersRing += item.getAmount();
                    break;
                case "phantom_prism":
                    phantomPrism += item.getAmount();
                    break;
            }
        }
    }

    @Override
    public void saveData() {

    }
}
