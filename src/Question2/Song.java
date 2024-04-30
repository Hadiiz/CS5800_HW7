package Question2;

public class Song {
    private Integer songID;
    private String title;
    private String artist;
    private String album;
    private int duration; // Seconds

    public Song(Integer songID, String title, String artist, String album, int duration) {
        this.songID = songID;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    // Getters
    public Integer getSongID() {
        return songID;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return String.format("Song[ID: %d, Title: %s, Artist: %s, Album: %s, Duration: %d secs]",
                songID, title, artist, album, duration);
    }
}
