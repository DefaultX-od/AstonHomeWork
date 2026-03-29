package ru.aston.task3.decorator;

public class PlayListFull extends PlayListDecorator {
    private final Integer trackCount;

    public PlayListFull(final IPlayList playList, final Integer trackCount) {
        super(playList);
        this.trackCount = trackCount;
    }

    public Integer getTrackCount() {
        return trackCount;
    }

    public String play() {
        return " Запускаю проигрывание плейлиста";
    }

    @Override
    public String toString() {
        return String.format(" trackCount: %d;", trackCount);
    }

    @Override
    public String showInfo() {
        return super.showInfo() + this + this.play();
    }
}
