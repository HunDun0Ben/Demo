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
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class MyGenerator {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC",
                username = "root",
                pwd = "root";

        String basePath = "E:/workspace/project/demo";

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
                .packageConfig((scanner, builder) -> {
                    String module = scanner.apply("请输入模块名:");
                    String base = "com.hundun.demo";
                    // String base = scanner.apply("请输入模块名:");
                    builder
                            // 基础包名
                            .parent(base)
                            // 设置模块名称·
                            .moduleName(module)
                            .entity("entity")
                            .mapper("mapper")
                            .xml("mapper.xml")
                            .service("service.facade")
                            .serviceImpl("service.facade.impl")
                            .controller("web.controller")
                            .other("other")
                            .pathInfo(getPathInfo(base, module));
                })
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .controllerBuilder()
                            .enableRestStyle()
                            .enableHyphenStyle()
                        .entityBuilder()
                            .enableLombok()
                            .addTableFills(new Column("create_time", FieldFill.INSERT))
                        .build())
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

    protected static Map<OutputFile, String> getPathInfo(String base, String module) {
        //
        CharMatcher matcher = CharMatcher.is('?');
        Map<OutputFile, String> map = new HashMap<>(OutputFile.values().length);
        map.put(OutputFile.entity, replaceJavaPath(OutputFile.entity, base, module));
        map.put(OutputFile.mapper, replaceJavaPath(OutputFile.entity, base, module));
        map.put(OutputFile.service, replaceJavaPath(OutputFile.entity, base, module));
        map.put(OutputFile.serviceImpl, replaceJavaPath(OutputFile.entity, base, module));
        map.put(OutputFile.controller, replaceJavaPath(OutputFile.entity, base, module));

        map.put(OutputFile.mapperXml, replaceResource(OutputFile.entity, module));
        return map;
    }

    protected static String replaceJavaPath(OutputFile file, String base, String module) {
        String javaPath = "E:/workspace/project/demo/{project}/src/main/java{base}{type}{module}";
        String type = StringUtils.isBlank(map.get(file)) ? "" : "/" + map.get(file);
        base = StringUtils.isBlank(base) ? "" : "/" + base;
        module = StringUtils.isBlank(module) ? "" : "/" + module;
        return javaPath.replace("{project}",projectMap.get(file))
                .replace("{base}", base)
                .replace("{type}", type)
                .replace("{module}", module)
                .replaceAll("\\.", "/");
    }

    protected static String replaceResource(OutputFile file, String module){
        String resourcePath = "E:/workspace/project/demo/{project}/src/main/resources{type}{module}";
        String type = StringUtils.isBlank(map.get(file)) ? "" : "/" + map.get(file);
        module = StringUtils.isBlank(module) ? "" : "/" + module;
        return resourcePath.replace("{project}",projectMap.get(file))
                .replace("{type}", type)
                .replace("{module}", module)
                .replaceAll("\\.", "/");
    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

    private static final Map<OutputFile, String> projectMap =
            ImmutableMap.<OutputFile, String>builder()
                    .put(OutputFile.entity, "demo-entity")
                    .put(OutputFile.mapper, "demo-entity")
                    .put(OutputFile.mapperXml, "demo-entity")
                    .put(OutputFile.service, "demo-facade")
                    .put(OutputFile.serviceImpl, "demo-service")
                    .put(OutputFile.controller, "demo-web")
                    .build();

    private static final Map<OutputFile, String> map =
            ImmutableMap.<OutputFile, String>builder()
                    .put(OutputFile.entity, "entity")
                    .put(OutputFile.mapper, "mapper")
                    .put(OutputFile.mapperXml, "mapper.xml")
                    .put(OutputFile.service, "service.facade")
                    .put(OutputFile.serviceImpl, "service.facade.impl")
                    .put(OutputFile.controller, "web.controller")
                    .put(OutputFile.other, "other")
                    .build();

}
