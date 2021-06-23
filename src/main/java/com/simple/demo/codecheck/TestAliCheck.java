package com.simple.demo.codecheck;

import com.alibaba.fastjson.JSONArray;

/**
 * @Title:com.simple.demo.codecheck.TestAliCheck
 * @Auther: Charles Rao
 * @Date: 2020/05/31/10:56
 * @Description:
 */
public class TestAliCheck {

    public static void main(String[] args) {
        JSONArray array = new JSONArray();
        array = getNewJsonArray();
    }

    private static JSONArray getNewJsonArray() {
        return new JSONArray();
    }

}
