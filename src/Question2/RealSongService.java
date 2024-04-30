package Question2;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RealSongService implements SongService {
    private List<Song> songs;

    public RealSongService() {
        this.songs = new ArrayList<>();
        songs.add(new Song(1,"Legends Never Die", "Against The Current", "League of Legends", 202));
        songs.add(new Song(2,"Rise", "The Glitch Mob, Mako, and The Word Alive", "League of Legends", 188));
        songs.add(new Song(3,"Warriors", "Imagine Dragons", "League of Legends", 172));
        songs.add(new Song(4,"Phoenix", "Cailin Russo and Chrissy Costanza", "League of Legends", 190));
        songs.add(new Song(5,"Giants", "True Damage", "League of Legends", 193));
        songs.add(new Song(6,"Take Over", "Jeremy McKinnon, MAX, Henry Lau", "League of Legends", 210));
        songs.add(new Song(7,"Awaken", "Valerie Broussard", "League of Legends", 210));
        songs.add(new Song(8,"Burn It All Down", "PVRIS", "League of Legends", 205));
        songs.add(new Song(9,"Enemy", "Imagine Dragons and JID", "League of Legends", 173));
        songs.add(new Song(10,"Worlds Collide", "Nicki Taylor", "League of Legends", 200));
    }

    @Override
    public Song searchById(Integer songID) {
        simulateDelay();
        if (songID >= 0 && songID < songs.size()) {
            return songs.get(songID);
        }
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        simulateDelay();
        return songs.stream().filter(song -> song.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        simulateDelay();
        return songs.stream().filter(song -> song.getAlbum().equalsIgnoreCase(album)).collect(Collectors.toList());
    }

    private void simulateDelay() {
        try {
            Thread.sleep(1000); // Simulates network/database delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
