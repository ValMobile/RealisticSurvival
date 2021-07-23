package me.val_mobile.utils;

import com.fastasyncworldedit.core.FaweAPI;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;
import com.sk89q.worldedit.world.World;
import me.val_mobile.rlcraft.RLCraft;
import org.bukkit.Location;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
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
    private final RLCraft plugin;

    // constructing the Schematics class
    public Schematics(RLCraft instance) {
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
        fireDragonNest = new File(plugin.getDataFolder(), "schematics/fire_dragon_nest.schem.gz");  // look for a file named "fire_dragon_nest.schem.gz" in the schematics folder

        // if the file "fire_dragon_nest.schem.gz" doesn't exist in the schematics folder
        if (!fireDragonNest.exists()) {
            // create the file
            fireDragonNest.getParentFile().mkdirs();

//            // save the file to the plugin resources, overwriting any previous schematic files
//            plugin.saveResource(fireDragonNest.getPath(), true);
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

    /**
     * Compresses a file into GZIP format
     * @param sourceFile
     * @param outputFile
     * @throws IOException
     */
    public void compressGZipFile(String sourceFile, String outputFile) {
        try {
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(outputFile);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(fos);
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) > 0){
                gZIPOutputStream.write(buffer, 0, len);
            }
            // keep it in finally
            fis.close();
            gZIPOutputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Decompresses a GZIP file
     * @param gZippedFile
     * @param newFile
     * @throws IOException
     */
    public void decompressGZipFile(String gZippedFile, String newFile) {
        try {
            FileInputStream fis = new FileInputStream(gZippedFile);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(fis);
            FileOutputStream fos = new FileOutputStream(newFile);
            byte[] buffer = new byte[1024];
            int len;
            while((len = gZIPInputStream.read(buffer)) > 0){
                fos.write(buffer, 0, len);
            }
            // keep it in finally
            fos.close();
            gZIPInputStream.close();
        }
        catch (IOException e) {

        }
    }
}
