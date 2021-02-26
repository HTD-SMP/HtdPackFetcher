package com.github.htd_smp.htd_pack_fetcher;

import com.github.htd_smp.htd_pack_reader.HtdPackV1;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ForgeFetcher {
    public final Path temp = Files.createTempDirectory("forge_fetcher_downloads_");

    public ForgeFetcher() throws IOException {

    }

    public File fetchFile(HtdPackV1.CurseMod mod) throws IOException {
        return fetchFile(mod, temp);
    }

    public static String getUrl(String slug, String fileId) {
        return "https://www.curseforge.com/minecraft/mc-mods/" + slug + "/download/" + fileId;
    }

    public static String getUrl(HtdPackV1.CurseMod mod) {
        return getUrl(mod.slug, mod.fileId);
    }

    public static File fetchFile(HtdPackV1.CurseMod mod, String path) throws IOException {
        return PackFetcher.downloadFile(getUrl(mod), path);
    }

    public static File fetchFile(HtdPackV1.CurseMod mod, Path path) throws IOException {
        return PackFetcher.downloadFile(getUrl(mod), path);
    }
}
