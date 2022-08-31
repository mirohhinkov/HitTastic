/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miroslav.model;

import lombok.Data;

/**
 *
 * @author Miroslav Hinkov
 */
//artist
//id, name
@Data
public class Artist {
   private long id;
   private String name;

   public Artist() {

   }

   public Artist(long id, String name) {
      this.id = id;
      this.name = name;
   }
}
