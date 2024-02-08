package com.ztuo;

import org.web3j.utils.Numeric;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        String hexValue = "0x58be9f2ffab3a287433a0b7bb34d2b225740cfb6";
        //Numeric.toBigInt(hexValue);
        BigInteger tem = Numeric.toBigInt(hexValue);
        System.out.println("Hello: " + tem);
    }
}
