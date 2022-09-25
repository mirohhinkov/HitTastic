/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.utils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import miroslav.model.Cart;
import erika.model.User;
import miroslav.model.Song;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 *
 * @author Miroslav Hinkov
 */
@Getter @Setter
public class State {
    @Setter(AccessLevel.NONE)
    private static State INSTANCE;
    @Setter(AccessLevel.NONE)
    private final JdbcTemplate jdbcTemplate;

    private Cart cart;
    private User user;
    private User admin;
    private List<Song> songs;
    private String filter;
    private Boolean addedToCart = false;
    private String message = "";

    
    private State() {
   
//        for test only to be removed before sending
//        user = new User();

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(IDataB.userName);
        dataSource.setPassword(IDataB.password);
        dataSource.setUrl(IDataB.url);
        dataSource.setDriverClassName(IDataB.driverClassName);
        jdbcTemplate = new JdbcTemplate(dataSource);
        
        cart = new Cart();
    }
    
    public static State getInstance() {
        if (INSTANCE == null) 
            INSTANCE = new State();
        return INSTANCE;
    }    

}
