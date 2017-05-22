package com.itour.base.util;

import java.util.ResourceBundle;

import org.apache.commons.lang3.math.NumberUtils;

public class RoleConstant {
	/**
	 * 超级管理员常量
	 * @author fred
	 *
	 */
	public static enum SuperAdmin {
		NO(0, "否"), YES(1,"是");
		public int key;
		public String value;
		private SuperAdmin(int key, String value) {
			this.key = key;
			this.value = value;
		}
		public static SuperAdmin get(int key) {
			SuperAdmin[] values = SuperAdmin.values();
			for (SuperAdmin object : values) {
				if (object.key == key) {
					return object;
				}
			}
			return null;
		}
	}

}