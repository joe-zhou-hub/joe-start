package com.joe.bin;

import org.junit.Test;

public class BinTest {

    @Test
    public void toBinaryStringTest() {
        // Integer.toBinaryString 打印对应数字的二进制形式
        //System.out.println(Integer.toBinaryString(4));// 100
        System.out.println(Integer.toBinaryString(-4));// 11111111 11111111 11111111 11111100
    }

    @Test
    public void aTest() {
        // 数值溢出的时候 现象 物极必反
        int num = 2147483647;
        int num2 = 2147483647 + 1;
        System.out.println(num2);
    }

    @Test
    public void andTest() {
        // 原理：相同为0 不同为1
        int a = 1;
        int b = 2;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

}
