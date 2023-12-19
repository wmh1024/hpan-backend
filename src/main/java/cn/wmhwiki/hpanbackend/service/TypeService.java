package cn.wmhwiki.hpanbackend.service;

import cn.wmhwiki.hpanbackend.common.BaseResponse;
import cn.wmhwiki.hpanbackend.domain.Type;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface TypeService extends IService<Type> {
    // 添加类型
    BaseResponse<Boolean> addType(Type type);

    // 删除
    BaseResponse<Boolean>  deleteType(Integer id);

    // 修改
    BaseResponse<Boolean>  updateType(Type type);

    // 查询所有
    BaseResponse<List<Type>> selectAll();

    // 查询单个
    BaseResponse<List<Type>>  selectOne(Integer id);

}
