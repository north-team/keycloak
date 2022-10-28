package org.keycloak.utils;

import com.google.common.base.Charsets;

import java.io.*;
import java.util.Optional;
import java.util.Properties;

public class F2CProperties {
    private static final Properties properties;
    private static String defaultProperties = "/opt/fit2cloud/conf/fit2cloud.properties";

    static {
            properties = new Properties();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                new FileInputStream(defaultProperties), Charsets.UTF_8))) {
            properties.load(bufferedReader);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getString(String key){

        Optional<Object> o = Optional.ofNullable(properties.get(key));
        if(o.isPresent()){
            return o.get().toString().trim();
        }
        return "";
    }

}
