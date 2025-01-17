package com.tencent.av.redpacket;

import android.media.SoundPool;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import jlh;

public class SoundPoolHelper
{
  int jdField_a_of_type_Int;
  SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  HashMap jdField_a_of_type_JavaUtilHashMap;
  public HashSet a;
  List jdField_a_of_type_JavaUtilList;
  public int b;
  HashMap b;
  public int c;
  
  public SoundPoolHelper(List paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_Int = paramList.size();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoundPoolHelper", 2, "releaseMusic");
    }
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null)
    {
      this.jdField_a_of_type_AndroidMediaSoundPool.release();
      this.jdField_a_of_type_AndroidMediaSoundPool = null;
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashSet.clear();
      this.jdField_b_of_type_JavaUtilHashMap.clear();
      this.c = 0;
    }
  }
  
  public void a(SoundPoolHelper.OnLoadFinishListener paramOnLoadFinishListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoundPoolHelper", 2, "loadMusic ,soundPool = " + this.jdField_a_of_type_AndroidMediaSoundPool);
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("SoundPoolHelper", 2, "loadMusic fail filPathList is empty");
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_AndroidMediaSoundPool == null)
      {
        this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_Int, 0);
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new jlh(this, paramOnLoadFinishListener));
      }
      paramOnLoadFinishListener = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramOnLoadFinishListener.hasNext())
      {
        String str = (String)paramOnLoadFinishListener.next();
        int i = this.jdField_a_of_type_AndroidMediaSoundPool.load(str, 1);
        this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(i));
      }
    }
  }
  
  public void a(String paramString)
  {
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localInteger == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SoundPoolHelper", 2, "stopMusic fail soundID is null, path = " + paramString);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_JavaUtilHashSet.contains(localInteger)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("SoundPoolHelper", 2, "stopMusic fail soundID is not ready, path = " + paramString);
        return;
        localInteger = (Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
        if (localInteger != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SoundPoolHelper", 2, "stopMusic fail steamID is null, path = " + paramString);
      return;
    } while (this.jdField_a_of_type_AndroidMediaSoundPool == null);
    this.jdField_a_of_type_AndroidMediaSoundPool.stop(localInteger.intValue());
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoundPoolHelper", 2, "playMusic, path = " + paramString + ",loop = " + paramBoolean);
    }
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("SoundPoolHelper", 2, "playMusic fail path is empty ");
      }
    }
    Integer localInteger;
    do
    {
      do
      {
        do
        {
          return;
          localInteger = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          if (localInteger != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("SoundPoolHelper", 2, "playMusic fail soundID is null, path = " + paramString + ",loop = " + paramBoolean);
        return;
        if (this.jdField_a_of_type_JavaUtilHashSet.contains(localInteger)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SoundPoolHelper", 2, "playMusic fail soundID is not ready, path = " + paramString + ",loop = " + paramBoolean);
      return;
    } while (this.jdField_a_of_type_AndroidMediaSoundPool == null);
    SoundPool localSoundPool = this.jdField_a_of_type_AndroidMediaSoundPool;
    int j = localInteger.intValue();
    if (paramBoolean) {}
    for (int i = -1;; i = 0)
    {
      i = localSoundPool.play(j, 1.0F, 1.0F, 1, i, 1.0F);
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.redpacket.SoundPoolHelper
 * JD-Core Version:    0.7.0.1
 */