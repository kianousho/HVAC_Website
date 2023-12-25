package ca.sheridancollege.heidarik.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.heidarik.beans.Furnace;

import ca.sheridancollege.heidarik.beans.User;



@Repository
public class DatabaseAccess {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	public void insertFurnace(Furnace books) {
	    MapSqlParameterSource namedParameters = new MapSqlParameterSource();
	    String query = "INSERT INTO furnace	(asin, brand, wattage, price, weight,description) VALUES (:asin, :brand, :wattage, :price, :weight, :description)";
	    
	    namedParameters.addValue("asin", books.getAsin());
	    namedParameters.addValue("brand", books.getBrand());
	    namedParameters.addValue("wattage", books.getWattage());
	    namedParameters.addValue("price", books.getPrice());
	    namedParameters.addValue("weight", books.getWeight());
	    namedParameters.addValue("description", books.getDescription());
	    int rowsAffected = jdbc.update(query, namedParameters);
	    
	    if (rowsAffected > 0) {
	        System.out.println("Furnace inserted into database");
	    }
	}
	
	public List<Furnace> getFurnaceList() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM furnace";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Furnace>(Furnace.class));
		}
	
	public List<Furnace> getFurnaceListById(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM furnace WHERE id = :id";
		namedParameters.addValue("id", id);
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Furnace>(Furnace.class));
		}
	
	public void deleteFurnaceById(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "DELETE FROM furnace WHERE id = :id";
		namedParameters.addValue("id", id);
		if (jdbc.update(query, namedParameters) > 0) {
		System.out.println("Deleted Furnace " + id + " from the database.");
		}
	}
	
	public void updateFurnace(Furnace updatedFurnace) {
	    MapSqlParameterSource namedParameters = new MapSqlParameterSource();
	    
	    String query = "UPDATE furnace SET brand = :brand WHERE id = :id";
	    namedParameters.addValue("brand", updatedFurnace.getBrand());
	    namedParameters.addValue("id", updatedFurnace.getId());
	    
	    int rowsAffected = jdbc.update(query, namedParameters);
	    
	    if (rowsAffected > 0) {
	        System.out.println("Updated Furnace with ID " + updatedFurnace.getId() + " in the database.");
	    }
	}
	
	
	
	
	

	
	// Method to find a user account by email
	public User findUserAccount(String email) {
		MapSqlParameterSource namedParameters = new
		MapSqlParameterSource();
		String query = "SELECT * FROM sec_user where email = :email";
		namedParameters.addValue("email", email);
		try {
		return jdbc.queryForObject(query, namedParameters, new BeanPropertyRowMapper<>(User.class));
		} catch (EmptyResultDataAccessException erdae) {
		return null;
		}
		}
		// Method to get User Roles for a specific User id
		public List<String> getRolesById(Long userId) { MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT sec_role.roleName FROM user_role, sec_role WHERE user_role.roleId = sec_role.roleId AND userId = :userId";
		namedParameters.addValue("userId", userId);
		return jdbc.queryForList(query, namedParameters,String.class);
		}
		}