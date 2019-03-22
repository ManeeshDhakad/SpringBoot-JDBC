package com.springboot.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.jdbc.entity.User;

@Transactional
@Repository
public class UserDoa implements IUserDao {
	
    @Autowired  
    JdbcTemplate jdbc;   

	@Override
	public List<User> getAllUsers() {
		final String sql = "select * from User";
		return jdbc.query(sql, new UserRowMapper());
	}

	@Override
	public User getUser(String id) {
		final String sql = "select * from User where id=?";
		return jdbc.queryForObject(sql, new Object[]{id}, new UserRowMapper());
	}

	@Override
	public void addUser(User user) {
		final String sql = "insert into User(id,name,email) values(?,?,?)";
		jdbc.update(sql, user.getId(), user.getName(),  user.getEmail());
	}

	@Override
	public void delete(String id) {
		final String sql = "delete from User where id=?";
		jdbc.update(sql, id);
	}
	
	class UserRowMapper implements RowMapper<User>
	{
	    @Override
	    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	        User user = new User();
	        user.setId(rs.getString("id"));
	        user.setName(rs.getString("name"));
	        user.setEmail(rs.getString("email"));
	        return user;
	    }
	}


}
