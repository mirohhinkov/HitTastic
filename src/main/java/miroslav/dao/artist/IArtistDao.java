/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.dao.artist;

import miroslav.model.Artist;

public interface IArtistDao {

    Artist getArtistById(long id);

    Artist getArtistByName(String name);
}
