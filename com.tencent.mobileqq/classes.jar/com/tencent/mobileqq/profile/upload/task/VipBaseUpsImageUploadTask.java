package com.tencent.mobileqq.profile.upload.task;

import com.tencent.upload.uinterface.data.UpsImageUploadTask;

public class VipBaseUpsImageUploadTask
  extends VipBaseUploadTask
{
  public long b;
  public byte[] d;
  public int g;
  public int h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  protected String k;
  public int l = 1;
  
  public VipBaseUpsImageUploadTask()
  {
    this.jdField_g_of_type_Int = 13;
    this.jdField_k_of_type_Int = 3;
  }
  
  public VipBaseUpsImageUploadTask(long paramLong, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    super(paramLong, paramString1, paramArrayOfByte);
    this.jdField_g_of_type_Int = 13;
    this.jdField_k_of_type_Int = 3;
    this.jdField_k_of_type_JavaLangString = paramString2;
  }
  
  public VipBaseUploadTask a()
  {
    UpsImageUploadTask localUpsImageUploadTask = new UpsImageUploadTask(this.jdField_g_of_type_JavaLangString);
    localUpsImageUploadTask.b2Gt = this.jdField_a_of_type_ArrayOfByte;
    localUpsImageUploadTask.dataType = this.jdField_g_of_type_Int;
    localUpsImageUploadTask.fileId = this.jdField_i_of_type_JavaLangString;
    localUpsImageUploadTask.flowId = this.jdField_e_of_type_Int;
    localUpsImageUploadTask.iBatchID = this.jdField_b_of_type_Long;
    localUpsImageUploadTask.iBatchUploadCount = this.jdField_h_of_type_Int;
    localUpsImageUploadTask.iBusiNessType = this.jdField_i_of_type_Int;
    localUpsImageUploadTask.iCurrentUploadOrder = this.jdField_j_of_type_Int;
    localUpsImageUploadTask.iSync = this.c;
    localUpsImageUploadTask.iUin = this.jdField_a_of_type_Long;
    localUpsImageUploadTask.iUploadType = this.jdField_k_of_type_Int;
    localUpsImageUploadTask.keepRaw = this.l;
    localUpsImageUploadTask.md5 = this.jdField_h_of_type_JavaLangString;
    localUpsImageUploadTask.preupload = this.jdField_d_of_type_Int;
    localUpsImageUploadTask.reportRefer = this.jdField_d_of_type_JavaLangString;
    localUpsImageUploadTask.sBusinessId = this.jdField_k_of_type_JavaLangString;
    localUpsImageUploadTask.sCommand = this.jdField_j_of_type_JavaLangString;
    localUpsImageUploadTask.sRefer = this.jdField_e_of_type_JavaLangString;
    localUpsImageUploadTask.transferData = this.jdField_a_of_type_JavaUtilMap;
    localUpsImageUploadTask.uiRefer = this.f;
    localUpsImageUploadTask.uploadTaskCallback = this.jdField_a_of_type_ComTencentUploadUinterfaceIUploadTaskCallback;
    localUpsImageUploadTask.vBusiNessData = this.jdField_d_of_type_ArrayOfByte;
    localUpsImageUploadTask.vLoginData = this.jdField_b_of_type_ArrayOfByte;
    this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask = localUpsImageUploadTask;
    return this;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.upload.task.VipBaseUpsImageUploadTask
 * JD-Core Version:    0.7.0.1
 */