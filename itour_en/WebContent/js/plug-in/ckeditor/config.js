/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here.
	// For complete reference see:
	// http://docs.ckeditor.com/#!/api/CKEDITOR.config
    //config.plugins = 'about,a11yhelp,basicstyles,bidi,blockquote,clipboard,colorbutton,colordialog,contextmenu,dialogadvtab,div,elementspath,enterkey,entities,filebrowser,find,flash,floatingspace,font,format,forms,horizontalrule,htmlwriter,image,iframe,indentlist,indentblock,justify,language,link,list,liststyle,magicline,maximize,newpage,pagebreak,pastefromword,pastetext,preview,print,removeformat,resize,save,scayt,selectall,showblocks,showborders,smiley,sourcearea,specialchar,stylescombo,tab,table,tabletools,templates,toolbar,undo,wsc,wysiwygarea';
	config.plugins = 'about,a11yhelp,basicstyles,blockquote,clipboard,colorbutton,contextmenu,elementspath,enterkey,entities,filebrowser,floatingspace,format,horizontalrule,htmlwriter,image,indentlist,link,list,magicline,maximize,pastefromword,pastetext,removeformat,resize,scayt,showborders,sourcearea,specialchar,stylescombo,tab,table,tabletools,toolbar,undo,wsc,wysiwygarea';
	// The toolbar groups arrangement, optimized for two toolbar rows.
	config.toolbarGroups = [
		{ name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
		{ name: 'links' },
		{ name: 'insert' },
		{ name: 'forms' },
		{ name: 'tools' },
		{ name: 'document',	   groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'others' },
		'/',
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
		{ name: 'styles' },
		{ name: 'colors' },
		{ name: 'about' }
	];
	/*   config.toolbar_Full = [
              ['Source','-','Save','NewPage','Preview','-','Templates'],
              ['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print','SpellChecker', 'Scayt'],
              ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
              ['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select','Button', 'ImageButton', 'HiddenField'],
               '/',
              ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
               ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
               ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
               ['Link','Unlink','Anchor'],
              ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
              '/',
                ['Styles','Format','Font','FontSize'],
               ['TextColor','BGColor']
            ];*/
	// 编辑器样式，有三种：'kama'（默认）、'office2003'、'v2'
  //  config.skin = 'v2';
	// 背景颜色
  //  config.uiColor = '#FFF';
    //工具栏（基础'Basic'、全能'Full'、自定义）plugins/toolbar/plugin.js
    config.toolbar = 'Basic';
    config.toolbar = 'Full';
	// Remove some buttons provided by the standard plugins, which are
	// not needed in the Standard(s) toolbar.
	config.removeButtons = 'Underline,Subscript,Superscript';

	// Set the most common block elements.
	config.format_tags = 'p;h1;h2;h3;pre';
	config.colorButton_colors = '000,800000,8B4513,2F4F4F,008080,000080,4B0082,696969,B22222,A52A2A,DAA520,006400,40E0D0,0000CD,800080,808080,F00,FF8C00,FFD700,008000,0FF,00F,EE82EE,A9A9A9,FFA07A,FFA500,FFFF00,00FF00,AFEEEE,ADD8E6,DDA0DD,D3D3D3,FFF0F5,FAEBD7,FFFFE0,F0FFF0,F0FFFF,F0F8FF,E6E6FA,FFF';
	// Simplify the dialog windows.
	config.removeDialogTabs = 'image:advanced;link:advanced';
	//设置字体大小时 使用的式样 plugins/font/plugin.js
	config.fontSize_style =
	    {
	        element   : 'span',
	        styles   : { 'font-size' : '#(size)' },
	        overrides : [ { element : 'font', attributes : { 'size' : null } } ]
	    };
	//字体默认大小 plugins/font/plugin.js
	config.fontSize_defaultLabel = '12px';
	config.extraPlugins = 'font';
	config.font_colors = '000,800000,8B4513,2F4F4F,008080,000080,4B0082,696969,B22222,A52A2A,DAA520,006400,40E0D0,0000CD,800080,808080,F00,FF8C00,FFD700,008000,0FF,00F,EE82EE,A9A9A9,FFA07A,FFA500,FFFF00,00FF00,AFEEEE,ADD8E6,DDA0DD,D3D3D3,FFF0F5,FAEBD7,FFFFE0,F0FFF0,F0FFFF,F0F8FF,E6E6FA,FFF';
	//字体编辑时可选的字体大小 plugins/font/plugin.js
	config.FontSizes = '初号/56px;小初/48px;一号/34px;32px/小一;29px/二号;24px/小二;21px/三号;20px/小三;18px/四号;16px/小四;14px/五号;12px/小五;10px/六号;小六/8px' ;    //设置字体大小时 使用的式样
	config.fontSize_sizes ='8/8px;9/9px;10/10px;11/11px;12/12px;14/14px;16/16px;18/18px;20/20px;22/22px;24/24px;26/26px;28/28px;36/36px;48/48px;72/72px';
	 config.font_names = '宋体/SimSun;新宋体/NSimSun;仿宋/FangSong;楷体/KaiTi;仿宋_GB2312/FangSong_GB2312;'+  
     '楷体_GB2312/KaiTi_GB2312;黑体/SimHei;华文细黑/STXihei;华文楷体/STKaiti;华文宋体/STSong;华文中宋/STZhongsong;'+  
     '华文仿宋/STFangsong;华文彩云/STCaiyun;华文琥珀/STHupo;华文隶书/STLiti;华文行楷/STXingkai;华文新魏/STXinwei;'+  
     '方正舒体/FZShuTi;方正姚体/FZYaoti;细明体/MingLiU;新细明体/PMingLiU;微软雅黑/Microsoft YaHei;微软正黑/Microsoft JhengHei;'+  
     'Arial Black/Arial Black;'+ config.font_names;
	 
};
