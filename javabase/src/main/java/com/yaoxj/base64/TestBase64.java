package com.yaoxj.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class TestBase64 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		final Base64.Decoder decoder = Base64.getDecoder();
		final Base64.Encoder encoder = Base64.getEncoder();
		final String text = "SampleClientId:tgb.258";
		final byte[] textByte = text.getBytes("UTF-8");
		final String text2 = "cloudjee:cloudjee";
		final byte[] textByte2 = text2.getBytes("UTF-8");
		//±àÂë 
		final String encodedText = encoder.encodeToString(textByte);
		final String encodedText2 = encoder.encodeToString(textByte2);
		System.out.println(encodedText);
		System.out.println(encodedText2);
		//½âÂë
		System.out.println(new String(decoder.decode("U2FtcGxlQ2xpZW50SWQ6dGdiLjI1ODEyMw=="), "UTF-8"));
		System.out.println(new String(decoder.decode(encodedText2), "UTF-8"));
		
		
//		System.out.println(encoder.encodeToString("tgb.258".getBytes("UTF-8")));
	}
}
