package com.cool.tu.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "aliyun.oss")
@Data
public class OssClientConfig {
  
    /**  
     * endpoint
     */  
    private String endpoint;
  
    /**  
     * accessKeyId
     */  
    private String accessKey;

    /**
     * accessKeySecret
     */
    private String secretKey;

    /**
     * bucketName
     */
    private String bucketName;
  
    @Bean
    public OSS ossClient() {
        return new OSSClientBuilder().build(endpoint, accessKey, secretKey);
    }  
}