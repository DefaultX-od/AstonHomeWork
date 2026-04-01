package ru.aston.task3.decorator;

public final class PlayList implements IPlayList {
    private final Integer id;
    private final String name;
    private final String imageCoverLink;

    public PlayList(final Integer id, final String name, final String imageCoverLink) {
        this.id = id;
        this.name = name;
        this.imageCoverLink = imageCoverLink;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageCoverLink() {
        return imageCoverLink;
    }

    @Override
    public String toString() {
        return String.format("id: %d; name: %s; imageCoverLink: %s;", id, name, imageCoverLink);
    }

    @Override
    public String showInfo() {
        return this.toString();
    }
}
