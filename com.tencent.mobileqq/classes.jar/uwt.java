import com.tencent.mobileqq.activity.aio.item.FilePicItemBuilder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;

class uwt
  implements Runnable
{
  uwt(uws paramuws) {}
  
  public void run()
  {
    if ((FileUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath)) || (FileUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strMiddleThumPath))) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemFilePicItemBuilder.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uwt
 * JD-Core Version:    0.7.0.1
 */