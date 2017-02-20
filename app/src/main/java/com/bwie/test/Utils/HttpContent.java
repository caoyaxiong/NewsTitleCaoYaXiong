package com.bwie.test.Utils;

/**private String[]title={"娱乐","电影","游戏","社会","笑话","军事","科技","汽车","体育","财经"};
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/2/16 10:07
 */

public class HttpContent {
   
    public static final String[] HTTP_ID={"T1370583240249","T1348649654285","T1348648517839","T1348648650048","T1348654151579","T1348648037603","T1350383429665","T1348648141035","T1348649580692","T1348654060988","T1348649079062","T1348648756099"};
    public static final String HOUSE_ID = "5YyX5Lqs";// 房产id
    public static final String FOOTBALL_ID = "T1399700447917";// 足球
    public static final String ENTERTAINMENT_ID = "T1348648517839";// 娱乐
    public static final String SPORTS_ID = "T1348649079062";// 体育
    public static final String FINANCE_ID = "T1348648756099";// 财经
    public static final String TECH_ID = "T1348649580692";// 科技
    public static final String MOVIE_ID = "T1348648650048";// 电影
    public static final String CAR_ID = "T1348654060988";// 汽车
    public static final String JOKE_ID = "T1350383429665";// 笑话
    public static final String GAME_ID = "T1348654151579";// 游戏
    public static final String FASHION_ID = "T1348650593803";// 时尚
    public static final String EMOTION_ID = "T1348650839000";// 情感
    public static final String CHOICE_ID = "T1370583240249";// 精选
    public static final String RADIO_ID = "T1379038288239";// 电台
    public static final String NBA_ID = "T1348649145984";// nba
    public static final String DIGITAL_ID = "T1348649776727";// 数码
    public static final String MOBILE_ID = "T1351233117091";// 移动
    public static final String LOTTERY_ID = "T1356600029035";// 彩票
    public static final String EDUCATION_ID = "T1348654225495";// 教育
    public static final String FORUM_ID = "T1349837670307";// 论坛
    public static final String TOUR_ID = "T1348654204705";// 旅游
    // 手机
    public static final String PHONE_ID = "T1348649654285";
    // 博客
    public static final String BLOG_ID = "T1349837698345";
    // 社会
    public static final String SOCIETY_ID = "T1348648037603";
    // 家居
    public static final String FURNISHING_ID = "T1348654105308";
    // 暴雪游戏
    public static final String BLIZZARD_ID = "T1397016069906";
    // 亲子
    public static final String PATERNITY_ID = "T1397116135282";
    // CBA
    public static final String CBA_ID = "T1348649475931";
    // 消息
    public static final String MSG_ID = "T1371543208049";
    // 军事
    public static final String MILITARY_ID = "T1348648141035";
    
    public static String getUrl(int i){
        String url= "http://c.m.163.com/nc/article/headline/"+HTTP_ID[i]+"/0-20.html";
        return url;
    }
}
