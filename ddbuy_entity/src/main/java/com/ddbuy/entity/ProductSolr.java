package com.ddbuy.entity;

import org.apache.solr.client.solrj.beans.Field;

//封装搜索结果的实体类
public class ProductSolr implements java.io.Serializable {

 @Field
 private long pid;
 @Field
 private String title;
 @Field
 private double price;
 @Field
 private String image;



 public String getTitle() {
  return title;
 }

 public void setTitle(String title) {
  this.title = title;
 }

 public String getImage() {
  return image;
 }

 public void setImage(String image) {
  this.image = image;
 }

 public double getPrice() {
  return price;
 }

 public void setPrice(double price) {
  this.price = price;
 }

 public long getPid() {
  return pid;
 }

 public void setPid(long pid) {
  this.pid = pid;
 }
}
