package demo.androidclassic.com.androidclassicdemo.saveobject;

import java.util.List;

public class Databean {


    /**
     * status : 1
     * lastDocType : 1
     * lastDoc : {"id":"3831","doc_no":"EX1015138724","user_id":"84","sender_name":"","receive_id":"84","receive_name":"熊政","doc_name":"包裹送达确认","user_company":"''","receive_company":"无","create_time":"2018-05-15 19:14:08","update_time":"2018-05-15 19:14:09","doc_status":"1","rec_status":"1","doc_type":"1","doc_relation_id":null,"sign_time":null,"pay_time":null,"send_time":"2018-05-15 19:14:09","receive_time":null,"role":1,"sign_return":0,"button":[{"name":"催单","url":"/v1/app/hurryDoc"},{"name":"查看","url":"/sys/doc/docDetail/no/EX1015138724#item3"}]}
     * waitSign : 15
     * waitPayCount : 4
     * waitReceive : 13
     * banner : [{"name":"banner2","desc":"2.3元全国包邮","value":"app_image/6c51f4b13b21d4717f4de288a875bf50.png","url":"/agent/courier/express"},{"name":"banner1","desc":"秒签人才介绍","value":"app_image/26ac55c7e109844a75afa254ec1bcb87.png","url":"/ding/index/select"}]
     * app : [{"name":"app_express","desc":"秒签快递","value":"app_image/34b452e56c0c895ce9d9710fb3ed6739.png","url":"/agent/courier/express"},{"name":"app_men","desc":"秒签人才","value":"app_image/16aeb16f7f95b07f266a8452a73bef63.png","url":"/ding/index/select"},{"name":"app_fp","desc":"电子发票","value":"app_image/fp.png","url":"/"}]
     * add : [{"name":"app_express","desc":"寄实物包裹","value":"app_image/735fcdff8576038495a84ecdd5a9b4f5.png","url":"/agent/courier/express"},{"name":"app_doc","desc":"寄电子合同","value":"app_image/6c9bcca99e5f05cd9d174d5c81ba486f.png","url":"/sys/waybill/quick"},{"name":"app_fp","desc":"电子发票","value":"app_image/210c0f3753903d316d4e44835caa0a09.png","url":"/"}]
     */

    private int status;
    private int lastDocType;
    private LastDocBean lastDoc;
    private String waitSign;
    private String waitPayCount;
    private String waitReceive;
    private List<BannerBean> banner;
    private List<AppBean> app;
    private List<AddBean> add;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLastDocType() {
        return lastDocType;
    }

    public void setLastDocType(int lastDocType) {
        this.lastDocType = lastDocType;
    }

    public LastDocBean getLastDoc() {
        return lastDoc;
    }

    public void setLastDoc(LastDocBean lastDoc) {
        this.lastDoc = lastDoc;
    }

    public String getWaitSign() {
        return waitSign;
    }

    public void setWaitSign(String waitSign) {
        this.waitSign = waitSign;
    }

    public String getWaitPayCount() {
        return waitPayCount;
    }

    public void setWaitPayCount(String waitPayCount) {
        this.waitPayCount = waitPayCount;
    }

    public String getWaitReceive() {
        return waitReceive;
    }

    public void setWaitReceive(String waitReceive) {
        this.waitReceive = waitReceive;
    }

    public List<BannerBean> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerBean> banner) {
        this.banner = banner;
    }

    public List<AppBean> getApp() {
        return app;
    }

    public void setApp(List<AppBean> app) {
        this.app = app;
    }

    public List<AddBean> getAdd() {
        return add;
    }

    public void setAdd(List<AddBean> add) {
        this.add = add;
    }

    public static class LastDocBean {
        /**
         * id : 3831
         * doc_no : EX1015138724
         * user_id : 84
         * sender_name :
         * receive_id : 84
         * receive_name : 熊政
         * doc_name : 包裹送达确认
         * user_company : ''
         * receive_company : 无
         * create_time : 2018-05-15 19:14:08
         * update_time : 2018-05-15 19:14:09
         * doc_status : 1
         * rec_status : 1
         * doc_type : 1
         * doc_relation_id : null
         * sign_time : null
         * pay_time : null
         * send_time : 2018-05-15 19:14:09
         * receive_time : null
         * role : 1
         * sign_return : 0
         * button : [{"name":"催单","url":"/v1/app/hurryDoc"},{"name":"查看","url":"/sys/doc/docDetail/no/EX1015138724#item3"}]
         */

        private String id;
        private String doc_no;
        private String user_id;
        private String sender_name;
        private String receive_id;
        private String receive_name;
        private String doc_name;
        private String user_company;
        private String receive_company;
        private String create_time;
        private String update_time;
        private String doc_status;
        private String rec_status;
        private String doc_type;
        private Object doc_relation_id;
        private Object sign_time;
        private Object pay_time;
        private String send_time;
        private Object receive_time;
        private int role;
        private int sign_return;
        private List<ButtonBean> button;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDoc_no() {
            return doc_no;
        }

        public void setDoc_no(String doc_no) {
            this.doc_no = doc_no;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getSender_name() {
            return sender_name;
        }

        public void setSender_name(String sender_name) {
            this.sender_name = sender_name;
        }

        public String getReceive_id() {
            return receive_id;
        }

        public void setReceive_id(String receive_id) {
            this.receive_id = receive_id;
        }

        public String getReceive_name() {
            return receive_name;
        }

        public void setReceive_name(String receive_name) {
            this.receive_name = receive_name;
        }

        public String getDoc_name() {
            return doc_name;
        }

        public void setDoc_name(String doc_name) {
            this.doc_name = doc_name;
        }

        public String getUser_company() {
            return user_company;
        }

        public void setUser_company(String user_company) {
            this.user_company = user_company;
        }

        public String getReceive_company() {
            return receive_company;
        }

        public void setReceive_company(String receive_company) {
            this.receive_company = receive_company;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public String getDoc_status() {
            return doc_status;
        }

        public void setDoc_status(String doc_status) {
            this.doc_status = doc_status;
        }

        public String getRec_status() {
            return rec_status;
        }

        public void setRec_status(String rec_status) {
            this.rec_status = rec_status;
        }

        public String getDoc_type() {
            return doc_type;
        }

        public void setDoc_type(String doc_type) {
            this.doc_type = doc_type;
        }

        public Object getDoc_relation_id() {
            return doc_relation_id;
        }

        public void setDoc_relation_id(Object doc_relation_id) {
            this.doc_relation_id = doc_relation_id;
        }

        public Object getSign_time() {
            return sign_time;
        }

        public void setSign_time(Object sign_time) {
            this.sign_time = sign_time;
        }

        public Object getPay_time() {
            return pay_time;
        }

        public void setPay_time(Object pay_time) {
            this.pay_time = pay_time;
        }

        public String getSend_time() {
            return send_time;
        }

        public void setSend_time(String send_time) {
            this.send_time = send_time;
        }

        public Object getReceive_time() {
            return receive_time;
        }

        public void setReceive_time(Object receive_time) {
            this.receive_time = receive_time;
        }

        public int getRole() {
            return role;
        }

        public void setRole(int role) {
            this.role = role;
        }

        public int getSign_return() {
            return sign_return;
        }

        public void setSign_return(int sign_return) {
            this.sign_return = sign_return;
        }

        public List<ButtonBean> getButton() {
            return button;
        }

        public void setButton(List<ButtonBean> button) {
            this.button = button;
        }

        public static class ButtonBean {
            /**
             * name : 催单
             * url : /v1/app/hurryDoc
             */

            private String name;
            private String url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class BannerBean {
        /**
         * name : banner2
         * desc : 2.3元全国包邮
         * value : app_image/6c51f4b13b21d4717f4de288a875bf50.png
         * url : /agent/courier/express
         */

        private String name;
        private String desc;
        private String value;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class AppBean {
        /**
         * name : app_express
         * desc : 秒签快递
         * value : app_image/34b452e56c0c895ce9d9710fb3ed6739.png
         * url : /agent/courier/express
         */

        private String name;
        private String desc;
        private String value;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class AddBean {
        /**
         * name : app_express
         * desc : 寄实物包裹
         * value : app_image/735fcdff8576038495a84ecdd5a9b4f5.png
         * url : /agent/courier/express
         */

        private String name;
        private String desc;
        private String value;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
