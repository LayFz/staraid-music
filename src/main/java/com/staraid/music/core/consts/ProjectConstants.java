package com.staraid.music.core.consts;

import com.staraid.music.MusicApplication;

/**
 * 项目的常量
 *
 * @author mine
 * @since 2023-06-02 22:58:38
 */
public interface ProjectConstants {

    /**
     * 项目的模块名称
     */
    String PROJECT_MODULE_NAME = "guns-standalone";

    /**
     * 异常枚举的步进值
     */
    String BUSINESS_EXCEPTION_STEP_CODE = "100";

    /**
     * 项目的包名，例如cn.stylefeng.guns
     */
    String ROOT_PACKAGE_NAME = MusicApplication.class.getPackage().getName();

}
