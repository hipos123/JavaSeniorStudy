package com.yaoxj.jasypt;

public class EncryptorTest {

	public static void main(String[] args) {
		/*BasicTextEncryptor  encryptor= new BasicTextEncryptor();

	    //加密盐
	    encryptor.setPassword("kyd");
	    //用户名
	    String name = encryptor.encrypt("kyd");
	    //密码
	    String password = encryptor.encrypt("kyd");
	    System.out.println("name===="+name);
	    System.out.println("password===="+password);


	    System.out.println("decrypt name===="+ encryptor.decrypt(name));
	    System.out.println("decrypt password===="+ encryptor.decrypt(password));*/
		mytest();

	}

	static void mytest(){
		//加密工具

		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();

		//加密配置

		EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();

		config.setAlgorithm("PBEWithMD5AndDES");

		//PBEWithMD5AndTripleDES
		String salt="yllt";

		//生成秘钥的盐

		config.setPassword(salt);

		//应用配置

		encryptor.setConfig(config);

		//明文密码

		String plaintext=salt;

		//加密

		String ciphertext=encryptor.encrypt(plaintext);

		System.out.println(plaintext + " : " + ciphertext);

		//解密 过程

		String pText=encryptor.decrypt(ciphertext);

		System.out.println(ciphertext + " : " + pText);

		String temp2=encryptor.decrypt("soCMMYdN+i9YucFm8zeJ4w==");

		System.out.println("xxxx===" + " : " + temp2);


	}
}
