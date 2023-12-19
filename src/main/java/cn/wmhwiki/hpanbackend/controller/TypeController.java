package cn.wmhwiki.hpanbackend.controller;

import cn.wmhwiki.hpanbackend.common.BaseResponse;
import cn.wmhwiki.hpanbackend.common.ErrorCode;
import cn.wmhwiki.hpanbackend.domain.Admin;
import cn.wmhwiki.hpanbackend.domain.Type;
import cn.wmhwiki.hpanbackend.exception.BusinessException;
import cn.wmhwiki.hpanbackend.service.TypeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/{id}")
    @ResponseBody
    public BaseResponse<List<Type>> getTypeName(@PathVariable Integer id) {
        if (id == null) {
            return typeService.selectAll();
        } else {
            return typeService.selectOne(id);
        }
    }

    @PostMapping("/")
    @ResponseBody
    public BaseResponse<Boolean> addType(@RequestBody Type type, HttpServletRequest httpServletRequest) {
        // 鉴权
        Admin admin = (Admin) httpServletRequest.getAttribute("admin");
        if (admin == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "鉴权失败");
        }
        // 判空
        if (type == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "参数为空");
        }
        return typeService.addType(type);
    }

    @PutMapping("/")
    @ResponseBody
    public BaseResponse<Boolean> updateType(@RequestBody Type type, HttpServletRequest httpServletRequest) {
        // 鉴权
        Admin admin = (Admin) httpServletRequest.getAttribute("admin");
        if (admin == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "鉴权失败");
        }
        // 判空
        if (type == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "参数为空");
        }
        return typeService.updateType(type);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public BaseResponse<Boolean> deleteType(@PathVariable Integer id, HttpServletRequest httpServletRequest) {
        // 鉴权
        Admin admin = (Admin) httpServletRequest.getAttribute("admin");
        if (admin == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "鉴权失败");
        }
        // 判空
        if (id == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "参数为空");
        }
        return typeService.deleteType(id);
    }
}
