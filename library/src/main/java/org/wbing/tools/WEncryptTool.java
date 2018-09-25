package org.wbing.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

/**
 * @author wangbing
 * @date 2018/9/25
 */
public class WEncryptTool {
    //  -------------- md5 -------

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

    private static String toHexStr(byte[] bytes) {
        StringBuilder md5sb = new StringBuilder();
        for (byte b : bytes) {
            // details refer to:
            // 1. http://www.avajava.com/tutorials/lessons/how-do-i-generate-an-md5-digest-for-a-string.html
            // 2. http://stackoverflow.com/questions/2817752/java-code-to-convert-byte-to-hexadecimal
            md5sb.append(String.format("%02x", b & 0xff));
        }
        return md5sb.toString();
    }

    public String fileToMD5(File file) {
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
}
