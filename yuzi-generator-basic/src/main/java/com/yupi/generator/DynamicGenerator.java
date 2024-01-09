package com.yupi.generator;

import com.yupi.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author 不是下雨天
 * @create 2024-01-09 16:14
 * @项目的名字: yuzi-generator-1
 */
public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {

        String systemPath = System.getProperty("user.dir") + File.separator + "yuzi-generator-basic";
//        得到模板生成器的路径
        String inputPath = systemPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
//        得到输出路径，将动态替换的内容进行输出
        String outputPath = System.getProperty("user.dir") + File.separator + "MainTemplate.java";


        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("bushi");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("输出结果是但是发生的: ");

        doGenerator(inputPath, outputPath, mainTemplateConfig);
    }

    public static void doGenerator(String inputPath, String outputPath, Object data) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);

        File templateDir = new File(inputPath).getParentFile();

        cfg.setDirectoryForTemplateLoading(templateDir);

        cfg.setDefaultEncoding("UTF-8");
        String templateName = new File(inputPath).getName();
        Template template = cfg.getTemplate(templateName);


        Writer writer = new FileWriter(outputPath);
        template.process(data, writer);
    }
}
