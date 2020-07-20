package com.ischoolbar.programmer.dao.admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ischoolbar.programmer.entity.admin.Authority;

/**
 * 权限实现类dao
 * @author llq
 *
 */
@Repository
public interface AuthorityDao {
	int add(Authority authority);
	int deleteByRoleId(Long roleId);
	List<Authority> findListByRoleId(Long roleId);
}
