package com.tencent.common.config.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

public class QZoneConfigProvider
  extends ContentProvider
  implements QZoneConfigConst
{
  private static final UriMatcher jdField_a_of_type_AndroidContentUriMatcher = ;
  private QZConfigSqliteManager jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager;
  
  private int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int i = this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.d(paramString, paramArrayOfString);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }
  
  private int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.b(paramUri, paramArrayOfContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }
  
  private static UriMatcher a()
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_configs", 1);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_cookie", 2);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_update", 3);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_isp_config", 4);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_delete", 6);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_check_time", 5);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_navigator_bar", 8);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "table_qz_unread", 9);
    return localUriMatcher;
  }
  
  private Cursor a(String[] paramArrayOfString)
  {
    return this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.c(paramArrayOfString);
  }
  
  private Cursor a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.b(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    paramContentValues.put("name", "cookie");
    paramUri = this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.d(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Cursor b(String[] paramArrayOfString)
  {
    return this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.a(paramArrayOfString);
  }
  
  private Cursor b(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.c(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri b(Uri paramUri, ContentValues paramContentValues)
  {
    paramContentValues.put("name", "check_time");
    paramUri = this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.e(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Cursor c(String[] paramArrayOfString)
  {
    return this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.b(paramArrayOfString);
  }
  
  private Cursor c(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.a(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri c(Uri paramUri, ContentValues paramContentValues)
  {
    paramContentValues.put("name", "updatelog");
    paramUri = this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.f(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Cursor d(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.d(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri d(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.a(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Uri e(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.c(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Uri f(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.b(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Uri g(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.g(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
    {
    default: 
      return this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.a(paramUri, paramArrayOfContentValues);
    }
    return a(paramUri, paramArrayOfContentValues);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
    {
    case 7: 
    default: 
      return 0;
    case 1: 
      return this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.a(paramString, paramArrayOfString);
    case 2: 
      return this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.a();
    case 3: 
      return this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.c();
    case 4: 
      return this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.b(paramString, paramArrayOfString);
    case 6: 
      return this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.d();
    case 5: 
      return this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.b();
    case 8: 
      return this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager.c(paramString, paramArrayOfString);
    }
    return a(paramUri, paramString, paramArrayOfString);
  }
  
  public String getType(Uri paramUri)
  {
    return "";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
    {
    case 6: 
    case 7: 
    default: 
      return null;
    case 1: 
      return d(paramUri, paramContentValues);
    case 2: 
      return a(paramUri, paramContentValues);
    case 3: 
      return c(paramUri, paramContentValues);
    case 4: 
      return e(paramUri, paramContentValues);
    case 5: 
      return b(paramUri, paramContentValues);
    case 8: 
      return f(paramUri, paramContentValues);
    }
    return g(paramUri, paramContentValues);
  }
  
  public boolean onCreate()
  {
    this.jdField_a_of_type_ComTencentCommonConfigProviderQZConfigSqliteManager = new QZConfigSqliteManager(getContext());
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    try
    {
      switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
      {
      case 1: 
        return a(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
      }
    }
    catch (Throwable paramUri)
    {
      if (!QLog.isColorLevel()) {
        break label138;
      }
      QLog.e("QZoneConfigProvider", 2, "query异常", paramUri);
      return null;
    }
    return b(paramArrayOfString1);
    return a(paramArrayOfString1);
    return b(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    return c(paramArrayOfString1);
    return c(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    paramUri = d(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    return paramUri;
    label138:
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.config.provider.QZoneConfigProvider
 * JD-Core Version:    0.7.0.1
 */