package com.recruitment.util;

import java.util.HashMap;

/**
 * @author mike_yi
 *  数据字典
 */
public class DictionaryUtil {
  public static HashMap<String,String> dicMap;
  
  //初始化字典
  static{
	  dicMap = new HashMap<String,String>();
	  dicMap.put("", "");
  }
}
