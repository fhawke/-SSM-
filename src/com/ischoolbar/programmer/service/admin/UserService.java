package com.ischoolbar.programmer.service.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.entity.admin.User;

/**
 * user”√ªßservice
 * @author llq
 *
 */
@Service
public interface UserService {
	User findByUsername(String username);
	int add(User user);
	int edit(User user);
	int editPassword(User user);
	int delete(String ids);
	List<User> findList(Map<String, Object> queryMap);
	int getTotal(Map<String, Object> queryMap);
}
