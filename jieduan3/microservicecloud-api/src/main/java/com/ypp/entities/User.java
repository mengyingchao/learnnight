package com.ypp.entities;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

public class User implements Serializable {
 private int id;
 private String email;
 private String mobile;
 private String avator;
 private String pwd;
 private Date creat_time;
 private Date update_time;
 private String username;
 public User() {
 }
 public int getId() {
  return id;
 }
 public void setId(int id) {
  this.id = id;
 }
 public String getEmail() {
  return email;
 }
 public void setEmail(String email) {
  this.email = email;
 }

 public String getMobile() {
  return mobile;
 }

 public void setMobile(String mobile) {
  this.mobile = mobile;
 }

 public String getAvator() {
  return avator;
 }

 public void setAvator(String avator) {
  this.avator = avator;
 }

 public String getPwd() {
  return pwd;
 }

 public void setPwd(String pwd) {
  this.pwd = pwd;
 }

 public Date getCreat_time() {
  return creat_time;
 }

 public void setCreat_time(Date creat_time) {
  this.creat_time = creat_time;
 }

 public Date getUpdate_time() {
  return update_time;
 }

 public void setUpdate_time(Date update_time) {
  this.update_time = update_time;
 }

 public String getUsername() {
  return username;
 }

 public void setUsername(String username) {
  this.username = username;
 }

 @Override
 public String toString() {
  return "User{" +
          "id=" + id +
          ", email='" + email + '\'' +
          ", mobile='" + mobile + '\'' +
          ", avator='" + avator + '\'' +
          ", pwd='" + pwd + '\'' +
          ", creat_time=" + creat_time +
          ", update_time=" + update_time +
          ", username='" + username + '\'' +
          '}';
 }
}