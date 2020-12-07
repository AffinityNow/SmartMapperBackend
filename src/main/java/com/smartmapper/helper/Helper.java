package com.smartmapper.helper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {
    static String version;

    public static void setNewVersion() {
        URI uri;
        try {
            uri = ClassLoader.getSystemResource("version.txt").toURI();
            final Path versionFilePath = Paths.get(uri);
            Files.lines(versionFilePath).forEach(l -> {
                version = String.valueOf(l);
            });
        }
        catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        } 
    }
    
    public static String getVersion() {
        return version;
    }
}
