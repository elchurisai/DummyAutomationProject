package com.prolian.test.framework.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {

    private static final String fs = File.separator;

    private static final String RESOURCEPATH = System.getProperty("user.dir")+ fs + "src" + fs + "test" + fs + "resources" + fs + "data" + fs;

    public List<Products> loadProducts(String  fileName) throws IOException , ParseException {

        List<Products> products = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();
        JSONArray productList = (JSONArray) jsonParser.parse(new FileReader(getResourcePath(fileName)));
        for (Object obj : productList) {
            JSONObject product = (JSONObject) obj;
            Gson gson = new GsonBuilder().create();
            products.add(gson.fromJson(product.toJSONString(),Products.class));
        }
        return products;

    }

    private String getResourcePath(String fileName) {
        String path;

        if (fileName.contains("products")) {
        path = RESOURCEPATH+fileName;
        }
        else {
            path ="";
        }

        return path;
    }

}
