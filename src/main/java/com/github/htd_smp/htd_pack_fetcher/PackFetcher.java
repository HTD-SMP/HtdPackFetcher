package com.github.htd_smp.htd_pack_fetcher;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

public class PackFetcher {
    public static File downloadFile(URL url, String path) throws IOException {
        return downloadFile(url, new File(path));
    }

    public static File downloadFile(URL url, File file) throws IOException {
        FileUtils.copyURLToFile(url, file);
        return file;
    }

    public static File downloadFile(String url, String path) throws IOException {
        return downloadFile(new URL(url), path);
    }

    public static File downloadFile(String url, Path path) throws IOException {
        return downloadFile(new URL(url), path.toString());
    }
}
