package com.banana.basecode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSon {
	// 首先将文件转换为String类型
	public static String getFileString(String filename) {
		BufferedReader br = null;
		// if (file.exists())
		if (true) {
			try {
				br = new BufferedReader(new FileReader(filename));
				StringBuffer sb = new StringBuffer();
				String temp = "";
				while ((temp = br.readLine()) != null) {
					sb.append(temp);
				}
				return sb.toString().trim(); // 出去多余的空格
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "";
	}

	// 将文件转换为Map 类型
	public static Map<String, Object> getMap(String filename) {
		String jsonString = getFileString(filename);
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(jsonString);
			@SuppressWarnings("unchecked")
			Iterator<String> keyIter = jsonObject.keys();
			String key;
			Object value;
			Map<String, Object> valueMap = new HashMap<String, Object>();
			while (keyIter.hasNext()) {
				key = (String) keyIter.next();
				value = jsonObject.get(key);
				valueMap.put(key, value);
			}
			return valueMap;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 把json 转换为 ArrayList 形式
	public static List<Map<String, Object>> getList(String filename) {
		List<Map<String, Object>> list = null;
		try {
			String jsonString = getFileString(filename);
			JSONArray jsonArray = new JSONArray(jsonString);
			JSONObject jsonObject;
			list = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < jsonArray.length(); i++) {
				jsonObject = jsonArray.getJSONObject(i);
				list.add(getMap(jsonObject.toString()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
