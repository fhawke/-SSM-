package com.ischoolbar.programmer.service.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.entity.admin.Authority;
import com.ischoolbar.programmer.entity.admin.Log;

/**
 * 日志接口
 * @author llq
 *
 */
@Service
public interface LogService {
	int add(Log log);
	int add(String content);
	List<Log> findList(Map<String, Object> queryMap);
	int getTotal(Map<String, Object> queryMap);
	int delete(String ids);
}
