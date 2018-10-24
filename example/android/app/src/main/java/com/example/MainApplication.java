package com.example;

import android.support.multidex.MultiDexApplication;

import io.invertase.firebase.RNFirebasePackage;

import com.facebook.react.ReactApplication;
import com.reactlibrary.RNChannelIOPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import com.zoyi.channel.react.android.ChannelPackage;
import com.zoyi.channel.plugin.android.ChannelIO;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends MultiDexApplication implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
            new RNChannelIOPackage(),
          new RNFirebasePackage(),
          new RNFirebaseMessagingPackage(),
          new RNFirebaseNotificationsPackage()
          new ChannelPackage()
      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    ChannelIO.initialize(this);
    SoLoader.init(this, /* native exopackage */ false);
  }
}
