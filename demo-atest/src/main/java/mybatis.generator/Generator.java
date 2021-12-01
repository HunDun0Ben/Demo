package mybatis.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;

import java.io.File;
import java.util.*;

public class Generator {

    public static void main(String[] args) {
        TemplateConfig.Builder tcb = new TemplateConfig.Builder()
//                .disable(TemplateType.ENTITY)
                .entity("/mybatis-plus/templates/entity.java")
                .service("/mybatis-plus/templates/service.java")
                .serviceImpl("/mybatis-plus/templates/serviceImpl.java")
                .mapper("/mybatis-plus/templates/mapper.java")
                .mapperXml("/mybatis-plus/templates/mapper.xml")
                .controller("/mybatis-plus/templates/controller.java");
        TemplateConfig tc = tcb.build();

        String url, username, pwd;
        String module;
        url = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
        username = "root";
        pwd = "root";
        module = "mybatis.test";

        DataSourceConfig.Builder dscb = new DataSourceConfig.Builder(url, username, pwd)
                .dbQuery(new MySqlQuery())
                .schema("demo")
                .typeConvert(new MySqlTypeConvert())
                .keyWordsHandler(new MySqlKeyWordsHandler());

        // 除了数据源， 剩余的config都会初始化一个默认的配置
        FastAutoGenerator.create(dscb)
                // 全局配置
                .globalConfig((scanner, builder) ->
                        builder.author(scanner.apply("请输入作者名称？"))
                                .outputDir("D:\\tmp\\mybatis\\test")
                                .dateType(DateType.TIME_PACK)
                                .commentDate("yyyy-MM-dd")
                                .fileOverride()
                                .enableSwagger()
                                // 禁止自动打开跳转输出目录
//                                .disableOpenDir()
                )
                // 包配置
                .packageConfig((scanner, builder) ->
                        builder.parent(scanner.apply("请输入包名？"))
                                // 设置模块名称
                                .moduleName(module)
                                .entity("po")
                                .service("service")
                                .serviceImpl("service.impl")
                                .mapper("mapper")
                                .xml("mapper.xml")
                                .controller("controller")
                                .other("other")
                                .pathInfo(getPathInfo()))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .controllerBuilder().enableRestStyle().enableHyphenStyle()
                        .entityBuilder().enableLombok().addTableFills(
                                new Column("create_time", FieldFill.INSERT)
                        ).build())
                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
                .injectionConfig((scanner, builder) -> builder.beforeOutputFile((tableInfo, objectMap) -> {
                    System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.toString());
                }))
                .execute();

    }

    protected static Map<OutputFile, String> getPathInfo() {
        String basePath = "E:\\workspace\\project\\demo";
        Map<OutputFile, String> map = new HashMap<>(OutputFile.values().length);
        map.put(OutputFile.entity, basePath + File.separator + "demo-entity");
        map.put(OutputFile.controller, basePath + File.separator + "demo-web");
        map.put(OutputFile.mapper, basePath + File.separator + "demo-entity");
        map.put(OutputFile.mapperXml, basePath + File.separator + "demo-entity");
        map.put(OutputFile.service, basePath + File.separator + "demo-facade");
        map.put(OutputFile.serviceImpl, basePath + File.separator + "demo-service");
        return map;
    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
