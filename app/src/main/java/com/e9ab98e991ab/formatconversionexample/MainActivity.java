package com.e9ab98e991ab.formatconversionexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.e9ab98e991ab.formatconversionexample.databinding.ActivityMainBinding;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity  {

    ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

    }

    /*****
     * Gson
     * @param v
     */
    Gson gson = new Gson();
    public void onGsonBeanToJson(View v) {
        mBinding.textView.setText(gson.toJson(new Bean()));
    }
    public void onGsonJsonTobean(View v) {
        Bean b = gson.fromJson(gson.toJson(new Bean()),Bean.class);
        mBinding.textView.setText(b.toString());
    }
    public void onGsonMapToJson(View v) {
        String j = gson.toJson(new Bean());
        Map<String, Object> map = gson.fromJson(j,new TypeToken<Map<String, Object>>() {}.getType());
        mBinding.textView.setText(gson.toJson(map));
    }
    public void onGsonJsonToMap(View v) {
        String j = gson.toJson(new Bean());
        Map<String, Object> map = gson.fromJson(j,new TypeToken<Map<String, Object>>() {}.getType());
        mBinding.textView.setText(map.toString());
    }
    public void onGsonFromListJson(View view) {
        List<Bean> list = new ArrayList<>();
        list.add(new Bean());
        mBinding.textView.setText(gson.toJson(list));
    }
    public void onGsonFromJsonList(View view) {
        List<Bean> list = new ArrayList<>();
        list.add(new Bean());
        mBinding.textView.setText(gson.fromJson(gson.toJson(list),new TypeToken<List<Bean>>(){}.getType()).toString());
    }
    /*****
     * FastJson
     */
    public void onFastBeanToJson(View v) {
        mBinding.textView.setText(JSON.toJSONString(new Bean()));
    }
    public void onFastJsonTobean(View v) {
        Bean b = JSON.parseObject(JSON.toJSONString(new Bean()),Bean.class);
        mBinding.textView.setText(b.toString());
    }
    public void onFastMapToJson(View view) {
        JSONObject  jsonObject = JSONObject.parseObject(JSON.toJSONString(new Bean()));
        Map<String,Object> map = (Map<String,Object>)jsonObject;
        mBinding.textView.setText(JSON.toJSONString(map));
    }

    public void onFastJsonToMap(View view) {
        JSONObject  jsonObject = JSONObject.parseObject(JSON.toJSONString(new Bean()));
        Map<String,Object> map = (Map<String,Object>)jsonObject;
        Object object = map.get("array");
        mBinding.textView.setText("从Map取array"+object);

    }
    public void onFastListtoJson(View view) {
        List<Bean> list = new ArrayList<>();
        list.add(new Bean());
        list.add(new Bean());
        mBinding.textView.setText(JSON.toJSONString(list));
    }
    public void onFastJsonToList(View view) {
        List<Bean> list = new ArrayList<>();
        list.add(new Bean());
        list.add(new Bean());
        String json = JSON.toJSONString(list);
        mBinding.textView.setText(JSON.parseArray(json,Bean.class).toString());
    }
    /*****
     * JackJson
     */

    private static ObjectMapper MAPPER = new ObjectMapper();
    public void onJackBeanToJson(View v) throws JsonProcessingException {
        mBinding.textView.setText(MAPPER.writeValueAsString(new Bean()));
    }
    public void onJackJsonTobean(View v) throws JsonProcessingException {
        String json =  MAPPER.writeValueAsString(new Bean());
        mBinding.textView.setText(MAPPER.readValue(json, Bean.class).toString());
    }
    public void onJackMapToJson(View v) throws JsonProcessingException {
        String json =  MAPPER.writeValueAsString(new Bean());
        Map urMap = MAPPER.readValue(json,Map.class);
        mBinding.textView.setText(MAPPER.writeValueAsString(urMap));
    }

    public void onJackJsonToMap(View v) throws JsonProcessingException {
        String json =  MAPPER.writeValueAsString(new Bean());
        Map urMap = MAPPER.readValue(json,Map.class);
        mBinding.textView.setText(urMap.toString());
    }
    public void onJackListtoJson(View view) throws JsonProcessingException {
        List<Bean> list = new ArrayList<>();
        list.add(new Bean());
        list.add(new Bean());
        String ljson = MAPPER.writeValueAsString(list);
        mBinding.textView.setText(ljson);
    }
    public void onJackJsonToList(View view) throws JsonProcessingException {
        List<Bean> list = new ArrayList<>();
        list.add(new Bean());
        list.add(new Bean());
        String ljson = MAPPER.writeValueAsString(list);
        mBinding.textView.setText(MAPPER.readValue(ljson, ArrayList.class).toString());
    }


    
}