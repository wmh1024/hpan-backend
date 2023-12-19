package cn.wmhwiki.hpanbackend.controller;

import cn.wmhwiki.hpanbackend.common.BaseResponse;
import cn.wmhwiki.hpanbackend.common.ErrorCode;
import cn.wmhwiki.hpanbackend.common.ResultUtils;
import cn.wmhwiki.hpanbackend.domain.Admin;
import cn.wmhwiki.hpanbackend.exception.BusinessException;
import cn.wmhwiki.hpanbackend.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AdminController {
    @Autowired
    private AdminService adminService;

    // 管理员登录
    @PostMapping("/login")
    @ResponseBody
    public BaseResponse login(@RequestBody Admin admin, HttpServletRequest httpServletRequest) {
        return adminService.login(admin.getUsername(), admin.getUserPassword(), httpServletRequest);
    }

    // 管理员退出
    @GetMapping("/logout")
    @ResponseBody
    public BaseResponse logout(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().removeAttribute("admin");
        return ResultUtils.success(null);
    }

    // 获取用户信息
    @GetMapping("")
    @ResponseBody
    public BaseResponse currentAdmin(HttpServletRequest httpServletRequest) {
        Admin admin = (Admin)httpServletRequest.getSession().getAttribute("admin");
        if (admin == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "鉴权失败");
        }
        return ResultUtils.success(admin);
    }
}
