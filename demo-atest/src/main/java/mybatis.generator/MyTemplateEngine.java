package mybatis.generator;

import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.util.Map;

public class MyTemplateEngine extends VelocityTemplateEngine {

    final Joiner joiner = Joiner.on(File.separator);
    final CharMatcher matcher = CharMatcher.is('.');

    @Override
    protected void outputFile(File file, Map<String, Object> objectMap, String templatePath) {
        super.outputFile(file, objectMap, templatePath);
        System.out.println(file.getPath());
    }

    @Override
    protected String getPathInfo(OutputFile outputFile) {
        String path = getConfigBuilder().getPathInfo().get(outputFile);
        PackageConfig packageConfig = getConfigBuilder().getPackageConfig();
        return matcher.replaceFrom(joiner.join(path, packageConfig.getPackageInfo().get(map.get(outputFile.ordinal()))), File.separator);
    }

    private static Map<Integer, String> map =
            ImmutableMap.<Integer, String>builder().put(OutputFile.entity.ordinal(), ConstVal.ENTITY)
            .put(OutputFile.mapper.ordinal(), ConstVal.MAPPER)
            .put(OutputFile.mapperXml.ordinal(), ConstVal.XML)
            .put(OutputFile.service.ordinal(), ConstVal.SERVICE)
            .put(OutputFile.serviceImpl.ordinal(), ConstVal.SERVICE_IMPL)
            .put(OutputFile.controller.ordinal(), ConstVal.CONTROLLER)
            .put(OutputFile.other.ordinal(), ConstVal.OTHER)
            .build();
}
