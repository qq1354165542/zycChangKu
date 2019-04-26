package entity;

import javax.xml.crypto.Data;

/**
 * Created by 李克顺 on 2019/3/18.
 * 浏览记录类
 */
public class Browserecord {
    private int id;             //浏览记录id
    private int uId;            //用户id
    private int vId;            //视频id
    private Data datetime;      //浏览的时间


    public Browserecord() {
    }

    public Browserecord(int id, int uId, int vId, Data datetime) {
        this.id = id;
        this.uId = uId;
        this.vId = vId;
        this.datetime = datetime;
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

    public Data getDatetime() {
        return datetime;
    }

    public void setDatetime(Data datetime) {
        this.datetime = datetime;
    }
}


