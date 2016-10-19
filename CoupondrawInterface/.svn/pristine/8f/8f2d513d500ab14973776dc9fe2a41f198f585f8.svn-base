package com.nnk.coupon.common;

import com.nnk.interfacetemplate.common.Hex;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/7/1
 * Time: 10:38
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */

public class Des3Utils {
    public static void main(String[] args) throws Exception {

        byte[] key = ("f510b8737344cddbca1c8564").getBytes();
        // byte[] keyiv = {0x66,0x6f,0x61,0x6f,0x63,0x75,0x65,0x6e};
        byte[] keyiv = "12345678".getBytes();

        System.out.println("\r\nkey.length:" + key.length);
        byte[] data = "中国ABCabc1234".getBytes("UTF-8");

        System.out.println("ECB加密解密");
        byte[] str3 = des3EncodeECB(key, data);
        byte[] str4 = des3DecodeECB(key, str3);
        System.out.println(new BASE64Encoder().encode(str3));
        System.out.println(new String(str4, "UTF-8"));
        System.out.println(Hex.encodeHex(str3));
        System.out.println("<=============>");

        System.out.println("CBC加密解密");
        byte[] str5 = des3EncodeCBC(key, keyiv, data);
        byte[] str6 = des3DecodeCBC(key, keyiv, str5);
        System.out.println(new BASE64Encoder().encode(str5));
        System.out.println(new String(str6, "UTF-8"));
        System.out.println(Hex.encodeHex(str5));

    }

    /**
     * ECB加密,不要IV
     *
     * @param key 密钥
     * @param data 明文
     * @return Base64编码的密文
     * @throws Exception
     */
    public static byte[] des3EncodeECB(byte[] key, byte[] data)
            throws Exception {

        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(key);
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);

        Cipher cipher = Cipher.getInstance("desede" + "/ECB/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, deskey);
        byte[] bOut = cipher.doFinal(data);

        return bOut;
    }

    /**
     * ECB解密,不要IV
     *
     * @param key 密钥
     * @param data Base64编码的密文
     * @return 明文
     * @throws Exception
     */
    public static byte[] des3DecodeECB(byte[] key, byte[] data)
            throws Exception {

        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(key);
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);

        Cipher cipher = Cipher.getInstance("desede" + "/ECB/PKCS5Padding");

        cipher.init(Cipher.DECRYPT_MODE, deskey);

        byte[] bOut = cipher.doFinal(data);

        return bOut;

    }

    /**
     * CBC加密
     *
     * @param key 密钥
     * @param keyiv IV
     * @param data 明文
     * @return Base64编码的密文
     * @throws Exception
     */
    public static byte[] des3EncodeCBC(byte[] key, byte[] keyiv, byte[] data)
            throws Exception {

        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(key);
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);

        Cipher cipher = Cipher.getInstance("desede" + "/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(keyiv);
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
        byte[] bOut = cipher.doFinal(data);

        return bOut;
    }

    /**
     * CBC解密
     *
     * @param key 密钥
     * @param keyiv IV
     * @param data Base64编码的密文
     * @return 明文
     * @throws Exception
     */
    public static byte[] des3DecodeCBC(byte[] key, byte[] keyiv, byte[] data)
            throws Exception {

        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(key);
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);

        Cipher cipher = Cipher.getInstance("desede" + "/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(keyiv);

        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);

        byte[] bOut = cipher.doFinal(data);

        return bOut;

    }

    /**
     *
     * @param key 密码
     * @param keyiv 偏移量
     * @param data 加密串
     * @return 原字符串
     * @throws Exception
     */
    public static String des3DecodeCBCtoString(byte[] key, byte[] keyiv, byte[] data) throws Exception {
        byte[] bOut = des3DecodeCBC(key, keyiv, data);
        return new String(bOut);
    }

    /**
     *
     * @param key 密码
     * @param keyiv 偏移量
     * @param data 原字符串
     * @return 16进制编码的加密字符串
     * @throws Exception
     */
    public static String des3EncodeCBCtoString(byte[] key, byte[] keyiv, byte[] data) throws Exception {
        byte[] bOut = des3EncodeCBC(key, keyiv, data);
        return Hex.encodeHexStr(bOut);
    }



    /**
     *
     * @param key 密码
     * @param data 加密串
     * @return 原字符串
     * @throws Exception
     */
    public static String des3DecodeEBCtoString(byte[] key, byte[] data) throws Exception {
        byte[] bOut = des3DecodeECB(key,data);
        return new String(bOut);
    }

    /**
     *
     * @param key 密码
     * @param data 原字符串
     * @return 16进制编码的加密字符串
     * @throws Exception
     */
    public static String des3EncodeECBtoString(byte[] key ,byte[] data) throws Exception {
        byte[] bOut = des3EncodeECB(key, data);
        return Hex.encodeHexStr(bOut);
    }

    /**
     *
     * @param key 加密key
     * @param data 16进制的加密串
     * @return 原始数据串
     * @throws Exception
     */
    public static String des3DecodeECBtoString(String key,String data) throws Exception {
        byte[] bytekey = key.getBytes();
        char[] des = new char[data.length()];
        data.getChars(0,data.length(),des,0);
        byte[] datas = Hex.decodeHex(des);
        return des3DecodeEBCtoString(bytekey,datas);
    }

    /**
     *
     * @param key 加密串
     * @param data 原始数据串
     * @return 16进制编码的加密串
     * @throws Exception
     */
    public static String des3EncodeECBtoString(String key ,String data) throws Exception {
        byte[] bytekey = key.getBytes();
        byte[] datas = data.getBytes();
        byte[] bOut = des3EncodeECB(bytekey, datas);
        return Hex.encodeHexStr(bOut);
    }


    /**
     *
     * @param key 密码
     * @param keyiv 偏移量
     * @param data  16进制编码的加密串
     * @return 原字符串
     * @throws Exception
     */
    public static String des3DecodeCBCtoString(String key, String keyiv, String data) throws Exception {
        byte[] bytekey = key.getBytes();
        byte[] bytetKeyIv = keyiv.getBytes();
        char[] des = new char[data.length()];
        data.getChars(0,data.length(),des,0);
        byte[] datas = Hex.decodeHex(des);
        byte[] bOut = des3DecodeCBC(bytekey, bytetKeyIv, datas);
        return new String(bOut);
    }

    /**
     *
     * @param key 密码
     * @param keyiv 偏移量
     * @param data 原字符串
     * @return 16进制编码的加密字符串
     * @throws Exception
     */
    public static String des3EncodeCBCtoString(String  key, String keyiv, String data) throws Exception {
        byte[] bytekey = key.getBytes();
        byte[] bytetKeyIv = keyiv.getBytes();
        byte[] datas = data.getBytes();
        byte[] bOut = des3EncodeCBC(bytekey, bytetKeyIv, datas);
        return Hex.encodeHexStr(bOut);
    }

}
