/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.model;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Getter;

@Getter
public class Cart {
    
    private final HashMap<Long, SongOrder> songOrders = new HashMap<>();
    

}
