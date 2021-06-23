package com.simple.demo.entity;

import java.io.Serializable;

/**
 * @Title:com.simple.demo.entity.MsgEntity
 * @Auther: Charles Rao
 * @Date: 2020/05/18/20:22
 * @Description:
 */
public class MsgEntity implements Serializable {

    private String msgId;

    private transient String pwd;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    private String content;

    public MsgEntity(String msgId, String content) {
        this.msgId = msgId;
        this.content = content;
    }

    public MsgEntity(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
