package entity;

import java.util.Date;

/**
 * Created by 李克顺 on 2019/3/11.
 * 视频类
 */
public class Video {
    private int id;             //视频编号
    private String name;       //视频名称
    private String url;         //视频存储路径
    private int typeId;         //视频类型
    private int browseNumber;   //浏览数
    private Date uploadTime;    //上传时间

    /**
     * 无参构造
     */
    public Video() {

    }

    public Video(int id, String name, String url, int typeId, int browseNumber, Date uploadTime) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.typeId = typeId;
        this.browseNumber = browseNumber;
        this.uploadTime = uploadTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getBrowseNumber() {
        return browseNumber;
    }

    public void setBrowseNumber(int browseNumber) {
        this.browseNumber = browseNumber;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}
