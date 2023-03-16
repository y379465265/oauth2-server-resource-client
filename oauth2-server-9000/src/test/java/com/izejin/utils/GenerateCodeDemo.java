package com.izejin.utils;

import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import org.junit.Test;

import java.util.Map;

/**
 * 描述：
 * <p>
 * 创建时间：2019/5/29 9:46
 * 修改时间：
 *
 */

public class GenerateCodeDemo {


    @Test
    public void genCode() {
        String tableNames = "sys_user";
        new AbstractCodeGenerator() {
            /**
             * 数据库业务类型
             */
            String projectPath = System.getProperty("user.dir");

            @Override
            public GlobalConfig custom(GlobalConfig globalConfig) {
                globalConfig.setOutputDir(projectPath + "/src/main/java");
                return super.custom(globalConfig);
            }

            @Override
            public InjectionConfig custom(InjectionConfig injectionConfig) {
                Map<String, Object> map = injectionConfig.getMap();
                map.put("swagger2", true);
                return injectionConfig;
            }

            @Override
            public PackageConfig custom(PackageConfig packageConfig) {
                packageConfig.setParent("com.izejin");
                return super.custom(packageConfig);
            }

            @Override
            public String getModuleName() {
                return "";
            }

            @Override
            public String[] getIncludeTableNames() {
                return new String[] {tableNames};
            }

            @Override
            public String[] getExcludeTableNames() {
                return new String[] {};
            }

            @Override
            public DataSourceConfig custom(DataSourceConfig dataSourceConfig) {
                dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/oauth2-server-resource-client?useUnicode=true&useSSL=false&characterEncoding=utf8");
                dataSourceConfig.setUsername("root");
                dataSourceConfig.setPassword("root");
                return dataSourceConfig;
            }
        }.run();
    }

}
