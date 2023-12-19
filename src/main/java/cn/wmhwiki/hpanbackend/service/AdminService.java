package cn.wmhwiki.hpanbackend.service;

import cn.wmhwiki.hpanbackend.common.BaseResponse;
import cn.wmhwiki.hpanbackend.domain.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface AdminService extends IService<Admin> {
    // 管理员登录
    public BaseResponse login(String username, String userPassword, HttpServletRequest httpServletRequest);

    // 管理员注册
    public BaseResponse register(String username, String userPassword);
}
