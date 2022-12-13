package spring.training.trdmthdemo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class DeskSeedsDB {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@PostConstruct
    public void init() {
		jdbcTemplate.update("insert into mydesk (assetsName,assetsQuantity) values (?,?)", new Object[]{"laptop",1});
		jdbcTemplate.update("insert into mydesk (assetsName,assetsQuantity) values (?,?)", new Object[]{"mouse",1});
		jdbcTemplate.update("insert into mydesk (assetsName,assetsQuantity) values (?,?)", new Object[]{"mousepad",1});
		jdbcTemplate.update("insert into mydesk (assetsName,assetsQuantity) values (?,?)", new Object[]{"headphones",1});
		jdbcTemplate.update("insert into mydesk (assetsName,assetsQuantity) values (?,?)", new Object[]{"bag",1});
		jdbcTemplate.update("insert into mydesk (assetsName,assetsQuantity) values (?,?)", new Object[]{"Keyboard",2});
		jdbcTemplate.update("insert into mydesk (assetsName,assetsQuantity) values (?,?)", new Object[]{"waterbottle",2});
		jdbcTemplate.update("insert into mydesk (assetsName,assetsQuantity) values (?,?)", new Object[]{"notpad",1});
		  
    }
}
