package com.excellence.basetoolslibrary.utils;

import android.text.TextUtils;

import java.io.File;
import java.text.DecimalFormat;

/**
 * Created by ZhangWei on 2017/1/23.
 */

/**
 * �ļ����
 */
public class FileUtils
{

	public static final long KB = 1024;
	public static final long MB = 1024 * 1024;
	public static final long GB = 1024 * 1024 * 1024;
	public static final long TB = 1024 * 1024 * 1024 * 1024L;
	public static final String DEFAULT_FORMAT_PATTERN = "#.##";

	/**
	 * ��ʽ���ļ���С
	 * <p>�Զ���ʽ������λ��</p>
	 *
	 * @param fileSize �ļ���С
	 * @param pattern ������ʽ
     * @return ת�����ļ���С
     */
	public static String formatFileSize(long fileSize, String pattern)
	{
		DecimalFormat sizeFormat = new DecimalFormat(pattern);
		String unitStr = "Bytes";
		long unit = 1;
		if (fileSize >= TB)
		{
			unitStr = "TB";
			unit = TB;
		}
		else if (fileSize >= GB)
		{
			unitStr = "GB";
			unit = GB;
		}
		else if (fileSize >= MB)
		{
			unitStr = "MB";
			unit = MB;
		}
		else if (fileSize >= KB)
		{
			unitStr = "KB";
			unit = KB;
		}
		return sizeFormat.format((double) fileSize / unit) + unitStr;
	}

	/**
	 * ��ʽ���ļ���С
	 * <p>Ĭ�ϸ�ʽ��������λС��</p>
	 *
	 * @param fileSize �ļ���С
	 * @return ת�����ļ���С
	 */
	public static String formatFileSize(long fileSize)
	{
		return formatFileSize(fileSize, DEFAULT_FORMAT_PATTERN);
	}

	/**
	 * ɾ��Ŀ¼
	 *
	 * @param dir
	 * @return
	 */
	public static boolean deleteDir(File dir)
	{
		if (dir.isDirectory())
		{
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++)
			{
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success)
				{
					return false;
				}
			}
		}
		return dir.delete();
	}

	/**
	 * ɾ��Ŀ¼�µ�ĳ��׺�ļ�
	 *
	 * @param dirPath
	 */
	public static void deletePostfixFiles(String dirPath, String postfix)
	{
		File dir = new File(dirPath);
		if (!dir.exists() || TextUtils.isEmpty(postfix))
			return;
		if (dir.isFile() && dir.getName().endsWith(postfix))
			dir.delete();
		else if (dir.isDirectory())
		{
			File[] files = dir.listFiles();
			for (File file : files)
			{
				if (file.isFile() && file.getName().endsWith(postfix))
					file.delete();
			}
		}
	}

	/**
	 * ɾ���ļ�
	 *
	 * @param filePath
	 */
	public static void deleteFile(String filePath)
	{
		File file = new File(filePath);
		if (file.exists())
			file.delete();
	}
}
