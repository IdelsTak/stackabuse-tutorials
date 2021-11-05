/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Path;
import java.nio.file.spi.FileSystemProvider;
import java.util.stream.StreamSupport;
import org.apache.commons.csv.CSVRecord;

import static java.lang.Double.parseDouble;
import static java.lang.System.out;
import static java.nio.file.Paths.get;
import static java.nio.file.spi.FileSystemProvider.installedProviders;
import static java.util.Collections.emptyMap;
import static org.apache.commons.csv.CSVFormat.DEFAULT;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class DeathsCSV {

    public static void main(String[] args) throws URISyntaxException, IOException {
        String rsc = "deaths-from-indoor-air-pollution-by-age.csv";
        Class<DeathsCSV> clazz = DeathsCSV.class;
        URL url = clazz.getResource(rsc);
        URI uri = initURI(url);
        Path p = get(uri);
        File f = p.toFile();
        Reader in = new FileReader(f);

        Iterable<CSVRecord> csvr = DEFAULT
                .builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .build()
                .parse(in);

        StreamSupport
                .stream(csvr.spliterator(), false)
                .map(DeathsCSV::toDeathStats)
                .forEach(out::println);

    }

    private static DeathStats toDeathStats(CSVRecord csvr) throws NumberFormatException {
        return new DeathStats(
                csvr.get(0),
                csvr.get(1),
                csvr.get(2),
                toInt(csvr.get(3)),
                toInt(csvr.get(4)),
                toInt(csvr.get(5)),
                toInt(csvr.get(6)),
                toInt(csvr.get(7))
        );
    }

    private static int toInt(String s) throws NumberFormatException {
        return (int) parseDouble(s);
    }

    private static URI initURI(URL url) throws IOException, URISyntaxException {
        URI uri = url.toURI();
        if ("jar".equals(uri.getScheme())) {
            for (FileSystemProvider fsp : installedProviders()) {
                if (fsp.getScheme().equalsIgnoreCase("jar")) {
                    try {
                        fsp.getFileSystem(uri);
                    } catch (FileSystemNotFoundException fsnfe) {
                        fsp.newFileSystem(uri, emptyMap());
                    }
                }
            }
        }
        return uri;
    }
}
