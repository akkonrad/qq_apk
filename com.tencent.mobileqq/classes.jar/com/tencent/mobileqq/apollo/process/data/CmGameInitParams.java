package com.tencent.mobileqq.apollo.process.data;

import java.io.Serializable;

public class CmGameInitParams
  implements Serializable
{
  public static final int GAME_MODE_CHALLENGE = 2;
  public static final int GAME_MODE_INSTANT_PK = 0;
  public static final int GAME_MODE_STANDBY = 4;
  public static final int GAME_MODE_STORE = 1;
  public static final int GAME_MODE_STRANGER = 3;
  public String apolloGameSt;
  public String apolloGameStkey;
  public int apolloStatus;
  public String extInfoFromSvr;
  public int gender;
  public boolean isWhiteUsr;
  public int mActionId;
  public int mAioType;
  public String mChineseName;
  public String mExtraStr;
  public String mFriendUin;
  public int mGameEnter;
  public int mGameId;
  public int mGameMode;
  public String mGameName;
  public String mGameParam;
  public String mGamePath;
  public boolean mIsMaster;
  public int mNetWorkType;
  public int mPort;
  public long mRoomId;
  public int mScreenMode;
  public String mSelfUin;
  public String mServerIp;
  public String mSessionId;
  public int mSessionType;
  public int mSrc;
  public String mVersion;
  public int mViewMode;
  public String openId;
  public String sessionOpenId;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameInitParams
 * JD-Core Version:    0.7.0.1
 */