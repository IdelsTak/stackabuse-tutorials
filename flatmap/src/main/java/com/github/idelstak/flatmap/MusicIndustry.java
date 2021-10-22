/*
 * Copyright 2021
 */
package com.github.idelstak.flatmap;

import java.util.Optional;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class MusicIndustry {

    public class Musician {

        private Optional<Album> album;

        public Optional<Album> getAlbum() {
            return album;
        }
    }

    public class Album {

        private Optional<CoverArt> art;

        public Optional<CoverArt> getCoverArt() {
            return art;
        }
    }

    public class CoverArt {

        private String designer;

        public String getDesigner() {
            return designer;
        }
    }

    public Optional<String> getMusiciansAlbumCoverDesigner() {
        Musician musician = new Musician();

        return Optional.ofNullable(musician)
                .flatMap(Musician::getAlbum)
                .flatMap(Album::getCoverArt)
                .map(CoverArt::getDesigner);

    }
}
