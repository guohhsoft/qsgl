package czxy.qsgl.util;


import java.security.MessageDigest;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class NoteUtil {
//	//对密码进行加密的方法
//	public static String md5(String src){
//		try {
//			//  进行加密处理
//			MessageDigest md=MessageDigest.getInstance("MD5");
//			byte[] output = md.digest(src.getBytes());
//			/*
//			 *   base64处理  将字节转换成字符串处理
//			 *   52个英文字母(大小写) + 10个数字(0~9) +(=，+)
//			 */
//			String ret = Base64.encodeBase64String(output);
//			return ret;
//		} catch (Exception e) {
//			return null;
//		}
//		
//	}
	//生成数据库的主键(id)
	public static String createId(){
		//使用UUID算法
		UUID uuid = UUID.randomUUID();
		String id =uuid.toString();
		
		return id.replace("-", "");
	}
	public static void main(String[] args) {
		//System.out.println(md5("123"));
		System.out.println(createId());
		//System.out.println(md5(createId()).length());
	}
}
