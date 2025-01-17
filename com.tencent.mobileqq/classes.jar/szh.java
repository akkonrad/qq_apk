import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class szh
  extends BaseAdapter
{
  RelativeSizeSpan jdField_a_of_type_AndroidTextStyleRelativeSizeSpan = new RelativeSizeSpan(0.62F);
  String jdField_a_of_type_JavaLangString;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  int[] jdField_a_of_type_ArrayOfInt = { 2130842689, 2130842690, 2130842691 };
  String jdField_b_of_type_JavaLangString;
  int[] jdField_b_of_type_ArrayOfInt = { 2130842686, 2130842687, 2130842688 };
  
  public szh(LikeRankingListActivity paramLikeRankingListActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramLikeRankingListActivity.getString(2131438653);
    this.jdField_a_of_type_JavaLangString = paramLikeRankingListActivity.getString(2131438654);
  }
  
  public LikeRankingInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (LikeRankingInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    LikeRankingInfo localLikeRankingInfo1 = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo;
    int i = paramList.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        LikeRankingInfo localLikeRankingInfo2 = (LikeRankingInfo)paramList.get(i);
        if (localLikeRankingInfo2.uin == this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.uin) {
          this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo = localLikeRankingInfo2;
        }
      }
      else
      {
        if ((this.jdField_a_of_type_JavaUtilList.size() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.rankingNum > 3) && (this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.likeCountOfToday > 0)) {
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo);
        }
        if (QLog.isColorLevel()) {
          QLog.i("LikeRankingListActivity", 2, String.format("setList isServer:%s oldRankInfo:%s newRankInfo:%s size:%d", new Object[] { Boolean.valueOf(paramBoolean), localLikeRankingInfo1, this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo, Integer.valueOf(paramList.size()) }));
        }
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        this.jdField_a_of_type_Boolean = false;
        notifyDataSetChanged();
        return;
      }
      i -= 1;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getCount() - 1) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 8;
    int i = 0;
    int k = getItemViewType(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {}
    switch (k)
    {
    default: 
      paramViewGroup = paramView;
      switch (k)
      {
      }
      break;
    }
    LikeRankingInfo localLikeRankingInfo;
    do
    {
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity).inflate(2130970398, null);
      paramView = new szj(this);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370362));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131370363));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131370365));
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131370364));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363387));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370368));
      paramView.d = ((TextView)paramViewGroup.findViewById(2131370367));
      paramView.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131363630);
      paramViewGroup.setTag(paramView);
      break;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity).inflate(2130969103, null);
      paramView = new szi(this);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364983));
      paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131363049));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131365172));
      paramViewGroup.setTag(paramView);
      break;
      localLikeRankingInfo = a(paramInt);
    } while (localLikeRankingInfo == null);
    szj localszj = (szj)paramViewGroup.getTag();
    localszj.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
    String str;
    if ((paramInt == 0) && (localLikeRankingInfo.uin == this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.uin) && ((localLikeRankingInfo.rankingNum > 3) || (localLikeRankingInfo.rankingNum < 1)))
    {
      localszj.jdField_a_of_type_AndroidViewView.setVisibility(0);
      str = String.valueOf(localLikeRankingInfo.uin);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(str);
      if (paramView == null) {
        break label634;
      }
      localszj.jdField_b_of_type_AndroidWidgetTextView.setText(paramView.getFriendNick());
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, str);
      paramView = (View)localObject;
      if (localObject == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(str, 1, true);
        }
        paramView = ImageUtil.a();
      }
      localszj.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
      label462:
      switch (localLikeRankingInfo.rankingNum)
      {
      default: 
        if (localLikeRankingInfo.rankingNum < 1) {
          localszj.jdField_a_of_type_AndroidWidgetTextView.setText("-");
        }
        break;
      }
    }
    for (;;)
    {
      localszj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localszj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      for (;;)
      {
        paramView = new SpannableString(String.format(Locale.CHINA, this.jdField_a_of_type_JavaLangString, new Object[] { Integer.valueOf(localLikeRankingInfo.likeCountOfToday) }));
        paramView.setSpan(this.jdField_a_of_type_AndroidTextStyleRelativeSizeSpan, 0, 1, 33);
        localszj.d.setText(paramView);
        localszj.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_b_of_type_JavaLangString, new Object[] { Integer.valueOf(localLikeRankingInfo.totalLikeCount) }));
        return paramViewGroup;
        localszj.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break;
        label634:
        localszj.jdField_b_of_type_AndroidWidgetTextView.setText(str);
        localszj.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.a());
        break label462;
        localszj.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localLikeRankingInfo.rankingNum));
        localszj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localszj.jdField_b_of_type_AndroidWidgetImageView.setImageResource(this.jdField_b_of_type_ArrayOfInt[(localLikeRankingInfo.rankingNum - 1)]);
        localszj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      localszj.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localLikeRankingInfo.rankingNum));
    }
    paramView = (szi)paramViewGroup.getTag();
    Object localObject = paramView.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 2131436538;
      ((TextView)localObject).setText(paramInt);
      localObject = paramView.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label831;
      }
      paramInt = 0;
      label781:
      ((ProgressBar)localObject).setVisibility(paramInt);
      paramView = paramView.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label837;
      }
      paramInt = j;
      label802:
      paramView.setVisibility(paramInt);
      if (!this.jdField_a_of_type_Boolean) {
        break label842;
      }
    }
    label831:
    label837:
    label842:
    for (paramInt = i;; paramInt = 4)
    {
      paramViewGroup.setVisibility(paramInt);
      return paramViewGroup;
      paramInt = 2131433937;
      break;
      paramInt = 8;
      break label781;
      paramInt = 0;
      break label802;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     szh
 * JD-Core Version:    0.7.0.1
 */