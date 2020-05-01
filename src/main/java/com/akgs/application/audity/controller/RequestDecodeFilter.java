package com.akgs.application.audity.controller;

import com.akgs.application.audity.utility.MyRequestWrapper;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestDecodeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        MyRequestWrapper requestWrapper = new MyRequestWrapper(request);
        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(requestWrapper.getBody());
        JsonNode root = mapper.readTree(parser);
        Map requestBodyMap = mapper.convertValue(root, Map.class);
        if(requestBodyMap != null){
            for(Object o : requestBodyMap.entrySet()) {
                Object obj = ((Map.Entry) o).getValue();
                if(obj instanceof String){
                    ((Map.Entry)o).setValue(java.net.URLDecoder.decode((String)obj, StandardCharsets.UTF_8.name()));
                }
                else if(obj instanceof ArrayList){
                    ArrayList list = (ArrayList) obj;
                    ArrayList<String> resList = new ArrayList<>();
                    for(Object s : list){
                        resList.add(java.net.URLDecoder.decode((String)s, StandardCharsets.UTF_8.name()));
                    };
                    ((Map.Entry)o).setValue(resList);
                }
            }
        }
        JsonNode modifiedJson = mapper.valueToTree(requestBodyMap);
        System.out.println("modifiedJson.toString() = " + modifiedJson.toString());
        requestWrapper.setBody(modifiedJson.toString());
        chain.doFilter(requestWrapper, response);
    }
}
