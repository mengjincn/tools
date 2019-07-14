package com.github.mengjincn.tools.service;

import org.springframework.stereotype.Service;

@Service
public class PropertiesService {
    public String getSystemProperty(String env){
        return System.getProperty(env);
    }
}
