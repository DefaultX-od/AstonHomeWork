package ru.aston.task3.adapter;

public class TrackListDemo {
    public static void main(String[] args) {
        TrackListProvider trackListProvider = new TrackListAdapter(new LegacyAPI());
        trackListProvider.getTracks()
                .forEach(System.out::println);
    }
}
