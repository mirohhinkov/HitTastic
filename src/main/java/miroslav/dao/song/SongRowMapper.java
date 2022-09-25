/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.dao.song;

import miroslav.model.Song;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SongRowMapper implements RowMapper<Song> {
    @Override
    public Song mapRow(ResultSet rs, int rowNum) throws SQLException {
        Song song = new Song();
        song.setId(rs.getLong("songs_id"));
        song.setArtistId(rs.getLong("artist_id"));
        song.setTitle(rs.getString("title"));
        song.setPrice(rs.getDouble("price"));
        song.setUrl(rs.getString("url"));
        song.setQuantity(rs.getInt("quantity"));
        return song;
    }
}
