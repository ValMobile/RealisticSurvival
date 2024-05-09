/*
    Copyright (C) 2024  Val_Mobile

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
package me.val_mobile.data.firstaid;

import me.val_mobile.data.RSVConfig;
import me.val_mobile.data.RSVDataModule;
import me.val_mobile.data.RSVModule;
import me.val_mobile.firstaid.FaModule;
import me.val_mobile.tan.TanModule;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.UUID;

public class DataModule implements RSVDataModule {

    public DataModule(Player player) {}

    @Override
    public void retrieveData() {}

    @Override
    public void saveData() {}

    public void saveFile(FileConfiguration config) {}
}
