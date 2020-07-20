package com.ischoolbar.programmer.service.admin;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.entity.admin.Authority;

/**
 * 权限service接口
 * @author llq
 *
 */
@Service
public interface AuthorityService {
	int add(Authority authority);
	int deleteByRoleId(Long roleId);
	List<Authority> findListByRoleId(Long roleId);
}
