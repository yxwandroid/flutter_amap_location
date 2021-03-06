package com.jzoom.amaplocation;

import android.content.Context;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class MyMapViewFactory extends PlatformViewFactory {
    private  BinaryMessenger messenger;
    private  AtomicInteger mActivityState;
    private  PluginRegistry.Registrar mPluginRegistrar;

    public MyMapViewFactory(AtomicInteger state, PluginRegistry.Registrar registrar) {
        super(StandardMessageCodec.INSTANCE);
        mActivityState = state;
        mPluginRegistrar = registrar;
    }
//    public MyMapViewFactory(BinaryMessenger messenger) {
//        super(StandardMessageCodec.INSTANCE);
//        this.messenger = messenger;
//    }

    @SuppressWarnings("unchecked")
    @Override
    public PlatformView create(Context context, int id, Object args) {
        Map<String, Object> params = (Map<String, Object>) args;
        return new MyMapView(context,mActivityState,mPluginRegistrar,id,params);
//        return new MyMapView(context, messenger, id, params);
    }

}