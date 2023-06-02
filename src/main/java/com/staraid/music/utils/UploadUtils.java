package com.staraid.music.utils;

import cn.hutool.core.date.DateUtil;
import cn.stylefeng.roses.kernel.file.api.FileOperatorApi;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * App端文件管理相关接口
 *
 * @author idroid
 * @date 2023-06-02 22:58:38
 */
public class UploadUtils {

    @Resource
    static FileOperatorApi fileOperatorApi;

    /**
     * 单个文件上传
     *
     * @author idroid
     * @date 2022/12/03 17:07
     */
    public static String upload(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

        String filePath = DateUtil.format(new Date(), "yyyy/MM/dd");
        String newFileName = UUID.randomUUID()+fileSuffix;

        fileOperatorApi.storageFile(filePath, newFileName, file.getInputStream());

//        String imgUrl = "http://101.43.63.130:8088/img/"+filePath+"/"+newFileName;
        String imgUrl = "http://101.43.63.130:8088/img/"+filePath+"/"+newFileName;

        return imgUrl;
    }
}
