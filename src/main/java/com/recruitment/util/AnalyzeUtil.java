package com.recruitment.util;

import java.util.HashMap;
import java.util.Set;

/**
 * @author mike_yi
 *
 */
public class AnalyzeUtil {
   /**
	 * 
	 * @param dictionaryMap 字典集
	 * @param contentStr  目标文本
	 * @param regx 字典间隔
	 * @param kind 分析结果类型
	 * @return
	 */
  static String baseAnaly(HashMap<String,String>dictionaryMap,String contentStr,String regx,int kind){
	  Set<String> dictionaryKey= dictionaryMap.keySet();
	  for(String key : dictionaryKey){
		  String [] dictionary= contentStr.split(regx);
		  for(int i=0;i<dictionary.length;i++){
			  if(contentStr.contains(dictionary[i])){
				  if(kind==0){
					  return key;
				  }else if(kind==1){
					  return null;
				  }else if(kind==2){
					  
				  }
			  }
		  }
	  }
	  return "未详";
  } 
}
