package com.ddbuy.util;

//接收页大小和当前页码，实现序列化接口
public class Page implements java.io.Serializable {

 //当前页码
 private Integer page=1;
 //页大小
 private Integer rows;

 public Page() {
 }

 public Page(Integer page, Integer rows) {
  this.page = page;
  this.rows = rows;
 }

 public Integer getPage() {
  return page;
 }

 public void setPage(Integer page) {
  this.page = page;
 }

 public Integer getRows() {
  return rows;
 }

 public void setRows(Integer rows) {
  this.rows = rows;
 }
}
