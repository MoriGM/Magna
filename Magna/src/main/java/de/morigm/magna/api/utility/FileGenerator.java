package de.morigm.magna.api.utility;

import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileGenerator {

    public static void createFileIfNotExists(String file) {
        createFileIfNotExists(new File(file));
    }

    public static void createFileIfNotExists(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createFile(String file) {
        createFile(new File(file));
    }

    public static void createFile(File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public static void copy(InputStream in, File out) {
        FileOutputStream outs = new FileOutputStream(out);
        copyFile(in, outs);
        outs.close();
    }

    @SneakyThrows
    public static void copyFile(InputStream in, OutputStream out) {
        int readlen;
        byte[] bt = new byte[1024];

        while ((readlen = in.read(bt)) >= 0)
            out.write(bt, 0, readlen);
    }

    public static void getFiles(List<File> files, File folder) {
        for (File f : Objects.requireNonNull(folder.listFiles()))
            if (f.isDirectory())
                getFiles(files, f);
            else {
                files.add(f);
            }

        files.add(folder);
    }

    public static void delete(List<File> files) {
        List<File> folders = new ArrayList<>();
        for (File f : files) {
            if (f.exists()) {
                if (f.isDirectory()) {
                    folders.add(f);
                    continue;
                }
                f.delete();
            }
        }

        for (File f : folders) {
            if (f.exists()) {
                f.delete();
            }
        }
    }

}
