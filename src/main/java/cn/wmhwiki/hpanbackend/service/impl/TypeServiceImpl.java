package cn.wmhwiki.hpanbackend.service.impl;

import cn.wmhwiki.hpanbackend.common.BaseResponse;
import cn.wmhwiki.hpanbackend.common.ErrorCode;
import cn.wmhwiki.hpanbackend.common.ResultUtils;
import cn.wmhwiki.hpanbackend.domain.Type;
import cn.wmhwiki.hpanbackend.exception.BusinessException;
import cn.wmhwiki.hpanbackend.mapper.TypeMapper;
import cn.wmhwiki.hpanbackend.service.TypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
        implements TypeService {

    @Override
    public BaseResponse<Boolean> addType(Type type) {
        // 判空
        if (type == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "参数为空");
        }
        // 添加数据
        boolean save = this.save(type);
        if (!save) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "添加失败");
        }
        return ResultUtils.success(save);
    }

    @Override
    public BaseResponse<Boolean> deleteType(Integer id) {
        // 判空
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
    public BaseResponse<Boolean> updateType(Type type) {
        // 判空
        if (type == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "参数为空");
        }
        // 修改数据
        boolean b = this.updateById(type);
        if (!b) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "修改失败");
        }
        return ResultUtils.success(b);
    }

    @Override
    public BaseResponse<List<Type>> selectAll() {
        // 查询所有数据
        List<Type> list = this.list();
        return ResultUtils.success(list);
    }

    @Override
    public BaseResponse<List<Type>> selectOne(Integer id) {
        // 判空
        if (id == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "参数为空");
        }
        // 查询单个数据
        Type type = this.getById(id);
        if (type == null) {
            throw new BusinessException(ErrorCode.ERROR.getCode(), "查询失败");
        }
        ArrayList<Type> list = new ArrayList<>();
        list.add(type);
        return ResultUtils.success(list);
    }
}




