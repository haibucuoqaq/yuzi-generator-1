package com.yupi.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author 不是下雨天
 * @create 2024-01-09 15:56
 * @项目的名字: yuzi-generator-1
 */
public class TestFTL {
    @Test
    public void test_() throws IOException {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);

        cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        cfg.setDefaultEncoding("UTF-8");
        Template template = cfg.getTemplate("myweb.html.ftl");

    }
}
