package com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;

public class PTVSwitchControl
{
  public static boolean a = false;
  
  static
  {
    if (CameraCompatibleList.e(CameraCompatibleList.B)) {
      a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.PTVSwitchControl
 * JD-Core Version:    0.7.0.1
 */