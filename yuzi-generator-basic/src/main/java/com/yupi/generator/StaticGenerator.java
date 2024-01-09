package com.yupi.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * @author 不是下雨天
 * @create 2024-01-09 14:17
 * @项目的名字: yuzi-generator
 */
public class StaticGenerator {
    public static void main(String[] args) throws IOException {
        String property = System.getProperty("user.dir");
        String inputPath = property + File.separator + "test" + File.separator + "acm-template";

        String outputPath = property + File.separator + "myacm";

        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
//        将文件夹进行拷贝
        copyFileByUseRecursive(inputFile, outputFile);

    }

    /**
     * @param inputPath  输入路径
     * @param outputPath 输出路径
     */
    public static void copyFileByUseHutool(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);

        FileUtil.copy(inputPath, outputPath, false);
    }

    public static void copyFileByUseRecursive(File inputFile, File outputFile) throws IOException {
        if (inputFile.isDirectory()) {
            System.out.println(inputFile.getName());
            File destOutputFile = new File(outputFile, inputFile.getName());
            if (!destOutputFile.exists()) {
                destOutputFile.mkdirs();
            }
            File[] listedFiles = inputFile.listFiles();
            if (ArrayUtil.isEmpty(listedFiles)) {
                return;
            }
            for (File listedFile : listedFiles) {
                copyFileByUseRecursive(listedFile, destOutputFile);
            }
        } else {
            Path resolve = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(), resolve, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
