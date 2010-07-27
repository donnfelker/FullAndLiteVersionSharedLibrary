package com.example.foolibrary;

import android.app.Application;
import android.util.Log;

public class FooLibraryApplication extends Application {
	public boolean isLiteVersion() {
		Log.d("FooLibrary", getPackageName());
		return getPackageName().toLowerCase().contains("lite"); 
	}
}
