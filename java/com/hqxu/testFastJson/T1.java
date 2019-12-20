package com.hqxu.testFastJson;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

class VO {
    
    private String name;
    private List<String> item;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getItem() {
        return item;
    }
    public void setItem(List<String> item) {
        this.item = item;
    }
    @Override
    public String toString() {
        return "VO [name=" + name + ", item=" + item + "]";
    }
    
}

public class T1 {

	
	public static void main(String[] args) {
	
		String json = "[{name:\"hqxu\"},{age:17},{color:[{hhh:3,bbb:5}]},[{kkk:1,lll:[{ksks:0}]},{efe:\"yyr34\"}]]";
		//String json1="[[{name:[{name:444}]},{age:3}],[{class:21},{student:45}]]";

		parseJSONString(json);
		
		String jsonString = "{name:\"hqxu\",item:[]}";
		VO a = JSON.parseObject(jsonString, VO.class);
		for (String r: a.getItem()) {
		    System.out.println(r);
		}
		System.out.println(a);
		
	}
	
	
	//jsonString 是 array 
	public static void parseJSONString(String json)
	{
		JSONArray  jsonArray = JSON.parseArray(json);
		
		for(int i = 0; i < jsonArray.size(); i++){
			try
			{
				JSONObject jsonObject = jsonArray.getJSONObject(i);	//如果是JSONArray抛出异常
				for(String str:jsonObject.keySet()){
					
					String json2 = jsonObject.get(str).toString();
					
					//System.out.println(str + ":" +jsonObject.get(str));
					
					//1.如果value是一个JSONArray
					if(isJSONArray(json2))
					{
						//迭代
						parseJSONString(json2);
					}
					else
					{
						System.out.println(str + ":" +jsonObject.get(str));
					}

					
				}
			}
			catch(Exception e)
			{
				//2.如果JSONArray的元素是一个JSONArray
				JSONArray jsonArray1 = jsonArray.getJSONArray(i);
				String json1 = jsonArray1.toJSONString();
				//System.out.println("json1"+json1);
				
				//迭代
				parseJSONString(json1);
			}
		}
	}
	
	
	
	
	public static boolean isJSONArray(String json)
	{
		try
		{
			JSONArray jsonArray = JSON.parseArray(json);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public static boolean isJSONObject(String json)
	{
		try
		{
			JSONObject jsonObject = JSON.parseObject(json);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	
}
