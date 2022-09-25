/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.dao.song;

import miroslav.model.Artist;
import miroslav.model.Song;
import miroslav.service.artist.ArtistService;
import miroslav.utils.State;
import miroslav.utils.UserInputUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collections;
import java.util.List;


public class SongDao implements ISongDao {
    private final State state = State.getInstance();

    private final JdbcTemplate jdbcTemplate = state.getJdbcTemplate();
    private final ArtistService artistService = new ArtistService();



    @Override
    public List<Song> getAllSongs() {
        String sqlQuery ="SELECT * FROM songs";
        List<Song> songs = jdbcTemplate.query(sqlQuery, new SongRowMapper());

        if(!songs.isEmpty())
            populateArtists(songs);

        return songs;
    }

    @Override
    public List<Song> getSongsByTitle(String title) {
        String newTitle = UserInputUtils.capitalizeWords(UserInputUtils.removeSpecialCharacters(title));
        String sqlQuery ="SELECT * FROM songs WHERE " + UserInputUtils.prepareTitleForSqlQuery("title", newTitle);

        List<Song> songs = jdbcTemplate.query(sqlQuery, new SongRowMapper());

        // populate Artists
        if(!songs.isEmpty())
            populateArtists(songs);
        return songs;
    }

    @Override
    public List<Song> getSongsByArtist(String artistName) {
        Artist artist = artistService.getArtistByName(artistName);
        List<Song> songs = Collections.emptyList();
        if (artist != null) {
            String sqlQuery = "SELECT * FROM songs WHERE artist_id = ?";
            songs = jdbcTemplate.query(sqlQuery, new SongRowMapper(),
                    new Object[] {Long.valueOf(artist.getId())});
            for (Song song : songs)
                song.setArtist(artist);
        }
        return songs;
    }

    //To be implemented by member C
    @Override
    public void addSong(Song song) {

    }

    @Override
    public void modifySong(Song song) {

    }

    @Override
    public void deleteSong(Song song) {

    }

    private void populateArtists(List<Song> songs) {
        for (int i = 0; i < songs.size(); i++) {
            Artist artist = artistService.getArtistById(songs.get(i).getArtistId());
            songs.get(i).setArtist(artist);
        }
    }
}
