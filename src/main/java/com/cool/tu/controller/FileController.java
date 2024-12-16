package com.cool.tu.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectResult;
import com.cool.tu.annotation.AuthCheck;
import com.cool.tu.common.BaseResponse;
import com.cool.tu.common.ResultUtils;
import com.cool.tu.config.OssClientConfig;
import com.cool.tu.constant.UserConstant;
import com.cool.tu.exception.BusinessException;
import com.cool.tu.exception.ErrorCode;
import com.cool.tu.manager.OssManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;

/**
 * @Author Cool
 * @Date 2024/12/16 下午4:49
 */
@RestController
@Slf4j
public class FileController {

    @Resource
    private OssManager ossManager;

    /**
     * 文件上传
     */
//    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    @PostMapping("/test/upload")
    public BaseResponse<String> UploadFile(@RequestPart("file") MultipartFile multipartFile) {
        try {
            InputStream inputStream = multipartFile.getInputStream();
            String originalFilename = multipartFile.getOriginalFilename();
            String filePath = "test/" + originalFilename;
            PutObjectResult putObjectResult = ossManager.putObject(filePath, inputStream);
            System.out.println(putObjectResult.toString());
            return ResultUtils.success(putObjectResult.getETag());
        } catch (Exception e) {
            log.error("上传失败", e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
    }
    //下载文件
//    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    @GetMapping("/test/download")
    public BaseResponse<String> DownloadFile(String filePath) {
        try {
            String Path = "test/" + filePath;
            OSSObject ossObject = ossManager.getObject(Path);
            return ResultUtils.success(ossObject.getObjectContent().toString() );
        } catch (Exception e) {
            log.error("下载失败", e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
    }
}
