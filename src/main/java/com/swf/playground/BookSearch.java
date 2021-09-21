package com.swf.playground;

public class BookSearch {

    private String author;

    private String ISBN;

    private String title;

    @Override
    public String toString() {
        return "BookSearch{" + "author='" + this.author + '\'' + ", ISBN='" + this.ISBN + '\'' + ", title='" + this.title + '\'' + '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

}
