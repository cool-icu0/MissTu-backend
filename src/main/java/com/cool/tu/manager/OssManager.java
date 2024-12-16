package com.cool.tu.manager;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.cool.tu.config.OssClientConfig;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;

@Component
public class OssManager {

    @Resource
    private OssClientConfig ossClientConfig;

    @Resource
    private OSSClient ossClient;


    /**
     * 上传对象
     */
    public PutObjectResult putObject(String filePath, InputStream inputStream) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(ossClientConfig.getBucketName(), filePath,
                inputStream);
        return ossClient.putObject(putObjectRequest);
    }


    /**
     * 下载对象
     */
    public OSSObject getObject(String downloadPath) {
        GetObjectRequest getObjectRequest = new GetObjectRequest(ossClientConfig.getBucketName(), downloadPath);
        return ossClient.getObject(getObjectRequest);
    }
}