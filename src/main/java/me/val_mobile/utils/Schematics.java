/*
    Copyright (C) 2021  Val_Mobile

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

import com.fastasyncworldedit.core.FaweAPI;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.*;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;
import com.sk89q.worldedit.world.World;
import me.val_mobile.rlcraft.RLCraftPlugin;
import org.bukkit.Location;

import java.io.*;
/**
 * Schematics is a class that creates and stores schematic files
 * for world generation use
 * @author Val_Mobile
 * @version 1.2
 * @since 1.2
 */
public class Schematics {

    // initializing class variables to store files and folders
    private static File schematicsFolder;
    private static File fireDragonNest;

    // dependency injecting the main class for use
    private final RLCraftPlugin plugin;

    // constructing the Schematics class
    public Schematics(RLCraftPlugin instance) {
        plugin = instance;
    }

    /**
     * Creates the schematics folder which stores schematic files
     */
    public void createSchematicsFolder() {
        schematicsFolder = new File(plugin.getDataFolder(), "schematics"); // look for a folder named "schematics"

        // if the folder "schematics" doesn't exist in the RLCraft plugins folder
        if (!schematicsFolder.exists()) {
            // create the folder
            schematicsFolder.getParentFile().mkdirs();
        }
    }

    /**
     * Creates the fire dragon nest schematic file
     */
    public void createFireDragonNest() {
        fireDragonNest = new File(plugin.getDataFolder(), "schematics/fire_dragon_nest.schem");  // look for a file named "fire_dragon_nest.schem" in the schematics folder

        // if the file "fire_dragon_nest.schem" doesn't exist in the schematics folder
        if (!fireDragonNest.exists()) {
            // create the file

            Clipboard clipboard = null;

            ClipboardFormat format = ClipboardFormats.findByFile(fireDragonNest);
            try (ClipboardReader reader = format.getReader(new FileInputStream(fireDragonNest))) {
                clipboard = reader.read();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (ClipboardWriter writer = BuiltInClipboardFormat.SPONGE_SCHEMATIC.getWriter(new FileOutputStream(fireDragonNest))) {
                writer.write(clipboard);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // save the file to the plugin resources, overwriting any previous schematic files
            plugin.saveResource(fireDragonNest.getPath(), true);
        }
    }

    /**
     * Gets the fire dragon nest schematic
     * @return The schematic file storing the fire dragon nest
     */
    public static File getFireDragonNest() {
        return fireDragonNest;
    }

    /**
     * Pastes a schematic at a given location
     * @param file The schematic file to be pasted
     * @param location The location where the schematic will be pasted
     * @param noAir A boolean determining whether air blocks will be ignored when pasting
     */
    public static void pasteSchematic(File file, Location location, boolean noAir) throws IOException {

        World world = FaweAPI.getWorld(location.getWorld().getName()); // get the world
        Clipboard clipboard; // initialize clipboard

        ClipboardFormat format = ClipboardFormats.findByFile(file); // get the clipboard format
        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) { // get the reader
            clipboard = reader.read(); // assign clipboard
        }

        // paste the schematic with no block limit
        try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(world, -1)) {
            Operation operation = new ClipboardHolder(clipboard)
                    .createPaste(editSession)
                    .to(BlockVector3.at(location.getX(), location.getY(), location.getZ()))
                    .ignoreAirBlocks(noAir)
                    .build();
            Operations.complete(operation);
        }
    }

    /**
     * Pastes a schematic at a given location
     * @param path The path of the schematic file to be pasted
     * @param location The location where the schematic will be pasted
     * @param noAir A boolean determining whether air blocks will be ignored when pasting
     */
    public static void pasteSchematic(String path, Location location, boolean noAir) throws IOException {

        File file = new File(path); // get the file with that path

        World world = FaweAPI.getWorld(location.getWorld().getName()); // get the world
        Clipboard clipboard; // initialize clipboard

        ClipboardFormat format = ClipboardFormats.findByFile(file); // get the clipboard format
        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) { // get the reader
            clipboard = reader.read(); // assign clipboard
        }

        // paste the schematic with no block limit
        try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(world, -1)) {
            Operation operation = new ClipboardHolder(clipboard)
                    .createPaste(editSession)
                    .to(BlockVector3.at(location.getX(), location.getY(), location.getZ()))
                    .ignoreAirBlocks(noAir)
                    .build();
            Operations.complete(operation);
        }
    }
}