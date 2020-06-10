package me.lokka.ssmcrud.bean;

public class Article {
    private Long id;
    private String title;
    private Long publishTime;   //时间戳
    private String content;
    private Integer readTimes;
    private Integer thumbUp;
    private Integer thumbDown;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getReadTimes() {
        return readTimes;
    }

    public void setReadTimes(Integer readTimes) {
        this.readTimes = readTimes;
    }

    public Integer getThumbUp() {
        return thumbUp;
    }

    public void setThumbUp(Integer thumbUp) {
        this.thumbUp = thumbUp;
    }

    public Integer getThumbDown() {
        return thumbDown;
    }

    public void setThumbDown(Integer thumbDown) {
        this.thumbDown = thumbDown;
    }
}
