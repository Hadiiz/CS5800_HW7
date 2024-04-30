package Question2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SongService realSongService = new RealSongService();
        SongService songServiceProxy = new SongServiceProxy(realSongService);

        // List of song IDs to search for
        List<Integer> songIds = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Fetch songs using the proxy server (initial retrieval)
        System.out.println("Fetching songs using proxy server (initial retrieval):");
        long startTimeProxy = System.currentTimeMillis();
        songIds.forEach(id -> {
            Song song = songServiceProxy.searchById(id);
            if (song != null) {
                System.out.println("Song retrieved from proxy: " + song.getTitle());
            } else {
                System.out.println("No song found for ID: " + id);
            }
        });
        long endTimeProxy = System.currentTimeMillis();
        long timeTakenProxyInitial = endTimeProxy - startTimeProxy;
        System.out.println("Time taken with proxy (initial access): " + timeTakenProxyInitial + " ms");

        // Fetch the same songs again using the proxy server to demonstrate caching
        System.out.println("\nFetching the same songs again using proxy server (using cache):");
        long startTimeCachedProxy = System.currentTimeMillis();
        songIds.forEach(id -> {
            Song cachedSong = songServiceProxy.searchById(id);
            if (cachedSong != null) {
                System.out.println("Cached song retrieved from proxy: " + cachedSong.getTitle());
            } else {
                System.out.println("No cached song found for ID: " + id);
            }
        });
        long endTimeCachedProxy = System.currentTimeMillis();
        long timeTakenProxyCached = endTimeCachedProxy - startTimeCachedProxy;
        System.out.println("Time taken with proxy (cached access): " + timeTakenProxyCached + " ms");

        // Fetch songs using the real service
        System.out.println("\nFetching songs using real service:");
        long startTimeReal = System.currentTimeMillis();
        songIds.forEach(id -> {
            Song song = realSongService.searchById(id);
            if (song != null) {
                System.out.println("Song retrieved from real service: " + song.getTitle());
            } else {
                System.out.println("No song found in real service for ID: " + id);
            }
        });
        long endTimeReal = System.currentTimeMillis();
        long timeTakenReal = endTimeReal - startTimeReal;
        System.out.println("Time taken without proxy: " + timeTakenReal + " ms");

        // Compare results
        System.out.println("\nPerformance Summary:");
        System.out.println("Total time taken to retrieve songs from proxy server (initial): " + timeTakenProxyInitial + " milliseconds");
        System.out.println("Total time taken to retrieve cached songs from proxy server: " + timeTakenProxyCached + " milliseconds");
        System.out.println("Total time taken to retrieve songs from real server: " + timeTakenReal + " milliseconds");
    }
}

