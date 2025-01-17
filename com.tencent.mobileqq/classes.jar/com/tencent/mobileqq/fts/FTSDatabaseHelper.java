package com.tencent.mobileqq.fts;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.tencent.mobileqq.data.fts.FTSTroop;
import com.tencent.mobileqq.data.fts.TroopIndex;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FTSDatabaseHelper
{
  public static int a(FTSDatabase paramFTSDatabase, String paramString)
  {
    paramString = "SELECT cursor FROM " + paramString + " WHERE id=1;";
    try
    {
      int i = c(paramFTSDatabase, paramString);
      return i;
    }
    catch (SQLiteException paramFTSDatabase) {}
    return -1;
  }
  
  public static int a(FTSDatabase paramFTSDatabase, ArrayList paramArrayList, String paramString, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("FTSDatabaseHelper", 2, "batchTransToDatabase: entities == null");
      }
      return -1;
    }
    int k = a(paramFTSDatabase, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("FTSDatabaseHelper", 2, "FTSDatabaseHelper.queryCursorTable = " + k);
    }
    if (k == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("FTSDatabaseHelper", 2, "batchTransToDatabase: syncCursor == -1");
      }
      return -1;
    }
    if (!paramFTSDatabase.b())
    {
      if (QLog.isColorLevel()) {
        QLog.w("FTSDatabaseHelper", 2, "batchTransToDatabase: beginTransaction failed");
      }
      return -1;
    }
    int j = 0;
    int i = 0;
    boolean bool1 = true;
    TroopIndex localTroopIndex;
    if (j < paramArrayList.size())
    {
      FTSTroop localFTSTroop = (FTSTroop)paramArrayList.get(j);
      localTroopIndex = new TroopIndex(localFTSTroop.mType, localFTSTroop.mTroopUin, localFTSTroop.mMemberUin, localFTSTroop.mMemberName, localFTSTroop.mMemberCard, localFTSTroop.mMemberNick);
      localTroopIndex.preWrite();
      switch (localFTSTroop.mOpt)
      {
      default: 
        label224:
        if (bool1) {
          break;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FTSDatabaseHelper", 2, "batchTransToDatabase: insert count = " + i);
      }
      i = paramInt;
      if (paramInt == -1) {
        i = paramArrayList.size();
      }
      if ((bool1) && (paramArrayList.size() != 0) && (i != 0)) {
        bool1 = paramFTSDatabase.a("UPDATE " + paramString + " SET cursor=" + (k + i) + " WHERE id=1;");
      }
      for (;;)
      {
        boolean bool2 = bool1;
        if (bool1) {
          bool2 = paramFTSDatabase.c();
        }
        if (bool2)
        {
          return k + i;
          bool1 = paramFTSDatabase.a(localTroopIndex);
          i += 1;
          break label224;
          bool1 = a(paramFTSDatabase, localTroopIndex);
          break label224;
          bool1 = a(paramFTSDatabase, localTroopIndex);
          if (!bool1) {
            break label428;
          }
          bool1 = paramFTSDatabase.a(localTroopIndex);
          break label224;
          j += 1;
          break;
        }
        return k;
      }
      label428:
      break label224;
    }
  }
  
  public static boolean a(FTSDatabase paramFTSDatabase, TroopIndex paramTroopIndex)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("DELETE FROM " + paramTroopIndex.getTableName() + " WHERE " + paramTroopIndex.getTableName() + " MATCH 'type:");
    localStringBuilder.append(paramTroopIndex.type);
    localStringBuilder.append(" ext1:");
    localStringBuilder.append(paramTroopIndex.ext1);
    if (!TextUtils.isEmpty(paramTroopIndex.ext6))
    {
      localStringBuilder.append(" ext6:");
      localStringBuilder.append(paramTroopIndex.ext6);
    }
    localStringBuilder.append("';");
    return paramFTSDatabase.a(localStringBuilder.toString());
  }
  
  public static boolean a(FTSDatabase paramFTSDatabase, String paramString)
  {
    paramFTSDatabase = paramFTSDatabase.a("SELECT name FROM sqlite_master WHERE type='table' AND name='" + paramString + "'", new int[] { 3 });
    return (paramFTSDatabase != null) && (paramFTSDatabase.size() > 0);
  }
  
  public static int b(FTSDatabase paramFTSDatabase, String paramString)
  {
    paramString = "SELECT COUNT(*) FROM " + paramString;
    try
    {
      int i = c(paramFTSDatabase, paramString);
      return i;
    }
    catch (SQLiteException paramFTSDatabase) {}
    return -1;
  }
  
  public static boolean b(FTSDatabase paramFTSDatabase, String paramString)
  {
    if (!paramFTSDatabase.b()) {}
    do
    {
      return false;
      paramFTSDatabase.a("CREATE TABLE IF NOT EXISTS " + paramString + "(id INTEGER PRIMARY KEY AUTOINCREMENT, cursor INTEGER);");
      paramFTSDatabase.a("INSERT INTO " + paramString + "(cursor) VALUES(0);");
    } while (!paramFTSDatabase.c());
    return true;
  }
  
  public static int c(FTSDatabase paramFTSDatabase, String paramString)
  {
    paramFTSDatabase = paramFTSDatabase.a(paramString, new int[] { 1 });
    if ((paramFTSDatabase == null) || (paramFTSDatabase.size() != 1)) {
      throw new SQLiteException("No result or result size != 1");
    }
    paramFTSDatabase = (Map)paramFTSDatabase.get(0);
    if ((paramFTSDatabase == null) || (paramFTSDatabase.size() != 1)) {
      throw new SQLiteException("No column or column count != 1");
    }
    try
    {
      int i = ((Long)paramFTSDatabase.values().toArray()[0]).intValue();
      return i;
    }
    catch (Exception paramFTSDatabase)
    {
      throw new SQLiteException("No column or column count != 1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.fts.FTSDatabaseHelper
 * JD-Core Version:    0.7.0.1
 */