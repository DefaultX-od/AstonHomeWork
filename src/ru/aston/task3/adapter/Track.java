package ru.aston.task3.adapter;

public class Track {
    private final String name;
    private final String artist;
    private final int year;

    public Track(final String name, final String artist, final int year) {
        this.name = name;
        this.artist = artist;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("name: %s; artist: %s; year: %d", name, artist, year);
    }
}
