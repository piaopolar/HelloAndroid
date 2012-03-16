package com.banana.basecode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class JSon {

	static private Context m_context;

	public static void SetContext(Context context) {
		m_context = context;
	}

	// 首先将文件转换为String类型
	public static String getFileString(String filename) {
		BufferedReader br = null;
		// if (file.exists())
		if (true) {
			try {

				InputStream in = m_context.getResources().getAssets()
						.open(filename);

				// \Test\assets\yan.txt这里有这样的文件存在

				InputStreamReader is = new InputStreamReader(in);
				br = new BufferedReader(is);
				String read = br.readLine();
				StringBuffer sb = new StringBuffer();
				sb.append(read);

				while (read != null) {
					// System.out.println(read);
					read = br.readLine();
					sb.append(read);
				}

				return sb.toString();
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

	// 把json 转换为 ArrayList 形式
	public static ArrayList<Map<String, Object>> getArrayList(String filename) {
		ArrayList<Map<String, Object>> list = null;
		try {
			String jsonString = getFileString(filename);
			System.out.print(jsonString);
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
