package cn.qiang.bean;

import java.util.List;

public class OrderBean {


    /**
     * code : 1
     * msg : 请求成功
     * time : 1585464510
     * data : [{"id":70910,"ids":"正常单","ashouyi":null,"enttime":"2020-03-29 19:35:00","uid":6593,"changci":8,"price":1782.8,"uptime":"2020-03-28 19:35:00","uptime_md":"03-28","uptime_hi":"19:35","shouyi":5,"zouqi":1,"timemin":"19:35","timemax":"19:40","pricemax":3600,"taozi":8,"name":"白天鹅","cimg":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/7391575275837%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_10.png","extime":"2020-03-29 19:35:00","extime_md":"03-29","extime_hi":"19:35"},{"id":70665,"ids":"正常单","ashouyi":null,"enttime":"2020-04-06 16:25:00","uid":6593,"changci":7,"price":1528.8,"uptime":"2020-03-28 16:25:00","uptime_md":"03-28","uptime_hi":"16:25","shouyi":20,"zouqi":9,"timemin":"16:25","timemax":"16:30","pricemax":3600,"taozi":18,"name":"赤兔马","cimg":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/3191575275723%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_05.png","extime":"2020-04-06 16:25:00","extime_md":"04-06","extime_hi":"16:25"},{"id":70434,"ids":"正常单","ashouyi":null,"enttime":"2020-04-12 15:55:00","uid":6593,"changci":6,"price":10718.5,"uptime":"2020-03-28 15:55:00","uptime_md":"03-28","uptime_hi":"15:55","shouyi":30,"zouqi":15,"timemin":"15:55","timemax":"16:00","pricemax":24000,"taozi":42,"name":"中国龙","cimg":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/9881575275964%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_18.png","extime":"2020-04-12 15:55:00","extime_md":"04-12","extime_hi":"15:55"},{"id":70254,"ids":"正常单","ashouyi":null,"enttime":"2020-04-02 14:55:00","uid":6593,"changci":4,"price":427.17,"uptime":"2020-03-28 14:55:00","uptime_md":"03-28","uptime_hi":"14:55","shouyi":15,"zouqi":5,"timemin":"14:55","timemax":"15:00","pricemax":1200,"taozi":12,"name":"旺财狗","cimg":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/3701575276014%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_22.png","extime":"2020-04-02 14:55:00","extime_md":"04-02","extime_hi":"14:55"},{"id":69496,"ids":"正常单","ashouyi":null,"enttime":"2020-04-05 20:35:00","uid":6593,"changci":10,"price":3613,"uptime":"2020-03-27 20:35:00","uptime_md":"03-27","uptime_hi":"20:35","shouyi":18,"zouqi":9,"timemin":"20:35","timemax":"20:40","pricemax":8000,"taozi":22,"name":"大熊猫","cimg":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/3641575275621%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_03.png","extime":"2020-04-05 20:35:00","extime_md":"04-05","extime_hi":"20:35"},{"id":68879,"ids":"正常单","ashouyi":null,"enttime":"2020-04-05 16:25:00","uid":6593,"changci":7,"price":1527.6,"uptime":"2020-03-27 16:25:00","uptime_md":"03-27","uptime_hi":"16:25","shouyi":20,"zouqi":9,"timemin":"16:25","timemax":"16:30","pricemax":3600,"taozi":18,"name":"赤兔马","cimg":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/3191575275723%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_05.png","extime":"2020-04-05 16:25:00","extime_md":"04-05","extime_hi":"16:25"},{"id":67647,"ids":"升级单","ashouyi":18,"enttime":"2020-04-04 15:55:00","uid":6593,"changci":6,"price":8284,"uptime":"2020-03-20 15:55:00","uptime_md":"03-20","uptime_hi":"15:55","shouyi":0,"zouqi":15,"timemin":"15:55","timemax":"16:00","pricemax":24000,"taozi":42,"name":"中国龙","cimg":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/9881575275964%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_18.png","extime":"2020-04-04 15:55:00","extime_md":"04-04","extime_hi":"15:55"},{"id":67529,"ids":"正常单","ashouyi":null,"enttime":"2020-04-07 20:05:00","uid":6593,"changci":9,"price":3771,"uptime":"2020-03-26 20:05:00","uptime_md":"03-26","uptime_hi":"20:05","shouyi":24,"zouqi":12,"timemin":"20:05","timemax":"20:10","pricemax":8000,"taozi":24,"name":"东北虎","cimg":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/5231575275990%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_21.png","extime":"2020-04-07 20:05:00","extime_md":"04-07","extime_hi":"20:05"},{"id":66760,"ids":"正常单","ashouyi":null,"enttime":"2020-03-31 14:55:00","uid":6593,"changci":4,"price":449.65,"uptime":"2020-03-26 14:55:00","uptime_md":"03-26","uptime_hi":"14:55","shouyi":15,"zouqi":5,"timemin":"14:55","timemax":"15:00","pricemax":1200,"taozi":12,"name":"旺财狗","cimg":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/3701575276014%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_22.png","extime":"2020-03-31 14:55:00","extime_md":"03-31","extime_hi":"14:55"},{"id":66039,"ids":"正常单","ashouyi":null,"enttime":"2020-04-03 20:35:00","uid":6593,"changci":10,"price":5048.84,"uptime":"2020-03-25 20:35:00","uptime_md":"03-25","uptime_hi":"20:35","shouyi":18,"zouqi":9,"timemin":"20:35","timemax":"20:40","pricemax":8000,"taozi":22,"name":"大熊猫","cimg":"https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/3641575275621%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_03.png","extime":"2020-04-03 20:35:00","extime_md":"04-03","extime_hi":"20:35"}]
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
         * id : 70910
         * ids : 正常单
         * ashouyi : null
         * enttime : 2020-03-29 19:35:00
         * uid : 6593
         * changci : 8
         * price : 1782.8
         * uptime : 2020-03-28 19:35:00
         * uptime_md : 03-28
         * uptime_hi : 19:35
         * shouyi : 5
         * zouqi : 1
         * timemin : 19:35
         * timemax : 19:40
         * pricemax : 3600
         * taozi : 8
         * name : 白天鹅
         * cimg : https://dwsj2019.oss-ap-southeast-1.aliyuncs.com/public/img/2019-12-02/7391575275837%E5%8A%A8%E7%89%A9%E4%B8%96%E7%95%8C_10.png
         * extime : 2020-03-29 19:35:00
         * extime_md : 03-29
         * extime_hi : 19:35
         */

        private int id;
        private String ids;
        private Object ashouyi;
        private String enttime;
        private int uid;
        private int changci;
        private double price;
        private String uptime;
        private String uptime_md;
        private String uptime_hi;
        private int shouyi;
        private int zouqi;
        private String timemin;
        private String timemax;
        private int pricemax;
        private int taozi;
        private String name;
        private String cimg;
        private String extime;
        private String extime_md;
        private String extime_hi;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIds() {
            return ids;
        }

        public void setIds(String ids) {
            this.ids = ids;
        }

        public Object getAshouyi() {
            return ashouyi;
        }

        public void setAshouyi(Object ashouyi) {
            this.ashouyi = ashouyi;
        }

        public String getEnttime() {
            return enttime;
        }

        public void setEnttime(String enttime) {
            this.enttime = enttime;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getChangci() {
            return changci;
        }

        public void setChangci(int changci) {
            this.changci = changci;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getUptime() {
            return uptime;
        }

        public void setUptime(String uptime) {
            this.uptime = uptime;
        }

        public String getUptime_md() {
            return uptime_md;
        }

        public void setUptime_md(String uptime_md) {
            this.uptime_md = uptime_md;
        }

        public String getUptime_hi() {
            return uptime_hi;
        }

        public void setUptime_hi(String uptime_hi) {
            this.uptime_hi = uptime_hi;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCimg() {
            return cimg;
        }

        public void setCimg(String cimg) {
            this.cimg = cimg;
        }

        public String getExtime() {
            return extime;
        }

        public void setExtime(String extime) {
            this.extime = extime;
        }

        public String getExtime_md() {
            return extime_md;
        }

        public void setExtime_md(String extime_md) {
            this.extime_md = extime_md;
        }

        public String getExtime_hi() {
            return extime_hi;
        }

        public void setExtime_hi(String extime_hi) {
            this.extime_hi = extime_hi;
        }
    }
}

