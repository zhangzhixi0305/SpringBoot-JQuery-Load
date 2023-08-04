package com.zhixi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhixi.pojo.User;
import com.zhixi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangzhixi
 * @version 1.0
 * @description
 * @date 2023-08-03 23:28
 */
@Controller
public class UserControllerNew {

    @Resource
    private UserService userService;

    /**
     * 通过ID查询用户-MybatisPlus方式
     *
     * @return 用户信息
     */
    @RequestMapping("/getUserAllLimit10")
    public String getUserByIdToMybatisPlus(Model model) {
        // 查询所有，limit取前10条
        List<User> userList = userService.getBaseMapper().selectPage(new Page<>(1, 10), null).getRecords();
        model.addAttribute("users", userList);
        return "index";
    }

    @ResponseBody
    @RequestMapping("/getUserList")
    public List<User> getUserList() {
       return userService.getBaseMapper().selectPage(new Page<>(1, 10), null).getRecords();
    }

    @ResponseBody
    @GetMapping("/deleteById")
    public Long deleteById(Long id) {
        boolean removeById = userService.removeById(id);
        if (removeById) {
            return id;
        }
        return 0L;
    }
}
