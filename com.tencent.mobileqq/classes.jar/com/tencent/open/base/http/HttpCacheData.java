package com.tencent.open.base.http;

import alfn;
import android.content.ContentValues;
import android.os.Parcel;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.component.cache.database.DbCacheData;
import com.tencent.open.component.cache.database.DbCacheData.DbCreator;

public class HttpCacheData
  extends DbCacheData
{
  public static final DbCacheData.DbCreator a;
  public long a;
  public String a;
  public long b;
  public String b;
  public String c;
  public String d;
  
  static
  {
    jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheData$DbCreator = new alfn();
  }
  
  public HttpCacheData(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.c = paramString3;
  }
  
  HttpCacheData(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangString = MD5Utils.b(paramString1);
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public void a(ContentValues paramContentValues)
  {
    paramContentValues.put("urlKey", this.jdField_a_of_type_JavaLangString);
    paramContentValues.put("ETag", this.jdField_b_of_type_JavaLangString);
    paramContentValues.put("lastModify", Long.valueOf(this.jdField_a_of_type_Long));
    paramContentValues.put("cacheTime", Long.valueOf(this.jdField_b_of_type_Long));
    Parcel localParcel = Parcel.obtain();
    localParcel.writeString(this.c);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    paramContentValues.put("response", arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.base.http.HttpCacheData
 * JD-Core Version:    0.7.0.1
 */