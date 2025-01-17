package com.tencent.TMG.camera;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.tencent.TMG.camera.opengl.SurfaceTextureManager;
import com.tencent.TMG.config.ConfigSystemImpl;
import com.tencent.TMG.sdk.AVUILoopProxy;
import com.tencent.TMG.sdk.AVVideoCtrl.AfterPreviewListener;
import com.tencent.TMG.sdk.AVVideoCtrl.CameraPreviewChangeCallback;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.TMG.utils.PhoneStatusTools;
import com.tencent.TMG.utils.QLog;
import com.tencent.TMG.utils.VcSystemInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.hardware.Camera.Size;>;
import java.util.StringTokenizer;

public class VcCamera
{
  static final int BACK_CAMERA = 1;
  static final int CAMERA_NONE = -1;
  static final String CAMERA_THREAD_NAME = "CAMERA";
  static final int FRONT_CAMERA = 0;
  static CameraInformation Info = new CameraInformation();
  static final String TAG = "VcCamera";
  static boolean isCameraOpened = false;
  public static WeakReference<AVVideoCtrl.CameraPreviewChangeCallback> mCameraPreviewChangeCallback = null;
  public static WeakReference<SurfaceHolder> mHolder = null;
  static volatile int nInFPS;
  volatile int CUR_CAMERA = -1;
  int CameraId = -1;
  int CompenSateRecvAngle = 0;
  int CompenSateSendAngle = 0;
  String DEV_MANUFACTURER;
  String DEV_MODEL;
  volatile int LAST_CAMERA = -1;
  int NUM_CAMERA = 0;
  int SDK_VERSION;
  CameraCaptureSettings VideoChatSettings = new CameraCaptureSettings();
  public Object afterPreviewListener;
  public final Object afterPreviewListenerLock = new Object();
  private String androidSysOorientationConfig;
  private Camera.PreviewCallback cameraCallback = new Camera.PreviewCallback()
  {
    /* Error */
    @android.annotation.TargetApi(8)
    public void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 6
      //   3: iconst_1
      //   4: istore 5
      //   6: getstatic 29	com/tencent/TMG/camera/VcCamera:nInFPS	I
      //   9: ifle +228 -> 237
      //   12: aload_0
      //   13: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   16: invokestatic 33	com/tencent/TMG/camera/VcCamera:access$800	(Lcom/tencent/TMG/camera/VcCamera;)Z
      //   19: ifeq +451 -> 470
      //   22: aload_0
      //   23: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   26: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
      //   29: ifne +209 -> 238
      //   32: aload_0
      //   33: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   36: getfield 39	com/tencent/TMG/camera/VcCamera:screenOrientation	I
      //   39: iconst_2
      //   40: if_icmpeq +1292 -> 1332
      //   43: aload_0
      //   44: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   47: getfield 39	com/tencent/TMG/camera/VcCamera:screenOrientation	I
      //   50: iconst_1
      //   51: if_icmpeq +1281 -> 1332
      //   54: aload_0
      //   55: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   58: getfield 43	com/tencent/TMG/camera/VcCamera:devDisplay	Landroid/view/Display;
      //   61: invokevirtual 49	android/view/Display:getRotation	()I
      //   64: bipush 90
      //   66: imul
      //   67: istore_3
      //   68: sipush 360
      //   71: iload_3
      //   72: aload_0
      //   73: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   76: invokevirtual 52	com/tencent/TMG/camera/VcCamera:getOrientation	()I
      //   79: iadd
      //   80: sipush 360
      //   83: irem
      //   84: isub
      //   85: sipush 360
      //   88: irem
      //   89: istore_3
      //   90: iload_3
      //   91: aload_0
      //   92: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   95: invokevirtual 53	com/tencent/TMG/camera/VcCamera:getRotation	()I
      //   98: iadd
      //   99: istore 4
      //   101: aload_0
      //   102: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   105: invokevirtual 52	com/tencent/TMG/camera/VcCamera:getOrientation	()I
      //   108: sipush 270
      //   111: if_icmpeq +15 -> 126
      //   114: aload_0
      //   115: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   118: invokevirtual 52	com/tencent/TMG/camera/VcCamera:getOrientation	()I
      //   121: bipush 90
      //   123: if_icmpne +161 -> 284
      //   126: iload 4
      //   128: istore_3
      //   129: aload_0
      //   130: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   133: invokevirtual 53	com/tencent/TMG/camera/VcCamera:getRotation	()I
      //   136: sipush 180
      //   139: irem
      //   140: ifne +41 -> 181
      //   143: iload 4
      //   145: istore_3
      //   146: aload_0
      //   147: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   150: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
      //   153: ifne +28 -> 181
      //   156: iload 4
      //   158: istore_3
      //   159: aload_0
      //   160: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   163: invokestatic 57	com/tencent/TMG/camera/VcCamera:access$900	(Lcom/tencent/TMG/camera/VcCamera;)Ljava/lang/String;
      //   166: ldc 59
      //   168: invokevirtual 65	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   171: ifne +10 -> 181
      //   174: iload 4
      //   176: sipush 180
      //   179: iadd
      //   180: istore_3
      //   181: aload_0
      //   182: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   185: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
      //   188: ifne +239 -> 427
      //   191: aload_0
      //   192: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   195: getfield 68	com/tencent/TMG/camera/VcCamera:mFrontCameraAngle	I
      //   198: ifle +209 -> 407
      //   201: iload_3
      //   202: sipush 360
      //   205: aload_0
      //   206: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   209: getfield 68	com/tencent/TMG/camera/VcCamera:mFrontCameraAngle	I
      //   212: isub
      //   213: iadd
      //   214: istore_3
      //   215: iload_3
      //   216: sipush 360
      //   219: irem
      //   220: bipush 90
      //   222: idiv
      //   223: istore 7
      //   225: aload_1
      //   226: ifnonnull +471 -> 697
      //   229: ldc 70
      //   231: iconst_0
      //   232: ldc 72
      //   234: invokestatic 78	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   237: return
      //   238: aload_0
      //   239: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   242: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
      //   245: iconst_1
      //   246: if_icmpne +1081 -> 1327
      //   249: aload_0
      //   250: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   253: getfield 43	com/tencent/TMG/camera/VcCamera:devDisplay	Landroid/view/Display;
      //   256: invokevirtual 49	android/view/Display:getRotation	()I
      //   259: istore_3
      //   260: aload_0
      //   261: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   264: invokevirtual 52	com/tencent/TMG/camera/VcCamera:getOrientation	()I
      //   267: iload_3
      //   268: bipush 90
      //   270: imul
      //   271: isub
      //   272: sipush 360
      //   275: iadd
      //   276: sipush 360
      //   279: irem
      //   280: istore_3
      //   281: goto -191 -> 90
      //   284: aload_0
      //   285: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   288: invokevirtual 52	com/tencent/TMG/camera/VcCamera:getOrientation	()I
      //   291: ifeq +19 -> 310
      //   294: iload 4
      //   296: istore_3
      //   297: aload_0
      //   298: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   301: invokevirtual 52	com/tencent/TMG/camera/VcCamera:getOrientation	()I
      //   304: sipush 180
      //   307: if_icmpne -126 -> 181
      //   310: aload_0
      //   311: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   314: invokevirtual 53	com/tencent/TMG/camera/VcCamera:getRotation	()I
      //   317: bipush 90
      //   319: if_icmpeq +16 -> 335
      //   322: aload_0
      //   323: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   326: invokevirtual 53	com/tencent/TMG/camera/VcCamera:getRotation	()I
      //   329: sipush 270
      //   332: if_icmpne +39 -> 371
      //   335: iload 4
      //   337: istore_3
      //   338: aload_0
      //   339: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   342: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
      //   345: ifne -164 -> 181
      //   348: iload 4
      //   350: istore_3
      //   351: aload_0
      //   352: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   355: getfield 82	com/tencent/TMG/camera/VcCamera:mbIsTablet	Z
      //   358: ifne -177 -> 181
      //   361: iload 4
      //   363: sipush 180
      //   366: iadd
      //   367: istore_3
      //   368: goto -187 -> 181
      //   371: iload 4
      //   373: istore_3
      //   374: aload_0
      //   375: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   378: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
      //   381: ifne -200 -> 181
      //   384: iload 4
      //   386: istore_3
      //   387: aload_0
      //   388: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   391: getfield 82	com/tencent/TMG/camera/VcCamera:mbIsTablet	Z
      //   394: ifeq -213 -> 181
      //   397: iload 4
      //   399: sipush 180
      //   402: iadd
      //   403: istore_3
      //   404: goto -223 -> 181
      //   407: iload_3
      //   408: aload_0
      //   409: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   412: aload_0
      //   413: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   416: invokevirtual 53	com/tencent/TMG/camera/VcCamera:getRotation	()I
      //   419: invokevirtual 86	com/tencent/TMG/camera/VcCamera:getRemoteAngleForFrontCamera	(I)I
      //   422: iadd
      //   423: istore_3
      //   424: goto -209 -> 215
      //   427: aload_0
      //   428: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   431: getfield 89	com/tencent/TMG/camera/VcCamera:mBackCameraAngle	I
      //   434: ifle +16 -> 450
      //   437: iload_3
      //   438: aload_0
      //   439: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   442: getfield 89	com/tencent/TMG/camera/VcCamera:mBackCameraAngle	I
      //   445: iadd
      //   446: istore_3
      //   447: goto -232 -> 215
      //   450: iload_3
      //   451: aload_0
      //   452: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   455: aload_0
      //   456: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   459: invokevirtual 53	com/tencent/TMG/camera/VcCamera:getRotation	()I
      //   462: invokevirtual 92	com/tencent/TMG/camera/VcCamera:getRemoteAngleForBackCamera	(I)I
      //   465: iadd
      //   466: istore_3
      //   467: goto -252 -> 215
      //   470: aload_0
      //   471: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   474: invokevirtual 53	com/tencent/TMG/camera/VcCamera:getRotation	()I
      //   477: aload_0
      //   478: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   481: getfield 95	com/tencent/TMG/camera/VcCamera:CompenSateRecvAngle	I
      //   484: iadd
      //   485: bipush 90
      //   487: iadd
      //   488: sipush 360
      //   491: irem
      //   492: istore 4
      //   494: aload_0
      //   495: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   498: invokevirtual 52	com/tencent/TMG/camera/VcCamera:getOrientation	()I
      //   501: sipush 270
      //   504: if_icmpeq +18 -> 522
      //   507: iload 4
      //   509: istore_3
      //   510: aload_0
      //   511: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   514: invokevirtual 52	com/tencent/TMG/camera/VcCamera:getOrientation	()I
      //   517: bipush 90
      //   519: if_icmpne +19 -> 538
      //   522: aload_0
      //   523: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   526: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
      //   529: ifne +82 -> 611
      //   532: iload 4
      //   534: bipush 90
      //   536: iadd
      //   537: istore_3
      //   538: aload_0
      //   539: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   542: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
      //   545: ifne +76 -> 621
      //   548: iload_3
      //   549: istore 4
      //   551: aload_0
      //   552: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   555: invokestatic 57	com/tencent/TMG/camera/VcCamera:access$900	(Lcom/tencent/TMG/camera/VcCamera;)Ljava/lang/String;
      //   558: ldc 59
      //   560: invokevirtual 65	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   563: ifne +10 -> 573
      //   566: iload_3
      //   567: sipush 180
      //   570: iadd
      //   571: istore 4
      //   573: aload_0
      //   574: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   577: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
      //   580: ifne +72 -> 652
      //   583: aload_0
      //   584: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   587: getfield 68	com/tencent/TMG/camera/VcCamera:mFrontCameraAngle	I
      //   590: ifle +41 -> 631
      //   593: iload 4
      //   595: sipush 360
      //   598: aload_0
      //   599: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   602: getfield 68	com/tencent/TMG/camera/VcCamera:mFrontCameraAngle	I
      //   605: isub
      //   606: iadd
      //   607: istore_3
      //   608: goto -393 -> 215
      //   611: iload 4
      //   613: sipush 180
      //   616: iadd
      //   617: istore_3
      //   618: goto -80 -> 538
      //   621: iload_3
      //   622: sipush 180
      //   625: iadd
      //   626: istore 4
      //   628: goto -55 -> 573
      //   631: iload 4
      //   633: aload_0
      //   634: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   637: aload_0
      //   638: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   641: invokevirtual 53	com/tencent/TMG/camera/VcCamera:getRotation	()I
      //   644: invokevirtual 86	com/tencent/TMG/camera/VcCamera:getRemoteAngleForFrontCamera	(I)I
      //   647: iadd
      //   648: istore_3
      //   649: goto -434 -> 215
      //   652: aload_0
      //   653: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   656: getfield 89	com/tencent/TMG/camera/VcCamera:mBackCameraAngle	I
      //   659: ifle +17 -> 676
      //   662: iload 4
      //   664: aload_0
      //   665: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   668: getfield 89	com/tencent/TMG/camera/VcCamera:mBackCameraAngle	I
      //   671: iadd
      //   672: istore_3
      //   673: goto -458 -> 215
      //   676: iload 4
      //   678: aload_0
      //   679: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   682: aload_0
      //   683: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   686: invokevirtual 53	com/tencent/TMG/camera/VcCamera:getRotation	()I
      //   689: invokevirtual 92	com/tencent/TMG/camera/VcCamera:getRemoteAngleForBackCamera	(I)I
      //   692: iadd
      //   693: istore_3
      //   694: goto -479 -> 215
      //   697: aload_0
      //   698: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   701: getfield 98	com/tencent/TMG/camera/VcCamera:LAST_CAMERA	I
      //   704: aload_0
      //   705: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   708: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
      //   711: if_icmpeq +38 -> 749
      //   714: new 100	com/tencent/TMG/camera/VcCamera$CameraPreviewChangeRunnable
      //   717: dup
      //   718: aload_0
      //   719: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   722: aload_0
      //   723: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   726: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
      //   729: invokespecial 103	com/tencent/TMG/camera/VcCamera$CameraPreviewChangeRunnable:<init>	(Lcom/tencent/TMG/camera/VcCamera;I)V
      //   732: invokestatic 109	com/tencent/TMG/sdk/AVUILoopProxy:postTaskToMainLooper	(Ljava/lang/Runnable;)V
      //   735: aload_0
      //   736: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   739: aload_0
      //   740: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   743: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
      //   746: putfield 98	com/tencent/TMG/camera/VcCamera:LAST_CAMERA	I
      //   749: aload_1
      //   750: arraylength
      //   751: istore 8
      //   753: iload 8
      //   755: aload_0
      //   756: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   759: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
      //   762: getfield 118	com/tencent/TMG/camera/CameraCaptureSettings:width	I
      //   765: aload_0
      //   766: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   769: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
      //   772: getfield 121	com/tencent/TMG/camera/CameraCaptureSettings:height	I
      //   775: imul
      //   776: aload_0
      //   777: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   780: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
      //   783: getfield 124	com/tencent/TMG/camera/CameraCaptureSettings:format	I
      //   786: invokestatic 129	android/graphics/ImageFormat:getBitsPerPixel	(I)I
      //   789: imul
      //   790: bipush 8
      //   792: idiv
      //   793: if_icmpeq +476 -> 1269
      //   796: ldc 70
      //   798: iconst_0
      //   799: new 131	java/lang/StringBuilder
      //   802: dup
      //   803: invokespecial 132	java/lang/StringBuilder:<init>	()V
      //   806: ldc 134
      //   808: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   811: aload_0
      //   812: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   815: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
      //   818: getfield 118	com/tencent/TMG/camera/CameraCaptureSettings:width	I
      //   821: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   824: ldc 143
      //   826: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   829: aload_0
      //   830: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   833: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
      //   836: getfield 121	com/tencent/TMG/camera/CameraCaptureSettings:height	I
      //   839: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   842: ldc 145
      //   844: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   847: aload_0
      //   848: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   851: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
      //   854: getfield 124	com/tencent/TMG/camera/CameraCaptureSettings:format	I
      //   857: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   860: ldc 147
      //   862: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   865: iload 8
      //   867: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   870: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   873: invokestatic 78	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   876: aload_0
      //   877: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   880: getfield 155	com/tencent/TMG/camera/VcCamera:mFrameSizes	Ljava/util/List;
      //   883: ifnull +439 -> 1322
      //   886: aload_0
      //   887: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   890: getfield 155	com/tencent/TMG/camera/VcCamera:mFrameSizes	Ljava/util/List;
      //   893: invokeinterface 161 1 0
      //   898: astore 13
      //   900: aload 13
      //   902: invokeinterface 167 1 0
      //   907: ifeq +415 -> 1322
      //   910: aload 13
      //   912: invokeinterface 171 1 0
      //   917: checkcast 173	android/hardware/Camera$Size
      //   920: astore 14
      //   922: aload 14
      //   924: getfield 174	android/hardware/Camera$Size:height	I
      //   927: aload 14
      //   929: getfield 175	android/hardware/Camera$Size:width	I
      //   932: imul
      //   933: aload_0
      //   934: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   937: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
      //   940: getfield 124	com/tencent/TMG/camera/CameraCaptureSettings:format	I
      //   943: invokestatic 129	android/graphics/ImageFormat:getBitsPerPixel	(I)I
      //   946: imul
      //   947: bipush 8
      //   949: idiv
      //   950: iload 8
      //   952: if_icmpne -52 -> 900
      //   955: ldc 70
      //   957: iconst_0
      //   958: new 131	java/lang/StringBuilder
      //   961: dup
      //   962: invokespecial 132	java/lang/StringBuilder:<init>	()V
      //   965: ldc 177
      //   967: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   970: aload 14
      //   972: getfield 175	android/hardware/Camera$Size:width	I
      //   975: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   978: ldc 143
      //   980: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   983: aload 14
      //   985: getfield 174	android/hardware/Camera$Size:height	I
      //   988: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   991: ldc 145
      //   993: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   996: aload_0
      //   997: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   1000: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
      //   1003: getfield 124	com/tencent/TMG/camera/CameraCaptureSettings:format	I
      //   1006: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1009: ldc 147
      //   1011: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1014: iload 8
      //   1016: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1019: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1022: invokestatic 78	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1025: aload 14
      //   1027: getfield 175	android/hardware/Camera$Size:width	I
      //   1030: aload 14
      //   1032: getfield 174	android/hardware/Camera$Size:height	I
      //   1035: if_icmplt -135 -> 900
      //   1038: aload_0
      //   1039: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   1042: aload_1
      //   1043: iload 8
      //   1045: aload 14
      //   1047: getfield 175	android/hardware/Camera$Size:width	I
      //   1050: aload 14
      //   1052: getfield 174	android/hardware/Camera$Size:height	I
      //   1055: iload 7
      //   1057: aload_0
      //   1058: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   1061: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
      //   1064: getfield 124	com/tencent/TMG/camera/CameraCaptureSettings:format	I
      //   1067: invokestatic 181	com/tencent/TMG/camera/VcCamera:access$1000	(Lcom/tencent/TMG/camera/VcCamera;[BIIIII)V
      //   1070: iconst_1
      //   1071: istore_3
      //   1072: iload_3
      //   1073: istore 4
      //   1075: iload_3
      //   1076: ifne +157 -> 1233
      //   1079: iload_3
      //   1080: istore 4
      //   1082: aload_2
      //   1083: ifnull +150 -> 1233
      //   1086: aload_2
      //   1087: invokevirtual 187	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
      //   1090: astore 13
      //   1092: iload_3
      //   1093: istore 4
      //   1095: aload 13
      //   1097: ifnull +136 -> 1233
      //   1100: aload 13
      //   1102: invokevirtual 193	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
      //   1105: getfield 175	android/hardware/Camera$Size:width	I
      //   1108: istore 9
      //   1110: aload 13
      //   1112: invokevirtual 193	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
      //   1115: getfield 174	android/hardware/Camera$Size:height	I
      //   1118: istore 10
      //   1120: aload 13
      //   1122: invokevirtual 196	android/hardware/Camera$Parameters:getPreviewFormat	()I
      //   1125: istore 11
      //   1127: ldc 70
      //   1129: iconst_0
      //   1130: new 131	java/lang/StringBuilder
      //   1133: dup
      //   1134: invokespecial 132	java/lang/StringBuilder:<init>	()V
      //   1137: ldc 198
      //   1139: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1142: iload 9
      //   1144: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1147: ldc 200
      //   1149: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1152: iload 10
      //   1154: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1157: ldc 202
      //   1159: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1162: iload 11
      //   1164: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1167: ldc 147
      //   1169: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1172: iload 8
      //   1174: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1177: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1180: invokestatic 78	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1183: iload 9
      //   1185: iload 10
      //   1187: imul
      //   1188: iload 11
      //   1190: invokestatic 129	android/graphics/ImageFormat:getBitsPerPixel	(I)I
      //   1193: imul
      //   1194: bipush 8
      //   1196: idiv
      //   1197: istore 12
      //   1199: iload_3
      //   1200: istore 4
      //   1202: iload 12
      //   1204: iload 8
      //   1206: if_icmpne +27 -> 1233
      //   1209: aload_0
      //   1210: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   1213: aload_1
      //   1214: iload 8
      //   1216: iload 9
      //   1218: iload 10
      //   1220: iload 7
      //   1222: iload 11
      //   1224: invokestatic 181	com/tencent/TMG/camera/VcCamera:access$1000	(Lcom/tencent/TMG/camera/VcCamera;[BIIIII)V
      //   1227: iload 5
      //   1229: istore_3
      //   1230: iload_3
      //   1231: istore 4
      //   1233: iload 4
      //   1235: ifne +11 -> 1246
      //   1238: ldc 70
      //   1240: iconst_0
      //   1241: ldc 204
      //   1243: invokestatic 78	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1246: aload_0
      //   1247: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   1250: getfield 208	com/tencent/TMG/camera/VcCamera:mCallbackBufferAddStrategy	Lcom/tencent/TMG/camera/CallbackBufferAddStrategy;
      //   1253: aload_2
      //   1254: aload_1
      //   1255: invokevirtual 214	com/tencent/TMG/camera/CallbackBufferAddStrategy:supplement	(Landroid/hardware/Camera;[B)V
      //   1258: return
      //   1259: astore 13
      //   1261: aload 13
      //   1263: invokevirtual 217	java/lang/Exception:printStackTrace	()V
      //   1266: goto -36 -> 1230
      //   1269: aload_0
      //   1270: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   1273: aload_1
      //   1274: iload 8
      //   1276: aload_0
      //   1277: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   1280: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
      //   1283: getfield 118	com/tencent/TMG/camera/CameraCaptureSettings:width	I
      //   1286: aload_0
      //   1287: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   1290: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
      //   1293: getfield 121	com/tencent/TMG/camera/CameraCaptureSettings:height	I
      //   1296: iload 7
      //   1298: aload_0
      //   1299: getfield 14	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
      //   1302: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
      //   1305: getfield 124	com/tencent/TMG/camera/CameraCaptureSettings:format	I
      //   1308: invokestatic 181	com/tencent/TMG/camera/VcCamera:access$1000	(Lcom/tencent/TMG/camera/VcCamera;[BIIIII)V
      //   1311: goto -65 -> 1246
      //   1314: astore 13
      //   1316: iload 6
      //   1318: istore_3
      //   1319: goto -58 -> 1261
      //   1322: iconst_0
      //   1323: istore_3
      //   1324: goto -252 -> 1072
      //   1327: iconst_0
      //   1328: istore_3
      //   1329: goto -1239 -> 90
      //   1332: iconst_0
      //   1333: istore_3
      //   1334: goto -1266 -> 68
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1337	0	this	7
      //   0	1337	1	paramAnonymousArrayOfByte	byte[]
      //   0	1337	2	paramAnonymousCamera	Camera
      //   67	1267	3	i	int
      //   99	1135	4	j	int
      //   4	1224	5	k	int
      //   1	1316	6	m	int
      //   223	1074	7	n	int
      //   751	524	8	i1	int
      //   1108	109	9	i2	int
      //   1118	101	10	i3	int
      //   1125	98	11	i4	int
      //   1197	10	12	i5	int
      //   898	223	13	localObject	Object
      //   1259	3	13	localException1	Exception
      //   1314	1	13	localException2	Exception
      //   920	131	14	localSize	Camera.Size
      // Exception table:
      //   from	to	target	type
      //   1086	1092	1259	java/lang/Exception
      //   1100	1199	1259	java/lang/Exception
      //   1209	1227	1314	java/lang/Exception
    }
  };
  boolean cameraInitialed = false;
  public final Object cameraPreviewChangeCallbackLock = new Object();
  Display devDisplay;
  public final Object holderLock = new Object();
  boolean isPreviewFpsPrint = false;
  boolean isPreviewSizePrint = false;
  int mBackCameraAngle = 0;
  CallbackBufferAddStrategy mCallbackBufferAddStrategy;
  Camera mCamera = null;
  private Handler mCameraHandler = null;
  HandlerThread mCameraThread = null;
  Context mContext = null;
  List<Camera.Size> mFrameSizes = null;
  int mFrontCameraAngle = 0;
  volatile SurfaceTextureManager mSurfaceTextureManager = null;
  private boolean mUseSurfaceTexture = false;
  boolean mbIsTablet = false;
  int nativeObj = 0;
  int screenOrientation = 1;
  
  public VcCamera() {}
  
  public VcCamera(Context paramContext)
  {
    if (paramContext == null) {
      QLog.e("VcCamera", 0, "VcCamera initial context is null");
    }
    do
    {
      return;
      this.mContext = paramContext;
      this.devDisplay = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
      this.androidSysOorientationConfig = get(this.mContext, "ro.qq.orientation");
      this.mbIsTablet = PhoneStatusTools.isTablet(paramContext);
      this.SDK_VERSION = getVersion();
      this.DEV_MODEL = Build.MODEL;
      this.DEV_MANUFACTURER = Build.MANUFACTURER;
      Info.orientation = -1;
      Info.rotation = -1;
      this.screenOrientation = this.mContext.getResources().getConfiguration().orientation;
      this.mSurfaceTextureManager = new SurfaceTextureManager(this.mContext);
      this.mCallbackBufferAddStrategy = new CallbackBufferAddStrategy();
    } while (!QLog.isColorLevel());
    QLog.d("VcCamera", 0, "Device_Tag = " + this.DEV_MANUFACTURER + ": " + this.DEV_MODEL);
    QLog.d("VcCamera", 0, "Rom_Tag = " + Build.VERSION.INCREMENTAL);
    QLog.d("VcCamera", 0, "screenOrientation = " + this.screenOrientation);
  }
  
  private static int GetNumberOfCamera()
  {
    try
    {
      int i = Integer.parseInt(Class.forName("android.hardware.Camera").getMethod("getNumberOfCameras", new Class[0]).invoke(null, (Object[])null).toString());
      return i;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "GetNumberOfCamera", localException);
      }
    }
    return 1;
  }
  
  private void adjustDirection(Camera paramCamera)
  {
    try
    {
      Method localMethod = paramCamera.getClass().getMethod("setDisplayOrientation", new Class[] { Integer.TYPE });
      if (this.CUR_CAMERA == 0) {}
      for (int i = getPreviewAngleForFrontCamera() % 360;; i = getPreviewAngleForBackCamera() % 360)
      {
        localMethod.invoke(paramCamera, new Object[] { Integer.valueOf(i) });
        return;
      }
      return;
    }
    catch (Exception paramCamera)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "adjustDirection", paramCamera);
      }
    }
  }
  
  private void afterCapture(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    for (;;)
    {
      synchronized (this.afterPreviewListenerLock)
      {
        if (this.afterPreviewListener != null)
        {
          AVVideoCtrl.VideoFrame localVideoFrame = new AVVideoCtrl.VideoFrame();
          localVideoFrame.data = paramArrayOfByte;
          localVideoFrame.dataLen = paramInt1;
          localVideoFrame.height = paramInt3;
          localVideoFrame.width = paramInt2;
          localVideoFrame.videoFormat = paramInt5;
          localVideoFrame.rotate = paramInt4;
          ((AVVideoCtrl.AfterPreviewListener)this.afterPreviewListener).onFrameReceive(localVideoFrame);
          paramArrayOfByte = localVideoFrame.data;
          paramInt1 = localVideoFrame.dataLen;
          paramInt2 = localVideoFrame.width;
          paramInt3 = localVideoFrame.height;
          paramInt5 = localVideoFrame.videoFormat;
          onCaptureFrame(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
          return;
        }
      }
    }
  }
  
  private boolean fitSdkVersion()
  {
    return this.SDK_VERSION >= 10;
  }
  
  public static String get(Context paramContext, String paramString)
    throws IllegalArgumentException
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { new String(paramString) });
      return paramContext;
    }
    catch (IllegalArgumentException paramContext)
    {
      throw paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private CameraInformation getCameraDisplayOrientation(int paramInt, Camera paramCamera)
  {
    paramCamera = new CameraInformation();
    try
    {
      Object localObject2 = Class.forName("android.hardware.Camera");
      Class localClass = Class.forName("android.hardware.Camera$CameraInfo");
      if (localClass == null)
      {
        paramCamera.rotation = -1;
        paramCamera.orientation = -1;
        return paramCamera;
      }
      Object localObject1 = localClass.newInstance();
      if (localObject1 == null)
      {
        paramCamera.rotation = -1;
        paramCamera.orientation = -1;
        return paramCamera;
      }
      Field localField1 = localObject1.getClass().getField("facing");
      Field localField2 = localObject1.getClass().getField("orientation");
      if ((localField1 == null) || (localField2 == null))
      {
        paramCamera.rotation = -1;
        paramCamera.orientation = -1;
        return paramCamera;
      }
      localObject2 = ((Class)localObject2).getMethod("getCameraInfo", new Class[] { Integer.TYPE, localClass });
      if (localObject2 == null)
      {
        paramCamera.rotation = -1;
        paramCamera.orientation = -1;
        return paramCamera;
      }
      ((Method)localObject2).invoke(null, new Object[] { Integer.valueOf(paramInt), localObject1 });
      paramCamera.facing = localField1.getInt(localObject1);
      paramCamera.orientation = localField2.getInt(localObject1);
      if (this.devDisplay == null)
      {
        paramCamera.rotation = -1;
        return paramCamera;
      }
      localObject1 = this.devDisplay.getClass().getMethod("getRotation", new Class[0]);
      if (localObject1 == null)
      {
        paramCamera.rotation = -1;
        return paramCamera;
      }
      switch (Integer.parseInt(((Method)localObject1).invoke(this.devDisplay, (Object[])null).toString()))
      {
      case 0: 
        paramCamera.rotation = 0;
      }
    }
    catch (Exception localException)
    {
      paramCamera.rotation = 0;
      return paramCamera;
    }
    paramCamera.rotation = 90;
    return paramCamera;
    paramCamera.rotation = 180;
    return paramCamera;
    paramCamera.rotation = 270;
    return paramCamera;
  }
  
  public static int getCameraNum()
  {
    return GetNumberOfCamera();
  }
  
  private Camera getFrontCamera()
  {
    if (fitSdkVersion()) {
      return openFrontFacingCamera();
    }
    if (this.DEV_MANUFACTURER.equalsIgnoreCase("motorola")) {
      return tryMotoFrontCamera();
    }
    if (this.DEV_MANUFACTURER.equalsIgnoreCase("samsung")) {
      return trySamsungFrontCamera();
    }
    return null;
  }
  
  public static boolean getIsNeonSupported()
  {
    return VcSystemInfo.isNeonSupported();
  }
  
  private Camera.Size getOptimalEqualPreviewSize(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    Object localObject1;
    if (!this.isPreviewSizePrint)
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Camera.Size)((Iterator)localObject1).next();
        QLog.d("VcCamera", 0, "previewsize ,w= " + ((Camera.Size)localObject2).width + ",h=" + ((Camera.Size)localObject2).height);
      }
      this.isPreviewSizePrint = true;
    }
    int i = paramInt1;
    int j = paramInt2;
    if (!VcSystemInfo.isNormalSharp()) {
      if (paramInt1 == 192)
      {
        i = paramInt1;
        j = paramInt2;
        if (paramInt2 == 144) {}
      }
      else
      {
        j = 144;
        i = 192;
      }
    }
    Object localObject2 = paramList.iterator();
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Camera.Size)((Iterator)localObject2).next();
        if ((((Camera.Size)localObject1).width == i) && (((Camera.Size)localObject1).height == j))
        {
          paramList = (List<Camera.Size>)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("VcCamera", 0, "previewsize ,w= " + i + ",h=" + j);
            paramList = (List<Camera.Size>)localObject1;
          }
        }
      }
    }
    do
    {
      return paramList;
      if ((VcSystemInfo.isNormalSharp()) || ((i == 320) && (j == 240))) {
        break label523;
      }
      localObject2 = paramList.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (Camera.Size)((Iterator)localObject2).next();
      } while ((((Camera.Size)localObject1).width != 320) || (((Camera.Size)localObject1).height != 240));
      paramList = (List<Camera.Size>)localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("VcCamera", 0, "previewsize 2, w= " + 320 + ",h=" + 240);
    return localObject1;
    paramInt1 = 240;
    for (paramInt2 = 320;; paramInt2 = i)
    {
      j = paramInt1;
      i = paramInt2;
      if (paramInt2 == 320)
      {
        j = paramInt1;
        i = paramInt2;
        if (paramInt1 == 240)
        {
          localObject2 = paramList.iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              localObject1 = (Camera.Size)((Iterator)localObject2).next();
              if ((((Camera.Size)localObject1).width == 640) && (((Camera.Size)localObject1).height == 480))
              {
                paramList = (List<Camera.Size>)localObject1;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("VcCamera", 0, "previewsize ,w= " + 640 + ",h=" + 480);
                return localObject1;
              }
            }
          }
          j = 480;
          i = 640;
        }
      }
      if (0 == 0) {
        return getOptimalPreviewSize(paramList, i, j);
      }
      return null;
      label523:
      paramInt1 = j;
    }
  }
  
  private Camera.Size getOptimalPreviewSize(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    if (paramList == null) {
      return null;
    }
    Collections.sort(paramList, new CameraSizeComparator());
    Iterator localIterator = paramList.iterator();
    paramList = null;
    Camera.Size localSize;
    while (localIterator.hasNext())
    {
      localSize = (Camera.Size)localIterator.next();
      if (((localSize.width >= paramInt1) && (localSize.height > paramInt2)) || ((localSize.width > paramInt1) && (localSize.height >= paramInt2)))
      {
        Object localObject = paramList;
        if (paramList == null)
        {
          QLog.i("VcCamera", 0, "better size width: " + localSize.width + "height: " + localSize.height);
          localObject = localSize;
        }
        paramList = (List<Camera.Size>)localObject;
        if (localSize.width * paramInt2 == localSize.height * paramInt1)
        {
          QLog.i("VcCamera", 0, "best size width: " + localSize.width + "height: " + localSize.height + "w*h1: " + localSize.width * paramInt2 + "w*h2: " + localSize.height * paramInt1);
          paramList = (List<Camera.Size>)localObject;
        }
      }
    }
    for (;;)
    {
      if (localSize != null) {
        return localSize;
      }
      if (paramList == null) {
        break;
      }
      return paramList;
      localSize = null;
    }
  }
  
  private int getPreviewFPS(int paramInt, Camera.Parameters paramParameters)
  {
    Integer localInteger;
    try
    {
      localObject = paramParameters.getClass().getMethod("getSupportedPreviewFrameRates", new Class[0]);
      i = paramInt;
      if (localObject != null)
      {
        paramParameters = (List)((Method)localObject).invoke(paramParameters, (Object[])null);
        i = paramInt;
        if (paramParameters != null)
        {
          if (this.isPreviewFpsPrint) {
            break label156;
          }
          localObject = paramParameters.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localInteger = (Integer)((Iterator)localObject).next();
            QLog.i("VcCamera", 0, "supported fps = " + localInteger);
          }
        }
      }
      QLog.i("VcCamera", 0, "getPreviewFPS fps = " + i);
    }
    catch (Exception paramParameters)
    {
      QLog.e("VcCamera", 0, "getSupportedPreviewFrameRates error = ", paramParameters);
      i = paramInt;
    }
    return i;
    this.isPreviewFpsPrint = true;
    label156:
    int i = 10;
    Object localObject = paramParameters.iterator();
    int j = 0;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localInteger = (Integer)((Iterator)localObject).next();
        if ((localInteger.intValue() <= paramInt) && (localInteger.intValue() >= i))
        {
          j = localInteger.intValue();
          i = 1;
          break label334;
        }
      }
      else
      {
        if (j == 0)
        {
          QLog.i("VcCamera", 0, "not find valid fps = targetFPS");
          paramParameters = paramParameters.iterator();
          i = paramInt;
          j = i;
          if (paramParameters.hasNext())
          {
            localObject = (Integer)paramParameters.next();
            if (((Integer)localObject).intValue() >= paramInt)
            {
              k = ((Integer)localObject).intValue();
              if (i == paramInt) {
                j = k;
              }
            }
            for (;;)
            {
              i = j;
              break;
              j = k;
              if (k > i) {
                j = i;
              }
            }
          }
        }
        else
        {
          j = i;
        }
        i = j;
        break;
      }
      int k = j;
      j = i;
      i = k;
      label334:
      k = j;
      j = i;
      i = k;
    }
  }
  
  private int getRecvAngleCompensation()
  {
    return 0;
  }
  
  private int getSendAngleCompensation()
  {
    return 0;
  }
  
  public static int getVersion()
  {
    return Build.VERSION.SDK_INT;
  }
  
  private boolean openBackCamera()
  {
    try
    {
      this.mCamera = Camera.open();
      this.CUR_CAMERA = 1;
      isCameraOpened = true;
      this.CameraId = 0;
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "openBackCamera success");
      }
      return true;
    }
    catch (Exception localException)
    {
      isCameraOpened = false;
      if (this.mCamera != null) {
        this.mCamera.release();
      }
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "openBackCamera exception" + localException.getStackTrace());
      }
    }
    return false;
  }
  
  private boolean openFrontCamera()
  {
    this.mCamera = getFrontCamera();
    if (this.mCamera == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "openFrontCamera camera == null");
      }
      isCameraOpened = false;
      return false;
    }
    if (this.NUM_CAMERA == 0) {
      this.NUM_CAMERA = 2;
    }
    this.CUR_CAMERA = 0;
    isCameraOpened = true;
    if (QLog.isColorLevel()) {
      QLog.d("VcCamera", 0, "openFrontCamera success");
    }
    return true;
  }
  
  /* Error */
  private Camera openFrontFacingCamera()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 11
    //   15: aconst_null
    //   16: astore 12
    //   18: aconst_null
    //   19: astore 13
    //   21: aconst_null
    //   22: astore 14
    //   24: aconst_null
    //   25: astore 7
    //   27: aload_0
    //   28: iconst_m1
    //   29: putfield 140	com/tencent/TMG/camera/VcCamera:CameraId	I
    //   32: ldc_w 302
    //   35: invokestatic 308	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   38: astore 15
    //   40: aload_0
    //   41: getfield 136	com/tencent/TMG/camera/VcCamera:NUM_CAMERA	I
    //   44: ifne +10 -> 54
    //   47: aload_0
    //   48: invokestatic 361	com/tencent/TMG/camera/VcCamera:GetNumberOfCamera	()I
    //   51: putfield 136	com/tencent/TMG/camera/VcCamera:NUM_CAMERA	I
    //   54: aload 4
    //   56: astore_3
    //   57: aload_0
    //   58: getfield 136	com/tencent/TMG/camera/VcCamera:NUM_CAMERA	I
    //   61: iconst_1
    //   62: if_icmplt +257 -> 319
    //   65: ldc_w 458
    //   68: invokestatic 308	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   71: astore 17
    //   73: aload 17
    //   75: ifnull +567 -> 642
    //   78: aload 17
    //   80: invokevirtual 462	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   83: astore 5
    //   85: aload 5
    //   87: ifnull +549 -> 636
    //   90: aload 5
    //   92: invokevirtual 383	java/lang/Object:getClass	()Ljava/lang/Class;
    //   95: ldc_w 464
    //   98: invokevirtual 468	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   101: astore 6
    //   103: aload 15
    //   105: ldc_w 471
    //   108: iconst_2
    //   109: anewarray 304	java/lang/Class
    //   112: dup
    //   113: iconst_0
    //   114: getstatic 389	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: aload 17
    //   122: aastore
    //   123: invokevirtual 314	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   126: astore 16
    //   128: aload 4
    //   130: astore_3
    //   131: aload 16
    //   133: ifnull +186 -> 319
    //   136: aload 4
    //   138: astore_3
    //   139: aload 17
    //   141: ifnull +178 -> 319
    //   144: aload 4
    //   146: astore_3
    //   147: aload 6
    //   149: ifnull +170 -> 319
    //   152: iconst_0
    //   153: istore_1
    //   154: aconst_null
    //   155: astore_3
    //   156: iload_1
    //   157: aload_0
    //   158: getfield 136	com/tencent/TMG/camera/VcCamera:NUM_CAMERA	I
    //   161: if_icmpge +473 -> 634
    //   164: aload 16
    //   166: aconst_null
    //   167: iconst_2
    //   168: anewarray 4	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: iload_1
    //   174: invokestatic 396	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: aastore
    //   178: dup
    //   179: iconst_1
    //   180: aload 5
    //   182: aastore
    //   183: invokevirtual 322	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   186: pop
    //   187: aload 6
    //   189: aload 5
    //   191: invokevirtual 477	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   194: istore_2
    //   195: iload_2
    //   196: iconst_1
    //   197: if_icmpne +431 -> 628
    //   200: aload 15
    //   202: ldc_w 628
    //   205: iconst_1
    //   206: anewarray 304	java/lang/Class
    //   209: dup
    //   210: iconst_0
    //   211: getstatic 389	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   214: aastore
    //   215: invokevirtual 314	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   218: astore 4
    //   220: aload 4
    //   222: ifnull +406 -> 628
    //   225: aload 4
    //   227: aconst_null
    //   228: iconst_1
    //   229: anewarray 4	java/lang/Object
    //   232: dup
    //   233: iconst_0
    //   234: iload_1
    //   235: invokestatic 396	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: aastore
    //   239: invokevirtual 322	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   242: checkcast 593	android/hardware/Camera
    //   245: astore 4
    //   247: aload_0
    //   248: iload_1
    //   249: putfield 140	com/tencent/TMG/camera/VcCamera:CameraId	I
    //   252: iload_1
    //   253: iconst_1
    //   254: iadd
    //   255: istore_1
    //   256: aload 4
    //   258: astore_3
    //   259: goto -103 -> 156
    //   262: astore_3
    //   263: aload_0
    //   264: iconst_0
    //   265: putfield 140	com/tencent/TMG/camera/VcCamera:CameraId	I
    //   268: invokestatic 267	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   271: ifeq +13 -> 284
    //   274: ldc 52
    //   276: iconst_0
    //   277: ldc_w 629
    //   280: aload_3
    //   281: invokestatic 579	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   284: aconst_null
    //   285: astore 4
    //   287: goto -35 -> 252
    //   290: astore 5
    //   292: aload 7
    //   294: astore 4
    //   296: aload 4
    //   298: astore_3
    //   299: invokestatic 267	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   302: ifeq +17 -> 319
    //   305: ldc 52
    //   307: iconst_0
    //   308: ldc_w 631
    //   311: aload 5
    //   313: invokestatic 579	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   316: aload 4
    //   318: astore_3
    //   319: aload_3
    //   320: areturn
    //   321: astore 5
    //   323: aload 8
    //   325: astore 4
    //   327: aload 4
    //   329: astore_3
    //   330: invokestatic 267	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   333: ifeq -14 -> 319
    //   336: ldc 52
    //   338: iconst_0
    //   339: ldc_w 633
    //   342: aload 5
    //   344: invokestatic 579	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   347: aload 4
    //   349: areturn
    //   350: astore 5
    //   352: aload 9
    //   354: astore 4
    //   356: aload 4
    //   358: astore_3
    //   359: invokestatic 267	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   362: ifeq -43 -> 319
    //   365: ldc 52
    //   367: iconst_0
    //   368: ldc_w 635
    //   371: aload 5
    //   373: invokestatic 579	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   376: aload 4
    //   378: areturn
    //   379: astore 5
    //   381: aload 10
    //   383: astore 4
    //   385: aload 4
    //   387: astore_3
    //   388: invokestatic 267	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   391: ifeq -72 -> 319
    //   394: ldc 52
    //   396: iconst_0
    //   397: ldc_w 637
    //   400: aload 5
    //   402: invokestatic 579	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   405: aload 4
    //   407: areturn
    //   408: astore 5
    //   410: aload 11
    //   412: astore 4
    //   414: aload 4
    //   416: astore_3
    //   417: invokestatic 267	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   420: ifeq -101 -> 319
    //   423: ldc 52
    //   425: iconst_0
    //   426: ldc_w 639
    //   429: aload 5
    //   431: invokestatic 579	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   434: aload 4
    //   436: areturn
    //   437: astore 5
    //   439: aload 12
    //   441: astore 4
    //   443: aload 4
    //   445: astore_3
    //   446: invokestatic 267	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   449: ifeq -130 -> 319
    //   452: ldc 52
    //   454: iconst_0
    //   455: ldc_w 641
    //   458: aload 5
    //   460: invokestatic 579	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   463: aload 4
    //   465: areturn
    //   466: astore 5
    //   468: aload 13
    //   470: astore 4
    //   472: aload 4
    //   474: astore_3
    //   475: invokestatic 267	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   478: ifeq -159 -> 319
    //   481: ldc 52
    //   483: iconst_0
    //   484: ldc_w 643
    //   487: aload 5
    //   489: invokestatic 579	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   492: aload 4
    //   494: areturn
    //   495: astore 5
    //   497: aload 14
    //   499: astore 4
    //   501: aload 4
    //   503: astore_3
    //   504: invokestatic 267	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   507: ifeq -188 -> 319
    //   510: ldc 52
    //   512: iconst_0
    //   513: ldc_w 629
    //   516: aload 5
    //   518: invokestatic 579	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   521: aload 4
    //   523: areturn
    //   524: astore 5
    //   526: aload_3
    //   527: astore 4
    //   529: goto -28 -> 501
    //   532: astore 5
    //   534: goto -33 -> 501
    //   537: astore 5
    //   539: aload_3
    //   540: astore 4
    //   542: goto -70 -> 472
    //   545: astore 5
    //   547: goto -75 -> 472
    //   550: astore 5
    //   552: aload_3
    //   553: astore 4
    //   555: goto -112 -> 443
    //   558: astore 5
    //   560: goto -117 -> 443
    //   563: astore 5
    //   565: aload_3
    //   566: astore 4
    //   568: goto -154 -> 414
    //   571: astore 5
    //   573: goto -159 -> 414
    //   576: astore 5
    //   578: aload_3
    //   579: astore 4
    //   581: goto -196 -> 385
    //   584: astore 5
    //   586: goto -201 -> 385
    //   589: astore 5
    //   591: aload_3
    //   592: astore 4
    //   594: goto -238 -> 356
    //   597: astore 5
    //   599: goto -243 -> 356
    //   602: astore 5
    //   604: aload_3
    //   605: astore 4
    //   607: goto -280 -> 327
    //   610: astore 5
    //   612: goto -285 -> 327
    //   615: astore 5
    //   617: aload_3
    //   618: astore 4
    //   620: goto -324 -> 296
    //   623: astore 5
    //   625: goto -329 -> 296
    //   628: aload_3
    //   629: astore 4
    //   631: goto -379 -> 252
    //   634: aload_3
    //   635: areturn
    //   636: aconst_null
    //   637: astore 6
    //   639: goto -536 -> 103
    //   642: aconst_null
    //   643: astore 5
    //   645: goto -560 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	648	0	this	VcCamera
    //   153	103	1	i	int
    //   194	4	2	j	int
    //   56	203	3	localObject1	Object
    //   262	19	3	localRuntimeException	RuntimeException
    //   298	337	3	localObject2	Object
    //   1	629	4	localObject3	Object
    //   83	107	5	localObject4	Object
    //   290	22	5	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   321	22	5	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   350	22	5	localNoSuchFieldException1	java.lang.NoSuchFieldException
    //   379	22	5	localIllegalAccessException1	java.lang.IllegalAccessException
    //   408	22	5	localInvocationTargetException1	java.lang.reflect.InvocationTargetException
    //   437	22	5	localInstantiationException1	java.lang.InstantiationException
    //   466	22	5	localSecurityException1	java.lang.SecurityException
    //   495	22	5	localException1	Exception
    //   524	1	5	localException2	Exception
    //   532	1	5	localException3	Exception
    //   537	1	5	localSecurityException2	java.lang.SecurityException
    //   545	1	5	localSecurityException3	java.lang.SecurityException
    //   550	1	5	localInstantiationException2	java.lang.InstantiationException
    //   558	1	5	localInstantiationException3	java.lang.InstantiationException
    //   563	1	5	localInvocationTargetException2	java.lang.reflect.InvocationTargetException
    //   571	1	5	localInvocationTargetException3	java.lang.reflect.InvocationTargetException
    //   576	1	5	localIllegalAccessException2	java.lang.IllegalAccessException
    //   584	1	5	localIllegalAccessException3	java.lang.IllegalAccessException
    //   589	1	5	localNoSuchFieldException2	java.lang.NoSuchFieldException
    //   597	1	5	localNoSuchFieldException3	java.lang.NoSuchFieldException
    //   602	1	5	localNoSuchMethodException2	java.lang.NoSuchMethodException
    //   610	1	5	localNoSuchMethodException3	java.lang.NoSuchMethodException
    //   615	1	5	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   623	1	5	localClassNotFoundException3	java.lang.ClassNotFoundException
    //   643	1	5	localObject5	Object
    //   101	537	6	localField	Field
    //   25	268	7	localObject6	Object
    //   4	320	8	localObject7	Object
    //   7	346	9	localObject8	Object
    //   10	372	10	localObject9	Object
    //   13	398	11	localObject10	Object
    //   16	424	12	localObject11	Object
    //   19	450	13	localObject12	Object
    //   22	476	14	localObject13	Object
    //   38	163	15	localClass1	Class
    //   126	39	16	localMethod	Method
    //   71	69	17	localClass2	Class
    // Exception table:
    //   from	to	target	type
    //   200	220	262	java/lang/RuntimeException
    //   225	247	262	java/lang/RuntimeException
    //   247	252	262	java/lang/RuntimeException
    //   32	54	290	java/lang/ClassNotFoundException
    //   57	73	290	java/lang/ClassNotFoundException
    //   78	85	290	java/lang/ClassNotFoundException
    //   90	103	290	java/lang/ClassNotFoundException
    //   103	128	290	java/lang/ClassNotFoundException
    //   263	284	290	java/lang/ClassNotFoundException
    //   32	54	321	java/lang/NoSuchMethodException
    //   57	73	321	java/lang/NoSuchMethodException
    //   78	85	321	java/lang/NoSuchMethodException
    //   90	103	321	java/lang/NoSuchMethodException
    //   103	128	321	java/lang/NoSuchMethodException
    //   263	284	321	java/lang/NoSuchMethodException
    //   32	54	350	java/lang/NoSuchFieldException
    //   57	73	350	java/lang/NoSuchFieldException
    //   78	85	350	java/lang/NoSuchFieldException
    //   90	103	350	java/lang/NoSuchFieldException
    //   103	128	350	java/lang/NoSuchFieldException
    //   263	284	350	java/lang/NoSuchFieldException
    //   32	54	379	java/lang/IllegalAccessException
    //   57	73	379	java/lang/IllegalAccessException
    //   78	85	379	java/lang/IllegalAccessException
    //   90	103	379	java/lang/IllegalAccessException
    //   103	128	379	java/lang/IllegalAccessException
    //   263	284	379	java/lang/IllegalAccessException
    //   32	54	408	java/lang/reflect/InvocationTargetException
    //   57	73	408	java/lang/reflect/InvocationTargetException
    //   78	85	408	java/lang/reflect/InvocationTargetException
    //   90	103	408	java/lang/reflect/InvocationTargetException
    //   103	128	408	java/lang/reflect/InvocationTargetException
    //   263	284	408	java/lang/reflect/InvocationTargetException
    //   32	54	437	java/lang/InstantiationException
    //   57	73	437	java/lang/InstantiationException
    //   78	85	437	java/lang/InstantiationException
    //   90	103	437	java/lang/InstantiationException
    //   103	128	437	java/lang/InstantiationException
    //   263	284	437	java/lang/InstantiationException
    //   32	54	466	java/lang/SecurityException
    //   57	73	466	java/lang/SecurityException
    //   78	85	466	java/lang/SecurityException
    //   90	103	466	java/lang/SecurityException
    //   103	128	466	java/lang/SecurityException
    //   263	284	466	java/lang/SecurityException
    //   32	54	495	java/lang/Exception
    //   57	73	495	java/lang/Exception
    //   78	85	495	java/lang/Exception
    //   90	103	495	java/lang/Exception
    //   103	128	495	java/lang/Exception
    //   263	284	495	java/lang/Exception
    //   156	195	524	java/lang/Exception
    //   200	220	524	java/lang/Exception
    //   225	247	524	java/lang/Exception
    //   247	252	532	java/lang/Exception
    //   156	195	537	java/lang/SecurityException
    //   200	220	537	java/lang/SecurityException
    //   225	247	537	java/lang/SecurityException
    //   247	252	545	java/lang/SecurityException
    //   156	195	550	java/lang/InstantiationException
    //   200	220	550	java/lang/InstantiationException
    //   225	247	550	java/lang/InstantiationException
    //   247	252	558	java/lang/InstantiationException
    //   156	195	563	java/lang/reflect/InvocationTargetException
    //   200	220	563	java/lang/reflect/InvocationTargetException
    //   225	247	563	java/lang/reflect/InvocationTargetException
    //   247	252	571	java/lang/reflect/InvocationTargetException
    //   156	195	576	java/lang/IllegalAccessException
    //   200	220	576	java/lang/IllegalAccessException
    //   225	247	576	java/lang/IllegalAccessException
    //   247	252	584	java/lang/IllegalAccessException
    //   156	195	589	java/lang/NoSuchFieldException
    //   200	220	589	java/lang/NoSuchFieldException
    //   225	247	589	java/lang/NoSuchFieldException
    //   247	252	597	java/lang/NoSuchFieldException
    //   156	195	602	java/lang/NoSuchMethodException
    //   200	220	602	java/lang/NoSuchMethodException
    //   225	247	602	java/lang/NoSuchMethodException
    //   247	252	610	java/lang/NoSuchMethodException
    //   156	195	615	java/lang/ClassNotFoundException
    //   200	220	615	java/lang/ClassNotFoundException
    //   225	247	615	java/lang/ClassNotFoundException
    //   247	252	623	java/lang/ClassNotFoundException
  }
  
  private boolean setCameraDisplayOrientation(int paramInt, Camera paramCamera)
  {
    CameraInformation localCameraInformation = getCameraDisplayOrientation(paramInt, paramCamera);
    this.CompenSateSendAngle = getSendAngleCompensation();
    this.CompenSateRecvAngle = getRecvAngleCompensation();
    Info.facing = localCameraInformation.facing;
    Info.orientation = localCameraInformation.orientation;
    if (localCameraInformation.facing == 1)
    {
      paramInt = (360 - (getOrientation() + getRotation()) % 360) % 360;
      if (localCameraInformation.facing != 1) {
        break label121;
      }
    }
    label121:
    for (paramInt = (paramInt + getPreviewAngleForFrontCamera()) % 360;; paramInt = (paramInt + getPreviewAngleForBackCamera()) % 360)
    {
      setDisplayOrientation(paramCamera, paramInt);
      return true;
      paramInt = (getOrientation() - getRotation() + 360) % 360;
      break;
    }
  }
  
  private void setCameraFps(int paramInt)
    throws RuntimeException
  {
    try
    {
      Camera.Parameters localParameters1 = this.mCamera.getParameters();
      if (localParameters1 == null) {
        return;
      }
    }
    catch (Exception localException1)
    {
      Camera.Parameters localParameters2;
      for (;;)
      {
        QLog.d("VcCamera", 0, "getParameters exception", localException1);
        localParameters2 = null;
      }
      nInFPS = getPreviewFPS(paramInt, localParameters2);
      localParameters2.setPreviewFrameRate(nInFPS);
      QLog.i("VcCamera", 0, "setCameraFps fps = " + nInFPS);
      try
      {
        this.mCamera.setParameters(localParameters2);
        return;
      }
      catch (Exception localException2)
      {
        QLog.i("VcCamera", 0, "setParameters exception", localException2);
      }
    }
  }
  
  private void setCameraPara(int paramInt1, int paramInt2)
    throws RuntimeException
  {
    if (this.mCamera == null) {
      QLog.d("VcCamera", 0, "openCamera camera == null");
    }
    for (;;)
    {
      return;
      label45:
      synchronized (Info)
      {
        if (fitSdkVersion()) {
          setCameraDisplayOrientation(this.CameraId, this.mCamera);
        }
      }
      try
      {
        ??? = this.mCamera.getParameters();
        if (??? == null)
        {
          QLog.d("VcCamera", 0, "getParameters parameters == null ");
          if ((paramInt1 <= this.VideoChatSettings.width) || (paramInt2 <= this.VideoChatSettings.height)) {
            continue;
          }
          QLog.d("VcCamera", 0, "save parasw" + paramInt1 + "h" + paramInt2);
          this.VideoChatSettings.width = paramInt1;
          this.VideoChatSettings.height = paramInt2;
          return;
          adjustDirection(this.mCamera);
          break label45;
          localObject3 = finally;
          throw localObject3;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          QLog.d("VcCamera", 0, "getParameters exception", localException1);
          localObject2 = null;
        }
      }
    }
    try
    {
      localObject4 = (List)localObject2.getClass().getMethod("getSupportedPreviewFormats", new Class[0]).invoke(localObject2, (Object[])null);
      if (localObject4 == null) {
        break label1449;
      }
      i = 0;
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        try
        {
          localObject4 = localObject2.getClass().getMethod("getSupportedPreviewSizes", new Class[0]);
          if (localObject4 != null)
          {
            localObject4 = (List)((Method)localObject4).invoke(localObject2, (Object[])null);
            if (localObject4 != null)
            {
              this.mFrameSizes = ((List)localObject4);
              localObject4 = getOptimalEqualPreviewSize((List)localObject4, paramInt1, paramInt2);
              if (localObject4 == null) {
                continue;
              }
              this.VideoChatSettings.width = ((Camera.Size)localObject4).width;
              this.VideoChatSettings.height = ((Camera.Size)localObject4).height;
            }
          }
          if (((this.DEV_MANUFACTURER.equalsIgnoreCase("samsung")) && (this.DEV_MODEL.equalsIgnoreCase("GT-I9003"))) || ((this.DEV_MANUFACTURER.equalsIgnoreCase("samsung")) && (this.DEV_MODEL.equalsIgnoreCase("GT-I9220"))) || ((this.DEV_MANUFACTURER.equalsIgnoreCase("samsung")) && (this.DEV_MODEL.equalsIgnoreCase("GT-I7000"))))
          {
            this.VideoChatSettings.width = 320;
            this.VideoChatSettings.height = 240;
            ((Camera.Parameters)localObject2).setPreviewSize(this.VideoChatSettings.width, this.VideoChatSettings.height);
            if (((Camera.Parameters)localObject2).getSupportedFocusModes().contains("continuous-video")) {
              ((Camera.Parameters)localObject2).setFocusMode("continuous-video");
            }
            if ((nInFPS > 30) || (nInFPS < 10)) {
              nInFPS = 10;
            }
            QLog.i("VcCamera", 0, "setCameraPara user setting of fps = " + nInFPS);
            nInFPS = getPreviewFPS(nInFPS, (Camera.Parameters)localObject2);
            if ((nInFPS > 30) || (nInFPS < 10)) {
              nInFPS = 10;
            }
            QLog.i("VcCamera", 0, "setCameraPara fps = " + nInFPS);
            if (i == 0) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("VcCamera", 0, "supportFormat = " + i);
            }
            ((Camera.Parameters)localObject2).setPreviewFormat(i);
            ((Camera.Parameters)localObject2).setPreviewFrameRate(nInFPS);
            ((Camera.Parameters)localObject2).set("Rotation", 180);
            paramInt1 = 1;
          }
        }
        catch (Exception localException4)
        {
          try
          {
            this.mCamera.setParameters((Camera.Parameters)localObject2);
            Object localObject4 = ((Camera.Parameters)localObject2).getPreviewSize();
            paramInt2 = ((Camera.Parameters)localObject2).getPreviewFormat();
            if (QLog.isColorLevel()) {
              QLog.d("VcCamera", 0, "videoFormat = " + paramInt2);
            }
            this.VideoChatSettings.width = ((Camera.Size)localObject4).width;
            this.VideoChatSettings.height = ((Camera.Size)localObject4).height;
            this.VideoChatSettings.format = paramInt2;
            if ((this.DEV_MANUFACTURER.equalsIgnoreCase("meizu")) && (this.DEV_MODEL.equalsIgnoreCase("meizu_m9")))
            {
              this.VideoChatSettings.format = 18;
              if (paramInt1 != 0) {}
            }
            try
            {
              localObject2 = this.mCamera.getParameters();
              if (localObject2 != null)
              {
                this.VideoChatSettings.width = ((Camera.Parameters)localObject2).getPreviewSize().width;
                this.VideoChatSettings.height = ((Camera.Parameters)localObject2).getPreviewSize().height;
                this.VideoChatSettings.format = ((Camera.Parameters)localObject2).getPreviewFormat();
              }
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
              continue;
            }
            QLog.d("VcCamera", 0, "setCameraPara width: " + this.VideoChatSettings.width + "height: " + this.VideoChatSettings.height + "format: " + this.VideoChatSettings.format);
            return;
            if (((List)localObject4).contains(Integer.valueOf(16)))
            {
              i = 16;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(20)))
            {
              i = 20;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(842094169)))
            {
              i = 842094169;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(4)))
            {
              i = 4;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(17)))
            {
              i = 17;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(16)))
            {
              i = 16;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(3)))
            {
              i = 3;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(2)))
            {
              i = 2;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(4)))
            {
              i = 4;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(100)))
            {
              i = 100;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(101)))
            {
              i = 101;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(102)))
            {
              i = 102;
              continue;
            }
            if (((List)localObject4).contains(Integer.valueOf(103)))
            {
              i = 103;
              continue;
            }
            boolean bool = ((List)localObject4).contains(Integer.valueOf(104));
            if (bool)
            {
              i = 104;
              continue;
              localException3 = localException3;
              localException3.printStackTrace();
              i = 0;
              continue;
              this.VideoChatSettings.width = 640;
              this.VideoChatSettings.height = 480;
              continue;
              localException4 = localException4;
              localException4.printStackTrace();
              continue;
              if ((!this.DEV_MANUFACTURER.equalsIgnoreCase("OPPO")) || (!this.DEV_MODEL.equalsIgnoreCase("OPPO R9s"))) {
                continue;
              }
              QLog.i("VcCamera", 0, "oppo r9s");
              if ((this.VideoChatSettings.width != 320) || (this.VideoChatSettings.height != 240)) {
                continue;
              }
              this.VideoChatSettings.width = 640;
              this.VideoChatSettings.height = 480;
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("VcCamera", 0, "supportFormat = 17(default value)");
              }
              ((Camera.Parameters)localObject2).setPreviewFormat(17);
            }
          }
          catch (Exception localException5)
          {
            localException5.printStackTrace();
            paramInt1 = 0;
            continue;
            if ((!this.DEV_MANUFACTURER.equalsIgnoreCase("ZTE")) || (!this.DEV_MODEL.equalsIgnoreCase("ZTE-T U880"))) {
              continue;
            }
            this.VideoChatSettings.format = 100;
            continue;
          }
        }
        int i = 0;
        continue;
        i += 1;
      }
    }
    if (i < ((List)localObject4).size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "format: " + ((List)localObject4).get(i));
      }
    }
    else
    {
      bool = ((List)localObject4).contains(Integer.valueOf(17));
      if (bool) {
        i = 17;
      }
    }
  }
  
  private void setDisplayOrientation(Camera paramCamera, int paramInt)
  {
    try
    {
      paramCamera.getClass().getMethod("setDisplayOrientation", new Class[] { Integer.TYPE }).invoke(paramCamera, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramCamera)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VcCamera", 0, "setDisplayOrientation", paramCamera);
    }
  }
  
  private static ArrayList<Integer> splitInt(String paramString)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ",");
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      paramString = localArrayList;
      if (!localStringTokenizer.hasMoreElements()) {
        break;
      }
      localArrayList.add(Integer.valueOf(Integer.parseInt(localStringTokenizer.nextToken())));
    }
  }
  
  private Camera tryMotoFrontCamera()
  {
    Camera localCamera2 = this.mCamera;
    Camera localCamera1;
    if (localCamera2 != null) {
      localCamera1 = localCamera2;
    }
    try
    {
      localCamera2.release();
      localCamera1 = localCamera2;
      localCamera2 = Camera.open();
      if (localCamera2 == null) {
        return null;
      }
      localCamera1 = localCamera2;
      Camera.Parameters localParameters = (Camera.Parameters)localCamera2.getClass().getMethod("getCustomParameters", new Class[0]).invoke(localCamera2, new Object[0]);
      localCamera1 = localCamera2;
      ArrayList localArrayList = splitInt(localParameters.get("camera-sensor-values"));
      localCamera1 = localCamera2;
      Method localMethod = localCamera2.getClass().getMethod("setCustomParameters", new Class[] { localParameters.getClass() });
      if (localArrayList != null)
      {
        localCamera1 = localCamera2;
        if (localArrayList.indexOf(Integer.valueOf(1)) != -1)
        {
          localCamera1 = localCamera2;
          localParameters.set("camera-sensor", "1");
          localCamera1 = localCamera2;
          localMethod.invoke(localCamera2, new Object[] { localParameters });
          return localCamera2;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "tryMotoFrontCamera", localException);
      }
      if (localCamera1 != null) {
        localCamera1.release();
      }
      return null;
    }
    return localException;
  }
  
  private Camera trySamsungFrontCamera()
  {
    Camera localCamera = this.mCamera;
    if (localCamera != null) {}
    try
    {
      localCamera.release();
      localCamera = Camera.open();
      if (localCamera == null) {
        return null;
      }
      Camera.Parameters localParameters = localCamera.getParameters();
      localParameters.set("camera-id", 2);
      localCamera.setParameters(localParameters);
      this.mCamera = localCamera;
      return localCamera;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VcCamera", 0, "trySamsungFrontCamera", localException);
      }
    }
    return null;
  }
  
  public void close()
  {
    if (this.mCameraHandler == null) {
      return;
    }
    this.mCameraHandler.post(new Runnable()
    {
      public void run()
      {
        VcCamera.this.closeInternal();
        VcCamera.this.mCameraThread.quit();
        VcCamera.this.mCameraThread = null;
        VcCamera.access$702(VcCamera.this, null);
        AVUILoopProxy.postTaskToMainLooper(new VcCamera.CloseCompleteRunnable(VcCamera.this, VcCamera.this));
      }
    });
  }
  
  void closeInternal()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VcCamera", 0, "closeCamera begin.");
    }
    if ((this.mCamera == null) && (!isCameraOpened) && (QLog.isColorLevel())) {
      QLog.d("VcCamera", 0, "Camera not open.");
    }
    if (this.mCamera != null) {
      if (isCameraOpened)
      {
        if (!this.mCallbackBufferAddStrategy.getIsUseBuffer()) {
          break label137;
        }
        this.mCamera.setPreviewCallbackWithBuffer(null);
      }
    }
    for (;;)
    {
      this.mCamera.stopPreview();
      this.mCamera.release();
      this.mCamera = null;
      if (this.mUseSurfaceTexture) {
        this.mSurfaceTextureManager.uninit();
      }
      isCameraOpened = false;
      this.CUR_CAMERA = -1;
      this.LAST_CAMERA = -1;
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "closeCamera end.");
      }
      return;
      label137:
      this.mCamera.setPreviewCallback(null);
    }
  }
  
  public boolean finish()
  {
    if (this.mCameraHandler == null) {
      return false;
    }
    this.mCameraHandler.post(new Runnable()
    {
      public void run()
      {
        VcCamera.this.closeInternal();
        VcCamera.this.mCameraThread.quit();
        VcCamera.this.mCameraThread = null;
        AVUILoopProxy.postTaskToMainLooper(new VcCamera.FinishCompleteRunnable(VcCamera.this, VcCamera.this));
      }
    });
    return true;
  }
  
  public Object getCamera()
  {
    if ((!isCameraOpened) || (this.mCamera == null)) {
      return null;
    }
    return this.mCamera;
  }
  
  public Object getCameraHandler()
  {
    return this.mCameraHandler;
  }
  
  public Object getCameraParameter()
  {
    if ((!isCameraOpened) || (this.mCamera == null)) {
      return null;
    }
    return this.mCamera.getParameters();
  }
  
  public int getCompenSateRecvAngle()
  {
    return this.CompenSateRecvAngle;
  }
  
  public int getCompenSateSendAngle()
  {
    return this.CompenSateSendAngle;
  }
  
  public int getOrientation()
  {
    if (Info.orientation == -1)
    {
      if (this.CUR_CAMERA == 0) {
        return 270;
      }
      if (this.CUR_CAMERA == 1) {
        return 90;
      }
    }
    return Info.orientation;
  }
  
  int getPreviewAngleForBackCamera()
  {
    return ConfigSystemImpl.GetAngleForCamera(this.mContext, false, true, (byte)0) * 90;
  }
  
  int getPreviewAngleForFrontCamera()
  {
    return 360 - ConfigSystemImpl.GetAngleForCamera(this.mContext, true, true, (byte)0) * 90;
  }
  
  int getRemoteAngleForBackCamera(int paramInt)
  {
    byte b;
    switch (paramInt)
    {
    default: 
      b = 0;
    }
    for (;;)
    {
      return ConfigSystemImpl.GetAngleForCamera(this.mContext, false, false, b) * 90;
      b = 0;
      continue;
      b = 1;
      continue;
      b = 2;
      continue;
      b = 3;
    }
  }
  
  int getRemoteAngleForFrontCamera(int paramInt)
  {
    byte b;
    switch (paramInt)
    {
    default: 
      b = 0;
    }
    for (;;)
    {
      return ConfigSystemImpl.GetAngleForCamera(this.mContext, true, false, b) * 90;
      b = 0;
      continue;
      b = 1;
      continue;
      b = 2;
      continue;
      b = 3;
    }
  }
  
  public int getRotation()
  {
    if (Info.rotation == -1) {
      return 0;
    }
    return Info.rotation;
  }
  
  public int getUserCameraAngle(boolean paramBoolean)
  {
    if (paramBoolean == true) {
      return this.mFrontCameraAngle;
    }
    return this.mBackCameraAngle;
  }
  
  public void initCameraSetting(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.i("VcCamera", 0, "setWebConfigCameraSetting fps = " + paramInt3 + "width = " + paramInt1 + "height = " + paramInt2);
    nInFPS = paramInt3;
    this.VideoChatSettings.width = paramInt1;
    this.VideoChatSettings.height = paramInt2;
  }
  
  public boolean isFrontCamera()
  {
    if (this.CUR_CAMERA == -1) {}
    while (this.CUR_CAMERA == 0) {
      return true;
    }
    return false;
  }
  
  native void onCaptureFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  native void onCloseCamera();
  
  native void onFinishCamera();
  
  native void onOpenCamera(boolean paramBoolean);
  
  public void open(final int paramInt)
  {
    QLog.d("VcCamera", 0, "openCamera begin.");
    if (this.mCameraThread == null)
    {
      this.mCameraThread = new HandlerThread("CAMERA");
      this.mCameraThread.start();
      this.mCameraHandler = new Handler(this.mCameraThread.getLooper());
    }
    this.mCameraHandler.post(new Runnable()
    {
      public void run()
      {
        QLog.d("VcCamera", 0, "openCamera run.");
        boolean bool;
        if (VcCamera.isCameraOpened) {
          bool = true;
        }
        for (;;)
        {
          VcCamera.isCameraOpened = bool;
          AVUILoopProxy.postTaskToMainLooper(new VcCamera.OpenCompleteRunnable(VcCamera.this, VcCamera.this, bool));
          QLog.d("VcCamera", 0, "openCamera end.");
          return;
          if (VcCamera.this.mContext == null)
          {
            QLog.d("VcCamera", 0, "openCamera context == null");
            bool = false;
          }
          else
          {
            synchronized (VcCamera.this.holderLock)
            {
              SurfaceHolder localSurfaceHolder;
              if (VcCamera.mHolder == null)
              {
                localSurfaceHolder = null;
                if (VcCamera.this.mUseSurfaceTexture)
                {
                  VcCamera.this.mSurfaceTextureManager.init();
                  SurfaceTexture localSurfaceTexture = VcCamera.this.mSurfaceTextureManager.getSurfaceTexture();
                  ??? = localSurfaceTexture;
                  if (localSurfaceTexture != null) {
                    break label181;
                  }
                  QLog.d("VcCamera", 0, "openCamera surfaceTexture == null");
                  bool = false;
                }
              }
              else
              {
                localSurfaceHolder = (SurfaceHolder)VcCamera.mHolder.get();
              }
            }
            if (localObject1 == null)
            {
              QLog.d("VcCamera", 0, "openCamera holder == null");
              bool = false;
            }
            else
            {
              ??? = null;
              label181:
              if (VcCamera.this.NUM_CAMERA == 0) {
                VcCamera.this.NUM_CAMERA = VcCamera.access$400();
              }
              if (paramInt == 0)
              {
                if ((!VcCamera.this.openFrontCamera()) && (!VcCamera.this.openBackCamera()))
                {
                  QLog.d("VcCamera", 0, "openCamera failed");
                  bool = false;
                }
              }
              else if ((!VcCamera.this.openBackCamera()) && (!VcCamera.this.openFrontCamera()))
              {
                QLog.d("VcCamera", 0, "openCamera failed");
                bool = false;
                continue;
              }
              if (VcCamera.this.mCamera != null) {
                break;
              }
              QLog.d("VcCamera", 0, "openCamera camera == null");
              bool = false;
            }
          }
        }
        VcCamera.this.setCameraPara(VcCamera.this.VideoChatSettings.width, VcCamera.this.VideoChatSettings.height);
        for (;;)
        {
          try
          {
            VcCamera.this.mCallbackBufferAddStrategy.setCameraCaptureSettings(VcCamera.this.VideoChatSettings);
            VcCamera.this.mCallbackBufferAddStrategy.fistAdd(VcCamera.this.mCamera);
            if (VcCamera.this.mCallbackBufferAddStrategy.getIsUseBuffer())
            {
              VcCamera.this.mCamera.setPreviewCallbackWithBuffer(VcCamera.this.cameraCallback);
              if (!VcCamera.this.mUseSurfaceTexture) {
                break label463;
              }
              VcCamera.this.mCamera.setPreviewTexture(???);
              VcCamera.this.mCamera.startPreview();
              bool = true;
              break;
            }
            VcCamera.this.mCamera.setPreviewCallback(VcCamera.this.cameraCallback);
            continue;
          }
          catch (Exception localException)
          {
            QLog.d("VcCamera", 0, "setPreviewDisplay error", localException);
            localException.printStackTrace();
            bool = false;
          }
          label463:
          VcCamera.this.mCamera.setPreviewDisplay(localException);
        }
      }
    });
  }
  
  /* Error */
  public void setAfterPreviewListener(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 160	com/tencent/TMG/camera/VcCamera:afterPreviewListenerLock	Ljava/lang/Object;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_0
    //   10: aload_1
    //   11: putfield 402	com/tencent/TMG/camera/VcCamera:afterPreviewListener	Ljava/lang/Object;
    //   14: aload_2
    //   15: monitorexit
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore_1
    //   20: aload_2
    //   21: monitorexit
    //   22: aload_1
    //   23: athrow
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	this	VcCamera
    //   0	29	1	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	16	19	finally
    //   20	22	19	finally
    //   2	9	24	finally
    //   22	24	24	finally
  }
  
  public void setCameraAngleFix(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      this.mFrontCameraAngle = (paramInt % 360);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 0, "mFrontCameraAngle" + this.mFrontCameraAngle + "mBackCameraAngle" + this.mBackCameraAngle);
      }
      return;
      this.mBackCameraAngle = (paramInt % 360);
    }
  }
  
  public void setCameraParaDynamic(final int paramInt1, final int paramInt2)
  {
    QLog.d("VcCamera", 0, "setCameraParaDynamic w: " + paramInt1 + " h: " + paramInt2);
    if (this.mCameraHandler == null)
    {
      QLog.i("VcCamera", 0, "setCameraParaDynamic mCameraHandler == null");
      this.VideoChatSettings.width = paramInt1;
      this.VideoChatSettings.height = paramInt2;
      return;
    }
    this.mCameraHandler.post(new Runnable()
    {
      public void run()
      {
        if (VcCamera.this.mCamera == null) {
          return;
        }
        for (;;)
        {
          try
          {
            if (VcCamera.this.mCallbackBufferAddStrategy.getIsUseBuffer())
            {
              VcCamera.this.mCamera.setPreviewCallbackWithBuffer(null);
              VcCamera.this.mCamera.stopPreview();
              VcCamera.this.setCameraPara(paramInt1, paramInt2);
              VcCamera.this.mCallbackBufferAddStrategy.setCameraCaptureSettings(VcCamera.this.VideoChatSettings);
              VcCamera.this.mCallbackBufferAddStrategy.fistAdd(VcCamera.this.mCamera);
              if (!VcCamera.this.mCallbackBufferAddStrategy.getIsUseBuffer()) {
                break label164;
              }
              VcCamera.this.mCamera.setPreviewCallbackWithBuffer(VcCamera.this.cameraCallback);
              VcCamera.this.mCamera.startPreview();
              return;
            }
          }
          catch (Exception localException)
          {
            QLog.d("VcCamera", 0, "setCameraParaDynamic error", localException);
            localException.printStackTrace();
            return;
          }
          VcCamera.this.mCamera.setPreviewCallback(null);
          continue;
          label164:
          VcCamera.this.mCamera.setPreviewCallback(VcCamera.this.cameraCallback);
        }
      }
    });
  }
  
  public void setCameraParaDynamic(final int paramInt, final boolean paramBoolean)
  {
    QLog.d("VcCamera", 0, "setCameraParaDynamic fps: " + paramInt + "needRestartPreview: " + paramBoolean);
    if (this.mCameraHandler == null)
    {
      QLog.i("VcCamera", 0, "setCameraParaDynamic mCameraHandler == null");
      nInFPS = paramInt;
      return;
    }
    this.mCameraHandler.post(new Runnable()
    {
      public void run()
      {
        if (VcCamera.this.mCamera == null) {
          return;
        }
        if (paramBoolean) {
          for (;;)
          {
            try
            {
              if (VcCamera.this.mCallbackBufferAddStrategy.getIsUseBuffer())
              {
                VcCamera.this.mCamera.setPreviewCallbackWithBuffer(null);
                VcCamera.this.mCamera.stopPreview();
                VcCamera.this.setCameraFps(paramInt);
                VcCamera.this.mCallbackBufferAddStrategy.setCameraCaptureSettings(VcCamera.this.VideoChatSettings);
                VcCamera.this.mCallbackBufferAddStrategy.fistAdd(VcCamera.this.mCamera);
                if (!VcCamera.this.mCallbackBufferAddStrategy.getIsUseBuffer()) {
                  break label167;
                }
                VcCamera.this.mCamera.setPreviewCallbackWithBuffer(VcCamera.this.cameraCallback);
                VcCamera.this.mCamera.startPreview();
                return;
              }
            }
            catch (Exception localException)
            {
              QLog.d("VcCamera", 0, "setCameraParaDynamic error", localException);
              localException.printStackTrace();
              return;
            }
            VcCamera.this.mCamera.setPreviewCallback(null);
            continue;
            label167:
            VcCamera.this.mCamera.setPreviewCallback(VcCamera.this.cameraCallback);
          }
        }
        VcCamera.this.setCameraFps(paramInt);
      }
    });
  }
  
  public void setCameraParameter(final Object paramObject)
  {
    this.mCameraHandler.post(new Runnable()
    {
      public void run()
      {
        if ((paramObject != null) && (VcCamera.this.mCamera != null) && ((paramObject instanceof Camera.Parameters))) {}
        try
        {
          VcCamera.this.mCamera.setParameters((Camera.Parameters)paramObject);
          return;
        }
        catch (Exception localException) {}
      }
    });
  }
  
  public void setCameraPreviewChangeCallback(Object paramObject)
  {
    localObject = this.cameraPreviewChangeCallbackLock;
    if (paramObject == null) {}
    for (;;)
    {
      try
      {
        mCameraPreviewChangeCallback = null;
        return;
      }
      finally {}
      mCameraPreviewChangeCallback = new WeakReference((AVVideoCtrl.CameraPreviewChangeCallback)paramObject);
    }
  }
  
  public void setPreviewDisplay(Object paramObject)
  {
    synchronized (this.holderLock)
    {
      mHolder = new WeakReference((SurfaceHolder)paramObject);
      return;
    }
  }
  
  public void setRotation(int paramInt)
  {
    Info.rotation = ((this.CompenSateSendAngle + paramInt) % 360);
  }
  
  public void setUseSurfaceTexture(boolean paramBoolean)
  {
    QLog.i("VcCamera", 0, "setUseSurfaceTexture useSurfaceTexture" + paramBoolean);
    this.mUseSurfaceTexture = paramBoolean;
  }
  
  public void setWebConfigFps(int paramInt)
  {
    QLog.i("VcCamera", 0, "setWebConfigFps fps = " + paramInt);
    nInFPS = paramInt;
  }
  
  public void switchCamera(int paramInt)
  {
    this.mCameraHandler.post(new SwitchCameraRunnable(paramInt));
  }
  
  static class CameraInformation
  {
    int facing;
    int orientation;
    int rotation;
  }
  
  class CameraPreviewChangeRunnable
    implements Runnable
  {
    int cameraId = -1;
    
    CameraPreviewChangeRunnable(int paramInt)
    {
      this.cameraId = paramInt;
    }
    
    public void run()
    {
      QLog.d("VcCamera", 0, "onCameraPreviewChangeCallback run.");
      Object localObject2 = VcCamera.this.cameraPreviewChangeCallbackLock;
      AVVideoCtrl.CameraPreviewChangeCallback localCameraPreviewChangeCallback = null;
      try
      {
        if (VcCamera.mCameraPreviewChangeCallback != null) {
          localCameraPreviewChangeCallback = (AVVideoCtrl.CameraPreviewChangeCallback)VcCamera.mCameraPreviewChangeCallback.get();
        }
        if (localCameraPreviewChangeCallback != null) {
          localCameraPreviewChangeCallback.onCameraPreviewChangeCallback(this.cameraId);
        }
        return;
      }
      finally {}
    }
  }
  
  class CloseCompleteRunnable
    implements Runnable
  {
    WeakReference<VcCamera> mHost = null;
    
    CloseCompleteRunnable(VcCamera paramVcCamera)
    {
      this.mHost = new WeakReference(paramVcCamera);
    }
    
    public void run()
    {
      if ((this.mHost != null) && (this.mHost.get() != null)) {
        ((VcCamera)this.mHost.get()).onCloseCamera();
      }
    }
  }
  
  class FinishCompleteRunnable
    implements Runnable
  {
    WeakReference<VcCamera> mHost = null;
    
    FinishCompleteRunnable(VcCamera paramVcCamera)
    {
      this.mHost = new WeakReference(paramVcCamera);
    }
    
    public void run()
    {
      if ((this.mHost != null) && (this.mHost.get() != null)) {
        ((VcCamera)this.mHost.get()).onFinishCamera();
      }
    }
  }
  
  class OpenCompleteRunnable
    implements Runnable
  {
    WeakReference<VcCamera> mHost = null;
    boolean mResult = false;
    
    OpenCompleteRunnable(VcCamera paramVcCamera, boolean paramBoolean)
    {
      this.mResult = paramBoolean;
      this.mHost = new WeakReference(paramVcCamera);
    }
    
    public void run()
    {
      if ((this.mHost != null) && (this.mHost.get() != null)) {
        ((VcCamera)this.mHost.get()).onOpenCamera(this.mResult);
      }
    }
  }
  
  class SwitchCameraRunnable
    implements Runnable
  {
    int mCameraId = 0;
    
    SwitchCameraRunnable(int paramInt)
    {
      this.mCameraId = paramInt;
    }
    
    public void run()
    {
      if ((VcCamera.this.NUM_CAMERA < 2) || (VcCamera.this.mCamera == null)) {}
      while (this.mCameraId == VcCamera.this.CUR_CAMERA) {
        return;
      }
      VcCamera.this.closeInternal();
      if (this.mCameraId == 0)
      {
        if (!VcCamera.this.openFrontCamera()) {
          break label397;
        }
        VcCamera.this.setCameraPara(VcCamera.this.VideoChatSettings.width, VcCamera.this.VideoChatSettings.height);
      }
      label397:
      for (int i = 1;; i = 0) {
        for (;;)
        {
          synchronized (VcCamera.this.holderLock)
          {
            if (VcCamera.mHolder == null)
            {
              localSurfaceHolder1 = null;
              if (!VcCamera.this.mUseSurfaceTexture) {
                break label339;
              }
              VcCamera.this.mSurfaceTextureManager.init();
              SurfaceTexture localSurfaceTexture = VcCamera.this.mSurfaceTextureManager.getSurfaceTexture();
              ??? = localSurfaceTexture;
              if (localSurfaceTexture == null)
              {
                QLog.d("VcCamera", 0, "switchCamera surfaceTexture == null");
                i = 0;
                ??? = localSurfaceTexture;
              }
              if (i == 0) {
                break;
              }
              try
              {
                VcCamera.this.mCallbackBufferAddStrategy.setCameraCaptureSettings(VcCamera.this.VideoChatSettings);
                VcCamera.this.mCallbackBufferAddStrategy.fistAdd(VcCamera.this.mCamera);
                if (!VcCamera.this.mCallbackBufferAddStrategy.getIsUseBuffer()) {
                  break label358;
                }
                VcCamera.this.mCamera.setPreviewCallbackWithBuffer(VcCamera.this.cameraCallback);
                if (!VcCamera.this.mUseSurfaceTexture) {
                  break label378;
                }
                VcCamera.this.mCamera.setPreviewTexture(???);
                VcCamera.this.mCamera.startPreview();
                return;
              }
              catch (Exception localException) {}
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("VcCamera", 0, "setPreviewDisplay error", localException);
              return;
              if (!VcCamera.this.openBackCamera()) {
                break label397;
              }
              VcCamera.this.setCameraPara(VcCamera.this.VideoChatSettings.width, VcCamera.this.VideoChatSettings.height);
              i = 1;
              continue;
            }
            SurfaceHolder localSurfaceHolder1 = (SurfaceHolder)VcCamera.mHolder.get();
          }
          label339:
          Object localObject2;
          if (localSurfaceHolder2 == null)
          {
            QLog.d("VcCamera", 0, "switchCamera holder == null");
            localObject2 = null;
            i = 0;
            continue;
            label358:
            VcCamera.this.mCamera.setPreviewCallback(VcCamera.this.cameraCallback);
            continue;
            label378:
            VcCamera.this.mCamera.setPreviewDisplay(localSurfaceHolder2);
          }
          else
          {
            localObject2 = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera
 * JD-Core Version:    0.7.0.1
 */