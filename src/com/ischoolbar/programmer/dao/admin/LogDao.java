package com.ischoolbar.programmer.dao.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ischoolbar.programmer.entity.admin.Authority;
import com.ischoolbar.programmer.entity.admin.Log;

/**
 * ϵͳ��־��dao
 * @author llq
 *
 */
@Repository
public interface LogDao {
	int add(Log log);
	List<Log> findList(Map<String, Object> queryMap);
	int getTotal(Map<String, Object> queryMap);
	int delete(String ids);
}
