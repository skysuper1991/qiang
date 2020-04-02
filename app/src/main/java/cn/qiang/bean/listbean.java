package cn.qiang.bean;

import java.util.List;

public class listbean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1583213913
     * data : [{"id":1,"category_id":3,"pricemin":301,"pricemax":1200,"taozi":6,"shouyi":9,"zouqi":3,"timemin":"10:25","timemax":"10:30","changci":1,"name":"报喜鸟","img":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/8931575275869%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_13.png","min_time":1583202300,"max_time":1583202600,"is_yu":1},{"id":2,"category_id":1,"pricemin":60,"pricemax":300,"taozi":1,"shouyi":6,"zouqi":2,"timemin":"10:55","timemax":"11:00","changci":2,"name":"和平鸽","img":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/6381575275790%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_09.png","min_time":1583204100,"max_time":1583204400,"is_yu":2},{"id":3,"category_id":6,"pricemin":1201,"pricemax":3600,"taozi":12,"shouyi":15,"zouqi":5,"timemin":"11:25","timemax":"11:30","changci":3,"name":"金丝猴","img":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/7961575275910%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_14.png","min_time":1583205900,"max_time":1583206200,"is_yu":1},{"id":4,"category_id":2,"pricemin":301,"pricemax":1200,"taozi":12,"shouyi":15,"zouqi":5,"timemin":"14:55","timemax":"15:00","changci":4,"name":"旺财狗","img":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/3701575276014%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_22.png","min_time":1583218500,"max_time":1583218800,"is_yu":1},{"id":5,"category_id":7,"pricemin":3601,"pricemax":8000,"taozi":18,"shouyi":14,"zouqi":7,"timemin":"15:25","timemax":"15:30","changci":5,"name":"大红鹰","img":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/5701575275937%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_17.png","min_time":1583220300,"max_time":1583220600,"is_yu":0},{"id":6,"category_id":10,"pricemin":8001,"pricemax":24000,"taozi":42,"shouyi":30,"zouqi":15,"timemin":"15:55","timemax":"16:00","changci":6,"name":"中国龙","img":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/9881575275964%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_18.png","min_time":1583222100,"max_time":1583222400,"is_yu":0},{"id":7,"category_id":4,"pricemin":1201,"pricemax":3600,"taozi":18,"shouyi":20,"zouqi":9,"timemin":"16:25","timemax":"16:30","changci":7,"name":"赤兔马","img":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/3191575275723%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_05.png","min_time":1583223900,"max_time":1583224200,"is_yu":0},{"id":8,"category_id":5,"pricemin":1201,"pricemax":3600,"taozi":8,"shouyi":5,"zouqi":1,"timemin":"19:35","timemax":"19:40","changci":8,"name":"白天鹅","img":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/7391575275837%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_10.png","min_time":1583235300,"max_time":1583235600,"is_yu":0},{"id":9,"category_id":8,"pricemin":3601,"pricemax":8000,"taozi":24,"shouyi":24,"zouqi":12,"timemin":"20:05","timemax":"20:10","changci":9,"name":"东北虎","img":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/5231575275990%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_21.png","min_time":1583237100,"max_time":1583237400,"is_yu":0},{"id":10,"category_id":9,"pricemin":3601,"pricemax":8000,"taozi":22,"shouyi":18,"zouqi":9,"timemin":"20:35","timemax":"20:40","changci":10,"name":"大熊猫","img":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/3641575275621%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_03.png","min_time":1583238900,"max_time":1583239200,"is_yu":0}]
     */

    private int code;
    private String msg;
    private String time;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * category_id : 3
         * pricemin : 301
         * pricemax : 1200
         * taozi : 6
         * shouyi : 9
         * zouqi : 3
         * timemin : 10:25
         * timemax : 10:30
         * changci : 1
         * name : 报喜鸟
         * img : https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/8931575275869%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_13.png
         * min_time : 1583202300
         * max_time : 1583202600
         * is_yu : 1
         */
        private String  stips="";
        private int id;
        private int category_id;
        private int pricemin;
        private int pricemax;
        private int taozi;
        private int shouyi;
        private int zouqi;
        private String timemin;
        private String timemax;
        private int changci;
        private String name;
        private String img;
        private int min_time;
        private int max_time;
        private int is_yu;
        private int  counts=0;
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public int getPricemin() {
            return pricemin;
        }

        public void setPricemin(int pricemin) {
            this.pricemin = pricemin;
        }

        public int getPricemax() {
            return pricemax;
        }

        public void setPricemax(int pricemax) {
            this.pricemax = pricemax;
        }

        public int getTaozi() {
            return taozi;
        }

        public void setTaozi(int taozi) {
            this.taozi = taozi;
        }

        public int getShouyi() {
            return shouyi;
        }

        public void setShouyi(int shouyi) {
            this.shouyi = shouyi;
        }

        public int getZouqi() {
            return zouqi;
        }

        public void setZouqi(int zouqi) {
            this.zouqi = zouqi;
        }

        public String getTimemin() {
            return timemin;
        }

        public void setTimemin(String timemin) {
            this.timemin = timemin;
        }

        public String getTimemax() {
            return timemax;
        }

        public void setTimemax(String timemax) {
            this.timemax = timemax;
        }

        public int getChangci() {
            return changci;
        }

        public void setChangci(int changci) {
            this.changci = changci;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getMin_time() {
            return min_time;
        }

        public void setMin_time(int min_time) {
            this.min_time = min_time;
        }

        public int getMax_time() {
            return max_time;
        }

        public void setMax_time(int max_time) {
            this.max_time = max_time;
        }

        public int getIs_yu() {
            return is_yu;
        }

        public void setIs_yu(int is_yu) {
            this.is_yu = is_yu;
        }

        public String getStips() {
            return stips;
        }

        public void setStips(String stips) {
            this.stips = stips;
        }

        public int getCounts() {
            return counts;
        }

        public void setCounts(int counts) {
            this.counts = counts;
        }
    }
}
