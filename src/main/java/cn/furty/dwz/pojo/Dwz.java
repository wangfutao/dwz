package cn.furty.dwz.pojo;

import java.sql.Timestamp;

public class Dwz {

  private int id;
  private String dwz;
  private String ywz;
  private Timestamp createTime;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getDwz() {
    return dwz;
  }

  public void setDwz(String dwz) {
    this.dwz = dwz;
  }


  public String getYwz() {
    return ywz;
  }

  public void setYwz(String ywz) {
    this.ywz = ywz;
  }


  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    return "Dwz{" +
            "id=" + id +
            ", dwz='" + dwz + '\'' +
            ", ywz='" + ywz + '\'' +
            ", createTime=" + createTime +
            '}';
  }
}
