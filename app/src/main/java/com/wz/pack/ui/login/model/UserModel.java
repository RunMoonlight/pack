package com.wz.pack.ui.login.model;

import com.wz.pack.ui.login.contract.UserContract;

/**
 * Created by wang_zhen1 on 2018/1/16 0016.
 */

public class UserModel  {


    /**
     * code : 1
     * msg : null
     * data : {"id":1,"username":"wz","headimg":"http://guocaicai.cn/uploadimg/1509588089999_ic_launcher.png"}
     */

    private int code;
    private Object msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * username : wz
         * headimg : http://guocaicai.cn/uploadimg/1509588089999_ic_launcher.png
         */

        private int id;
        private String username;
        private String headimg;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getHeadimg() {
            return headimg;
        }

        public void setHeadimg(String headimg) {
            this.headimg = headimg;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", headimg='" + headimg + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "code=" + code +
                ", msg=" + msg +
                ", data=" + data +
                '}';
    }
}
