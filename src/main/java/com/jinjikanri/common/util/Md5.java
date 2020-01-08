package com.jinjikanri.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Md5加密
 * @author caichunyu
 *
 */
public class Md5 {
	/**
	 * 加密方法
	 * @param password
	 * @param loginName
	 * @return
	 */
	public static String encode(String password, String loginName) {
		try {
			String hashAlgorithmName = "Md5";
			String credentials = password;
			int hashIterations = 1024;
			ByteSource credentialsSalt = ByteSource.Util.bytes(loginName);
			Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
			return obj.toString();
		} catch (Exception e) {
			return null;
		}
	}
}
