package com.yupi;

import com.yupi.cli.command.CommandExecutor;

/**
 * @author 不是下雨天
 * @create 2024-01-09 15:35
 * @项目的名字: Default (Template) Project
 */
public class Main {
    public static void main(String[] args) {
        //        args = new String[]{""};
//        args = new String[]{"config"};
//        args = new String[]{"gen","-l","-a","-o"};
//        args = new String[]{"gen","-a"};
        CommandExecutor commandExecutor  =new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}