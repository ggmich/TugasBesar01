package com.example.tugasbesar01;

public class MenuList {

    String title,tag,desc,type;

    public MenuList(String title, String tag, String desc, String type) {
        this.title = title;
        this.tag = tag;
        this.desc = desc;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getTag() {
        return tag;
    }

    public String getDesc() {
        return desc;
    }

    public String getType() {
        return type;
    }
}
