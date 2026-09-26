package encapsulation.assingments;

import java.util.Arrays;

class Playlist {
    private String[] songs;
    private int songCount;

    public Playlist(int maxSize) {
        songs = new String[maxSize];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount >= songs.length) {
            System.out.println("Playlist is full.");
            return;
        }

        songs[songCount] = song;
        songCount++;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }
}

public class PlaylistDemo {
    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println("Before changing copy:");
        System.out.println(copy[0]);
        System.out.println(copy[1]);

        copy[0] = "Hacked";

        System.out.println("After changing copy:");
        System.out.println("Playlist first song: " + p.getSongs()[0]);

        System.out.println("Song count: " + p.getSongCount());
    }
}
