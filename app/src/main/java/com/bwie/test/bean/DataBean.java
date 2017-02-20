package com.bwie.test.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/2/16 11:50
 */

public class DataBean {


   
        /**
         * postid : PHOT247JN000100A
         * hasCover : false
         * hasHead : 1
         * replyCount : 121528
         * hasImg : 1
         * digest : 
         * hasIcon : false
         * docid : 9IG74V5H00963VRO_CDHBSGQFdaililiupdateDoc
         * title :  她20年收养102个弃婴 患病却没钱住院
         * order : 1
         * priority : 354
         * lmodify : 2017-02-18 10:53:48
         * boardid : photoview_bbs
         * ads : [{"title":"一周精选:朝鲜金正日75周年诞辰纪念花展","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/2cd985a7bd7f4c2499e384c3e6020d5b20170218074938.jpeg","subtitle":"","url":"19BR0001|2235896"},{"title":"壶口瀑布冰凌消融水量增大 瀑布奔腾而下","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/453a0721dbdd45718dd1c33d577fc47720170218095121.jpeg","subtitle":"","url":"00AP0001|2236053"},{"title":"伊拉克情侣逃离摩苏尔 难民营中办婚礼","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/0c6cd0a8178549529e41a42afbca0e2920170217210524.jpeg","subtitle":"","url":"00AO0001|2235998"},{"title":"暴风雨席卷南加利福尼亚 街头一片汪洋","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/6b8919cbb6bf49d3a7bf99a41587d56e20170218104005.jpeg","subtitle":"","url":"00AO0001|2236065"},{"title":"特朗普牵外孙外孙女出行 展示罕见慈爱","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/11e7db1b089949adacb115a12fffee2420170218090113.jpeg","subtitle":"","url":"00AO0001|2236036"}]
         * photosetID : 00AP0001|2236023
         * imgsum : 4
         * topic_background : http://img2.cache.netease.com/m/newsapp/reading/cover1/C1348646712614.jpg
         * template : normal1
         * votecount : 117315
         * skipID : 00AP0001|2236023
         * alias : Top News
         * skipType : photoset
         * cid : C1348646712614
         * hasAD : 1
         * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/167d3b75e0cb4d0ab3db8035c6fd649c20170218030603.jpeg"},{"imgsrc":"http://cms-bucket.nosdn.127.net/a81e20437a1d416492def89e0ce9fc1020170218030603.jpeg"}]
         * source : 网易原创
         * ename : androidnews
         * tname : 头条
         * imgsrc : http://cms-bucket.nosdn.127.net/22f3e3fcf24b4e97847dfa706bf1b13120170218105246.jpeg
         * ptime : 2017-02-18 03:06:38
         * url_3w : http://news.163.com/17/0217/19/CDGILCM2000189FH.html
         * ltitle : 习近平主持召开国家安全工作座谈会 
         * url : http://3g.163.com/news/17/0217/19/CDGILCM2000189FH.html
         * specialID : S1451880983492
         * subtitle : 
         */

        private String postid;
        private boolean hasCover;
        private int hasHead;
        private int replyCount;
        private int hasImg;
        private String digest;
        private boolean hasIcon;
        private String docid;
        private String title;
        private int order;
        private int priority;
        private String lmodify;
        private String boardid;
        private String photosetID;
        private int imgsum;
        private String topic_background;
        private String template;
        private int votecount;
        private String skipID;
        private String alias;
        private String skipType;
        private String cid;
        private int hasAD;
        private String source;
        private String ename;
        private String tname;
        private String imgsrc;
        private String ptime;
        private String url_3w;
        private String ltitle;
        private String url;
        private String specialID;
        private String subtitle;
        
        private List<ImgextraBean> imgextra;

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public int getHasHead() {
            return hasHead;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public int getHasImg() {
            return hasImg;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public boolean isHasIcon() {
            return hasIcon;
        }

        public void setHasIcon(boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
        }

        public String getBoardid() {
            return boardid;
        }

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public String getPhotosetID() {
            return photosetID;
        }

        public void setPhotosetID(String photosetID) {
            this.photosetID = photosetID;
        }

        public int getImgsum() {
            return imgsum;
        }

        public void setImgsum(int imgsum) {
            this.imgsum = imgsum;
        }

        public String getTopic_background() {
            return topic_background;
        }

        public void setTopic_background(String topic_background) {
            this.topic_background = topic_background;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public int getVotecount() {
            return votecount;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public String getSkipID() {
            return skipID;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getSkipType() {
            return skipType;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public int getHasAD() {
            return hasAD;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getUrl_3w() {
            return url_3w;
        }

        public void setUrl_3w(String url_3w) {
            this.url_3w = url_3w;
        }

        public String getLtitle() {
            return ltitle;
        }

        public void setLtitle(String ltitle) {
            this.ltitle = ltitle;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSpecialID() {
            return specialID;
        }

        public void setSpecialID(String specialID) {
            this.specialID = specialID;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }


        public List<ImgextraBean> getImgextra() {
            return imgextra;
        }

        public void setImgextra(List<ImgextraBean> imgextra) {
            this.imgextra = imgextra;
        }

     

        public static class ImgextraBean {
            /**
             * imgsrc : http://cms-bucket.nosdn.127.net/167d3b75e0cb4d0ab3db8035c6fd649c20170218030603.jpeg
             */

            private String imgsrc;

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }
        }
    
}
