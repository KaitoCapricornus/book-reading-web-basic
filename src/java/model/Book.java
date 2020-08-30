/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author dinht
 */
public class Book {
    private String BookID;
    private String Author;
    private String BookName;
    private String Img;
    private String Review;
    private String Type;

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String Img) {
        this.Img = Img;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String Review) {
        this.Review = Review;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
}
