package cn.wmhwiki.hpanbackend.controller;

import cn.wmhwiki.hpanbackend.common.BaseResponse;
import cn.wmhwiki.hpanbackend.domain.Download;
import cn.wmhwiki.hpanbackend.service.DownloadService;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DownloadController {
    @Resource
    private DownloadService downloadService;

    @GetMapping("")
    @ResponseBody
    public BaseResponse<List<Download>> getList(Integer type, HttpServletRequest httpServletRequest) {
        return downloadService.getDownloadList(type, httpServletRequest);
    }

    @PostMapping("/add")
    @ResponseBody
    public BaseResponse<Boolean> addDownload(@RequestBody Download download, HttpServletRequest request) {
        System.out.println(download);
        return downloadService.addDownload(download, request);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public BaseResponse<Boolean> deleteDownload(@PathVariable Long id, HttpServletRequest request) {
        return downloadService.deleteDownload(id, request);
    }

    @PutMapping("")
    @ResponseBody
    public BaseResponse<Boolean> updateDownload(@RequestBody Download download, HttpServletRequest request) {
        return downloadService.updateDownload(download, request);
    }
}
