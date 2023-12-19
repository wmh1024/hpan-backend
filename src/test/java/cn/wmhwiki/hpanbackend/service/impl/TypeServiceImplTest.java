package cn.wmhwiki.hpanbackend.service.impl;

import cn.wmhwiki.hpanbackend.domain.Type;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TypeServiceImplTest {
    @Resource
    private TypeServiceImpl typeService;

//    @Test
//    public void addType() {
//        Type type = new Type();
//        type.setTypeName("test");
//        // 添加数据
//        boolean result = typeService.addType(type);
//        // 判断是否添加成功
//        Assertions.assertTrue(result);
//    }
//
//    @Test
//    public void deleteType() {
//        // 删除数据
//        boolean result = typeService.deleteType(1);
//        // 判断是否删除成功
//        Assertions.assertTrue(result);
//    }
//
//    @Test
//    public void updateType() {
//        Type type = new Type();
//        type.setId(1);
//        type.setTypeName("wmh");
//        // 修改数据
////        boolean result = typeService.updateType(type);
//        // 判断是否修改成功
//        Assertions.assertTrue(result);
//    }
//
//    @Test
//    public void selectAll() {
//        // 查询所有数据
//        Assertions.assertNotNull(typeService.selectAll());
//    }
//
//    @Test
//    public void selectOne() {
//        // 查询单个数据
//        Assertions.assertNotNull(typeService.selectOne(1));
//    }
}