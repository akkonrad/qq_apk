package com.tencent.mobileqq.magicface.magicfaceaction;

import com.tencent.mobileqq.app.ThreadManager;
import dyo;
import java.util.Timer;
import java.util.TimerTask;

public class ActionGlobalData
{
  public static final String a = "%param%";
  public static final String b = "mic";
  public static final String c = "gravity";
  private static final int d = 100;
  public static final String d = "touch";
  public static final String e = "non-ver";
  public static final String f = "send";
  public static final String g = "receive";
  public float a;
  public int a;
  private ActionGlobalData.ActionCountdownOver jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData$ActionCountdownOver;
  public MagicfacebackText a;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask = new dyo(this);
  public boolean a;
  public int b;
  public boolean b = false;
  public int c;
  public boolean c;
  private int e = 0;
  public String h = "send";
  public String i = "non-ver";
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  
  public ActionGlobalData()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Float = this.jdField_c_of_type_Int;
    ThreadManager.a().schedule(this.jdField_a_of_type_JavaUtilTimerTask, 0L, 100L);
  }
  
  public void a(ActionGlobalData.ActionCountdownOver paramActionCountdownOver)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData$ActionCountdownOver = paramActionCountdownOver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData
 * JD-Core Version:    0.7.0.1
 */