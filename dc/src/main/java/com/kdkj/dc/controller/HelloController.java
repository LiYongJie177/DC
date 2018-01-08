package com.kdkj.dc.controller;

import com.kdkj.dc.entity.SysUser;
import com.kdkj.dc.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "helloController ", description = "测试接口")
@RestController
public class HelloController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "获取用户列表", notes = "aaaaaaaaaaaaaaaaaaaaaa")
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public Map<String, Object> say() {
        Map<String, Object> map = new HashMap<>();
        map.put("123", "123");
        map.put("234", "234");
        return map;
    }

    @ApiOperation(value = "vlidator", notes = "用户vlidator")
//    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String"),
////            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
////            @ApiImplicitParam(name = "password", value = "密码", required = false, dataType = "String")
////    })
    @RequestMapping(value = "/ss", method = RequestMethod.GET)
    String ss(@PathVariable("id") String id, @PathVariable("username") String username,
              @PathVariable("password") String password) {
        return id + "  " + username + "----" + password;
    }

    @ApiOperation(value = "获得A+B", notes = "根据url的classNo和url的studentName获得请求参数的字符串相加，RestFul风格的请求")
    @ApiImplicitParams({@ApiImplicitParam(name = "classNo", value = "班级编号", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/class/{classNo}/to/{studentName}", method = RequestMethod.GET)
    String world(@PathVariable("classNo") String classNo, @PathVariable("studentName") String studentName) {
        SysUser user = new SysUser();
        user.setId("1");
        user.setPassword("123");
        return classNo + "  " + studentName + "----" + user.toString();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<SysUser> SysUserList() {
        return sysUserService.findAll();
    }

}
