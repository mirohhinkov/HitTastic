/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miroslav.model;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Getter;

/**
 *
 * @author Miroslav Hinkov
 */
@Getter
public class Cart {
    
    private final HashMap<Long, SongOrder> songOrders = new HashMap<>();
    

}
