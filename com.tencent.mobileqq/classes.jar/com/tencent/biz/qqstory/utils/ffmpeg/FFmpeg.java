package com.tencent.biz.qqstory.utils.ffmpeg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import oou;
import oow;
import oox;
import ooy;
import ooz;
import opa;
import opb;
import opg;
import opi;

public class FFmpeg
{
  public static volatile FFmpeg a;
  public int a;
  protected long a;
  public BroadcastReceiver a;
  public final Context a;
  public FFmpegCommandUnit a;
  public String a;
  public ArrayList a;
  public opb a;
  protected boolean a;
  public ArrayList b = new ArrayList();
  public boolean b;
  
  private FFmpeg(Context paramContext)
  {
    this.jdField_a_of_type_Long = 9223372036854775807L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = -9999;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new opa(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.SCREEN_OFF");
    paramContext.addAction("android.intent.action.SCREEN_ON");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramContext);
    opi.a(new File(opg.a(this.jdField_a_of_type_AndroidContentContext)));
  }
  
  public static FFmpeg a(Context paramContext)
  {
    return a(paramContext, false);
  }
  
  public static FFmpeg a(Context paramContext, boolean paramBoolean)
  {
    if (jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg == null) {
        jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg = new FFmpeg(paramContext);
      }
      jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.jdField_a_of_type_Boolean = paramBoolean;
      return jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg;
    }
    finally {}
  }
  
  private String a(int paramInt)
  {
    return String.format("%02d:%02d:%02d.%03d", new Object[] { Integer.valueOf((int)Math.floor(paramInt / 3600000)), Integer.valueOf((int)Math.floor(paramInt % 3600000) / 60000), Integer.valueOf((int)Math.floor(paramInt % 60000 / 1000)), Integer.valueOf((int)Math.floor(paramInt % 1000)) });
  }
  
  public static FFmpeg b(Context paramContext, boolean paramBoolean)
  {
    paramContext = new FFmpeg(paramContext);
    paramContext.jdField_a_of_type_Boolean = paramBoolean;
    return paramContext;
  }
  
  public oou a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    paramString4 = new oou(paramString4);
    paramString4.jdField_a_of_type_JavaLangString = paramString3;
    return a(paramString1, paramString2, paramBoolean, paramString4, paramInt, paramFFmpegExecuteResponseCallback);
  }
  
  public oou a(String paramString1, String paramString2, boolean paramBoolean, oou paramoou, int paramInt, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "combineAudioAndVideo arguments: \n inVideo" + paramString1 + "\n inAudio:" + paramString2 + "\n outMedia:" + paramoou);
    if (!com.tencent.biz.qqstory.utils.FileUtils.c(paramString1))
    {
      SLog.e("Q.qqstory.ffmpeg.FFmpegCmd", "clipAudio but inVideo file is not exist");
      paramFFmpegExecuteResponseCallback.b(String.valueOf(941002));
      paramFFmpegExecuteResponseCallback.a(false);
      return paramoou;
    }
    if (!com.tencent.biz.qqstory.utils.FileUtils.c(paramString2))
    {
      SLog.e("Q.qqstory.ffmpeg.FFmpegCmd", "clipAudio but inAudio file is not exist");
      paramFFmpegExecuteResponseCallback.b(String.valueOf(941002));
      paramFFmpegExecuteResponseCallback.a(false);
      return paramoou;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    String str;
    long l1;
    if (paramBoolean)
    {
      paramString1 = new MediaMetadataRetriever();
      paramString1.setDataSource(paramString2);
      str = paramString1.extractMetadata(9);
      paramString1.release();
      l1 = paramInt;
    }
    label810:
    label822:
    try
    {
      long l2 = Long.parseLong(str);
      l1 = l2;
    }
    catch (Exception paramString1)
    {
      label204:
      int i;
      StringBuilder localStringBuilder;
      label443:
      break label204;
    }
    i = (int)Math.ceil(paramInt / (float)l1);
    if (i > 1)
    {
      paramString1 = new File(paramString2).getCanonicalPath();
      str = new File(paramString2).getParent() + "/catAudioFile.txt";
      localStringBuilder = new StringBuilder();
      paramInt = 0;
      while (paramInt < i)
      {
        if (paramInt > 0) {
          localStringBuilder.append("\n");
        }
        localStringBuilder.append("file '").append(paramString1).append("'");
        paramInt += 1;
      }
      com.tencent.mobileqq.utils.FileUtils.a(str, localStringBuilder.toString());
      localArrayList.add("-f");
      localArrayList.add("concat");
      localArrayList.add("-safe");
      localArrayList.add("0");
      localArrayList.add("-i");
      localArrayList.add(str);
      localArrayList.add("-map_chapters");
      localArrayList.add("-1");
      localArrayList.add("-strict");
      localArrayList.add("-2");
      localArrayList.add("-vcodec");
      if (paramoou.jdField_a_of_type_JavaLangString == null) {
        break label810;
      }
      localArrayList.add(paramoou.jdField_a_of_type_JavaLangString);
      localArrayList.add("-acodec");
      if (paramoou.jdField_c_of_type_JavaLangString == null) {
        break label822;
      }
      localArrayList.add(paramoou.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      FFmpegUtils.a(paramString2);
      localArrayList.add("-bsf:a");
      localArrayList.add("aac_adtstoasc");
      if (paramoou.jdField_c_of_type_Int != -1)
      {
        localArrayList.add("-b:v");
        localArrayList.add(paramoou.jdField_c_of_type_Int + "k");
      }
      if (paramoou.jdField_b_of_type_JavaLangString != null)
      {
        localArrayList.add("-r");
        localArrayList.add(paramoou.jdField_b_of_type_JavaLangString);
      }
      if (paramoou.jdField_e_of_type_Int != -1)
      {
        localArrayList.add("-b:a");
        localArrayList.add(paramoou.jdField_e_of_type_Int + "k");
      }
      if (paramoou.jdField_a_of_type_Int > 0)
      {
        localArrayList.add("-s");
        localArrayList.add(paramoou.jdField_a_of_type_Int + "x" + paramoou.jdField_b_of_type_Int);
      }
      if (paramoou.jdField_e_of_type_JavaLangString != null)
      {
        localArrayList.add("-f");
        localArrayList.add(paramoou.jdField_e_of_type_JavaLangString);
      }
      paramString1 = new File(paramoou.d);
      if (paramBoolean) {
        localArrayList.add("-shortest");
      }
      localArrayList.add(paramString1.getCanonicalPath());
      a((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
      return paramoou;
      localArrayList.add("-i");
      localArrayList.add(new File(paramString2).getCanonicalPath());
      break;
      localArrayList.add("-i");
      localArrayList.add(new File(paramString2).getCanonicalPath());
      break;
      localArrayList.add("copy");
      break label443;
      localArrayList.add("aac");
    }
  }
  
  public void a()
  {
    opi.a(new File(opg.a(this.jdField_a_of_type_AndroidContentContext)));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    Object localObject = VideoUtils.a(paramString1);
    if (localObject == null)
    {
      paramFFmpegExecuteResponseCallback.b("input path is null");
      paramFFmpegExecuteResponseCallback.a(false);
      SLog.e("Q.qqstory.ffmpeg.FFmpegCmd", "compressVideo input path is null");
      return;
    }
    int k = localObject[1];
    int n = localObject[2];
    int m = -1;
    int i = -1;
    int j;
    if ((k > 960) || (n > 960))
    {
      if (n >= k) {
        break label641;
      }
      i = 540;
      j = 540 * k / n;
    }
    for (;;)
    {
      if (k <= n)
      {
        j = 540;
        i = 540 * n / k;
      }
      k = i;
      if (i % 2 != 0) {
        k = i + 1;
      }
      i = j;
      m = k;
      if (j % 2 != 0)
      {
        i = j + 1;
        m = k;
      }
      k = 1;
      long l = com.tencent.biz.qqstory.utils.FileUtils.a(paramString1);
      j = k;
      if (l != -1L)
      {
        j = k;
        if (l < 2202009.6000000001D) {
          j = 0;
        }
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add("-y");
      if (paramInt2 != 0)
      {
        ((ArrayList)localObject).add("-ss");
        ((ArrayList)localObject).add(String.valueOf(paramInt1 / 1000) + "." + String.valueOf(paramInt1 % 1000));
        ((ArrayList)localObject).add("-accurate_seek");
      }
      ((ArrayList)localObject).add("-i");
      ((ArrayList)localObject).add(new File(paramString1).getCanonicalPath());
      if (paramInt2 != 0)
      {
        ((ArrayList)localObject).add("-t");
        ((ArrayList)localObject).add(String.valueOf(paramInt2 / 1000) + "." + String.valueOf(paramInt2 % 1000));
      }
      if ((i > 0) && (m > 0))
      {
        ((ArrayList)localObject).add("-vf");
        ((ArrayList)localObject).add("scale=" + i + ":" + m);
      }
      if (paramBoolean) {
        ((ArrayList)localObject).add("-an");
      }
      for (;;)
      {
        ((ArrayList)localObject).add("-vcodec");
        ((ArrayList)localObject).add("libx264");
        if (j != 0)
        {
          ((ArrayList)localObject).add("-b:v");
          ((ArrayList)localObject).add("" + paramInt3);
        }
        ((ArrayList)localObject).add("-bufsize");
        ((ArrayList)localObject).add("800k");
        ((ArrayList)localObject).add("-r");
        ((ArrayList)localObject).add("25");
        ((ArrayList)localObject).add("-metadata");
        ((ArrayList)localObject).add("title=" + System.currentTimeMillis());
        ((ArrayList)localObject).add("-movflags");
        ((ArrayList)localObject).add("faststart");
        ((ArrayList)localObject).add(new File(paramString2).getCanonicalPath());
        a((String[])((ArrayList)localObject).toArray(new String[0]), paramFFmpegExecuteResponseCallback);
        return;
        ((ArrayList)localObject).add("-acodec");
        ((ArrayList)localObject).add("aac");
      }
      label641:
      j = k;
      i = n;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "clipAudio arguments: \n inAudio" + paramString1 + "\n outAudio:" + paramString2 + "\n start:" + paramInt1 + "\n duration:" + paramInt2);
    if (!com.tencent.biz.qqstory.utils.FileUtils.c(paramString1))
    {
      SLog.e("Q.qqstory.ffmpeg.FFmpegCmd", "clipAudio but inAudio file is not exist");
      paramFFmpegExecuteResponseCallback.b(String.valueOf(941001));
      paramFFmpegExecuteResponseCallback.a(false);
      return;
    }
    String str1 = a(paramInt1);
    String str2 = a(paramInt2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-ss");
    localArrayList.add(str1);
    localArrayList.add("-t");
    localArrayList.add(str2);
    localArrayList.add("-acodec");
    localArrayList.add("copy");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    a((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void a(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "mp4Tots arguments: \n input:" + paramString1 + "\n outputPath:" + paramString2);
    this.b.add(paramString2);
    if (com.tencent.biz.qqstory.utils.FileUtils.c(paramString2))
    {
      paramFFmpegExecuteResponseCallback.a("TS file exists");
      paramFFmpegExecuteResponseCallback.a(true);
      SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "TS file exists");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-c");
    localArrayList.add("copy");
    localArrayList.add("-bsf:v");
    localArrayList.add("h264_mp4toannexb");
    localArrayList.add("-f");
    localArrayList.add("mpegts");
    localArrayList.add(paramString2);
    a((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "watermark arguments: \n inImage" + paramString1 + "\n inMedia:" + paramString2 + "\n outMedia:" + paramString3 + "\n videoWidth:" + paramInt1 + "\n videoHeight:" + paramInt2);
    if ((paramString2 == null) || (paramString3 == null))
    {
      paramFFmpegExecuteResponseCallback.b("input path is null");
      paramFFmpegExecuteResponseCallback.a(false);
      SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "watermark input path is null");
      return;
    }
    if (paramString1 == null)
    {
      boolean bool = com.tencent.biz.qqstory.utils.FileUtils.a(this.jdField_a_of_type_AndroidContentContext, paramString2, paramString3);
      if (bool) {
        paramFFmpegExecuteResponseCallback.a("copy_success");
      }
      for (;;)
      {
        paramFFmpegExecuteResponseCallback.a(bool);
        SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "watermark inImage == null, copy to DCIM result is " + bool);
        return;
        paramFFmpegExecuteResponseCallback.b("copy_fail");
      }
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    localArrayList.add("-vf");
    localArrayList.add("movie=" + paramString1 + " [watermark]; [watermark]scale=" + paramInt1 + ":" + paramInt2 + " [watermark]; [in][watermark] overlay=(main_w-overlay_w)/2:(main_h-overlay_h)/2 [out] ");
    localArrayList.add("-max_muxing_queue_size");
    localArrayList.add("9999");
    localArrayList.add(new File(paramString3).getCanonicalPath());
    a((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    int i = Integer.valueOf(paramString2).intValue();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vf");
    switch (i % 360)
    {
    default: 
      SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "unSupport orientation:%s", new Object[] { paramString2 });
      return;
    case 0: 
      SLog.b("Q.qqstory.ffmpeg.FFmpegCmd", "no need rotate.");
      return;
    case 90: 
      localArrayList.add("transpose=1");
    }
    for (;;)
    {
      localArrayList.add("-c:a");
      localArrayList.add("copy");
      localArrayList.add(new File(paramString3).getCanonicalPath());
      a((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
      return;
      localArrayList.add("transpose=1,transpose=1");
      continue;
      localArrayList.add("transpose=1,transpose=1,transpose=1");
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      return;
    }
    paramArrayList = (FFmpegCommandUnit)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    ArrayList localArrayList = paramArrayList.jdField_a_of_type_JavaUtilArrayList;
    String[] arrayOfString = paramArrayList.jdField_a_of_type_ArrayOfJavaLangString;
    ooz localooz = new ooz(this, paramArrayList.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback, arrayOfString, this.jdField_a_of_type_JavaUtilArrayList);
    if (arrayOfString != null)
    {
      a(arrayOfString, localooz);
      return;
    }
    switch (paramArrayList.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), ((Integer)localArrayList.get(3)).intValue(), ((Integer)localArrayList.get(4)).intValue(), localooz);
      return;
    case 3: 
      a((String)localArrayList.get(0), (String)localArrayList.get(1), ((Integer)localArrayList.get(2)).intValue(), ((Integer)localArrayList.get(3)).intValue(), localooz);
      return;
    case 4: 
      a((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), (String)localArrayList.get(3), ((Boolean)localArrayList.get(4)).booleanValue(), ((Integer)localArrayList.get(5)).intValue(), localooz);
      return;
    case 2: 
      a((List)localArrayList.get(0), (String)localArrayList.get(1), localooz, ((Boolean)localArrayList.get(2)).booleanValue());
      return;
    case 7: 
      b((List)localArrayList.get(0), (String)localArrayList.get(1), localooz);
      return;
    case 8: 
      a((List)localArrayList.get(0), (String)localArrayList.get(1), localooz);
      return;
    case 5: 
      a((String)localArrayList.get(0), (String)localArrayList.get(1), localooz);
      return;
    case 6: 
      c((List)localArrayList.get(0), (String)localArrayList.get(1), localooz);
      return;
    case 9: 
      c((String)localArrayList.get(0), (String)localArrayList.get(1), localooz);
      return;
    case 10: 
      f((String)localArrayList.get(0), (String)localArrayList.get(1), localooz);
      return;
    case 11: 
      a((String)localArrayList.get(0), ((Integer)localArrayList.get(1)).intValue(), ((Integer)localArrayList.get(2)).intValue(), ((Integer)localArrayList.get(3)).intValue(), ((Boolean)localArrayList.get(4)).booleanValue(), (String)localArrayList.get(5), localooz);
      return;
    case 12: 
      a((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), localooz);
      return;
    case 13: 
      b((String)localArrayList.get(0), (String)localArrayList.get(1), localooz);
      return;
    case 14: 
      d((String)localArrayList.get(0), (String)localArrayList.get(1), localooz);
      return;
    case 15: 
      b((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), localooz);
      return;
    }
    e((String)localArrayList.get(0), (String)localArrayList.get(1), localooz);
  }
  
  public void a(List paramList, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "concatDifferentCodingMedia arguments: \n inMedias:" + paramList + "\n outMedia:" + paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add("-i");
      localArrayList.add(new File((String)paramList.get(i)).getCanonicalPath());
      localStringBuilder.append("[" + i + ":0]");
      localStringBuilder.append(" ");
      localStringBuilder.append("[" + i + ":1]");
      localStringBuilder.append(" ");
      i += 1;
    }
    localStringBuilder.append("concat=n=" + paramList.size() + ":v=1:a=1 [v] [a]");
    localArrayList.add("-filter_complex");
    localArrayList.add(localStringBuilder.toString());
    localArrayList.add("-map");
    localArrayList.add("[v]");
    localArrayList.add("-map");
    localArrayList.add("[a]");
    localArrayList.add(new File(paramString).getCanonicalPath());
    a((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void a(List paramList, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback, boolean paramBoolean)
  {
    SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "concatMedia arguments: \n inMedias:" + paramList + "\n outMedia:" + paramString);
    new File(paramString);
    File localFile = new File(QQStoryConstant.i + "temp.txt");
    if (localFile.exists()) {
      localFile.delete();
    }
    if (!localFile.getParentFile().exists()) {
      localFile.getParentFile().mkdirs();
    }
    localFile.createNewFile();
    for (;;)
    {
      try
      {
        localBufferedWriter = new BufferedWriter(new FileWriter(localFile, true));
        int i = 0;
        if (paramString == null) {
          break label360;
        }
      }
      finally
      {
        try
        {
          if (i < paramList.size())
          {
            localBufferedWriter.write("file '" + new File((String)paramList.get(i)).getCanonicalPath() + "'");
            localBufferedWriter.newLine();
            i += 1;
            continue;
          }
          localBufferedWriter.flush();
          if (localBufferedWriter != null) {
            localBufferedWriter.close();
          }
          paramList = new ArrayList();
          paramList.add("-y");
          paramList.add("-f");
          paramList.add("concat");
          paramList.add("-i");
          paramList.add(localFile.getCanonicalPath());
          if (!paramBoolean) {
            break label362;
          }
          paramList.add("-c:v");
          paramList.add("libx264");
          paramList.add("-bsf:a");
          paramList.add("aac_adtstoasc");
          paramList.add(new File(paramString).getCanonicalPath());
          a((String[])paramList.toArray(new String[0]), new oox(this, paramFFmpegExecuteResponseCallback, localFile));
          return;
        }
        finally
        {
          for (;;)
          {
            BufferedWriter localBufferedWriter;
            paramString = localBufferedWriter;
          }
        }
        paramList = finally;
        paramString = null;
      }
      paramString.close();
      label360:
      throw paramList;
      label362:
      paramList.add("-c");
      paramList.add("copy");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Opb != null) && (!this.jdField_a_of_type_Opb.a()))
    {
      opi.a(this.jdField_a_of_type_Opb);
      this.jdField_a_of_type_Opb = null;
      this.jdField_a_of_type_Int = -9999;
      if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit != null)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.jdField_a_of_type_JavaLangString != null)
        {
          File localFile = new File(this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.jdField_a_of_type_JavaLangString);
          if (localFile.exists()) {
            localFile.delete();
          }
        }
        if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback != null))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.b("FFmpeg任务被强制Kill掉");
          this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.a(false);
          SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "FFmpeg任务被强制Kill掉");
        }
      }
    }
  }
  
  public void a(String[] paramArrayOfString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    if ((this.jdField_a_of_type_Opb != null) && (!this.jdField_a_of_type_Opb.a()))
    {
      SLog.e("Q.qqstory.ffmpeg.FFmpegCmd", "FFmpeg command is already running");
      throw new FFmpegCommandAlreadyRunningException("FFmpeg command is already running, you are only allowed to run single command at a time");
    }
    if (paramArrayOfString.length != 0)
    {
      Object localObject = paramArrayOfString[(paramArrayOfString.length - 1)];
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit = new FFmpegCommandUnit(paramArrayOfString, (String)localObject, paramFFmpegExecuteResponseCallback);
      int i = ((String)localObject).lastIndexOf("/");
      if ((i > -1) && (i < ((String)localObject).length() - 1))
      {
        localObject = new File(((String)localObject).substring(0, i + 1));
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdir();
        }
      }
      paramFFmpegExecuteResponseCallback = new oow(this, paramFFmpegExecuteResponseCallback);
      paramArrayOfString = (String[])opi.a((String[])opi.a(new String[] { opg.a(this.jdField_a_of_type_AndroidContentContext) }, paramArrayOfString), new String[] { opg.b(this.jdField_a_of_type_AndroidContentContext) });
      this.jdField_a_of_type_Opb = new opb(this.jdField_a_of_type_AndroidContentContext, paramArrayOfString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramFFmpegExecuteResponseCallback);
      this.jdField_a_of_type_Opb.execute(new Void[0]);
      SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "command execute: " + TextUtils.join(" ", paramArrayOfString));
      return;
    }
    throw new IllegalArgumentException("shell command cannot be empty");
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Opb != null) && (!this.jdField_a_of_type_Opb.a());
  }
  
  public boolean a(String paramString)
  {
    return (this.jdField_a_of_type_JavaLangString != null) && (paramString != null) && (paramString.equals(this.jdField_a_of_type_JavaLangString));
  }
  
  public void b(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-metadata");
    localArrayList.add("title=" + System.currentTimeMillis());
    paramString1 = new StringBuilder();
    paramString1.append("dev=").append(DeviceInfoUtil.e()).append("/").append("os=").append(DeviceInfoUtil.f()).append("/").append("appVer=").append("V 7.6.3.3560");
    localArrayList.add("-metadata");
    localArrayList.add("comment=" + paramString1.toString());
    localArrayList.add("-movflags");
    localArrayList.add("faststart");
    localArrayList.add("-codec");
    localArrayList.add("copy");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    a((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-i");
    localArrayList.add(paramString2);
    localArrayList.add("-filter_complex");
    localArrayList.add("[1:v]scale=iw:ih[s];[0:v][s]overlay=0:0");
    localArrayList.add(paramString3);
    a((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void b(ArrayList paramArrayList)
  {
    a(false);
    SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "[insertFFmpegQueue][old] " + TextUtils.join(" ", paramArrayList.toArray()));
    if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit);
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(0, paramArrayList);
    a(this.jdField_a_of_type_JavaUtilArrayList);
    SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "[insertFFmpegQueue][new] " + TextUtils.join(" ", paramArrayList.toArray()));
  }
  
  public void b(List paramList, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "concatMediaByTs arguments: \n inMedias:" + paramList + "\n outMedia:" + paramString);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localObject1 = (String)paramList.get(i);
      Object localObject2 = new File((String)localObject1).getName().split("\\.");
      localObject2 = QQStoryConstant.i + localObject2[0] + ".ts";
      Object localObject3 = new File((String)localObject2);
      if (!((File)localObject3).getParentFile().exists()) {
        ((File)localObject3).getParentFile().mkdirs();
      }
      localObject3 = new FFmpegCommandUnit();
      ((FFmpegCommandUnit)localObject3).jdField_a_of_type_Int = 5;
      ((FFmpegCommandUnit)localObject3).jdField_a_of_type_JavaUtilArrayList = new FFmpeg.3(this, (String)localObject1, (String)localObject2);
      ((FFmpegCommandUnit)localObject3).jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = new ooy(this, paramFFmpegExecuteResponseCallback);
      localArrayList.add(localObject3);
      i += 1;
    }
    paramList = new FFmpegCommandUnit();
    Object localObject1 = this.b;
    paramList.jdField_a_of_type_Int = 2;
    paramList.jdField_a_of_type_JavaUtilArrayList = new FFmpeg.5(this, (ArrayList)localObject1, paramString);
    paramList.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(paramList);
    a(localArrayList);
  }
  
  public void c(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-analyzeduration");
    localArrayList.add("2147483647");
    localArrayList.add("-probesize");
    localArrayList.add("2147483647");
    localArrayList.add("-framerate");
    localArrayList.add("1/3");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vcodec");
    localArrayList.add("libx264");
    localArrayList.add("-preset");
    localArrayList.add("veryslow");
    localArrayList.add("-bufsize");
    localArrayList.add("800k");
    localArrayList.add("-metadata");
    localArrayList.add("title=" + System.currentTimeMillis());
    localArrayList.add("-movflags");
    localArrayList.add("faststart");
    localArrayList.add("-r");
    localArrayList.add("25");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    paramString1 = (String[])localArrayList.toArray(new String[0]);
    SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "convertPicToVideo args: %s", new Object[] { Arrays.toString(paramString1) });
    a(paramString1, paramFFmpegExecuteResponseCallback);
  }
  
  public void c(List paramList, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\"concat:");
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuffer.append((String)paramList.get(i));
      if (i != paramList.size() - 1) {
        localStringBuffer.append("|");
      }
      i += 1;
    }
    localStringBuffer.append("\"");
    this.b = new ArrayList();
    paramList = new ArrayList();
    paramList.add("-y");
    paramList.add("-i");
    paramList.add(new String(localStringBuffer));
    paramList.add("-c");
    paramList.add("copy");
    paramList.add("-bsf:a");
    paramList.add("aac_adtstoasc");
    paramList.add(paramString);
    a((String[])paramList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void d(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "fake ffmeng command. arguments: \n inMedia:" + paramString1 + "\n outMedia:" + paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramFFmpegExecuteResponseCallback.b("input path is null");
      SLog.e("Q.qqstory.ffmpeg.FFmpegCmd", "fake ffmeng command. input path is null");
      paramFFmpegExecuteResponseCallback.a(false);
      return;
    }
    boolean bool = com.tencent.biz.qqstory.utils.FileUtils.a(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2);
    if (bool) {
      paramFFmpegExecuteResponseCallback.a("copy_success");
    }
    for (;;)
    {
      paramFFmpegExecuteResponseCallback.a(bool);
      SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "copy video to album result is " + bool);
      return;
      paramFFmpegExecuteResponseCallback.b("copy_fail");
    }
  }
  
  public void e(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vn");
    localArrayList.add("-c:a");
    localArrayList.add("copy");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    paramString1 = (String[])localArrayList.toArray(new String[0]);
    SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "extractAudioFromMp4 args: %s", new Object[] { Arrays.toString(paramString1) });
    a(paramString1, paramFFmpegExecuteResponseCallback);
  }
  
  public void f(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vf");
    localArrayList.add("transpose=1");
    localArrayList.add("-metadata:s:v");
    localArrayList.add("rotate=0");
    localArrayList.add(paramString2);
    a((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg
 * JD-Core Version:    0.7.0.1
 */