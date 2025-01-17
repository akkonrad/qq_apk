package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public final class MotionEventCompat
{
  public static final int ACTION_HOVER_ENTER = 9;
  public static final int ACTION_HOVER_EXIT = 10;
  public static final int ACTION_HOVER_MOVE = 7;
  public static final int ACTION_MASK = 255;
  public static final int ACTION_POINTER_DOWN = 5;
  public static final int ACTION_POINTER_INDEX_MASK = 65280;
  public static final int ACTION_POINTER_INDEX_SHIFT = 8;
  public static final int ACTION_POINTER_UP = 6;
  public static final int ACTION_SCROLL = 8;
  public static final int AXIS_BRAKE = 23;
  public static final int AXIS_DISTANCE = 24;
  public static final int AXIS_GAS = 22;
  public static final int AXIS_GENERIC_1 = 32;
  public static final int AXIS_GENERIC_10 = 41;
  public static final int AXIS_GENERIC_11 = 42;
  public static final int AXIS_GENERIC_12 = 43;
  public static final int AXIS_GENERIC_13 = 44;
  public static final int AXIS_GENERIC_14 = 45;
  public static final int AXIS_GENERIC_15 = 46;
  public static final int AXIS_GENERIC_16 = 47;
  public static final int AXIS_GENERIC_2 = 33;
  public static final int AXIS_GENERIC_3 = 34;
  public static final int AXIS_GENERIC_4 = 35;
  public static final int AXIS_GENERIC_5 = 36;
  public static final int AXIS_GENERIC_6 = 37;
  public static final int AXIS_GENERIC_7 = 38;
  public static final int AXIS_GENERIC_8 = 39;
  public static final int AXIS_GENERIC_9 = 40;
  public static final int AXIS_HAT_X = 15;
  public static final int AXIS_HAT_Y = 16;
  public static final int AXIS_HSCROLL = 10;
  public static final int AXIS_LTRIGGER = 17;
  public static final int AXIS_ORIENTATION = 8;
  public static final int AXIS_PRESSURE = 2;
  public static final int AXIS_RTRIGGER = 18;
  public static final int AXIS_RUDDER = 20;
  public static final int AXIS_RX = 12;
  public static final int AXIS_RY = 13;
  public static final int AXIS_RZ = 14;
  public static final int AXIS_SIZE = 3;
  public static final int AXIS_THROTTLE = 19;
  public static final int AXIS_TILT = 25;
  public static final int AXIS_TOOL_MAJOR = 6;
  public static final int AXIS_TOOL_MINOR = 7;
  public static final int AXIS_TOUCH_MAJOR = 4;
  public static final int AXIS_TOUCH_MINOR = 5;
  public static final int AXIS_VSCROLL = 9;
  public static final int AXIS_WHEEL = 21;
  public static final int AXIS_X = 0;
  public static final int AXIS_Y = 1;
  public static final int AXIS_Z = 11;
  static final MotionEventVersionImpl IMPL = new BaseMotionEventVersionImpl();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 12)
    {
      IMPL = new HoneycombMr1MotionEventVersionImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      IMPL = new GingerbreadMotionEventVersionImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 5)
    {
      IMPL = new EclairMotionEventVersionImpl();
      return;
    }
  }
  
  public static int findPointerIndex(MotionEvent paramMotionEvent, int paramInt)
  {
    return IMPL.findPointerIndex(paramMotionEvent, paramInt);
  }
  
  public static int getActionIndex(MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getAction() & 0xFF00) >> 8;
  }
  
  public static int getActionMasked(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getAction() & 0xFF;
  }
  
  public static float getAxisValue(MotionEvent paramMotionEvent, int paramInt)
  {
    return IMPL.getAxisValue(paramMotionEvent, paramInt);
  }
  
  public static float getAxisValue(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    return IMPL.getAxisValue(paramMotionEvent, paramInt1, paramInt2);
  }
  
  public static int getPointerCount(MotionEvent paramMotionEvent)
  {
    return IMPL.getPointerCount(paramMotionEvent);
  }
  
  public static int getPointerId(MotionEvent paramMotionEvent, int paramInt)
  {
    return IMPL.getPointerId(paramMotionEvent, paramInt);
  }
  
  public static int getSource(MotionEvent paramMotionEvent)
  {
    return IMPL.getSource(paramMotionEvent);
  }
  
  public static float getX(MotionEvent paramMotionEvent, int paramInt)
  {
    return IMPL.getX(paramMotionEvent, paramInt);
  }
  
  public static float getY(MotionEvent paramMotionEvent, int paramInt)
  {
    return IMPL.getY(paramMotionEvent, paramInt);
  }
  
  static class BaseMotionEventVersionImpl
    implements MotionEventCompat.MotionEventVersionImpl
  {
    public int findPointerIndex(MotionEvent paramMotionEvent, int paramInt)
    {
      if (paramInt == 0) {
        return 0;
      }
      return -1;
    }
    
    public float getAxisValue(MotionEvent paramMotionEvent, int paramInt)
    {
      return 0.0F;
    }
    
    public float getAxisValue(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
    {
      return 0.0F;
    }
    
    public int getPointerCount(MotionEvent paramMotionEvent)
    {
      return 1;
    }
    
    public int getPointerId(MotionEvent paramMotionEvent, int paramInt)
    {
      if (paramInt == 0) {
        return 0;
      }
      throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
    
    public int getSource(MotionEvent paramMotionEvent)
    {
      return 0;
    }
    
    public float getX(MotionEvent paramMotionEvent, int paramInt)
    {
      if (paramInt == 0) {
        return paramMotionEvent.getX();
      }
      throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
    
    public float getY(MotionEvent paramMotionEvent, int paramInt)
    {
      if (paramInt == 0) {
        return paramMotionEvent.getY();
      }
      throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
  }
  
  static class EclairMotionEventVersionImpl
    extends MotionEventCompat.BaseMotionEventVersionImpl
  {
    public int findPointerIndex(MotionEvent paramMotionEvent, int paramInt)
    {
      return MotionEventCompatEclair.findPointerIndex(paramMotionEvent, paramInt);
    }
    
    public int getPointerCount(MotionEvent paramMotionEvent)
    {
      return MotionEventCompatEclair.getPointerCount(paramMotionEvent);
    }
    
    public int getPointerId(MotionEvent paramMotionEvent, int paramInt)
    {
      return MotionEventCompatEclair.getPointerId(paramMotionEvent, paramInt);
    }
    
    public float getX(MotionEvent paramMotionEvent, int paramInt)
    {
      return MotionEventCompatEclair.getX(paramMotionEvent, paramInt);
    }
    
    public float getY(MotionEvent paramMotionEvent, int paramInt)
    {
      return MotionEventCompatEclair.getY(paramMotionEvent, paramInt);
    }
  }
  
  static class GingerbreadMotionEventVersionImpl
    extends MotionEventCompat.EclairMotionEventVersionImpl
  {
    public int getSource(MotionEvent paramMotionEvent)
    {
      return MotionEventCompatGingerbread.getSource(paramMotionEvent);
    }
  }
  
  static class HoneycombMr1MotionEventVersionImpl
    extends MotionEventCompat.GingerbreadMotionEventVersionImpl
  {
    public float getAxisValue(MotionEvent paramMotionEvent, int paramInt)
    {
      return MotionEventCompatHoneycombMr1.getAxisValue(paramMotionEvent, paramInt);
    }
    
    public float getAxisValue(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
    {
      return MotionEventCompatHoneycombMr1.getAxisValue(paramMotionEvent, paramInt1, paramInt2);
    }
  }
  
  static abstract interface MotionEventVersionImpl
  {
    public abstract int findPointerIndex(MotionEvent paramMotionEvent, int paramInt);
    
    public abstract float getAxisValue(MotionEvent paramMotionEvent, int paramInt);
    
    public abstract float getAxisValue(MotionEvent paramMotionEvent, int paramInt1, int paramInt2);
    
    public abstract int getPointerCount(MotionEvent paramMotionEvent);
    
    public abstract int getPointerId(MotionEvent paramMotionEvent, int paramInt);
    
    public abstract int getSource(MotionEvent paramMotionEvent);
    
    public abstract float getX(MotionEvent paramMotionEvent, int paramInt);
    
    public abstract float getY(MotionEvent paramMotionEvent, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.MotionEventCompat
 * JD-Core Version:    0.7.0.1
 */