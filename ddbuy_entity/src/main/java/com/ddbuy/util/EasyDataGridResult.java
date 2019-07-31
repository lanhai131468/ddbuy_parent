package com.ddbuy.util;

import java.util.List;

//封装分页后的数据和分页的行数
public class EasyDataGridResult<T> implements java.io.Serializable {

 private Integer total;  //总行数
 private List<T> rows; //显示的数据

 public EasyDataGridResult() {
 }

 public EasyDataGridResult(List<T> rows) {
  this.rows = rows;
 }

 public EasyDataGridResult(Integer total, List<T> rows) {
  this.total = total;
  this.rows = rows;
 }

 public Integer getTotal() {
  return total;
 }

 public void setTotal(Integer total) {
  this.total = total;
 }

 public List<T> getRows() {
  return rows;
 }

 public void setRows(List<T> rows) {
  this.rows = rows;
 }
}
