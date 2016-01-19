package com.tusiri.biodict;

import android.content.Context;
import android.webkit.WebView;

public class GifWebView extends WebView {

	public GifWebView(Context context, String path) {
	    super(context);
	    loadUrl(path);
	}
	/*public GifWebView(Context context) {
        super(context);
    }
        
    public void setGifAssetPath(String pPath) {
        String baseUrl = pPath.substring(0, pPath.lastIndexOf("/") + 1);
        String fileName = pPath.substring(pPath.lastIndexOf("/")+1);
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("<html><head><style type='text/css'>body{margin:auto auto;text-align:center;} img{width:100%25;} </style>");
        strBuilder.append("</head><body>");
        strBuilder.append("<img src=\"" + fileName + "\" width=\"100%\" /></body></html>");
        String data = strBuilder.toString();

        loadDataWithBaseURL(baseUrl, data, "text/html", "utf-8", null);
    }*/
}
