package cooperation.qzone.music;

import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QzoneMusicHelper
{
  public static final String NO_NETWORK_MSG = "无网络情况下无法修改设置";
  
  public static SongInfo convertAudioSongInfo(JSONObject paramJSONObject)
  {
    SongInfo localSongInfo = new SongInfo();
    localSongInfo.jdField_b_of_type_JavaLangString = getString(paramJSONObject, "name");
    localSongInfo.g = getString(paramJSONObject, "singer");
    localSongInfo.jdField_a_of_type_Long = getLong(paramJSONObject, "songId");
    localSongInfo.jdField_a_of_type_JavaLangString = getString(paramJSONObject, "playUrl");
    localSongInfo.jdField_a_of_type_Int = getInt(paramJSONObject, "type");
    localSongInfo.d = getString(paramJSONObject, "cover");
    localSongInfo.jdField_b_of_type_Long = getLong(paramJSONObject, "singerId");
    localSongInfo.f = getString(paramJSONObject, "album");
    localSongInfo.e = getString(paramJSONObject, "detailUrl");
    localSongInfo.c = getString(paramJSONObject, "showId");
    if (localSongInfo.jdField_a_of_type_Long == 0L) {
      localSongInfo.jdField_a_of_type_Long = getFMID(localSongInfo.c);
    }
    return localSongInfo;
  }
  
  public static SongInfo convertFMBgMusic(JSONObject paramJSONObject)
  {
    SongInfo localSongInfo = new SongInfo();
    String str = getString(paramJSONObject, "showID");
    localSongInfo.jdField_b_of_type_JavaLangString = getString(paramJSONObject, "showName");
    localSongInfo.g = "";
    localSongInfo.jdField_a_of_type_Long = getFMID(str);
    localSongInfo.jdField_a_of_type_JavaLangString = getString(paramJSONObject, "showAudioUrl");
    localSongInfo.jdField_a_of_type_Int = 8;
    localSongInfo.d = "";
    localSongInfo.jdField_b_of_type_Long = 0L;
    localSongInfo.f = "";
    localSongInfo.e = "";
    localSongInfo.c = str;
    return localSongInfo;
  }
  
  public static SongInfo convertSongInfo(JSONObject paramJSONObject)
  {
    SongInfo localSongInfo = new SongInfo();
    localSongInfo.jdField_b_of_type_JavaLangString = getString(paramJSONObject, "name");
    localSongInfo.g = getString(paramJSONObject, "singer");
    localSongInfo.jdField_a_of_type_Long = getLong(paramJSONObject, "songId");
    localSongInfo.jdField_a_of_type_JavaLangString = getString(paramJSONObject, "playUrl");
    localSongInfo.jdField_a_of_type_Int = getInt(paramJSONObject, "type");
    localSongInfo.d = getString(paramJSONObject, "cover");
    localSongInfo.jdField_b_of_type_Long = getLong(paramJSONObject, "singerId");
    localSongInfo.f = getString(paramJSONObject, "album");
    localSongInfo.e = getString(paramJSONObject, "detailUrl");
    return localSongInfo;
  }
  
  public static long getFMID(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      long l2 = paramString.hashCode();
      long l1 = l2;
      if (l2 >= 0L) {
        l1 = l2 * -1L - 1L - 2147483648L;
      }
      return l1;
    }
    return 0L;
  }
  
  private static int getInt(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      int i = paramJSONObject.getInt(paramString);
      return i;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("QzoneWebMusicJsPlugin", 2, "getInt " + paramJSONObject.getMessage());
    }
    return 0;
  }
  
  private static long getLong(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      long l = paramJSONObject.getLong(paramString);
      return l;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("QzoneWebMusicJsPlugin", 2, "getLong " + paramJSONObject.getMessage());
    }
    return 0L;
  }
  
  private static String getString(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString(paramString);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("QzoneWebMusicJsPlugin", 2, "getString " + paramJSONObject.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.music.QzoneMusicHelper
 * JD-Core Version:    0.7.0.1
 */