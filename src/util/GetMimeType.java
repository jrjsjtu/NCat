package util;

import java.util.HashMap;

/**
 * Created by jrj on 17-3-27.
 */
public class GetMimeType {
    static HashMap<String,String> mime_type = new HashMap<String,String>();
    static{
        mime_type.put("css","text/css; charset=utf-8");
        mime_type.put("js","text/html; charset=utf-8");
        mime_type.put("html","text/html; charset=utf-8");
        mime_type.put("woff2","application/x-font-woff");
    }
    public static String get_mime_type(String file_path){
        int index = file_path.lastIndexOf(".");
        String result = file_path.substring(index+1,file_path.length());
        return result!=null?result:"text/html; charset=utf-8";
    }
}
