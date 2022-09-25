/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.model;

import lombok.Data;
import lombok.Setter;

@Data
public class SongOrder {
    private Song song;
    @Setter
    private int quantity;

    public SongOrder(Song song, int quantity) {
        this.song = song;
        this.quantity = quantity;
    }
}
