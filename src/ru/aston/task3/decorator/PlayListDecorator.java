package ru.aston.task3.decorator;

public class PlayListDecorator implements IPlayList{
    private final IPlayList playList;

    public PlayListDecorator(final IPlayList playList){
        this.playList = playList;
    }

    @Override
    public String showInfo() {
        return playList.showInfo();
    }
}
