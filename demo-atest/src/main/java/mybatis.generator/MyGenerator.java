package mybatis.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import com.google.common.base.CharMatcher;

import java.util.*;

public class MyGenerator {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC",
                username = "root",
                pwd = "root";

        String basePath = "E:\\workspace\\project\\demo";

        DataSourceConfig.Builder dscb = new DataSourceConfig.Builder(url, username, pwd)
                .dbQuery(new MySqlQuery())
                .schema("demo")
                .typeConvert(new MySqlTypeConvert())
                .keyWordsHandler(new MySqlKeyWordsHandler());

        // 除了数据源， 剩余的config都会先初始化一个默认配置
        FastAutoGenerator.create(dscb)
                // 全局配置
                .globalConfig((scanner, builder) ->
                                builder.outputDir(basePath)
                                        .dateType(DateType.TIME_PACK)
                                        .commentDate("yyyy-MM-dd")
                                        .author("Ben")
//                                        .author(scanner.apply("请输入作者名称？"))
//                                        .enableSwagger()
//                                        .fileOverride() // 覆盖已有文件
//                                        .disableOpenDir() // 禁止自动打开跳转输出目录, 只会跳转到 outputDir
                )
                // 包配置
                .packageConfig((scanner, builder) ->
                        builder
//                                .parent(scanner.apply("请输入包名？"))
                                // 基础包名
                                .parent("com.hundun.demo")
                                // 设置模块名称·
                                .moduleName(scanner.apply("请输入模块名:"))
                                .entity("entity")
                                .mapper("mapper")
                                .xml("mapper.xml")
                                .service("service.facade")
                                .serviceImpl("service.facade.impl")
                                .controller("web.controller")
                                .other("other")
                                .pathInfo(getPathInfo()))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .controllerBuilder()
                            .enableRestStyle()
                            .enableHyphenStyle()
                        .entityBuilder()
                            .enableLombok()
                            .addTableFills(new Column("create_time", FieldFill.INSERT))
                        .build())

                .templateEngine(new MyTemplateEngine())
                .injectionConfig((scanner, builder) -> builder.beforeOutputFile((tableInfo, objectMap) -> {
                    System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.toString());
                }))
                /*
                模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
               .templateEngine(new BeetlTemplateEngine())
               .templateEngine(new FreemarkerTemplateEngine())
                */
                .execute();

    }

    protected static Map<OutputFile, String> getPathInfo() {
        String javaPath = "E:\\workspace\\project\\demo\\?\\src\\main\\java";
        String resourcePath = "E:\\workspace\\project\\demo\\?\\src\\main\\resources";
        //
        CharMatcher matcher = CharMatcher.is('?');
        Map<OutputFile, String> map = new HashMap<>(OutputFile.values().length);
        map.put(OutputFile.entity, matcher.replaceFrom(javaPath, "demo-entity"));
        map.put(OutputFile.mapper, matcher.replaceFrom(javaPath, "demo-entity"));
        map.put(OutputFile.service, matcher.replaceFrom(javaPath, "demo-facade"));
        map.put(OutputFile.serviceImpl, matcher.replaceFrom(javaPath, "demo-service"));
        map.put(OutputFile.controller, matcher.replaceFrom(javaPath, "demo-web"));

        map.put(OutputFile.mapperXml, matcher.replaceFrom(resourcePath, "demo-entity"));
        return map;
    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
