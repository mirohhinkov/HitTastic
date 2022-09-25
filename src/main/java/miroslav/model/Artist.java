/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.model;

import lombok.Data;

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
