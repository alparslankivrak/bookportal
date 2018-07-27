package tr.com.obss.dao.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tr.com.obss.dao.user.UserDao;
import tr.com.obss.dao.user.mapper.UserRowMapper;
import tr.com.obss.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public User post(User user) {

		String sql = "INSERT INTO user " + "(userID, roleID, username, email, password) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { user.getUserID(), user.getRoleID(), user.getUsername(), user.getEmail(),
				user.getPassword() });
		System.out.println("Insert User!!!");
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List get(String userName) {

		String sql = "SELECT * FROM user WHERE username like ?";
		List<UserDao> users= jdbcTemplate.query(sql, new String[] { "%"+userName +"%" },new UserRowMapper());
		return users;
	}

	@Override
	public User put(int userID, User user) {
		String sql = "UPDATE user SET userID=?,roleID=?,username=?,email=?,password=? WHERE userID=?";
		jdbcTemplate.update(sql, new Object[] { user.getUserID(), user.getRoleID(), user.getUsername(), user.getEmail(),
				user.getPassword(), userID });
		System.out.println("Updated!!!");
		return user;
	}

	@Override
	public void delete(int userID) {
		String sql = "DELETE FROM user WHERE userID=?";
		jdbcTemplate.update(sql, new Object[] { userID });
		System.out.println("Deleted!!!");
	}

	@Override
	public List getAllUsers() {
		String sql= "select * from user";
		List<UserDao> users= jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
		return users;
	}

}
