/*
    Copyright (C) 2025  Val_Mobile

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
package me.val_mobile.firstaid;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Body {

    private final FaModule module;
    private final Location playerLoc;
    private final FileConfiguration config;

    private double leftLegHealth;
    private double rightLegHealth;
    private double leftArmHealth;
    private double rightArmHealth;
    private double leftFootHealth;
    private double rightFootHealth;
    private double torsoHealth;
    private double headHealth;

    public Body(@Nonnull FaModule module, @Nonnull Location playerLoc) {
        this.module = module;
        this.playerLoc = playerLoc.clone();
        this.config = module.getUserConfig().getConfig();
    }

    public @Nullable BodyPart getHitBodyPart(@Nonnull Location loc) {
        return null; // TODO: fix
    }

    public double getHealth(@Nonnull BodyPart organType) {
        return switch (organType) {
            case LEFT_LEG -> leftLegHealth;
            case RIGHT_LEG -> rightLegHealth;
            case LEFT_ARM -> leftArmHealth;
            case RIGHT_ARM -> rightArmHealth;
            case LEFT_FOOT -> leftFootHealth;
            case RIGHT_FOOT -> rightFootHealth;
            case TORSO -> torsoHealth;
            case HEAD -> headHealth;
            default -> -1;
        };
    }

    public void setHealth(@Nonnull BodyPart organType, @Nonnegative double health) {
        health = Math.max(health, 0); // ensure health is non-negative

        switch (organType) {
            case LEFT_LEG -> leftLegHealth = health;
        }
    }


    public double getMaximumHealth(@Nonnull BodyPart organType) {
        return -1; // TODO: Fix
    }

    public enum BodyPart {
        LEFT_LEG, RIGHT_LEG, LEFT_FOOT, RIGHT_FOOT, LEFT_ARM, RIGHT_ARM, HEAD, TORSO
    }
}
