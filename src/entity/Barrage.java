package entity;

import java.util.Date;

/**
 * Created by 李克顺 on 2019/3/11.
 * 弹幕类
 */
public class Barrage {
    private int id;             //弹幕id
    private int uId;         //用户id
    private int vId;         //视频id
    private String barrageInfo; //弹幕信息
    private Date time;          //发送时视频播放进度条的时间

    public Barrage(){}

    public Barrage(int id, int uId, int vId, String barrageInfo, Date time) {
        this.id = id;
        this.uId = uId;
        this.vId = vId;
        this.barrageInfo = barrageInfo;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getvId() {
        return vId;
    }

    public void setvId(int vId) {
        this.vId = vId;
    }

    public String getBarrageInfo() {
        return barrageInfo;
    }

    public void setBarrageInfo(String barrageInfo) {
        this.barrageInfo = barrageInfo;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
