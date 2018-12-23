package org.blackist.common.util.format.date;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * @author LiangLiang.Dong[liangl.dong@gmail.com]
 * @since 2018/12/12
 */

public class DateSerializer implements JsonSerializer<Date> {

    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getTime());
    }
}
