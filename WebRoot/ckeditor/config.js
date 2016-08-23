/**
 * @license Copyright (c) 2003-2014, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {// Define changes to default configuration here. For example:
	// config.language = 'fr';
	 config.uiColor = '#237DED';
	 config.language = 'zh-cn'; 
	 config.uiColor = '#237DED';
	 config.width = 740; 
	 config.height = 540;
	 //config.skin = 'v2'; 
	 // 窗口拉伸
	 config.resize_enabled = false; 
	 //config.toolbar = "Basic"; 
	 //	config.toolbar = "Full"; 
	  config.toolbar = 
	  [ 
	  ['Bold', 'Italic', 'Underline'], 
	  ['Outdent', 'Indent'], 
	  ['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'], 
	  ['Link', 'Unlink'], 
	  ['Format', 'FontSize'], 
	  ['TextColor', 'BGColor'] ,
	  ['Image']
	  ];
	 config.filebrowserBrowseUrl = 'ckfinder/ckfinder.html',
	 config.filebrowserImageBrowseUrl = 'ckfinder/ckfinder.html?type=Images',
	 config.filebrowserFlashBrowseUrl = 'ckfinder/ckfinder.html?type=Flash',
	 config.filebrowserUploadUrl = 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files',
	 config.filebrowserImageUploadUrl = 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images',
	 config.filebrowserFlashUploadUrl = 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash',
	 config.filebrowserWindowWidth = '1000',
	 config.filebrowserWindowHeight = '700';
};
