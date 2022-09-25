/**
 *
 * @author Miroslav Hinkov
 */

package miroslav.model;

import lombok.Data;

@Data
public class Song {
    private long id;
    private String title;
    private long artistId;
    private Artist artist;
    private double price;
    private String url;
    private int quantity;

}
