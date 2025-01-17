package cooperation.comic.emoticon;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;

public class VipComicEmoticonUploadRemoteCmd
  extends RemoteCommand
{
  private boolean a;
  
  public VipComicEmoticonUploadRemoteCmd(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.a = paramBoolean;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = PluginCommunicationHandler.getInstance();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.register(new VipComicEmoticonUploadRemoteCmd("qqcomicemoticonipccmd", false));
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicEmoticonUploadRemoteCmd", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
    }
    do
    {
      do
      {
        return null;
        localObject = (QQAppInterface)localObject;
      } while (!"Remotecall_uploadEmoticon".equals(paramBundle.getString("qqcomicemoticonipccmd")));
      localObject = (VipComicEmoticonUploadManager)((QQAppInterface)localObject).getManager(146);
    } while (localObject == null);
    ((VipComicEmoticonUploadManager)localObject).a(paramBundle, paramOnInvokeFinishLinstener);
    return null;
  }
  
  public boolean isSynchronized()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.comic.emoticon.VipComicEmoticonUploadRemoteCmd
 * JD-Core Version:    0.7.0.1
 */