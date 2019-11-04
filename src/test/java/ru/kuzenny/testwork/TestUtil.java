package ru.kuzenny.testwork;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import ru.kuzenny.testwork.model.Order;
import ru.kuzenny.testwork.web.json.JsonUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class TestUtil {
    public static String getContent(MvcResult result) throws UnsupportedEncodingException {
        return result.getResponse().getContentAsString();
    }

    public static <T> T readFromJson(ResultActions action, Class<T> clazz) throws UnsupportedEncodingException {
        return JsonUtil.readValue(getContent(action.andReturn()), clazz);
    }

    public static <T> T readFromJsonMvcResult(MvcResult result, Class<T> clazz) throws UnsupportedEncodingException {
        return JsonUtil.readValue(getContent(result), clazz);
    }

    public static <T> List<T> readListFromJsonMvcResult(MvcResult result, Class<T> clazz) throws UnsupportedEncodingException {
        return JsonUtil.readValues(getContent(result), clazz);
    }

//    public static Order readFromJsonMvcResult(MvcResult result) throws UnsupportedEncodingException {
//        ObjectMapper mapper = new ObjectMapper();
//        Order order = null;
//        try {
////            order = mapper.readValue(getContent(result), Order.class);
//            String s =[{"id":18,"numberOrder":113,"email":"user3@yandex.ru","time":[2019,9,27,23,0], null}]
//            order = mapper.readValue(getContent(result), Order.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return order;
//        return JsonUtil.readValue(getContent(result), Order.class);
//    }
}
