package cn.wmhwiki.hpanbackend.service.impl;

import cn.wmhwiki.hpanbackend.common.BaseResponse;
import cn.wmhwiki.hpanbackend.common.ErrorCode;
import cn.wmhwiki.hpanbackend.common.ResultUtils;
import cn.wmhwiki.hpanbackend.domain.Admin;
import cn.wmhwiki.hpanbackend.exception.BusinessException;
import cn.wmhwiki.hpanbackend.mapper.AdminMapper;
import cn.wmhwiki.hpanbackend.service.AdminService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
        implements AdminService {

    @Override
    public BaseResponse<Admin> login(String username, String userPassword, HttpServletRequest httpServletRequest) {
        // 对参数进行非空校验
        if (username == null || userPassword == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "用户名或密码不能为空");
        }
        // 对参数进行空字符串校验
        if (username.trim().equals("") || userPassword.trim().equals("")) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "用户名或密码不能为空");
        }
        //
        // 对密码进行md5加密 盐值为"wmh"
        userPassword = DigestUtils.md5DigestAsHex((userPassword + "wmh").getBytes());
        // 根据用户名密码查询用户
        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<Admin>().eq("username", username).eq("user_password", userPassword);
        Admin admin = this.getOne(adminQueryWrapper);
        // 如果查询到用户，返回用户id
        // 打印id
        
        if (admin == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "用户名或密码错误");
        }
        // 脱敏
        admin.setUserPassword(null);
        // 设置进session
        httpServletRequest.getSession().setAttribute("admin", admin);
        // 返回数据
        return ResultUtils.success(admin);
    }

    @Override
    public BaseResponse register(String username, String userPassword) {
        // 对参数进行非空校验
        if (username == null || userPassword == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "用户名或密码不能为空");
        }
        // 对参数进行空字符串校验
        if (username.trim().equals("") || userPassword.trim().equals("")) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "用户名或密码不能为空");
        }
        // 对密码进行md5加密 盐值为"wmh"
        userPassword = DigestUtils.md5DigestAsHex((userPassword + "wmh").getBytes());
        // 添加管理员
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setUserPassword(userPassword);
        // 存入数据库
        boolean save = this.save(admin);
        // 如果存入失败，返回null
        if (!save) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "注册失败");
        }
        // 返回管理员id
        return ResultUtils.success(admin.getId());
    }

}




