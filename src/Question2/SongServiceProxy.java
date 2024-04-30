package Question2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceProxy implements SongService {
    private SongService realService;
    private Map<Integer, Song> idCache = new HashMap<>();
    private Map<String, List<Song>> titleCache = new HashMap<>();
    private Map<String, List<Song>> albumCache = new HashMap<>();

    public SongServiceProxy(SongService realService) {
        this.realService = realService;
    }

    @Override
    public Song searchById(Integer songID) {
        return idCache.computeIfAbsent(songID, realService::searchById);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        return titleCache.computeIfAbsent(title.toLowerCase(), k -> realService.searchByTitle(title));
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        return albumCache.computeIfAbsent(album.toLowerCase(), k -> realService.searchByAlbum(album));
    }
}
