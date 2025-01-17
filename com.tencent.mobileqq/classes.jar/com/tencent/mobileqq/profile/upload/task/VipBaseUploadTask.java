package com.tencent.mobileqq.profile.upload.task;

import agqj;
import android.text.TextUtils;
import com.tencent.mobileqq.profile.upload.VipUploadUtils;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadService.UploadServiceCreator;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class VipBaseUploadTask
{
  public int a;
  public long a;
  protected AbstractUploadTask a;
  protected IUploadTaskCallback a;
  public Object a;
  public Map a;
  public byte[] a;
  public int b;
  protected IUploadTaskCallback b;
  protected String b;
  public byte[] b;
  public int c;
  public String c;
  protected byte[] c;
  public int d;
  public String d;
  protected int e;
  public String e;
  public volatile int f = -10001;
  public String f;
  protected String g;
  protected String h;
  
  public VipBaseUploadTask()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 6;
    this.jdField_c_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "mqq";
    this.jdField_e_of_type_Int = -1;
    this.jdField_b_of_type_ComTencentUploadUinterfaceIUploadTaskCallback = new agqj(this);
  }
  
  public VipBaseUploadTask(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 6;
    this.jdField_c_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "mqq";
    this.jdField_e_of_type_Int = -1;
    this.jdField_b_of_type_ComTencentUploadUinterfaceIUploadTaskCallback = new agqj(this);
    this.jdField_a_of_type_Long = paramLong;
    this.g = paramString;
    this.h = VipUploadUtils.a(paramString);
    this.jdField_e_of_type_Int = a();
    this.jdField_c_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentUploadUinterfaceIUploadTaskCallback = this.jdField_b_of_type_ComTencentUploadUinterfaceIUploadTaskCallback;
  }
  
  protected int a()
  {
    if (this.g == null) {}
    for (String str = "";; str = this.g) {
      return (str + System.currentTimeMillis()).hashCode();
    }
  }
  
  public final Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public final String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask == null) {
      throw new NullPointerException("Are you forget call buildTask()?");
    }
    if (!a()) {
      return;
    }
    b();
    b();
  }
  
  public abstract void a(int paramInt, Object... paramVarArgs);
  
  protected boolean a()
  {
    if ((this.jdField_c_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length == 0))
    {
      this.jdField_b_of_type_ComTencentUploadUinterfaceIUploadTaskCallback.onUploadError(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask, -3, "invalid login data");
      return false;
    }
    return true;
  }
  
  protected void b()
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localHashMap.put("task_state", this.jdField_b_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.uiRefer)) {
      localHashMap.put("business_refer", this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.uiRefer);
    }
    this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.transferData = localHashMap;
  }
  
  protected boolean b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.uploadFilePath))
    {
      this.jdField_b_of_type_ComTencentUploadUinterfaceIUploadTaskCallback.onUploadError(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask, -1, "no file path!");
      return false;
    }
    File localFile = new File(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.uploadFilePath);
    if ((localFile == null) || (!localFile.exists()) || (localFile.length() == 0L) || (localFile.isDirectory()))
    {
      this.jdField_b_of_type_ComTencentUploadUinterfaceIUploadTaskCallback.onUploadError(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask, -2, "file is not exist or empty!");
      return false;
    }
    this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.transferData.put("task_state", "running_task");
    return IUploadService.UploadServiceCreator.getInstance().upload(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.upload.task.VipBaseUploadTask
 * JD-Core Version:    0.7.0.1
 */