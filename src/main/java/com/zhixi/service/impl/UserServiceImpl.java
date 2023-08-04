package com.zhixi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixi.mapper.UserMapper;
import com.zhixi.pojo.User;
import com.zhixi.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author zhangzhixi
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2022-05-01 12:15:07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
}




