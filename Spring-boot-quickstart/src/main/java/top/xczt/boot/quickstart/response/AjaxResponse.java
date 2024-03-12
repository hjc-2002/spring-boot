package top.xczt.boot.quickstart.response;

import lombok.Data;

@Data
public class AjaxResponse {
    private boolean isok;
    private int code;
    private String message;
    private Object data;

    private AjaxResponse(){
    }

    public static AjaxResponse success(){
        AjaxResponse ajaxResponse=new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功！");
        return ajaxResponse;
    }

    public static AjaxResponse success(Object obj){
        AjaxResponse ajaxResponse=new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功！");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }

    public static AjaxResponse success(Object obj,String message){
        AjaxResponse ajaxResponse=new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage(message);
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
}
