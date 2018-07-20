package com.ypp.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class webUtil {
/**
 *   -1：验证邮箱格式
 *    -2：验证手机格式
 *    -3：密码规则校验 (不能 少于 6位， 至少 包含字母，特殊符号)
 */
//验证邮箱格式
  public static boolean emailFormat(String email){

                boolean tag = true;
                 final String pattern1 = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
                 final Pattern pattern = Pattern.compile(pattern1);
                 final Matcher mat = pattern.matcher(email);
                 if (!mat.find()) {
                        tag = false;
                    }
                 return tag;
            }
//验证手机格式
   public static boolean isMobile(String str) {
              Pattern p = null;
              Matcher m = null;
              boolean b = false;
              p = Pattern.compile("^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$"); // 验证手机号
              m = p.matcher(str);
              b = m.matches();
              return b;
  }
  //验证密码格式
  public static  boolean isPwd(String str){
      Pattern p = null;
      Matcher m = null;
      boolean b = false;
      String reg = "^(?![0-9A-Za-z]+$){6,}$";
      p = Pattern.compile(reg);
      m = p.matcher(str);
      b = m.matches();
      return b;
  }
}
