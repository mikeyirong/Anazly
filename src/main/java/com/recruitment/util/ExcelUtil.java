package com.recruitment.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author mike_yi
 * excel工具类
 */
public class ExcelUtil {
	public static <T> List<T> getBean(InputStream excel, Class<T> tClass, String[] cellKey)
			throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException{
		// 创建实体类对象容器
		List<T> beanList = new ArrayList<T>();
		// 读取excel文件
		XSSFWorkbook xlsFile = new XSSFWorkbook(excel);
		XSSFSheet sheet = xlsFile.getSheetAt(0);
		// 判断属性列表同excel文件列是否相符，避免数组范围溢出
		if (cellKey.length != sheet.getRow(0).getLastCellNum()) {
			throw new RuntimeException("传入列名参数不符合条件！");
		}
		// 创建属性map
		HashMap<String, String> valueMap = new HashMap<String, String>();
		// 遍历excel文件
		for (Row row : sheet) {
			for (int i = 0; i < cellKey.length; i++) {
			  row.getCell(i).setCellType(Cell.CELL_TYPE_STRING); 
			  valueMap.put(cellKey[i], row.getCell(i).getStringCellValue());
			}
			T t = tClass.newInstance();
			// 使用BeanUtils将封装的属性注入对象
			BeanUtils.populate(t, valueMap);
			// 将对象添加至容器
			beanList.add(t);
		}
	  return null;
  }
}
