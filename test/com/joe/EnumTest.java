package com.joe;

import com.oracle.dcompile.Week;
import org.junit.Test;

public class EnumTest {
    @Test
    public void enumTest() {
        System.out.println(Week.MON);// [枚举类名.枚举常量] 会返回一个该枚举类的枚举对象
        System.out.println(Week.MON.toString());// toString()方法可以返回该枚举对象的全部信息(名，序号等)的String形式
        System.out.println(Week.SAT.name());// name()方法可以返回该枚举对象的名字
        System.out.println(Week.FRI.ordinal());// 获取枚举对象的序号(从0开始)
        System.out.println(Week.TUE.compareTo(Week.THU));// 返回两个枚举对象的序号(ordinal)差

        // 遍历枚举数组
        Week[] week = Week.values();
        for (Week e : week) {
            System.out.print(e.toString() + "\t");
        }

    }
}
