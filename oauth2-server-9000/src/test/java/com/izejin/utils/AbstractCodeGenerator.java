package com.izejin.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.izejin.bean.BaseModel;

import java.util.*;

/**
 * 描述： 代码生成器
 * <p>
 * 创建时间：2019/5/29 12:30
 * 修改时间：
 *
 */
public abstract class AbstractCodeGenerator extends AutoGenerator {


    private static final String TEMPLATES_MAPPER_XML_VM = "/templates/mapper.xml.vm";
    private static final String TEMPLATES_ENTITY_JAVA_VM = "/templates/entity.java.vm";
    //private static final String TEMPLATES_REQ_JAVA_VM = "/templates/req.java.vm";



    public InjectionConfig custom(InjectionConfig injectionConfig) {
        return injectionConfig;
    }

    /**
     * 配置JDBC URL、用户、密码
     * <p>
     * dataSourceConfig.setUrl("jdbc:mysql://192.168.2.250:3306/sample?useUnicode=true&useSSL=false&characterEncoding=utf8");
     * dataSourceConfig.setUsername("username");
     * dataSourceConfig.setPassword("password");
     *
     * @param dataSourceConfig
     * @return
     */
    public abstract DataSourceConfig custom(DataSourceConfig dataSourceConfig);

    public StrategyConfig custom(StrategyConfig strategyConfig) {
        return strategyConfig;
    }

    public PackageConfig custom(PackageConfig packageConfig) {
        return packageConfig;
    }

    public TemplateConfig custom(TemplateConfig templateConfig) {
        return templateConfig;
    }

    public GlobalConfig custom(GlobalConfig globalConfig) {
        return globalConfig;
    }

    /**
     * 配置模块名，默认控制台输入
     *
     * @return
     */
    public String getModuleName() {
        return scanner("模块名");
    }

    /**
     * 配置表名，默认控制台输入
     * scanner("表名，多个英文逗号分割").split(",");
     *
     * @return
     */
    public String[] getIncludeTableNames() {
        return scanner("包含表名，多个英文逗号分割").split(",");
    }

    public String[] getExcludeTableNames() {
        return scanner("排除表名，多个英文逗号分割").split(",");
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public void run() {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        PackageConfig pc = getPackageConfig();

        String projectPath = System.getenv("HOMEDRIVE") + "/generated/" + getModuleName();
        GlobalConfig gc = getGlobalConfig(projectPath);
        DataSourceConfig dsc = getDataSourceConfig();
        InjectionConfig cfg = getInjectionConfig(gc.getOutputDir(), pc);
        TemplateConfig templateConfig = getTemplateConfig();
        StrategyConfig strategy = getStrategyConfig(pc);
        strategy.setSuperEntityClass(BaseModel.class);
        mpg.setGlobalConfig(gc);
        mpg.setPackageInfo(pc);
        mpg.setDataSource(dsc);
        mpg.setCfg(cfg);
        mpg.setTemplate(templateConfig);
        mpg.setStrategy(strategy);
        mpg.execute();
    }

    private GlobalConfig getGlobalConfig(String projectPath) {
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 生成文件的输出目录
        gc.setOutputDir(projectPath + "/src/main/java");
        // 是否覆盖已有文件
        gc.setFileOverride(true);
        // 是否打开输出目录
        gc.setOpen(false);
        // 开发人员
        gc.setAuthor("Auto Generator");
        // 开启 BaseResultMap
        gc.setBaseResultMap(true);
        // 开启 baseColumnList
        gc.setBaseColumnList(true);
        // 实体命名方式
        gc.setEntityName("%s");
        // mapper 命名方式
        gc.setMapperName("%sDao");
        // Mapper xml 命名方式
        gc.setXmlName("%sMapper");
        //设置主键类型
        gc.setIdType(IdType.UUID);
        return custom(gc);
    }

    private DataSourceConfig getDataSourceConfig() {
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        return custom(dsc);
    }

    private InjectionConfig getInjectionConfig(final String projectPath, final PackageConfig pc) {
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
        Map<String, Object> map = new HashMap<>();
        map.put("entityPackage", "com.izejin.entity");
        map.put("modelPackage", "com.izejin.model");
        cfg.setMap(map);
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(TEMPLATES_MAPPER_XML_VM) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/../resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getXmlName() + StringPool.DOT_XML;
            }
        });
        focList.add(new FileOutConfig(TEMPLATES_ENTITY_JAVA_VM) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/com/izejin/entity/" + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });

        cfg.setFileOutConfigList(focList);
        return custom(cfg);
    }

    private PackageConfig getPackageConfig() {
        // 包配置
        PackageConfig pc = new PackageConfig();
        // 父包名
        pc.setParent("com.izejin");
        // 父包模块名
        pc.setModuleName(getModuleName());
        // Entity包名
        pc.setEntity("entity");
        // Service包名
        pc.setService("service");
        // Service Impl包名
        pc.setServiceImpl("service.impl");
        // Mapper包名
        pc.setMapper("dao");
        // Controller包名
        pc.setController("controller");
        return custom(pc);
    }

    private TemplateConfig getTemplateConfig() {
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setController(null);
        templateConfig.setXml(null);
        templateConfig.setEntity(null);
        return custom(templateConfig);
    }

    private StrategyConfig getStrategyConfig(PackageConfig pc) {
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //【实体】是否为lombok模型（默认 false）
        strategy.setEntityLombokModel(false);
        // 生成 @RestController 控制器
        strategy.setRestControllerStyle(true);
        // 需要包含的表名，允许正则表达式
        if (getIncludeTableNames() != null && getIncludeTableNames().length > 0) {
            strategy.setInclude(getIncludeTableNames());
        } else {
            if (getExcludeTableNames() != null && getExcludeTableNames().length > 0) {
                strategy.setExclude(getExcludeTableNames());
            }
        }
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(new TableFill("create_date", FieldFill.INSERT));
        tableFills.add(new TableFill("create_time", FieldFill.INSERT));
        strategy.setTableFillList(tableFills);
        // 表前缀
        strategy.setTablePrefix(pc.getModuleName() + "_", "t_");
        // 开启字段注解
        strategy.setEntityTableFieldAnnotationEnable(true);
        return custom(strategy);
    }

}
