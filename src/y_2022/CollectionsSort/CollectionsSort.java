package y_2022.CollectionsSort;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import utils.XLog;

public class CollectionsSort {

	public static void main(String[] args) {

		List<Integer> list_01 = Arrays.asList(1, 2, 3, 2, 2, 3, 2, 3, 2, 2, 3, 2, 3, 3, 2, 2, 2, 2, 2, 2, 3, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1);
		List<Integer> list_02 = Arrays.asList(1, 2, 3, 2, 2, 3, 2, 3, 2, 2, 3, 2, 3, 3, 2, 2, 2, 2, 2, 2, 3, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1);

		// first(list_01);
		// first(list_02);

		List<String> dirList = Arrays.asList("System Volume Information", "LOST.DIR", "音乐1", "663663", "Android", "测试",
				"20210526", "2403FW", "4K", "8k", "300首220", "压缩包", "音乐", "音乐2", "Movies", "云存储性能测试", "各个分辨率图片",
				"SetTiming", "WIN_USB_PGTOOL_v2.0.7_V2", "部门培训", "测试图片", "超小图", "带字幕视频", "高清图片", "0923", "测试6666666",
				"1228", "123044", "1217", "图片1", "iwbWhiteBoard", "DCIM", "ceshi", "文档", "0222", "0216", "0216-1",
				"ViiCam", "问题复现的视频和照片66", "music", "Screenshots", "媒体资源", "普通视频", "删除测试", "视频", "图片110", "图片2",
				"iwbToolBar", "LCDtestV2 flicker Oct 22 03", "log apk", ".Spotlight-V100", "0106",
				"[08777-3041] 微信扫码登录后，IWB端无反应，还是显示二维码", "APK", "0111", "Pictures", "音乐1-1", "WhiteBoard", "Sounds",
				"Podcasts", "Ringtones", "Alarms", "Notifications", "Download", "Documents", "Audiobooks",
				"新建文件夹11111111", "01111", "0126", "图片2-1", "AOC_Regualr_LOGO", "复制太慢", "开关机压力测试的apk",
				"Automator_20220107");
		second(dirList);

		List<String> fileList = Arrays.asList("卓依婷 - 走在乡间的小路上.mp3", "8K_0009_3.jpg",
				"2017-01-06_15-52-27_Sony_4K_HDR_Camp.ts", "2019-12-27_13_36_38_crop-1-1.png",
				"2021.01.26_11.06.44.log", "6095cfb941808398fecf7b69702ebad5.apk", "13000X65000.jpg-1.jpg",
				"20178年 冠捷科技 宣传片-中文版.mp4", "20200617-10_31_19.jpg", "BaiduNetdisk_11.3.2.apk", "CheckSum.exe",
				"traces.txt", "CPUZ_10.apk", "dolphins_2000k.3gp", "ES-10053.apk", "FileManager_0414.apk",
				"key_a2_b3_2c_a3_88_cb", "key_18_65_71_f7_ea_97", "key_12_c6_2f_2c_02_79", "dacing.mp4", "pig.mp4",
				"putty.exe", "Screen-20210115-14_58_46.jpg", "sn_13", "sn_14", "sn_19", "SR_20200710-110855.mp4",
				"key_18_65_71_f7_ea_9d", "usb_update 非统一版.bin", "videosubtitle.mp4", "WIN_USB_PGTOOL_v2.0.7_V2.7z",
				"bootanimation.jpg", "WMV-WMV2-WMA8-001-1.wmv", "画质差声画不同步 H.265.mp4", "金海心 - 把耳朵叫醒.mp3", "logusb.txt",
				"key_8e_8b_7c_dd_42_3a", "key_18_65_71_f7_ec_9e", "key_18_65_71_a3_88_c5", "少女时代   1920×1080-1.avi",
				"key_18_65_71_f6_33_b7", "key_18_65_71_20_ea_6e", "bootlogo_90-1.jpg", "key_18_65_71_f7_e8_4f",
				"logcat_0925_1.txt", "logcat_0925.txt", "key_18_65_71_28_f6_ac", "key_18_65_71_a3_88_cb",
				"bootlogo-1.jpg", "key_1a_08_70_28_f6_ac", "阳光电影www.ygdy8.com.哥斯拉大战金刚.2021.1080P.国英双语.中英字幕.mkv",
				"我们星球的科学.2021.BD.1080P.中英双字.mkv", "哆啦A梦：伴我同行2.BD.1080p.国粤日三语中字.mkv", "dolphins_2000k-1.3gp", "key_1",
				"bootlogo.jpg", "金海心 - 把耳朵叫醒-1.mp3", "卓依婷 - 走在乡间的小路上-1.mp3",
				"阳光电影www.ygdy8.com.釜山行2：半岛.HD.1080p.韩语中.mkv", "ES文件管理_10061.apk", "bootlogo_90-1-1.jpg",
				"开机logo动画制作V1.2.pdf", "bootanimation_90.zip", "bootanimation_180.zip", "bootanimation_270.zip",
				"bootlogo_90.jpg", "bootlogo_180.jpg", "bootlogo_270.jpg", "tpvSidebar-release_20210701.apk",
				"tpvSidebar-release_20210701_1951.apk", "desc.txt", "bootanimation.zip", "PhilipsCmsClient_V3.2.35.apk",
				"AocCmsClient_V3.2.35.apk", "TencentMeeting_1410000356_2.16.2.406.publish.exe",
				"usb_update TT02.17.bin", "PD Compatibility Check List Report-20210816.xlsx",
				"usb_update.bin 2051T 2K V02.16", "app-release.apk", "tpvSidebar-debug.apk",
				"usb_update php fighter r2 01.19.bin", "FLV-H.264-MP3-002.flv", "新建文本文档 (3).txt",
				"usb_update长城 02.01.bin", "mac.bin", "usb_update 长城02.02.bin", "CP210x_Windows_Drivers.zip",
				"usb_update德为 05.bin", "usb_updateYQ 02.27.bin", "usb_update.bin长城C4",
				"4K画质测试视频4096x2304 HONEY BEES 96fps IN 4K (ULTRA HD).mp4", "XMA311D2E.img朗国",
				"usb_update.bin T33Z 00.10", "usb_update 2752 01.17.bin", "XMA311D2E.img FB03.10",
				"usb_update.bin_T13F_02.06", "usb_update.bin_regular_R3_00.17",
				"PD Engineering SPEC V1.1 20220222 for 65 75 86T33Z.PPTX", "XMA311D2E.imgD", "XMA311D2E.img FB03.11",
				"XMA311D2E.img", "usb_update fighte R2 02.20.bin", "usb_update C4 02.01.bin", "usb_update.bin");
		// second(fileList);
	}

	private static void second(List<String> list) {
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				Collator collator = Collator.getInstance(Locale.CHINA);
				// return collator.compare(o1, o2);
				return collator.getCollationKey(o1).compareTo(collator.getCollationKey(o2));
			}
		};

		Collections.sort(list, comparator);
		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i);
			XLog.init().debug("i: " + i + "; " + name + "; " + isChinese(name));
		}
	}

	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
			return true;
		}
		return false;
	}

	public static boolean isChinese(String strName) {
		char[] ch = strName.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (isChinese(c)) {
				return true;
			}
		}
		return false;
	}

	private static void first(List<Integer> list) {
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 > o2 ? 1 : -1; // error
				// return o1 == o2 ? 0 : (o1 > o2 ? 1 : -1); // right
			}
		});
		XLog.init().debug(list);
	}

}
