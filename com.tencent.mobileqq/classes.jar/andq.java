import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Base64;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.GifCoder;
import cooperation.qzone.webviewplugin.QzoneWidgetAIJsPlugin;
import cooperation.qzone.widgetai.QzoneWidgetAIInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class andq
  implements Runnable
{
  public andq(QzoneWidgetAIJsPlugin paramQzoneWidgetAIJsPlugin, String paramString) {}
  
  public void run()
  {
    int k = 0;
    Object localObject1 = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = new JSONObject(this.jdField_a_of_type_JavaLangString);
        Object localObject3 = ((JSONObject)localObject2).getJSONArray("images");
        if (localObject3 == null) {
          return;
        }
        int j = ((JSONObject)localObject2).optInt("delay");
        String str = ((JSONObject)localObject2).optString("content");
        localObject2 = ((JSONObject)localObject2).optString("tagTitle");
        i = 0;
        Object localObject4;
        if (i < ((JSONArray)localObject3).length())
        {
          QLog.d("QzoneWidgetAIJsPlugin", 1, "QzoneWidgetAI.handleShareWidgetAIGifAnimation jsonArrayImages, i = " + i);
          localObject4 = QzoneWidgetAIJsPlugin.a(this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneWidgetAIJsPlugin, ((JSONArray)localObject3).optString(i));
          QLog.d("QzoneWidgetAIJsPlugin", 1, "QzoneWidgetAI.handleShareWidgetAIGifAnimation base64Image = " + (String)localObject4);
          localObject4 = Base64.decode((String)localObject4, 0);
          localObject4 = QzoneWidgetAIJsPlugin.a(this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneWidgetAIJsPlugin, (byte[])localObject4);
          if (localObject4 == null) {
            break label465;
          }
          ((ArrayList)localObject1).add(localObject4);
          break label465;
        }
        if ((this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneWidgetAIJsPlugin.a != null) && (this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneWidgetAIJsPlugin.a.mRuntime != null) && (this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneWidgetAIJsPlugin.a.mRuntime.a() != null) && (this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneWidgetAIJsPlugin.a.mRuntime.a().getExternalFilesDir(Environment.DIRECTORY_PICTURES) != null) && (this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneWidgetAIJsPlugin.a.mRuntime.a().getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath() != null))
        {
          localObject3 = this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneWidgetAIJsPlugin.a.mRuntime.a().getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath().toString() + "/widgetAI.gif";
          if (((ArrayList)localObject1).size() > 0)
          {
            localObject4 = new GifCoder();
            ((GifCoder)localObject4).b(true);
            localObject1 = ((ArrayList)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              boolean bool = ((GifCoder)localObject4).a((Bitmap)((Iterator)localObject1).next(), (String)localObject3, j);
              k = bool;
              if (bool) {
                continue;
              }
              k = bool;
            }
            ((GifCoder)localObject4).b();
            if (k != 0)
            {
              QzoneWidgetAIInterface.publishMood(str, new ArrayList(Arrays.asList(new String[] { localObject3 })), 0, 1, null, 0L, null, (String)localObject2);
              QLog.d("QzoneWidgetAIJsPlugin", 1, "QzoneWidgetAI.handleShareWidgetAIGifAnimation EncodeGif, onSuccess!");
              return;
            }
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("QzoneWidgetAIJsPlugin", 2, QLog.getStackTraceString(localOutOfMemoryError));
        return;
        QLog.d("QzoneWidgetAIJsPlugin", 1, "encode gif failed");
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QzoneWidgetAIJsPlugin", 2, QLog.getStackTraceString(localThrowable));
      }
      return;
      label465:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andq
 * JD-Core Version:    0.7.0.1
 */