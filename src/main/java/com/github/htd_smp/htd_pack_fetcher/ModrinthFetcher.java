package com.github.htd_smp.htd_pack_fetcher;

import com.github.htd_smp.htd_pack_reader.HtdPackV1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ModrinthFetcher {
    public final Path temp = Files.createTempDirectory("forge_fetcher_downloads_");

    public ModrinthFetcher() throws IOException {
    }

    public File fetchFile(HtdPackV1.ModrinthMod mod) throws IOException {
        return fetchFile(mod, temp);
    }

    public static String getUrl(String id, String version, String fileName) {
        return "https://cdn.modrinth.com/data/" + id + "/versions/" + version + "/" + fileName;
    }

    public static String getUrl(HtdPackV1.ModrinthMod mod) {
        return getUrl(mod.id, mod.version, mod.fileName);
    }

    public static File fetchFile(HtdPackV1.ModrinthMod mod, String path) throws IOException {
        return PackFetcher.downloadFile(getUrl(mod), path);
    }

    public static File fetchFile(HtdPackV1.ModrinthMod mod, Path path) throws IOException {
        return PackFetcher.downloadFile(getUrl(mod), path);
    }
}
