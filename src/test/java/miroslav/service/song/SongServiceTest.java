package miroslav.service.song;

import miroslav.utils.State;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SongServiceTest {
    SongService songService = new SongService();
    @Test
    void getAllSongsTest() {
        State state = State.getInstance();
        JdbcTemplate jdbcTemplate = state.getJdbcTemplate();
        //get all records in songs table
        int totalSongs = jdbcTemplate.queryForObject("Select COUNT(*) as count FROM songs", new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                int count = rs.getInt("count");
                return count;
            }
        });


        assertEquals(totalSongs, songService.getAllSongs().size());
    }

    @Test
    void getSongsByTitle() {
    }

    @Test
    void getSongsByArtist() {
    }
}