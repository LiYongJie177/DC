package com.kdkj.dc.service.impl;

import com.kdkj.dc.entity.SysUser;
import com.kdkj.dc.repository.SysUserDao;
import com.kdkj.dc.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    public List<SysUser> findAll() {
        return sysUserDao.findAll();
    }
}
