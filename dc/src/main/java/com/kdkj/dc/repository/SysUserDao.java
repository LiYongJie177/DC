package com.kdkj.dc.repository;

import com.kdkj.dc.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserDao extends JpaRepository<SysUser, String> {
}
