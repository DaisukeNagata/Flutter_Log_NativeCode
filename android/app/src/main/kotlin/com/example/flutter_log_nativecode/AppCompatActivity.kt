package com.example.flutter_log_nativecode

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import io.flutter.embedding.engine.FlutterEngine
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

class AppCompatActivity() : AppCompatActivity() {

    private var battery_info: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.appcompat_activity)

        val textView1: TextView = findViewById(R.id.battery_info)
        val intentFilter1 = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val intent1: Intent = getBaseContext().registerReceiver(null, intentFilter1)!!

        battery_info = ""
        //残量を取得
        val level: Int = intent1.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        battery_info += "残量$level%\n"
        //接続状態
        val plugged: Int = intent1.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
        battery_info += """
            ${plug(plugged)}
            
            """.trimIndent()
        //健康状態を取得
        val health: Int = intent1.getIntExtra(BatteryManager.EXTRA_HEALTH, -1)
        battery_info += """
            ${health(health)}
            
            """.trimIndent()
        //ステータスを取得
        val statas: Int = intent1.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
        battery_info += """
            ${stat(statas)}
            
            """.trimIndent()
        //温度を取得
        val ondo: Int = intent1.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1)
        battery_info += (ondo / 10).toString() + "℃\n"
        //電圧を取得
        val voltage: Int = intent1.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1)
        battery_info += (voltage / 1000).toString() + "V\n"

        //結果レポートの出力
        textView1.setText(battery_info)
    }

    //バッテリーの健康状態を返す関数
    private fun health(h: Int): String {
        var return_health = ""
        when (h) {
            BatteryManager.BATTERY_HEALTH_COLD -> return_health = "低温…"
            BatteryManager.BATTERY_HEALTH_DEAD -> return_health = "故障…"
            BatteryManager.BATTERY_HEALTH_GOOD -> return_health = "良好"
            BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> return_health = "電圧オーバー"
            BatteryManager.BATTERY_HEALTH_OVERHEAT -> return_health = "オーバーヒート"
            BatteryManager.BATTERY_HEALTH_UNKNOWN -> return_health = "状態不明"
            BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> return_health = "未確認エラー"
        }
        //バッテリーの健康状態を返す
        return return_health
    }

    //接続状態を返す関数
    private fun plug(p: Int): String {
        var return_plug = ""
        return_plug = when (p) {
            BatteryManager.BATTERY_PLUGGED_AC -> "AC接続"
            BatteryManager.BATTERY_PLUGGED_USB -> "USB接続"
            BatteryManager.BATTERY_PLUGGED_WIRELESS -> "ワイヤレス接続"
            else -> "未接続"
        }
        //接続状態を返す
        return return_plug
    }

    //充電状態を返す関数
    private fun stat(s: Int): String {
        var return_status = ""
        when (s) {
            BatteryManager.BATTERY_STATUS_CHARGING -> return_status = "充電中"
            BatteryManager.BATTERY_STATUS_FULL -> return_status = "充電完了"
            BatteryManager.BATTERY_STATUS_DISCHARGING -> return_status = "放電"
            BatteryManager.BATTERY_STATUS_NOT_CHARGING -> return_status = "未充電"
            BatteryManager.BATTERY_STATUS_UNKNOWN -> return_status = "状態不明"
        }
        //充電ステータスを返す
        return return_status
    }
}