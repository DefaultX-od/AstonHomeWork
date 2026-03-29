package ru.aston.task3.adapter;

import java.util.List;

public class TrackListAdapter implements TrackListProvider {
    private final LegacyAPI legacyAPI;

    public TrackListAdapter(final LegacyAPI legacyAPI) {
        this.legacyAPI = legacyAPI;
    }

    @Override
    public List<Track> getTracks() {
        final String rawTracks = legacyAPI.getRawTracks();
        final List<String> rawTrackLines = List.of(rawTracks.split("\n"));

        return rawTrackLines.stream()
                .map(line -> line.split("; "))
                .filter(parts -> parts.length == 3)
                .map(parts -> new Track(
                        parts[0],
                        parts[1],
                        Integer.parseInt(parts[2])
                ))
                .toList();
    }
}
