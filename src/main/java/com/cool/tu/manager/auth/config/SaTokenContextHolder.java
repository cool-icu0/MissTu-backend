package com.cool.tu.manager.auth.config;

import java.util.HashMap;
import java.util.Map;

public class SaTokenContextHolder {
  
    private static final ThreadLocal<Map<String, Object>> CONTEXT = ThreadLocal.withInitial(HashMap::new);
  
    // 设置上下文数据  
    public static void set(String key, Object value) {  
        CONTEXT.get().put(key, value);  
    }  
  
    // 获取上下文数据  
    public static Object get(String key) {  
        return CONTEXT.get().get(key);  
    }  
  
    // 清理上下文数据（防止内存泄漏）  
    public static void clear() {  
        CONTEXT.remove();  
    }  
}