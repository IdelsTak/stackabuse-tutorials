/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Path;
import java.nio.file.spi.FileSystemProvider;
import java.util.stream.StreamSupport;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import static java.lang.Double.parseDouble;
import static java.lang.System.out;
import static java.math.RoundingMode.HALF_UP;
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
        Class<DeathsCSV> clazz = DeathsCSV.class;
        String rsc = "deaths-from-indoor-air-pollution-by-age.csv";
        URL url = clazz.getResource(rsc);
        URI uri = initURI(url);
        Path p = get(uri);
        File f = p.toFile();
        Reader in = new FileReader(f);
        CSVFormat csvf = DEFAULT.builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .build();

        StreamSupport
                .stream(
                        csvf.parse(in).spliterator(),
                        false
                )
                .map(DeathsCSV::toDeathStats)
                .forEach(out::println);
    }

    private static DeathStats toDeathStats(CSVRecord rec) throws NumberFormatException {
        return new DeathStats(
                rec.get(0),
                rec.get(1),
                rec.get(2),
                toDecimal(rec.get(3)),
                toDecimal(rec.get(4)),
                toDecimal(rec.get(5)),
                toDecimal(rec.get(6)),
                toDecimal(rec.get(7))
        );
    }

    private static BigDecimal toDecimal(String s) throws NumberFormatException {
        return new BigDecimal(parseDouble(s)).setScale(3, HALF_UP);
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
