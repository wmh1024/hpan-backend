package cn.wmhwiki.hpanbackend.service;

import cn.wmhwiki.hpanbackend.domain.Download;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DownloadServiceTest {
    @Resource
    private DownloadService downloadService;

//    @Test
//    public void testAddDownload() {
//        // 设置假数据
//        Download download = new Download();
//        download.setItemName("mysql");
//        download.setType(1);
//        download.setDes("数据库");
//        download.setChannel0("官网下载");
//        download.setChannel0Url("https://www.mysql.com/downloads/");
//        download.setChannel1("百度网盘");
//        download.setChannel1Url("https://pan.baidu.com/s/xxxx");
//        download.setImg("https://www.mysql.com/common/logos/logo-mysql-170x115.png");
//        // 打印download
//        System.out.println(download);
//        // 添加数据
//        boolean result = downloadService.addDownload(download, null);
//        // 打印download
//        System.out.println(download);
//        // 断言
//        Assertions.assertTrue(result);
//    }
//
//    // 修改数据
//    @Test
//    public void testUpdateDownload() {
//        // 设置假数据
//        Download download = new Download();
//        download.setId(1L);
//        download.setItemName("nginx");
//        download.setType(1);
//        download.setDes("数据库");
//        download.setChannel0("官网下载");
//        download.setChannel0Url("https://www.mysql.com/downloads/");
//        download.setChannel1("百度网盘");
//        download.setChannel1Url("https://pan.baidu.com/s/xxxx");
//        download.setImg("https://www.mysql.com/common/logos/logo-mysql-170x115.png");
//        // 打印download
//        System.out.println(download);
//        // 修改数据
//        boolean result = downloadService.updateDownload(download, null);
//        // 打印download
//        System.out.println(download);
//        // 断言
//        Assertions.assertTrue(result);
//    }
//
//    // 查询数据
//    @Test
//    public void testGetDownloadList() {
//        // 查询数据
//        List<Download> downloadList = downloadService.getDownloadList(1);
//        // 遍历输出downloadList
//        for (Download download : downloadList) {
//            System.out.println(download);
//        }
//        // 断言
//        Assertions.assertNotNull(downloadList);
//    }
//
//    // 删除数据
//    @Test
//    public void testDeleteDownload() {
//        // 删除数据
//        boolean result = downloadService.deleteDownload(1L, null);
//        // 断言
//        Assertions.assertTrue(result);
//    }
}