package cn.wmhwiki.hpanbackend.service;

import cn.wmhwiki.hpanbackend.common.BaseResponse;
import cn.wmhwiki.hpanbackend.domain.Download;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;


public interface DownloadService extends IService<Download> {
    // 添加数据
    BaseResponse<Boolean> addDownload(Download download, HttpServletRequest request);

    // 删除数据
    BaseResponse<Boolean> deleteDownload(Long id, HttpServletRequest request);

    // 修改数据
    BaseResponse<Boolean> updateDownload(Download download, HttpServletRequest request);

    // 查询数据
    BaseResponse<List<Download>> getDownloadList(Integer typeId, HttpServletRequest httpServletRequest);
}
