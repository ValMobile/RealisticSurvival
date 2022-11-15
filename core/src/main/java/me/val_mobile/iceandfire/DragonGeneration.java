package me.val_mobile.iceandfire;

import me.val_mobile.data.RSVModule;
import org.bukkit.configuration.file.FileConfiguration;

import javax.annotation.Nullable;

public enum DragonGeneration {
    ADULT,
    TEENAGER,
    CHILD;

    @Nullable
    public static DragonGeneration getGeneration(int age) {
        FileConfiguration config = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

        if (age >= config.getInt("Dragons.AdultStage")) {
            return ADULT;
        }
        else if (age >= config.getInt("Dragons.TeenagerStage")) {
            return TEENAGER;
        }
        else if (age >= config.getInt("Dragons.ChildStage")) {
            return CHILD;
        }
        return null;
    }
}
