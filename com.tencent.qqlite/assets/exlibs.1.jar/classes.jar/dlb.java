import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class dlb
  implements Runnable
{
  public dlb(QfileLocalFilePicTabView paramQfileLocalFilePicTabView) {}
  
  public void run()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("已下载图片", new ArrayList());
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)localIterator.next();
      String str = localFileInfo.a();
      if ((str != null) && (str.length() != 0))
      {
        localObject = str;
        if (!str.equalsIgnoreCase("QQfile_recv")) {}
      }
      else
      {
        localObject = "已下载图片";
      }
      if (!localLinkedHashMap.containsKey(localObject)) {
        localLinkedHashMap.put(localObject, new ArrayList());
      }
      ((List)localLinkedHashMap.get(localObject)).add(localFileInfo);
    }
    Object localObject = localLinkedHashMap.keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((List)localLinkedHashMap.get((String)((Iterator)localObject).next())).size() == 0) {
        ((Iterator)localObject).remove();
      }
    }
    QfileLocalFilePicTabView.a(this.a, new dlc(this, localLinkedHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dlb
 * JD-Core Version:    0.7.0.1
 */