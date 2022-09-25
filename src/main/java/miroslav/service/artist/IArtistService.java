/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.service.artist;

import miroslav.model.Artist;

public interface IArtistService {

    Artist getArtistById(long id);
    Artist getArtistByName(String name);
    void createArtist(Artist artist);
    void updateArtist(Artist artist);
    void deleteArtist(Artist artist);
}
