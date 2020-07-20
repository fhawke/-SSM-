package com.ischoolbar.programmer.dao.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ischoolbar.programmer.entity.admin.Menu;

/**
 * ≤Àµ•π‹¿Ìdao
 * @author llq
 *
 */
@Repository
public interface MenuDao {
	int add(Menu menu);
	List<Menu> findList(Map<String, Object> queryMap);
	List<Menu> findTopList();
	int getTotal(Map<String, Object> queryMap);
	int edit(Menu menu);
	int delete(Long id);
	List<Menu> findChildernList(Long parentId);
	List<Menu> findListByIds(String ids);
}
