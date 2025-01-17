package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.stPoi;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPhotoPoiArea
  extends JceStruct
{
  static stPoi cache_poi_info = new stPoi();
  public String description = "";
  public long end_shoot_time;
  public long is_userconfirmed;
  public long photo_num;
  public stPoi poi_info;
  public long poi_photo_num;
  public String scenery_name = "";
  public long start_shoot_time;
  
  public stPhotoPoiArea() {}
  
  public stPhotoPoiArea(long paramLong1, long paramLong2, long paramLong3, long paramLong4, stPoi paramstPoi, String paramString1, String paramString2, long paramLong5)
  {
    this.photo_num = paramLong1;
    this.poi_photo_num = paramLong2;
    this.start_shoot_time = paramLong3;
    this.end_shoot_time = paramLong4;
    this.poi_info = paramstPoi;
    this.description = paramString1;
    this.scenery_name = paramString2;
    this.is_userconfirmed = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.photo_num = paramJceInputStream.read(this.photo_num, 0, true);
    this.poi_photo_num = paramJceInputStream.read(this.poi_photo_num, 1, true);
    this.start_shoot_time = paramJceInputStream.read(this.start_shoot_time, 2, true);
    this.end_shoot_time = paramJceInputStream.read(this.end_shoot_time, 3, true);
    this.poi_info = ((stPoi)paramJceInputStream.read(cache_poi_info, 4, true));
    this.description = paramJceInputStream.readString(5, true);
    this.scenery_name = paramJceInputStream.readString(6, true);
    this.is_userconfirmed = paramJceInputStream.read(this.is_userconfirmed, 7, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.photo_num, 0);
    paramJceOutputStream.write(this.poi_photo_num, 1);
    paramJceOutputStream.write(this.start_shoot_time, 2);
    paramJceOutputStream.write(this.end_shoot_time, 3);
    paramJceOutputStream.write(this.poi_info, 4);
    paramJceOutputStream.write(this.description, 5);
    paramJceOutputStream.write(this.scenery_name, 6);
    paramJceOutputStream.write(this.is_userconfirmed, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.stPhotoPoiArea
 * JD-Core Version:    0.7.0.1
 */