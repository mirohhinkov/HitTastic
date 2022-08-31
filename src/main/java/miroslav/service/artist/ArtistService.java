package miroslav.service.artist;

import miroslav.dao.artist.ArtistDao;
import miroslav.model.Artist;

public class ArtistService implements IArtistService {
    private final ArtistDao artistDao = new ArtistDao();
    @Override
    public Artist getArtistById(long id) {
        return artistDao.getArtistById(id);
    }

    @Override
    public Artist getArtistByName(String name) {
        return artistDao.getArtistByName(name);
    }

    // ---  To be implemented by member C  ---
    @Override
    public void createArtist(Artist artist) {

    }

    @Override
    public void updateArtist(Artist artist) {

    }

    @Override
    public void deleteArtist(Artist artist) {

    }
}
