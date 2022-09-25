/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.dao.artist;

import miroslav.model.Artist;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistRowMapper implements RowMapper<Artist> {
    @Override
    public Artist mapRow(ResultSet rs, int rowNum) throws SQLException {
        Artist artist = new Artist();
        artist.setId(rs.getLong("artist_id"));
        artist.setName(rs.getString("artist_name"));
        return artist;
    }
}
