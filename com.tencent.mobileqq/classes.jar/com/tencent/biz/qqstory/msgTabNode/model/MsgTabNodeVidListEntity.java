package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="unionId,nodeType,requestSource")
public class MsgTabNodeVidListEntity
  extends Entity
{
  public int nodeType;
  public long reqTimeStamp;
  public int requestSource;
  public byte[] rspData;
  public String unionId;
  
  public static String[] getArgs(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    int i = paramMsgTabNodeInfo.jdField_a_of_type_Int;
    if (paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString == null) {}
    for (String str = "";; str = paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString) {
      return new String[] { String.valueOf(i), str, String.valueOf(paramMsgTabNodeInfo.e) };
    }
  }
  
  public static String getSelection()
  {
    return "nodeType=? and unionId=? and requestSource=?";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListEntity
 * JD-Core Version:    0.7.0.1
 */