# BaseToolsLibrary ���õĹ���

<!--[Maven](https://bintray.com/veizhang/maven/BaseTools "Bintray")-->
<!--[Maven Control][bintray][1.1.1]-->
<!--[Bintray][Bintray]-->

<!--[![Bintray](https://img.shields.io/badge/Bintray-v1.1.0-brightgreen.svg)](https://bintray.com/veizhang/maven/BaseTools "Bintray")-->
[![Bintray][icon_Bintray]][Bintray]
[![GitHub issues][icon_issues]][issues]
[![GitHub forks][icon_forks]][forks]
[![GitHub stars][icon_starts]][starts]

<!-- you should configure jcenter repository-->
## ����Android Studio
���jCenterԶ��������module���build.gradle��
```
  dependencies {
    compile 'com.excellence:BaseTools:1.1.1'
  }
```
����ֱ����ӱ���Library����
```
    compile project(':basetoolslibrary')
```

## 1.CommonAdapter

#### gridview��listview��ͨ��������

ʾ����[GridAdapterActivity][GridAdapterActivity]


```ʹ��CommonAdapter
    ����adapter��̳�CommonAdapter
    
    private class AppGridAdapter extends CommonAdapter<ResolveInfo>
    {
        public AppGridAdapter(Context context, List<ResolveInfo> datas, int layoutId)
        {
            super(context, datas, layoutId);
        }

        @Override
        public void convert(ViewHolder viewHolder, ResolveInfo item, int position)
        {
            ImageView iconView = viewHolder.getView(android.R.id.icon);
            iconView.setImageDrawable(item.loadIcon(mPackageManager));
            viewHolder.setText(android.R.id.text1, item.loadLabel(mPackageManager).toString());
        }
    }
```


```ʹ��ViewHolder
    ViewHolder��������
    
    public <T extends View> T getView(int viewId); ���ڻ�ȡItem�ڵ��ӿؼ�������Ϊ�ؼ���id
    public ViewHolder setText(int viewId, int strId); ���������ı��������ؼ�id���ַ���id
    public ViewHolder setBackgroundResource(int viewId, int resId); �������ñ���ͼƬ�������ؼ�id��ͼƬid
    public ViewHolder setImageResource(int viewId, int resId); ��������ImageViewͼƬ��Դ�������ؼ�id��ͼƬid
    public ViewHolder setOnClickListener(int viewId, View.OnClickListener listener); ���ڵ���¼�����
    *
    * 
    * 
    ����չ��������
```


```ˢ��
    ˢ��������
    adapter.notifyNewData(data);
```


## 2.BaseRecyclerAdapter

#### RecyclerView��ͨ��������

ʾ����[RecyclerAdapterActivity][RecyclerAdapterActivity]

```ʹ��CommonAdapter
    ����adapter��̳�BaseRecyclerAdapter

    private class AppRecyclerAdapter extends BaseRecyclerAdapter<ResolveInfo>
    {
        private PackageManager mPackageManager = null;

        public AppRecyclerAdapter(Context context, List<ResolveInfo> datas, int layoutId)
        {
            super(context, datas, layoutId);
            mPackageManager = context.getPackageManager();
        }

        @Override
        public void convert(RecyclerViewHolder viewHolder, ResolveInfo item, int position)
        {
            viewHolder.setText(android.R.id.text1, item.loadLabel(mPackageManager));
            viewHolder.setImageDrawable(android.R.id.icon, item.loadIcon(mPackageManager));
        }

    }
```


```ʹ��RecyclerViewHolder
    RecyclerViewHolder����������ͬViewHolder��������
    *
    *
    *
```


## 3.Utils

#### ͨ�õķ���

> - **Activity��ء�[ActivityUtils.java][ActivityUtils]**
```
startAnotherActivity   : Activity��ת
setActivityWindowAlpha : ����Activity����͸��ֵ
isActivityTopStack     : �ж�Activity�Ƿ���ջ��
getLauncherActivity    : ��ȡĳӦ�����Activity
```

> - **Ӧ����ء�[AppUtils.java][AppUtils]**
```
getInstalledApps       : ��ȡ��װ��ȫ��Ӧ��
getSystemInstalledApps : ��ȡ��װ��ϵͳӦ��
getUserInstalledApps   : ��ȡ��װ�ĵ�����Ӧ��
getPermissionList      : ��ȡĳӦ�õ�����Ȩ��
checkPermission        : ���ĳӦ���Ƿ���ĳȨ��
getAppVersionName      : ��ȡ��ǰӦ�ð汾��
getAppVersionCode      : ��ȡ��ǰӦ�ð汾��
getAppSize             : ��ȡ��ǰӦ�ô�С
getAppTime             : ��ȡ��ǰӦ�ð�װʱ��
getAppPath             : ��ȡ��ǰӦ��·��
getAPKFileSignature    : ��ȡapk�ļ���ǩ��
getPackageSignature    : ��ȡĳ��װӦ�õ�ǩ��
isAppInstalled         : �ж�Ӧ���Ƿ�װ
isAppDebug             : �жϵ�ǰӦ���Ƿ���Debug�汾
```

> - **������ء�[ConvertUtils.java][ConvertUtils]**
```
bytesToHexString : bytesת16����
```

> - **�洢��ء�[DBUtils.java][DBUtils]**
```
setStringSharedPreferences  : �洢String
getStringSharedPreferences  : ��ȡString
setBooleanSharedPreferences : �洢Boolean
getBooleanSharedPreferences : ��ȡBoolean
```

> - **�ֱ�����ء�[DensityUtils.java][DensityUtils]**
```
getDensity      : ��ȡ��ǰ��Ļ�ֱ���
getScaleDensity : ��ȡ��ǰ���ֱַ���
dp2px           : dpתpx
px2dp           : pxתdp
sp2px           : spתpx
px2sp           : pxתsp
```

> - **�жϿ���ء�[EmptyUtils.java][EmptyUtils]**
```
isEmpty    : �ж϶����Ƿ�Ϊ��
isNotEmpty : �ж϶����Ƿ�ǿ�
```

> - **�ļ���ء�[FileUtils.java][FileUtils]**
```
formatFileSize     : ��ʽ���ļ���С
deleteDir          : ɾ��Ŀ¼
deletePostfixFiles : ɾ��Ŀ¼�µ�ĳ��׺�ļ�
deleteFile         : ɾ���ļ�
```

> - **Handler��ء�[HandlerUtils.java][HandlerUtils]**
```
HandlerHolder: ʹ�ñض�
```

> - **Image��ء�[ImageUtils.java][ImageUtils]**
```
drawable2Bitmap : drawableתbitmap
bitmap2Drawable : bitmapתdrawable
view2Bitmap     : viewתBitmap
```

> - **������ء�[NetworkUtils.java][NetworkUtils]**
```
checkNetState : �����������
```

> - **������ʽ��ء�[RegexUtils.java][RegexUtils]**
```
isMobileSimple  : ��֤�ֻ��ţ��򵥣�
isMobileExact   : ��֤�ֻ��ţ���ȷ��
isTel           : ��֤�绰����
isIDCard15      : ��֤���֤����15λ
isIDCard18      : ��֤���֤����18λ
isEmail         : ��֤����
isURL           : ��֤URL
isZh            : ��֤����
isUsername      : ��֤�û���
isDate          : ��֤yyyy-MM-dd��ʽ������У�飬�ѿ���ƽ����
isIP            : ��֤IP��ַ
isMatch         : �ж��Ƿ�ƥ������
getMatches      : ��ȡ����ƥ��Ĳ���
getSplits       : ��ȡ����ƥ�����
getReplaceFirst : �滻����ƥ��ĵ�һ����
getReplaceAll   : �滻��������ƥ��Ĳ���
```

> - **������ء�[ShellUtils.java][ShellUtils]**
```
execProceeBuilderCommand : ִ������
execRuntimeCommand       : ִ������
```

> - **SpannableString��ء�[SpannableStringUtils.java][SpannableStringUtils]**
```
```

> - **ʱ����ء�[TimeUtils.java][TimeUtils]**
```
millisec2String  : ʱ���תʱ���ַ���
string2Date      : ʱ���ַ���תDate����
string2Millisec  : ʱ���ַ���ת����ʱ���
date2String      : Dateתʱ���ַ���
getTimeSpan      : ��ȡ����ʱ���
getNowTimeMillis : ��ȡ��ǰ����ʱ���
getNowTimeDate   : ��ȡ��ǰDateʱ��
getNowTimeString : ��ȡ��ǰʱ���ַ���
getTimeSpanByNow : ��ȡĳʱ���뵱ǰʱ��Ĳ�
isSameDay        : �ж�ʱ���Ƿ���ͬһ��
isToday          : �ж�ʱ���Ƿ��ǽ���
isLeapYear       : �ж��Ƿ�������
getWeek          : ��ȡ���ڼ�
getWeekOfMonth   : ��ȡ�·��еڼ���
getWeekOfYear    : ��ȡ����еĵڼ���
getChineseZodiac : ��ȡ��Ф
getZodiac        : ��ȡ����
```

<br><br>

|            �汾          |                              ����                               |
|------------------------- | -------------------------------------------------------------- |
| [1.1.1][BaseToolsV1.1.1] | Utils����һЩ���õĹ�����:Ӧ�á����ݿ⡢�ֱ��ʡ��ļ���������ʽ�����ʱ��� |
| [1.1.0][BaseToolsV1.1.0] | ����RecyclerView��ͨ���������͸�������������CommonAdapter��ĸ������� |
| [1.0.1][BaseToolsV1.0.1] | ����ListView��GridView��ͨ����������һЩ��������                    |

#### �ο�
> - [�ź���][ZhangHongYang]
> - [�����»�][Blankj]


<!-- ������վ���� -->
[Bintray]:https://bintray.com/veizhang/maven/BaseTools "Bintray"
[issues]:https://github.com/VeiZhang/BaseToolsLibrary/issues
[forks]:https://github.com/VeiZhang/BaseToolsLibrary/network
[starts]:https://github.com/VeiZhang/BaseToolsLibrary/stargazers

<!-- ͼƬ���� -->
[icon_Bintray]:https://img.shields.io/badge/Bintray-v1.1.1-brightgreen.svg
[icon_issues]:https://img.shields.io/github/issues/VeiZhang/BaseToolsLibrary.svg
[icon_forks]:https://img.shields.io/github/forks/VeiZhang/BaseToolsLibrary.svg?style=social
[icon_starts]:https://img.shields.io/github/stars/VeiZhang/BaseToolsLibrary.svg?style=social

<!-- �汾 -->
[BaseToolsV1.0.1]:https://bintray.com/veizhang/maven/BaseTools/1.0.1
[BaseToolsV1.1.0]:https://bintray.com/veizhang/maven/BaseTools/1.1.0
[BaseToolsV1.1.1]:https://bintray.com/veizhang/maven/BaseTools/1.1.1

<!-- �������� -->
[ZhangHongYang]:https://github.com/hongyangAndroid/baseAdapter "ͨ��������"
[Blankj]:https://github.com/Blankj/AndroidUtilCode "���ù�����"

<!-- �������� -->
[GridAdapterActivity]:https://github.com/VeiZhang/BaseToolsLibrary/blob/master/tooldemo/src/main/java/com/excellence/tooldemo/GridAdapterActivity.java
[RecyclerAdapterActivity]:https://github.com/VeiZhang/BaseToolsLibrary/blob/master/tooldemo/src/main/java/com/excellence/tooldemo/RecyclerAdapterActivity.java

[ActivityUtils]:https://github.com/VeiZhang/BaseToolsLibrary/blob/master/basetoolslibrary/src/main/java/com/excellence/basetoolslibrary/utils/ActivityUtils.java
[AppUtils]:https://github.com/VeiZhang/BaseToolsLibrary/blob/master/basetoolslibrary/src/main/java/com/excellence/basetoolslibrary/utils/AppUtils.java
[ConvertUtils]:https://github.com/VeiZhang/BaseToolsLibrary/blob/master/basetoolslibrary/src/main/java/com/excellence/basetoolslibrary/utils/ConvertUtils.java
[DBUtils]:https://github.com/VeiZhang/BaseToolsLibrary/blob/master/basetoolslibrary/src/main/java/com/excellence/basetoolslibrary/utils/DBUtils.java
[DensityUtils]:https://github.com/VeiZhang/BaseToolsLibrary/blob/master/basetoolslibrary/src/main/java/com/excellence/basetoolslibrary/utils/DensityUtils.java
[EmptyUtils]:https://github.com/VeiZhang/BaseToolsLibrary/blob/master/basetoolslibrary/src/main/java/com/excellence/basetoolslibrary/utils/EmptyUtils.java
[FileUtils]:https://github.com/VeiZhang/BaseToolsLibrary/blob/master/basetoolslibrary/src/main/java/com/excellence/basetoolslibrary/utils/FileUtils.java
[HandlerUtils]:https://github.com/VeiZhang/BaseToolsLibrary/blob/master/basetoolslibrary/src/main/java/com/excellence/basetoolslibrary/utils/HandlerUtils.java
[ImageUtils]:https://github.com/VeiZhang/BaseToolsLibrary/blob/master/basetoolslibrary/src/main/java/com/excellence/basetoolslibrary/utils/ImageUtils.java
[NetworkUtils]:https://github.com/VeiZhang/BaseToolsLibrary/blob/master/basetoolslibrary/src/main/java/com/excellence/basetoolslibrary/utils/NetworkUtils.java
[RegexUtils]:https://github.com/VeiZhang/BaseToolsLibrary/blob/master/basetoolslibrary/src/main/java/com/excellence/basetoolslibrary/utils/RegexUtils.java
[ShellUtils]:https://github.com/VeiZhang/BaseToolsLibrary/blob/master/basetoolslibrary/src/main/java/com/excellence/basetoolslibrary/utils/ShellUtils.java
[SpannableStringUtils]:https://github.com/VeiZhang/BaseToolsLibrary/blob/master/basetoolslibrary/src/main/java/com/excellence/basetoolslibrary/utils/SpannableStringUtils.java
[TimeUtils]:https://github.com/VeiZhang/BaseToolsLibrary/blob/master/basetoolslibrary/src/main/java/com/excellence/basetoolslibrary/utils/TimeUtils.java