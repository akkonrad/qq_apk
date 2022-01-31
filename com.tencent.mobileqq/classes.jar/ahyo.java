import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfoLoadObserver;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.TemplateParser;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class ahyo
  implements Runnable
{
  public ahyo(PtvTemplateManager paramPtvTemplateManager, File paramFile, boolean paramBoolean, PtvTemplateManager.DoodleInfoLoadObserver paramDoodleInfoLoadObserver, AppInterface paramAppInterface) {}
  
  public void run()
  {
    Object localObject1 = PtvTemplateManager.a(this.jdField_a_of_type_JavaIoFile);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    do
    {
      return;
      localObject1 = PtvTemplateManager.a((String)localObject1);
    } while ((localObject1 == null) || (((PtvTemplateManager.PtvTemplateInfo)localObject1).doodleInfos == null) || (((PtvTemplateManager.PtvTemplateInfo)localObject1).doodleInfos.isEmpty()));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.jdField_d_of_type_JavaUtilArrayList.clear();
    ??? = ((PtvTemplateManager.PtvTemplateInfo)localObject1).doodleInfos.iterator();
    while (((Iterator)???).hasNext())
    {
      Object localObject4 = (PtvTemplateManager.DoodleInfo)((Iterator)???).next();
      if (localObject4 != null)
      {
        ((PtvTemplateManager.DoodleInfo)localObject4).doodleUsable = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a((PtvTemplateManager.DoodleInfo)localObject4, true);
        if ((((PtvTemplateManager.DoodleInfo)localObject4).doodleUsable) && (this.jdField_a_of_type_Boolean))
        {
          localObject4 = PtvTemplateManager.c + ((PtvTemplateManager.DoodleInfo)localObject4).doodleName;
          QQVideoMaterial localQQVideoMaterial = TemplateParser.a((String)localObject4, "params");
          if (localQQVideoMaterial != null)
          {
            localQQVideoMaterial.setDataPath((String)localObject4);
            this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.jdField_d_of_type_JavaUtilArrayList.add(localQQVideoMaterial);
            if (QLog.isDevelopLevel()) {
              QLog.d("Doodle_Strokes_PtvTemplateManager", 4, new Object[] { "initLocalDoodleInfo add DoodleMaterial:", localQQVideoMaterial.getId() });
            }
          }
        }
      }
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.jdField_d_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a = ((PtvTemplateManager.PtvTemplateInfo)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver.a();
      }
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) && (PtvFilterSoLoad.b())) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      PtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahyo
 * JD-Core Version:    0.7.0.1
 */