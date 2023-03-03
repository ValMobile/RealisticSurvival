/*
    Copyright (C) 2023  Val_Mobile

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
package me.val_mobile.utils;

public class SchematicBuilder {

//    private File file;
//    private Clipboard schematic;
//
//    public SchematicBuilder(RealisticSurvivalPlugin plugin, String path) throws IOException {
//        file = new File(plugin.getDataFolder(), path);
//        schematic = FaweAPI.load(file);
//        file.createNewFile();
//
//        // if the file doesn't exist in the plugins folder
//        if (!file.exists()) {
//            // create a new yaml file
//            file.getParentFile().mkdirs();
//        }
//
//        InputStream is = plugin.getResource(path);
//
//        try (FileOutputStream fos = new FileOutputStream(file)) {
//            int len;
//            byte[] buffer = new byte[1024];
//
//            while ((len = is.read(buffer)) != -1) {
//                fos.write(buffer, 0, len);
//            }
//        }
//    }
//
//    public Clipboard getSchematic() {
//        return schematic;
//    }
//
//    public void paste(Location loc) {
//        pasteSchematic(schematic, loc);
//    }
//
//    /**
//     * Pastes a schematic at a given location
//     * @param file The schematic file to be pasted
//     * @param loc The location where the schematic will be pasted
//     */
//    public static void pasteSchematic(File file, Location loc) {
//
//        World world = FaweAPI.getWorld(loc.getWorld().getName()); // get the world
//        BlockVector3 vector = BlockVector3.at(loc.getX(), loc.getY(), loc.getZ());
//
//        try {
//            FaweAPI.load(file).paste(world, vector);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Pastes a schematic at a given location
//     * @param schematic The schematic to be pasted
//     * @param loc The location where the schematic will be pasted
//     */
//    public static void pasteSchematic(Clipboard schematic, Location loc) {
//
//        World world = FaweAPI.getWorld(loc.getWorld().getName()); // get the world
//        BlockVector3 vector = BlockVector3.at(loc.getX(), loc.getY(), loc.getZ());
//
//        schematic.paste(world, vector);
//    }
}
