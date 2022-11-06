package com.yusud.kullaniciadisaklama

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences
    var alinanKullaniciAdi : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SharedPreferences

        sharedPreferences = this.getSharedPreferences("com.yusud.kullaniciadisaklama", Context.MODE_PRIVATE)
        alinanKullaniciAdi = sharedPreferences.getString("kullaniciadi","")

        if(alinanKullaniciAdi != null){
            textView.text = "Kaydedilen Kullanıcılar: ${alinanKullaniciAdi}"
        }

    }

    fun kaydet(view : View){
        val kullaniciAdi = editText.text.toString()
        if(kullaniciAdi == ""){
            Toast.makeText(this,"Lütfen bir değer giriniz!",Toast.LENGTH_LONG).show()
        }else{
            sharedPreferences.edit().putString("kullaniciadi",kullaniciAdi).apply()
            textView.text = "Kaydedilen Kullanıcılar: ${kullaniciAdi}"
        }
    }

    fun sil(view : View){
        alinanKullaniciAdi = sharedPreferences.getString("kullaniciadi","")
        if(alinanKullaniciAdi != null){
            textView.text = "Kaydedilen Kullanıcılar: "
            sharedPreferences.edit().remove("kullaniciadi").apply()
        }
    }
}