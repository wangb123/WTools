package org.wbing.tools;

import android.util.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * @author wangbing
 * @date 2018/9/25
 */
public class WEncryptTool {


    //  -------------- md5 -------

    /**
     * 将二进制转换成16进制
     */
    private static String toHexStr(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            // details refer to:
            // 1. http://www.avajava.com/tutorials/lessons/how-do-i-generate-an-md5-digest-for-a-string.html
            // 2. http://stackoverflow.com/questions/2817752/java-code-to-convert-byte-to-hexadecimal
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }


    public static String strToMD5(String str) {
        return strToMD5(str, "UTF-8");
    }

    public static String strToMD5(String str, String encoding) {
        if (str == null) {
            return "";
        }
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes(encoding));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return toHexStr(messageDigest.digest());
    }

    public static String fileToMD5(File file) {
        if (file == null || !file.isFile()) {
            return "";
        }
        MessageDigest messageDigest = null;
        InputStream fis = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int numRead;
            while ((numRead = fis.read(buffer)) > 0) {
                messageDigest.update(buffer, 0, numRead);
            }
            return toHexStr(messageDigest.digest());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    // intentional ignore
                }
            }
        }
        return "";
    }

    //!!  -------------- md5 -------


    //  -------------- des -------

    /**
     * 加密
     *
     * @param srcStr
     * @param key
     * @return
     */
    public static String encryptDES(String srcStr, String key) {
        byte[] src = srcStr.getBytes();
        byte[] buf;
        try {
            buf = Des.encrypt(src, key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new String(Base64.encode(buf, Base64.DEFAULT));

    }

    /**
     * 解密
     *
     * @param hexStr
     * @param key
     * @return
     */
    public static String decryptDES(String hexStr, String key) {
        byte[] src = Base64.decode(hexStr.getBytes(), Base64.DEFAULT);
        byte[] buf;
        try {
            buf = Des.decrypt(src, key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new String(buf);
    }

    private static class Des {
        private final static String DES = "DES";

        /**
         * 加密
         *
         * @param data
         * @param sKey
         * @return
         */
        static byte[] encrypt(byte[] data, String sKey) throws Exception {
            byte[] key = sKey.getBytes();
            // 生成一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(key);
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成secretKey
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            SecretKey secretKey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance(DES);
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, sr);
            // 现在，获取数据并加密
            // 正式执行加密操作
            return cipher.doFinal(data);
        }

        /**
         * 解密
         *
         * @param src
         * @param sKey
         * @return
         * @throws Exception
         */
        static byte[] decrypt(byte[] src, String sKey) throws Exception {
            byte[] key = sKey.getBytes();
            // 生成一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(key);
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey secretKey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance(DES);
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, secretKey, sr);
            // 真正开始解密操作
            return cipher.doFinal(src);
        }

    }

    //!!  -------------- des -------
}
