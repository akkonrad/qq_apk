package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.os.Build.VERSION;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.KeyAgreement;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.request.t;

public class EcdhCrypt
{
  public static final String DEFAULT_PUB_KEY = "020b03cf3d99541f29ffec281bebbd4ea211292ac1f53d7128";
  public static final String DEFAULT_SHARE_KEY = "4da0f614fc9f29c2054c77048a6566d7";
  public static final String S_PUB_KEY = "04928D8850673088B343264E0C6BACB8496D697799F37211DEB25BB73906CB089FEA9639B4E0260498B51A992D50813DA8";
  public static final String X509_S_PUB_KEY = "3046301006072A8648CE3D020106052B8104001F03320004928D8850673088B343264E0C6BACB8496D697799F37211DEB25BB73906CB089FEA9639B4E0260498B51A992D50813DA8";
  public static byte[] _c_pri_key = new byte[0];
  public static byte[] _c_pub_key;
  private static byte[] _g_share_key = new byte[0];
  private static boolean initFlg = false;
  public static PrivateKey pkcs8PrivateKey;
  private static boolean userOpenSSLLib = true;
  public static PublicKey x509PublicKey;
  
  static
  {
    _c_pub_key = new byte[0];
  }
  
  public EcdhCrypt(Context paramContext)
  {
    util.loadLibrary("wtecdh", paramContext);
  }
  
  private byte[] calShareKeyByBouncycastle(byte[] paramArrayOfByte)
  {
    Object localObject1 = "3046301006072A8648CE3D020106052B8104001F03320004";
    try
    {
      if (paramArrayOfByte.length < 30) {
        localObject1 = "302E301006072A8648CE3D020106052B8104001F031A00";
      }
      Object localObject2 = util.buf_to_string(paramArrayOfByte);
      localObject1 = constructX509PublicKey((String)localObject1 + (String)localObject2);
      util.LOGI("raw public key " + util.buf_to_string(_c_pub_key), "");
      util.LOGI("pkcs8PrivateKey " + pkcs8PrivateKey.toString(), "");
      localObject2 = KeyAgreement.getInstance("ECDH", "BC");
      ((KeyAgreement)localObject2).init(pkcs8PrivateKey);
      ((KeyAgreement)localObject2).doPhase((Key)localObject1, true);
      localObject1 = ((KeyAgreement)localObject2).generateSecret();
      localObject2 = MD5.toMD5Byte((byte[])localObject1);
      util.LOGI("share key " + util.buf_to_string((byte[])localObject1), "");
      util.LOGI("share key md5 " + util.buf_to_string((byte[])localObject2), "");
      return localObject2;
    }
    catch (ExceptionInInitializerError paramArrayOfByte)
    {
      util.LOGW("create key failed ExceptionInInitializerError, " + paramArrayOfByte.getMessage(), "");
      t.an.attr_api(2459818);
      return null;
    }
    catch (Exception localException)
    {
      util.LOGI("calShareKeyByBouncycastle failed " + pkcs8PrivateKey.toString() + " peer public key " + util.buf_to_string(paramArrayOfByte), "");
      util.printException(localException);
      t.an.attr_api(2459818);
    }
    return null;
  }
  
  private byte[] calShareKeyByOpenSSL(String paramString1, String paramString2, String paramString3)
  {
    util.LOGI("calShareKeyByOpenSSL publickey " + paramString2, "");
    if (GenECDHKeyEx(paramString3, paramString2, paramString1) == 0) {
      return _g_share_key;
    }
    t.an.attr_api(2461268);
    return null;
  }
  
  private PublicKey constructX509PublicKey(String paramString)
  {
    util.LOGI("constructX509PublicKey publickey " + paramString + " at " + t.l(), "");
    return KeyFactory.getInstance("EC", "BC").generatePublic(new X509EncodedKeySpec(util.string_to_buf(paramString)));
  }
  
  private int initShareKeyByBouncycastle()
  {
    try
    {
      Object localObject1 = KeyPairGenerator.getInstance("EC", "BC");
      ((KeyPairGenerator)localObject1).initialize(new ECGenParameterSpec("secp192k1"));
      Object localObject2 = ((KeyPairGenerator)localObject1).genKeyPair();
      localObject1 = ((KeyPair)localObject2).getPublic();
      byte[] arrayOfByte = ((PublicKey)localObject1).getEncoded();
      localObject2 = ((KeyPair)localObject2).getPrivate();
      ((PrivateKey)localObject2).getEncoded();
      PublicKey localPublicKey = constructX509PublicKey("3046301006072A8648CE3D020106052B8104001F03320004928D8850673088B343264E0C6BACB8496D697799F37211DEB25BB73906CB089FEA9639B4E0260498B51A992D50813DA8");
      KeyAgreement localKeyAgreement = KeyAgreement.getInstance("ECDH", "BC");
      localKeyAgreement.init((Key)localObject2);
      localKeyAgreement.doPhase(localPublicKey, true);
      _g_share_key = MD5.toMD5Byte(localKeyAgreement.generateSecret());
      _c_pub_key = new byte[49];
      System.arraycopy(arrayOfByte, 23, _c_pub_key, 0, 49);
      x509PublicKey = (PublicKey)localObject1;
      pkcs8PrivateKey = (PrivateKey)localObject2;
      util.LOGI("initShareKeyByBouncycastle OK", "");
      return 0;
    }
    catch (ExceptionInInitializerError localExceptionInInitializerError)
    {
      util.LOGW("create key pair and shared key failed ExceptionInInitializerError, " + localExceptionInInitializerError.getMessage(), "");
      t.an.attr_api(2368735);
      return -1;
    }
    catch (Exception localException)
    {
      util.LOGI("initShareKeyByBouncycastle failed, ", "");
      util.printException(localException);
      t.an.attr_api(2368735);
    }
    return -2;
  }
  
  private int initShareKeyByOpenSSL()
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    while (GenereateKey() != 0) {
      return -1;
    }
    if ((_c_pub_key == null) || (_c_pub_key.length == 0) || (_c_pri_key == null) || (_c_pri_key.length == 0) || (_g_share_key == null) || (_g_share_key.length == 0))
    {
      util.LOGI("_c_pub_key " + util.buf_to_string(_c_pub_key), "");
      util.LOGI("_c_pri_key " + util.buf_to_string(_c_pri_key), "");
      util.LOGI("_g_share_key " + util.buf_to_string(_g_share_key), "");
      util.LOGI("initShareKeyByOpenSSL generate null key", "");
      return -2;
    }
    util.LOGI("initShareKeyByOpenSSL OK", "");
    return 0;
  }
  
  public native int GenECDHKeyEx(String paramString1, String paramString2, String paramString3);
  
  public int GenereateKey()
  {
    try
    {
      try
      {
        int i = GenECDHKeyEx("04928D8850673088B343264E0C6BACB8496D697799F37211DEB25BB73906CB089FEA9639B4E0260498B51A992D50813DA8", "", "");
        return i;
      }
      finally {}
      return -4;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      util.LOGI("GenereateKey failed " + localUnsatisfiedLinkError.getMessage(), "");
      return -1;
    }
    catch (RuntimeException localRuntimeException)
    {
      util.LOGW("OpenSSL generate key failed, turn another method " + localRuntimeException.getMessage(), "");
      return -2;
    }
    catch (Exception localException)
    {
      util.LOGI("GenereateKey failed " + localException.getMessage(), "");
      return -3;
    }
    catch (Error localError)
    {
      util.LOGI("GenereateKey failed " + localError.getMessage(), "");
    }
  }
  
  public byte[] calShareKeyMd5ByPeerPublicKey(byte[] paramArrayOfByte)
  {
    util.LOGI("userOpenSSLLib " + userOpenSSLLib + " peerRawPublicKey " + util.buf_to_string(paramArrayOfByte) + " at " + t.l(), "");
    if (true == userOpenSSLLib) {
      return calShareKeyByOpenSSL(util.buf_to_string(_c_pri_key), util.buf_to_string(_c_pub_key), util.buf_to_string(paramArrayOfByte));
    }
    return calShareKeyByBouncycastle(paramArrayOfByte);
  }
  
  public byte[] get_c_pub_key()
  {
    return (byte[])_c_pub_key.clone();
  }
  
  public byte[] get_g_share_key()
  {
    return (byte[])_g_share_key.clone();
  }
  
  public int initShareKey()
  {
    if (true == initFlg) {
      return 0;
    }
    initFlg = true;
    if (initShareKeyByOpenSSL() == 0)
    {
      userOpenSSLLib = true;
      return 0;
    }
    if (initShareKeyByBouncycastle() == 0)
    {
      userOpenSSLLib = false;
      return 0;
    }
    return initShareKeyByDefault();
  }
  
  public int initShareKeyByDefault()
  {
    _c_pub_key = util.string_to_buf("020b03cf3d99541f29ffec281bebbd4ea211292ac1f53d7128");
    _g_share_key = util.string_to_buf("4da0f614fc9f29c2054c77048a6566d7");
    util.LOGI("initShareKeyByDefault OK", "");
    return 0;
  }
  
  public void set_c_pri_key(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      _c_pri_key = (byte[])paramArrayOfByte.clone();
      return;
    }
    _c_pri_key = new byte[0];
  }
  
  public void set_c_pub_key(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      _c_pub_key = (byte[])paramArrayOfByte.clone();
      return;
    }
    _c_pub_key = new byte[0];
  }
  
  public void set_g_share_key(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      _g_share_key = (byte[])paramArrayOfByte.clone();
      return;
    }
    _g_share_key = new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.EcdhCrypt
 * JD-Core Version:    0.7.0.1
 */