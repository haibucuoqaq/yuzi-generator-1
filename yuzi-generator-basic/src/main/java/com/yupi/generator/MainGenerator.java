package com.yupi.generator;

import com.yupi.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @author 不是下雨天
 * @create 2024-01-09 16:44
 * @项目的名字: yuzi-generator-1
 */
public class MainGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
//        1 静态文件的生成
        String property = System.getProperty("user.dir");
        String inputPath = property + File.separator + "test" + File.separator + "acm-template";

        String outputPath = property + File.separator + "myacm";

        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
//        将文件夹进行拷贝
        StaticGenerator.copyFileByUseRecursive(inputFile, outputFile);
//        2 动态文件的生成
        String systemPath = System.getProperty("user.dir") + File.separator + "yuzi-generator-basic";
//        得到模板生成器的路径
        String templatePath = systemPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
//        得到输出路径，将动态替换的内容进行输出
        String doutputPath = outputPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";
//
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("bushi");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("输出结果是但是发生的: ");

        DynamicGenerator.doGenerator(templatePath, doutputPath, mainTemplateConfig);

    }
//   以上使用Main方法，生成代码
}
