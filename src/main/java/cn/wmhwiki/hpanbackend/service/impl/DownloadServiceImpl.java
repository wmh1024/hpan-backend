package cn.wmhwiki.hpanbackend.service.impl;

import cn.wmhwiki.hpanbackend.common.BaseResponse;
import cn.wmhwiki.hpanbackend.common.ErrorCode;
import cn.wmhwiki.hpanbackend.common.ResultUtils;
import cn.wmhwiki.hpanbackend.domain.Admin;
import cn.wmhwiki.hpanbackend.domain.Download;
import cn.wmhwiki.hpanbackend.exception.BusinessException;
import cn.wmhwiki.hpanbackend.mapper.DownloadMapper;
import cn.wmhwiki.hpanbackend.service.DownloadService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DownloadServiceImpl extends ServiceImpl<DownloadMapper, Download>
        implements DownloadService {

    @Override
    public BaseResponse<Boolean> addDownload(Download download, HttpServletRequest request) {
        // 鉴权
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        // 判空
        if (admin == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "鉴权失败");
        }
        // 参数判空
        if (download == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "参数为空");
        }
        // 添加数据
        boolean save = this.save(download);
        if (!save) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "添加失败");
        }
        return ResultUtils.success(save);
    }

    @Override
    public BaseResponse<Boolean> deleteDownload(Long id, HttpServletRequest request) {
        // 鉴权
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        // 判空
        if (admin == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "鉴权失败");
        }
        // 参数判空
        if (id == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "参数为空");
        }
        // 删除数据
        boolean b = this.removeById(id);
        if (!b) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "删除失败");
        }
        return ResultUtils.success(b);
    }

    @Override
    public BaseResponse<Boolean> updateDownload(Download download, HttpServletRequest request) {
        // 鉴权
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        // 判空
        if (admin == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "鉴权失败");
        }
        // 参数判空
        if (download == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "参数为空");
        }
        // 判断id是否存在
        if (download.getId() == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "id为空");
        }
        // 查询id是否已经在数据库中
        if (this.getById(download.getId()) == null) {
            return addDownload(download, request);
        }
        // 修改数据
        boolean b = this.updateById(download);
        if (!b) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "修改失败");
        }
        return ResultUtils.success(b);
    }

    @Override
    public BaseResponse<List<Download>> getDownloadList(Integer typeId, HttpServletRequest httpServletRequest) {
        // 查询数据
        QueryWrapper<Download> queryWrapper = new QueryWrapper<>();
        if (typeId != null) {
            queryWrapper.eq("type", typeId);
        }
        // 鉴权
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("admin");
        if (admin == null) {
            queryWrapper.eq("is_enable", 1);
        }
        List<Download> list = this.list(queryWrapper);
        // 返回数据
        return ResultUtils.success(list);
    }
}




