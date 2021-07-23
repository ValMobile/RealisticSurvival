package me.val_mobile.rlcraft;

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
import org.bukkit.Location;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Schematics {

    private static File schematicsFolder;
    private static File fireDragonNest;

    private final RLCraft plugin;
    public Schematics(RLCraft instance) {
        plugin = instance;
    }

    public void createSchematicsFolder() {
        schematicsFolder = new File(plugin.getDataFolder(), "schematics");

        File dir = schematicsFolder.getParentFile();
        dir.mkdirs();
    }

    public void createFireDragonNest() {
        fireDragonNest = new File(plugin.getDataFolder(), "schematics/fire_dragon_nest.schem");

        if (!fireDragonNest.exists()) {
            fireDragonNest.getParentFile().mkdirs();

            plugin.saveResource(fireDragonNest.getPath(), true);

            String path = fireDragonNest.getAbsolutePath();
            compressGZipFile(path, path);
        }
    }

    public static File getFireDragonNest() {
        return fireDragonNest;
    }

    public static void pasteSchematic(File file, Location loc, boolean noAir) throws IOException {

        World world = FaweAPI.getWorld(loc.getWorld().getName());
        Clipboard clipboard;

        ClipboardFormat format = ClipboardFormats.findByFile(file);
        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {
            clipboard = reader.read();
        }

        try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(world, -1)) {
            Operation operation = new ClipboardHolder(clipboard)
                    .createPaste(editSession)
                    .to(BlockVector3.at(loc.getX(), loc.getY(), loc.getZ()))
                    .ignoreAirBlocks(noAir)
                    .build();
            Operations.complete(operation);
        }
    }

    public static void pasteSchematic(String path, Location loc, boolean noAir) throws IOException {

        File file = new File(path);

        World world = FaweAPI.getWorld(loc.getWorld().getName());
        Clipboard clipboard;

        ClipboardFormat format = ClipboardFormats.findByFile(file);
        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {
            clipboard = reader.read();
        }

        try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(world, -1)) {
            Operation operation = new ClipboardHolder(clipboard)
                    .createPaste(editSession)
                    .to(BlockVector3.at(loc.getX(), loc.getY(), loc.getZ()))
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
            // Keep it in finally
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
    public void deCompressGZipFile(String gZippedFile, String newFile) {
        try {
            FileInputStream fis = new FileInputStream(gZippedFile);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(fis);
            FileOutputStream fos = new FileOutputStream(newFile);
            byte[] buffer = new byte[1024];
            int len;
            while((len = gZIPInputStream.read(buffer)) > 0){
                fos.write(buffer, 0, len);
            }
            // Keep it in finally
            fos.close();
            gZIPInputStream.close();
        }
        catch (IOException e) {

        }
    }
}
