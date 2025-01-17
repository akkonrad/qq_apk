package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="troopuin,memberuin")
public class TroopMemberCardInfo
  extends Entity
{
  public int charm;
  public String email;
  public String job;
  public String level;
  public String memberuin;
  public String memo;
  public String name;
  public String nick;
  public byte sex = -1;
  public String tel;
  public int torchFlag;
  public String troopuin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopMemberCardInfo
 * JD-Core Version:    0.7.0.1
 */