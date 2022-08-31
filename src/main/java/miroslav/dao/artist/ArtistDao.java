package miroslav.dao.artist;

import miroslav.model.Artist;
import miroslav.utils.State;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ArtistDao implements IArtistDao{
    private JdbcTemplate jdbcTemplate = State.getInstance().getJdbcTemplate();
    @Override
    public Artist getArtistById(long id) {
        String sqlQuery = "SELECT * FROM artists WHERE artist_id = ?";
        Artist artist = jdbcTemplate.queryForObject(sqlQuery, new ArtistRowMapper(),
                new Object[] {Long.valueOf(id)});
        return artist;
    }

    @Override
    public Artist getArtistByName(String name) {
        String sqlQuery = "SELECT * FROM artists WHERE artist_name = ?";
        try {
            Artist artist = jdbcTemplate.queryForObject(sqlQuery, new ArtistRowMapper(), new Object[]{name});
            return artist;
        } catch (Exception e) {
            return null;
        }
    }
}
