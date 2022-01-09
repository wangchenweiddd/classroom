package com.edu.ahu.classroom.common;

/**
 * 前台回应封装
 * Created by Administrator
 */

public class ResponsePojo {
    private static final String OK = "ok";
    private static final String ERROR = "error";
    private ResponsePojo.Meta meta;
    private Object data;

    public ResponsePojo() {
    }

    public ResponsePojo success() {
        this.meta = new ResponsePojo.Meta(true, "ok");
        return this;
    }

    public ResponsePojo success(Object data) {
        this.meta = new ResponsePojo.Meta(true, "ok");
        this.data = data;
        return this;
    }

    public ResponsePojo failure() {
        this.meta = new ResponsePojo.Meta(false, "error");
        return this;
    }

    public ResponsePojo failure(String message) {
        this.meta = new ResponsePojo.Meta(false, message);
        return this;
    }

    public ResponsePojo.Meta getMeta() {
        return this.meta;
    }

    public void setMeta(ResponsePojo.Meta meta) {
        this.meta = meta;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static class Meta {
        private boolean success;
        private String message;

        public Meta(){}

        public Meta(boolean success) {
            this.success = success;
        }

        public Meta( boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return this.success;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public boolean getSuccess() {
            return this.success;
        }
    }
}

