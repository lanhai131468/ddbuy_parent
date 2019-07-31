package com.ddbuy.util;

import org.csource.fastdfs.*;

public class FastDfs {

 //配置文件名的名称
 private static final String configFilename="fastdfs.properties";

 //编写上传文件的代码
 public static String []  uploadFile(byte [] bs,String expname){
  try {
   //1.加载配置文件
   ClientGlobal.init(configFilename);
   // 2、创建一个 TrackerClient 对象。直接 new 一个。
   TrackerClient trackerClient = new TrackerClient();
   // 3、使用 TrackerClient 对象创建连接，获得一个 TrackerServer 对象。
   TrackerServer trackerServer = trackerClient.getConnection();
   // 4、创建一个 StorageServer 的引用，值为 null
   StorageServer storageServer = null;
   // 5、创建一个 StorageClient 对象，需要两个参数 TrackerServer 对象、StorageServer 的引用
   StorageClient storageClient = new StorageClient(trackerServer, storageServer);
   // 6、使用 StorageClient 对象上传图片。
   String[] strings = storageClient.upload_file(bs, expname,null);
   return strings;
  } catch (Exception e) {
   e.printStackTrace();
  }
  return null;
 }



 /**
  *   //测试删除上传的
  * @param group  组名
  * @param filename  文件件
  * @return  整型   0表示成功   否则不成功
  */
 public static int delFile(String group,String filename) {
  int temp=-1;
  try {
   //1.加载配置文件
   ClientGlobal.init(configFilename);
   // 2、创建一个 TrackerClient 对象。直接 new 一个。
   TrackerClient trackerClient = new TrackerClient();
   // 3、使用 TrackerClient 对象创建连接，获得一个 TrackerServer 对象。
   TrackerServer trackerServer = trackerClient.getConnection();
   // 4、创建一个 StorageServer 的引用，值为 null
   StorageServer storageServer = null;
   // 5、创建一个 StorageClient 对象，需要两个参数 TrackerServer 对象、StorageServer 的引用
   StorageClient storageClient = new StorageClient(trackerServer, storageServer);
   // 6、使用 StorageClient 对象删除图片。
   temp=storageClient.delete_file (group,filename);

  } catch (Exception e) {
   e.printStackTrace();
  }
  return temp;
 }

}

