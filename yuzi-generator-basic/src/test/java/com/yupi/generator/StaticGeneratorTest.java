package com.yupi.generator;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 不是下雨天
 * @create 2024-01-09 15:54
 * @项目的名字: yuzi-generator-1
 */
public class StaticGeneratorTest extends TestCase {
    @Test
    public void test_() {
        List<String> strings = new ArrayList<String>();
        strings.add("aa");
        strings.add("cc");
        strings.add("dd");
        strings.add("aff");
        System.out.println(String.valueOf(strings));
    }
}