package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aoak;
import aoal;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.qq.im.capture.predownload.QIMPredownManager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.BaseFaceListAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.LocationFaceAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.NormalFaceAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import java.util.List;

public class FaceListPage
  extends RelativeLayout
  implements View.OnClickListener
{
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IFaceSelectedListener jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener;
  private FaceListPage.FacePackagePageEventListener jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener;
  private FacePackage jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage;
  private BaseFaceListAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter;
  private InformationFaceAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterInformationFaceAdapter;
  private LocationFaceAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter;
  private NormalFaceAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, IFaceSelectedListener paramIFaceSelectedListener, FaceListPage.FacePackagePageEventListener paramFacePackagePageEventListener)
  {
    super(paramContext);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener = paramFacePackagePageEventListener;
    this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener = paramIFaceSelectedListener;
    e();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    SLog.b("FaceListPage", "FacePackage is InformationFacePackage");
    if (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage instanceof InfomationFacePackage)) {
      return;
    }
    if (!((InfomationFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(0);
    this.d.setVisibility(4);
  }
  
  private void b(FacePackage paramFacePackage)
  {
    if ((paramFacePackage instanceof NormalFacePackage))
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter == null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter = new NormalFaceAdapter(super.getContext());
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter != null)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.a(this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.a(paramFacePackage);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter);
      }
      return;
      if ((paramFacePackage instanceof LocationFacePackage))
      {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter == null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter = new LocationFaceAdapter(super.getContext());
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter;
      }
      else if ((paramFacePackage instanceof InfomationFacePackage))
      {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterInformationFaceAdapter == null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterInformationFaceAdapter = new InformationFaceAdapter(super.getContext());
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterInformationFaceAdapter;
      }
      else
      {
        SLog.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void c()
  {
    SLog.b("FaceListPage", "FacePackage is LocationFacePackage");
    if (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage instanceof LocationFacePackage)) {
      return;
    }
    LocationFacePackage localLocationFacePackage = (LocationFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage;
    if (!localLocationFacePackage.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.notifyDataSetChanged();
      return;
    }
    if (localLocationFacePackage.b)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      this.c.setVisibility(4);
      this.d.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(0);
    this.d.setVisibility(4);
  }
  
  private void d()
  {
    SLog.b("FaceListPage", "FacePackage is NormalFacePackage " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage);
    ThreadManager.postImmediately(new aoal(this), null, true);
  }
  
  private void e()
  {
    this.jdField_b_of_type_Int = AIOUtils.a(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2130970718, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131371709));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131371710));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131363005));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131371707));
    View localView = new View(getContext());
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, DisplayUtil.a(getContext(), 10.0F)));
    localView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(localView);
    localView = new View(getContext());
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, DisplayUtil.a(getContext(), 36.0F)));
    localView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetListView.addFooterView(localView);
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131371708));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131371721));
    this.c = ((LinearLayout)super.findViewById(2131371722));
    this.d = ((LinearLayout)super.findViewById(2131371723));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363518));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage == null) {
      SLog.d("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a())) {
            break;
          }
          localObject = (LocationFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage;
        } while ((!((LocationFacePackage)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((LocationFacePackage)localObject).b) || (this.jdField_a_of_type_Boolean));
        if (NetworkUtil.g(super.getContext())) {
          StoryReportor.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_a_of_type_Boolean = true;
          return;
          StoryReportor.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a()));
      localObject = (NormalFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage;
      ((QIMPredownManager)QIMManager.a(14)).a(((NormalFacePackage)localObject).jdField_a_of_type_JavaLangString, 4);
    } while ((!NetworkUtil.a(getContext())) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener == null) || (((NormalFacePackage)localObject).b) || (!((NormalFacePackage)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    SLog.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener.a(((NormalFacePackage)localObject).jdField_a_of_type_JavaLangString);
    StoryReportor.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(FacePackage paramFacePackage)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new aoak(this, paramFacePackage));
    }
    do
    {
      return;
      if (paramFacePackage == null) {
        break;
      }
      SLog.b("FaceListPage", "onChange,FacePkgInfo:" + paramFacePackage.toString());
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage == null) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a().equals(paramFacePackage.a()))) {
        b(paramFacePackage);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage = paramFacePackage;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a()))
      {
        d();
        return;
      }
      if ("LocationFacePackage".equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a()))
      {
        c();
        return;
      }
    } while (!"InformationFacePackage".equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a()));
    b();
    return;
    SLog.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage = null;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.a(null);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
  }
  
  public void a(String paramString)
  {
    int k = 0;
    FacePackage localFacePackage = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage;
    int j = k;
    int m;
    int i;
    if (localFacePackage != null)
    {
      m = localFacePackage.a();
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i < localFacePackage.b())
      {
        String str = localFacePackage.a(i);
        SLog.b("FaceListPage", "selectByName : " + paramString + str);
        if ((str != null) && (str.contains(paramString))) {
          j = i / m;
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetListView.setSelection(j);
        return;
      }
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidWidgetTextView) {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener != null)
      {
        ((QIMPredownManager)QIMManager.a(14)).a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.jdField_a_of_type_JavaLangString, 4);
        if (((NormalFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).b) {
          break label105;
        }
        SLog.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidWidgetTextView.setText("正在下载");
      }
    }
    label105:
    while ((paramView != this.c) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener == null))
    {
      return;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(4);
    this.d.setVisibility(0);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */