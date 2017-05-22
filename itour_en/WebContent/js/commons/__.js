;
/**
 * 项目应用函数库. 
 * @author : YaoYiLang
 * @email : redrainyi@gmail.com
 * @version 1.0 α.1
 * <br>
 */
(function() {
	var __ = window.__ || {};
	var vI18nCache = {};
	var vMaskHash = {};
	var vDlgFnCache = {};
	var LOADING_PANEL_ID = 'y-loading-panel';

	window.__ = __ = ({
		id : (function() {
			var idSerial = 0;
			return function() {
				return '__' + (idSerial++);
			}
		})(),
		post : function(url, data, callback) {
			__.ajaxData('post', url, data, callback);
		},
		get : function(url, data, callback) {
			__.ajaxData('get', url, data, callback);
		},
		/**
		 * AJAX请求方法.<br>
		 * @param type 类型
		 * @param url 请求的URL
		 * @param data 传递到后台的数据
		 * @param callback ajax回调函数
		 */
		ajaxData : function(type, url, data, callback, sync) {
			if (typeof (data) === 'function') {
				callback = data;
				data = {};
			}
			var isJsonp = type === 'jsonp';
			if (isJsonp) {
				type = 'get';
			}
			__.mask();
			var request = $.ajax({
				url : url,
				type : type,
				async : !(sync && (sync === 'sync')),
				data : type == 'post' ? JSON.stringify(data) : data,
				contentType : "application/json",
				timeout : 60 * 1000,
				dataType : 'text',
				// dataType : isJsonp ? 'jsonp' : 'json',
				// 'xhrFields': {'withCredentials': true},'crossDomain': true,
				success : function(response, status, xhr) {
					__.unmask();
					var headers = {};
					try {
						// alert(xhr.getAllResponseHeaders());
						var value = xhr.getResponseHeader('@REDIRECT');
					} catch (e) {
					}
					if ($.isFunction(callback)) {
						callback(__.decode(response));
					}
				},
				error : function(result) {
					__.unmask();
				}
			});
		},
		/**
		 * 错误检验.<br>
		 * 如果AJAX出现异常,那么会返回异常对象,否则返回false.
		 * 
		 * @param o 后台返回的对象
		 * @return 如果对象为一个异常则返回true，否则返回false.
		 */
		err : function(o) {
			if (o && o['@failure'] === true) {
				return o;
			}
			return false;
		},
		/**
		 * 将JS对象，序列化为JSON字符串
		 * @param value JS对象
		 * @return 对象的JSON字符串
		 */
		encode : (function() {
			var I = !!{}.hasOwnProperty, _ = function(I) {
				return I < 10 ? "0" + I : I;
			}, A = {
				"\b" : "\\b",
				"\t" : "\\t",
				"\n" : "\\n",
				"\f" : "\\f",
				"\r" : "\\r",
				"\"" : "\\\"",
				"\\" : "\\\\"
			};
			return (function(C) {
				if (typeof C == "undefined" || C === null) {
					return "null";
				} else {
					if (Object.prototype.toString.call(C) === "[object Array]") {
						var B = [ "[" ], G, E, D = C.length, F;
						for (E = 0; E < D; E += 1) {
							F = C[E];
							switch (typeof F) {
							case "undefined":
							case "function":
							case "unknown":
								break;
							default:
								if (G) {
									B.push(",");
								}
								B.push(F === null ? "null" : __.encode(F));
								G = true;
							}
						}
						B.push("]");
						return B.join("");
					} else {
						if ((Object.prototype.toString.call(C) === "[object Date]")) {
							return "\"" + C.getFullYear() + "-" + _(C.getMonth() + 1) + "-" + _(C.getDate()) + "T" + _(C.getHours()) + ":"
									+ _(C.getMinutes()) + ":" + _(C.getSeconds()) + "\"";
						} else {
							if (typeof C == "string") {
								return "\"" + C.replace(/([\x00-\x1f\\"])/g, function(B, _) {
									var I = A[_];
									if (I) {
										return I;
									}
									return '';
								}).replace(/[^\u0000-\u00FF]/g, function($0) {
									return escape($0).replace(/(%u)(\w{4})/gi, "\\u$2")
								}) + "\"";
							} else {
								if (typeof C == "number") {
									return isFinite(C) ? String(C) : "null";
								} else {
									if (typeof C == "boolean") {
										return String(C);
									} else {
										B = [ "{" ], G, E, F;
										for (E in C) {
											if (!I || C.hasOwnProperty(E)) {
												F = C[E];
												if (F === null) {
													continue;
												}
												switch (typeof F) {
												case "undefined":
												case "function":
												case "unknown":
													break;
												default:
													if (G) {
														B.push(",");
													}
													B.push(__.encode(E), ":", __.encode(F));
													G = true;
												}
											}
										}
										B.push("}");
										return B.join("");
									}
								}
							}
						}
					}
				}
			});
		})(),
		/**
		 * 将JSON字符串，反序列化为JS对象
		 * @param json JSON字符串
		 * @return JS对象
		 */
		decode : function(json, unsafe) {
			try {
				return $.parseJSON(json);
			} catch (e) {
				if (unsafe === true) {
					try {
						return eval('(' + json + ')');
					} catch (e) {
					}
				}
			}
			return undefined;
		},
		/**
		 * 转义正则字符
		 */
		encodeReg : function(value) {
			return String(value).replace(/([.*+?^=!:${}()|[\]/\\])/g, '\\$1');
		},
		/**
		 * 转义HTML字符
		 */
		encodeHTML : function(content) {
			return $("<div/>").text(String(content)).html().replace(new RegExp('[\"\'<>&\s]', 'g'), function($0) {
				switch ($0) {
				case '"':
					return '&quot;';
				case "'":
					return '&apos;';
				case '>':
					return '&gt;';
				case '<':
					return '&lt;';
				case ' ':
					return '&nbsp;';
				default:
					return $0;
				}
			});
		},
		setCookie : function(name, value, option) {
			// (document.location.protocol);
			// (document.location.host);
			// (document.location.pathname);
			option = option || {};
			if (value == null) {
				option.expireDays = -1;
			}
			var str = name + '=' + escape(value);
			if (option.expireDays) {
				var date = new Date();
				var ms = option.expireDays * 24 * 3600 * 1000;
				date.setTime(date.getTime() + ms);
				str += '; expires=' + date.toGMTString();
			} else if (option.expireMillisecond) {
				var date = new Date();
				var ms = option.expireMillisecond;
				date.setTime(date.getTime() + ms);
				str += '; expires=' + date.toGMTString();
			}
			if (option.path) {
				str += '; path=' + path;
			}
			if (option.domain) {
				str += '; domain' + domain;
			}
			if (option.secure) {
				str += '; true';
			}
			document.cookie = str;
		},
		getCookie : function(name) {
			var cookieArray = document.cookie.split("; ");
			for (var i = 0; i < cookieArray.length; i++) {
				var arr = cookieArray[i].split("=");
				if (arr[0] == name) {
					return unescape(arr[1]);
				}
			}
			return null;
		},
		parseDate : function(dateString, pattern) {
			try {
				var matchs1 = (pattern || "yyyy-MM-dd").match(/([yMdHsm])(\1*)/g);
				var matchs2 = dateString.match(/(\d)+/g);
				if (matchs1.length == matchs2.length) {
					var $d = new Date(1970, 0, 1);
					for (var i = 0; i < matchs1.length; i++) {
						var $i = parseInt(matchs2[i], 10);
						eval((({
							"y" : "$d.setFullYear($i);",
							"M" : "$d.setMonth($i-1);",
							"d" : "$d.setDate($i);   ",
							"H" : "$d.setHours($i);  ",
							"m" : "$d.setMinutes($i);",
							"s" : "$d.setSeconds($i);"
						}[matchs1[i].charAt(0)]) || "pattern=undefined"));
					}
					return $d;
				}
			} catch (err) {
			}
			return null;
		},
		formatDate : function() {
			var SIGN_RG = /([yMdHsm])(\1*)/g;
			function padding(s, len) {
				var len = len - (s + "").length;
				for (var i = 0; i < len; i++) {
					s = "0" + s;
				}
				return s;
			}
			return function(value, pattern) {
				if (!$.isDate(value)) {
					return '';
				}
				try {
					pattern = pattern || "yyyy-MM-dd";
					return pattern.replace(SIGN_RG, function($0) {
						switch ($0.charAt(0)) {
						case "y":
							return padding(value.getFullYear(), $0.length);
						case "M":
							return padding(value.getMonth() + 1, $0.length);
						case "d":
							return padding(value.getDate(), $0.length);
						case "w":
							return value.getDay() + 1;
						case "H":
							return padding(value.getHours(), $0.length);
						case "m":
							return padding(value.getMinutes(), $0.length);
						case "s":
							return padding(value.getSeconds(), $0.length);
						case "q":
							return Math.floor((this.getMonth() + 3) / 3);
						default:
							return '';
						}
					});
				} catch (err) {
					return '';
				}
			};
		}(),
		/**
		 * 获得最顶层窗口(有访问权限的)
		 * 
		 * @return 有访问权限的最顶层窗口
		 */
		getRootWindow : function() {
			var win = window;
			while (win != win.parent) {
				try {
					var pd = win.parent.document; // 在没权限访问parent中的对象时会出错
					var all = pd.getElementsByTagName('*');
				} catch (ex) {
					return win;
				}
				if (typeof win.parent['__'] === 'undefined') {
					return win;
				}
				win = win.parent;
			}
			return win;
		},
		/**
		 * 国际化字符串
		 * 
		 * @param key 字符串的编码
		 * @return 字符串
		 */
		i18n : function(key, text) {
			var value = vI18nCache[key];
			return $.isEmpty(value, true) ? ($.isEmpty(text, true) ? key : text) : value;
		},
		/**
		 * 国际页面元素
		 */
		i18n_ready : function() {
			$('[data-i18n]').each(function(i, dom) {
				var k = dom.getAttribute('data-i18n');
				if (/^(span)$/i.test(dom.nodeName)) {
					dom.innerHTML = __.i18n(k, dom.innerHTML);
				} else if (/^(input)$/i.test(dom.nodeName) && /^(button)$/i.test(dom.type)) {
					dom.value = __.i18n(k, dom.value);
				} else if (/^(script)$/i.test(dom.nodeName)) {
					/* Ignore */
				} else if (!!dom.nodeName) {
					dom.innerHTML = __.i18n(k, dom.innerHTML);
				} else {
					/* Ignore */
				}
			});
		},
		/**
		 * 注册多语言
		 */
		i18n_register : function(props) {
			if (props) {
				for ( var k in props) {
					vI18nCache[k] = props[k]
				}
			}
		},
		/**
		 * 私有方法，注册多语言
		 */
		'@REGISTER_I18N' : function(props) {
			if (props) {
				for ( var k in props) {
					vI18nCache[k] = props[k]
				}
			}
		},
		/**
		 * 为页面添加蒙版
		 */
		mask : function(key) {
			vMaskHash[key + ''] = true;
			if ($('#' + LOADING_PANEL_ID).length == 0) {
				$('<div id="' + LOADING_PANEL_ID + '_mask" class="x-loading-mask" style="font-size: 30px"></div>'//
						+ '<div id="' + LOADING_PANEL_ID + '"class="x-loading-panel">'//
						+ '	<div class="x-loading-indicator">'//
						+ '		Loading...'//
						+ '	</div>'//
						+ '</div>').appendTo($(document.body));
			}
			if ($('#' + LOADING_PANEL_ID + '_mask').show().length > 0) {
				$('#' + LOADING_PANEL_ID).show();
			}
		},
		/**
		 * 取消页面蒙版
		 */
		unmask : function(key) {
			delete vMaskHash[key + ''];
			if ($('#' + LOADING_PANEL_ID + '_mask').hide().length > 0) {
				$('#' + LOADING_PANEL_ID).hide();
			}
		},
		encodeUrlParams : function(params) {
			var search = [];
			var addFields = function(key, val) {
				if (val == null) {
					return;
				}
				search.push([ encodeURIComponent((key + '').replace(/ /g, '+')), '=', encodeURIComponent((val + '').replace(/ /g, '+')) ].join(''));
			}
			$.each(params, function(key, val) {
				if (val == null) {
					return;
				}
				if ($.isArray(val)) {
					$.each(val, function() {
						addFields(key, this);
					});
				} else {
					addFields(key, val);
				}
			});
			return search.join('&');
		},
		decodeUrlParams : function(search) {
			search = search || location.search;
			var params = {};
			// (remove any leading ? || #)(remove any trailing & || ;)(replace
			// +'s with spaces)(split & || ;)
			jQuery.each(search.replace(/^[?#]/, '').replace(/[;&]$/, '').replace(/[+]/g, ' ').split(/[&;]/), function(i, o) {
				var key = decodeURIComponent(this.split('=')[0] || '');
				var val = decodeURIComponent(this.split('=')[1] || '');
				if (!key) {
					return;
				}
				if ($.isArray(params[key])) {
					params[key].push(val);
				} else if (params[key] != null) {
					params[key] = [ params[key], val ];
				} else {
					params[key] = val;
				}
			});
			return params;
		},
		isDate : function(v) {
			return Object.prototype.toString.call(v) === "[object Date]";
		},
		isRegExp : function(v) {
			return Object.prototype.toString.call(v) === "[object RegExp]";
		},
		isEmpty : function(v, allowBlank) {
			return v === null || v === undefined || (($.isArray(v) && !v.length)) || (!allowBlank ? v === '' : false);
		},
		defer : function(fn, millis) {
			millis = !isNaN(millis) && millis > 0 ? millis : 1;
			return setTimeout(fn, millis);
		},
		download : (function() {
			return function(url, params) {
				var oForm = document.createElement('form'), html = '';
				oForm.style.display = 'none';
				oForm.method = 'post';
				oForm.action = url;
				document.body.appendChild(oForm);
				if (params) {
					for ( var n in params) {
						var v = params[n];
						if (!!v) {
							if ($.isPlainObject(v)) {
								v = __.encode(v);
							} else if ($.isArray(v)) {
								v = __.encode(v);
							}
						}
						html += '<input name="' + __.encodeHTML(n) + '" value="' + __.encodeHTML(v) + '" type="hidden" />\n'
					}
				}
				oForm.innerHTML = html;
				oForm.submit();
				setTimeout(function() {
					document.body.removeChild(oForm);
					oForm = null;
				}, 10 * 1000);
			};
		})()
	});
})();