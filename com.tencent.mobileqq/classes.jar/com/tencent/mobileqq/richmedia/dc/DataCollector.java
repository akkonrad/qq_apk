package com.tencent.mobileqq.richmedia.dc;

import ahny;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class DataCollector
{
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public static String a;
  Handler jdField_a_of_type_AndroidOsHandler = new ahny(this, jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "DataCollector";
    jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Colloector-Tasker");
    jdField_a_of_type_AndroidOsHandlerThread.start();
  }
  
  public DataCollector(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  static Looper a()
  {
    return jdField_a_of_type_AndroidOsHandlerThread.getLooper();
  }
  
  public void a(Message paramMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DataCollector
 * JD-Core Version:    0.7.0.1
 */