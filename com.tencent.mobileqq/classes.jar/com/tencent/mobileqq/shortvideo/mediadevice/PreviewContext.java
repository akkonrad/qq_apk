package com.tencent.mobileqq.shortvideo.mediadevice;

import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.maxvideo.common.ControlFlagEnum;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.HwFrame;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class PreviewContext
{
  public static final boolean SG_SUPPORT_CALLBACK = true;
  private static final String TAG = "PreviewContext";
  public static final boolean USE_USER_BUFFER = true;
  private static final int sCheckSizeLimt = 32;
  int fps = 0;
  int frameCount = 0;
  AVCodec mAVCodec = null;
  public boolean mActivtiyDestory = false;
  int mBlockIndex = 0;
  public CameraProxy mCamera;
  private boolean mCheckedDataValid;
  private boolean mDisablePrivilage;
  public AtomicReference mEncodeRef = new AtomicReference(null);
  ArrayList mFrameCountArray = new ArrayList();
  private int mFrameIndex;
  private volatile boolean mFrameProcessEnd;
  List mFrameSrcList = new ArrayList();
  private boolean mInitHwEncode;
  int mLastFrameIndex = 0;
  public Handler mMsghandler;
  public boolean mPTVRealBeauty;
  private AVIOStruct mPTVRealBeautyCache = new AVIOStruct();
  private int mRecordToCache;
  private long[] mTimeStamp = new long[1];
  public AtomicInteger mVideoFrameProcess = new AtomicInteger(0);
  public AtomicInteger mVideoFrameWrite = new AtomicInteger(0);
  int mWriteFrameCount = 0;
  private Object mlock = new Object();
  Object mlockFrame = new Object();
  public boolean notifyFirstFrame;
  long updateTime = 0L;
  
  public PreviewContext(CameraProxy paramCameraProxy, int paramInt1, int paramInt2)
  {
    this.mCamera = paramCameraProxy;
    paramCameraProxy.jdField_b_of_type_Int = paramInt1;
    paramCameraProxy.c = paramInt2;
    this.mInitHwEncode = initHwCallBackSecurity();
    this.mFrameProcessEnd = false;
    this.mVideoFrameWrite.getAndSet(0);
    this.mVideoFrameProcess.getAndSet(0);
    this.mCheckedDataValid = false;
    this.mDisablePrivilage = false;
  }
  
  public static boolean checkIsDisablePrivilage(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return true;
    }
    if (paramArrayOfByte.length < paramInt) {
      return true;
    }
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      i += (paramArrayOfByte[j] & 0xFF);
      j += 1;
    }
    paramInt = paramArrayOfByte.length - paramInt;
    while (paramInt < paramArrayOfByte.length)
    {
      i += (paramArrayOfByte[paramInt] & 0xFF);
      paramInt += 1;
    }
    return i == 0;
  }
  
  private boolean checkPreviewDataLength(AVIOStruct paramAVIOStruct, byte[] paramArrayOfByte)
  {
    int i = paramAVIOStruct.vHeight;
    int j = paramAVIOStruct.vWidth;
    int k = paramAVIOStruct.vFormat;
    if (QLog.isColorLevel()) {
      QLog.d("PreviewContext", 2, "[@] checkPreviewDataLength,height = " + i + ",width = " + j + ",imgFmt = " + k + ",data.length = " + paramArrayOfByte.length + " Build.MODEL=" + Build.MODEL + " Build.CPU_ABI=" + Build.CPU_ABI);
    }
    switch (k)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("PreviewContext", 2, "[@] checkPreviewDataLength error 3,imgFmt  = " + k);
      }
      break;
    }
    do
    {
      do
      {
        return true;
        if (i * j * 2 == paramArrayOfByte.length) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PreviewContext", 2, "[@] checkPreviewDataLength error 1 [Build.MODEL=" + Build.MODEL + "]");
      return true;
      if (i * j * 3 / 2 == paramArrayOfByte.length) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PreviewContext", 2, "[@] checkPreviewDataLength error 2 [Build.MODEL=" + Build.MODEL + "]");
    return true;
    return false;
  }
  
  private native int getProcessedFrameData(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt);
  
  private native boolean initHwCallBack();
  
  private boolean initHwCallBackSecurity()
  {
    try
    {
      boolean bool = initHwCallBack();
      return bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    return false;
  }
  
  public void addUserBufferRecycle(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      CameraControl.a().a(true, paramArrayOfByte);
    }
  }
  
  public void encodeOneFrameNotify()
  {
    SVHwEncoder localSVHwEncoder = (SVHwEncoder)this.mEncodeRef.get();
    if (localSVHwEncoder != null)
    {
      localHwFrame = localSVHwEncoder.a();
      if (localHwFrame == null) {
        if (QLog.isColorLevel()) {
          QLog.d("PreviewContext", 2, "[@] encodeOneFrameNotify frame is null");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      int i;
      do
      {
        SVHwEncoder.HwFrame localHwFrame;
        return;
        int j = localSVHwEncoder.jdField_a_of_type_Int;
        try
        {
          i = getProcessedFrameData(localHwFrame.jdField_a_of_type_ArrayOfByte, this.mTimeStamp, j);
          if (QLog.isColorLevel()) {
            QLog.d("PreviewContext", 2, "[@] HandleVideo: error=" + i + " colorspace=" + j);
          }
          if (i == 0)
          {
            localHwFrame.jdField_a_of_type_Int = 0;
            localHwFrame.jdField_b_of_type_Int = localHwFrame.jdField_a_of_type_ArrayOfByte.length;
            localHwFrame.jdField_a_of_type_Long = this.mTimeStamp[0];
            localHwFrame.jdField_a_of_type_Boolean = false;
            localHwFrame.jdField_b_of_type_Boolean = true;
            localSVHwEncoder.a(localHwFrame, true);
            return;
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            i = -1001;
          }
          this.mEncodeRef.getAndSet(null);
        }
      } while (!QLog.isColorLevel());
      QLog.d("PreviewContext", 2, "[@] HandleVideo: error=" + i + " set encode to null...");
      return;
    }
    QLog.d("PreviewContext", 2, "[@] HandleVideo: [encodeOneFrameNotify] encode=null");
  }
  
  public int getFrameIndex()
  {
    return this.mFrameIndex;
  }
  
  public void getPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PreviewContext", 2, "[@] onPreviewFrame start Build.MODEL=" + Build.MODEL + ", Build.CPU_ABI=" + Build.CPU_ABI + ", notifyFirstFrame=" + this.notifyFirstFrame);
    }
    int i;
    if (this.updateTime == 0L)
    {
      this.updateTime = SystemClock.uptimeMillis();
      this.frameCount = 0;
      if (NewFlowCameraActivity.c == 0L) {
        NewFlowCameraActivity.c = SystemClock.elapsedRealtime();
      }
      if (this.frameCount == 100)
      {
        paramCamera = new StringBuilder().append("fps = ");
        i = (int)(this.frameCount * 1000 / (SystemClock.uptimeMillis() - this.updateTime));
        this.fps = i;
        QLog.d("PreviewContext", 2, i);
        this.updateTime = 0L;
        this.frameCount = 0;
      }
      if (this.mCheckedDataValid) {
        break label248;
      }
      if (!CameraCompatibleList.a(CameraCompatibleList.p)) {
        break label240;
      }
      this.mDisablePrivilage = checkIsDisablePrivilage(paramArrayOfByte, 32);
      label192:
      this.mCheckedDataValid = true;
      if (!this.mDisablePrivilage) {
        break label255;
      }
      this.mCamera.a.a(12, new Object[] { "camera disabled zero data." });
    }
    label564:
    label590:
    label1003:
    for (;;)
    {
      return;
      this.frameCount += 1;
      break;
      label240:
      this.mDisablePrivilage = false;
      break label192;
      label248:
      if (!this.mDisablePrivilage)
      {
        label255:
        if (paramArrayOfByte == null)
        {
          CameraControl.a().a(true);
          return;
        }
        this.mRecordToCache = 0;
        if (!this.mPTVRealBeauty) {
          sendFirstFrameMsg();
        }
        paramCamera = null;
        if (!this.mFrameSrcList.isEmpty()) {
          paramCamera = (AVIOStruct)this.mFrameSrcList.get(this.mFrameSrcList.size() - 1);
        }
        Object localObject;
        if (paramCamera != null)
        {
          if (!Lock.jdField_a_of_type_Boolean) {
            break label590;
          }
          if (paramCamera.pControlFlag != ControlFlagEnum.NONE.getValue()) {
            break label564;
          }
          localObject = CameraControl.a().a();
          i = CameraControl.a().a();
          paramCamera.vWidth = ((CameraControl.CustomSize)localObject).jdField_a_of_type_Int;
          paramCamera.vHeight = ((CameraControl.CustomSize)localObject).jdField_b_of_type_Int;
          paramCamera.vFormat = i;
          paramCamera.vOrientation = CameraControl.a().b();
          paramCamera.vFPS = CodecParam.g;
          paramCamera.pControlFlag = ControlFlagEnum.OPEN_FILE_AND_WRITE_FRAME_DATA.getValue();
          paramCamera.vBitrate = CodecParam.f;
          paramCamera.pCodec = CodecParam.jdField_b_of_type_Int;
        }
        for (;;)
        {
          if ((paramCamera != null) && (paramCamera.isWriteFrame()))
          {
            boolean bool = checkPreviewDataLength(paramCamera, paramArrayOfByte);
            if (QLog.isColorLevel()) {
              QLog.d("PreviewContext", 2, "[@] onPreviewFrame PreviewDataLength error : " + bool + " Build.MODEL=" + Build.MODEL + " Build.CPU_ABI=" + Build.CPU_ABI);
            }
            if (bool)
            {
              this.mCamera.a.a(8, new Object[] { "unacceptable camera preview data" });
              if (1 != FlowCameraMqqAction.jdField_a_of_type_Int) {
                break;
              }
              QzoneVideoBeaconReport.a(GloableValue.jdField_a_of_type_Long + "", "qzone_video_record", "8", null);
              return;
              if (paramCamera.pControlFlag != ControlFlagEnum.OPEN_FILE_AND_WRITE_FRAME_DATA.getValue()) {
                continue;
              }
              paramCamera.pControlFlag = ControlFlagEnum.WRITE_FRAME_DATA.getValue();
              continue;
              if (paramCamera.pControlFlag == ControlFlagEnum.WRITE_FRAME_DATA.getValue())
              {
                paramCamera.pControlFlag = ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue();
                continue;
              }
              if (paramCamera.pControlFlag != ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue()) {
                continue;
              }
              paramCamera.pControlFlag = ControlFlagEnum.NONE.getValue();
              continue;
            }
            i = this.mFrameIndex;
            this.mFrameIndex = (i + 1);
            paramCamera.pFrameIndex = i;
            paramCamera.vFrameTime = SystemClock.elapsedRealtime();
            this.mWriteFrameCount += 1;
            this.mRecordToCache = 1;
            if (!this.mPTVRealBeauty)
            {
              this.mVideoFrameWrite.incrementAndGet();
              this.mAVCodec.copyQQBuf(paramArrayOfByte, paramCamera);
              QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new PreviewContext.HandleVideo(this));
            }
          }
        }
        if (this.mPTVRealBeauty)
        {
          localObject = Message.obtain(this.mMsghandler);
          ((Message)localObject).what = -16716526;
          ((Message)localObject).arg1 = this.mRecordToCache;
          ((Message)localObject).arg2 = 1;
          ((Message)localObject).obj = paramArrayOfByte;
          if (this.mRecordToCache == 1)
          {
            PreviewContext.VFrameData localVFrameData = new PreviewContext.VFrameData();
            localVFrameData.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
            localVFrameData.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct = ((AVIOStruct)paramCamera.clone());
            ((Message)localObject).obj = localVFrameData;
            if (this.mMsghandler != null) {
              this.mMsghandler.sendMessage((Message)localObject);
            }
          }
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label1003;
          }
          QLog.d("PreviewContext", 2, "[@] onPreviewFrame end,mFrameIndex  = " + this.mFrameIndex);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("PreviewContext", 2, "[@] mPTVRealBeauty: [Build.MODEL=" + Build.MODEL + "]  mMsghandler=" + this.mMsghandler);
          }
          paramCamera = CameraControl.a().a();
          if (paramCamera == null) {
            break;
          }
          i = CameraControl.a().a();
          this.mPTVRealBeautyCache.vWidth = paramCamera.jdField_a_of_type_Int;
          this.mPTVRealBeautyCache.vHeight = paramCamera.jdField_b_of_type_Int;
          this.mPTVRealBeautyCache.vFormat = i;
          if (!checkPreviewDataLength(this.mPTVRealBeautyCache, paramArrayOfByte)) {
            break label811;
          }
          this.mCamera.a.a(8, new Object[] { "unacceptable camera preview data" });
          return;
          CameraControl.a().a(true, paramArrayOfByte);
        }
      }
    }
  }
  
  public int getRemainedRecordFrames(int paramInt)
  {
    if (paramInt >= this.mFrameCountArray.size()) {
      return 0;
    }
    int j = this.mFrameIndex;
    int i = 0;
    while (i < paramInt)
    {
      j -= ((Integer)this.mFrameCountArray.get(this.mFrameCountArray.size() - (i + 1))).intValue();
      i += 1;
    }
    return j;
  }
  
  public int getSegmentCount()
  {
    if (this.mFrameSrcList != null) {
      return this.mFrameSrcList.size();
    }
    return 0;
  }
  
  public void lockFrameSync()
  {
    if (!this.mFrameProcessEnd)
    {
      synchronized (this.mlock)
      {
        boolean bool = this.mFrameProcessEnd;
        if (bool) {}
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreviewContext", 2, "lockFrameSync start wait");
        }
        this.mlock.wait(2000L);
        if (QLog.isColorLevel()) {
          QLog.d("PreviewContext", 2, "lockFrameSync wait finish");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        label63:
        break label63;
      }
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void removeLatestVideo()
  {
    if ((this.mFrameSrcList != null) && (this.mFrameSrcList.size() > 0)) {
      this.mFrameSrcList.remove(this.mFrameSrcList.size() - 1);
    }
    if (this.mFrameCountArray.size() > 0)
    {
      this.mFrameIndex -= ((Integer)this.mFrameCountArray.get(this.mFrameCountArray.size() - 1)).intValue();
      if (this.mFrameIndex <= 0) {
        this.mFrameIndex = 0;
      }
      this.mFrameCountArray.remove(this.mFrameCountArray.size() - 1);
      if (this.mFrameCountArray.size() == 0)
      {
        this.mFrameIndex = 0;
        this.mFrameSrcList.clear();
      }
    }
  }
  
  public void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreviewContext", 2, "[@] reset");
    }
    if (this.mFrameSrcList != null) {
      this.mFrameSrcList.clear();
    }
    this.mFrameCountArray.clear();
    this.mBlockIndex = 0;
    this.mLastFrameIndex = 0;
    this.mWriteFrameCount = 0;
    this.mFrameIndex = 0;
  }
  
  public void sendFirstFrameMsg()
  {
    if ((this.notifyFirstFrame) && (this.mCamera != null))
    {
      this.mCamera.a.a(10, new Object[] { "getted" });
      this.notifyFirstFrame = false;
    }
  }
  
  public void setFrameIndex(int paramInt)
  {
    this.mFrameIndex = paramInt;
  }
  
  public void startCapture()
  {
    if (!Lock.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.mFrameSrcList == null) {
      this.mFrameSrcList = new ArrayList();
    }
    AVIOStruct localAVIOStruct = new AVIOStruct();
    int i = this.mBlockIndex;
    this.mBlockIndex = (i + 1);
    localAVIOStruct.pBlockIndex = i;
    this.mFrameSrcList.add(localAVIOStruct);
    this.mLastFrameIndex = this.mFrameIndex;
  }
  
  public void stopCapture()
  {
    this.mFrameCountArray.add(Integer.valueOf(this.mFrameIndex - this.mLastFrameIndex));
  }
  
  public void unlockFrameSync()
  {
    synchronized (this.mlock)
    {
      this.mFrameProcessEnd = true;
      this.mlock.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("PreviewContext", 2, "unlockFrameSync notifyAll");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext
 * JD-Core Version:    0.7.0.1
 */