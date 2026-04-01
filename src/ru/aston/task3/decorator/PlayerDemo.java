package ru.aston.task3.decorator;

public class PlayerDemo {
    public static void main(String[] args) {
        final IPlayList playList = new PlayListFull(new PlayList(21, "Любимое", "media/heart.png"), 255);
        System.out.println(playList.showInfo());
    }
}
