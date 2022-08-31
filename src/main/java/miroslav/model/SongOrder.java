/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miroslav.model;

import lombok.Data;
import lombok.Setter;

/**
 *
 * @author M1R
 */
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
