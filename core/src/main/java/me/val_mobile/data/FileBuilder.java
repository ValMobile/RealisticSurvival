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
package me.val_mobile.data;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;

import java.io.File;

public class FileBuilder {
    protected File file;
    private final boolean replace;

    private final RealisticSurvivalPlugin plugin;

    public FileBuilder(RealisticSurvivalPlugin plugin, String path, boolean replace) {
        this.plugin = plugin;
        this.replace = replace;

        createFile(path);
    }

    public void createFile(String path) {
        file = new File(plugin.getDataFolder(), path); // look for a file with the given path

        // if the file doesn't exist in the plugins folder
        if (!file.exists()) {
            // create a new yaml file
            file.getParentFile().mkdirs();
            // save the yaml file to the plugin resources
            plugin.saveResource(path, replace);
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
