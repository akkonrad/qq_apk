import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.troop.model.TroopStorySingleVideoSynchronizer;
import java.util.Collections;

public class ooa
  implements Runnable
{
  public ooa(TroopStorySingleVideoSynchronizer paramTroopStorySingleVideoSynchronizer, StoryVideoItem paramStoryVideoItem) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTroopModelTroopStorySingleVideoSynchronizer.a(Collections.singletonList(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ooa
 * JD-Core Version:    0.7.0.1
 */