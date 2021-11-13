package com.example.flutter_log_nativecode

import android.content.Intent
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant


class MainActivity: FlutterActivity() {
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        GeneratedPluginRegistrant.registerWith(flutterEngine)
        setAndroidChannel(flutterEngine)
    }

    private fun setAndroidChannel(flutterEngine: FlutterEngine) {
        var channel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "hello_code")
        channel.setMethodCallHandler { methodCall: MethodCall, result: MethodChannel.Result ->
            if (methodCall.method == "getData") {
                var intent = Intent(this, AppCompatActivity::class.java)
                result.success("AppCompatActivity")
                startActivity(intent)
            }
            else {
                result.notImplemented()
            }
        }
    }
}
