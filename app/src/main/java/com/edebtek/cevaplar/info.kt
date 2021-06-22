package com.edebtek.cevaplar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast

class info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_info)
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this@info, "Tekrardan Hoşgeldiniz", Toast.LENGTH_SHORT).show()
        var intent = Intent(this@info, MainActivity::class.java)
        startActivity(intent)
    }
}