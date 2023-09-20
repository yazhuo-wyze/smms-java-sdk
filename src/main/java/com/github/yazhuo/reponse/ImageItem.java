package com.github.yazhuo.reponse;

public class ImageItem {

    private Integer width;
    private Integer height;
    private String filename;
    private String storename;
    private Integer size;
    private String path;
    private String hash;
    private String url;
    private String delete;
    private String page;
    private String createAt;

    public Integer getWidth() {
        return this.width;
    }

    public void setWidth(final Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(final Integer height) {
        this.height = height;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(final String filename) {
        this.filename = filename;
    }

    public String getStorename() {
        return this.storename;
    }

    public void setStorename(final String storename) {
        this.storename = storename;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(final Integer size) {
        this.size = size;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(final String path) {
        this.path = path;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(final String hash) {
        this.hash = hash;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getDelete() {
        return this.delete;
    }

    public void setDelete(final String delete) {
        this.delete = delete;
    }

    public String getPage() {
        return this.page;
    }

    public void setPage(final String page) {
        this.page = page;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(final String createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "ImageItem{" +
                "width=" + this.width +
                ", height=" + this.height +
                ", filename='" + this.filename + '\'' +
                ", storename='" + this.storename + '\'' +
                ", size=" + this.size +
                ", path='" + this.path + '\'' +
                ", hash='" + this.hash + '\'' +
                ", url='" + this.url + '\'' +
                ", delete='" + this.delete + '\'' +
                ", page='" + this.page + '\'' +
                ", createAt='" + this.createAt + '\'' +
                '}';
    }
}
