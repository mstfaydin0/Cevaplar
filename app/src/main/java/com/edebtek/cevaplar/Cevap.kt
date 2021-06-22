package com.edebtek.cevaplar

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.concurrent.timerTask

class Cevap : AppCompatActivity() {

    private lateinit var mp: MediaPlayer
    private lateinit var sp: MediaPlayer
    private var totalTime: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_cevap)

        val yeniden = findViewById<Button>(R.id.yeniden)
        val son = findViewById<TextView>(R.id.finish)

        mp = MediaPlayer.create(this,R.raw.paper)
        mp.isLooping = false
        mp.setVolume(0.5f,0.5f)
        totalTime = 2000

        Timer().schedule(timerTask {
            mp.start()
        }, 1000)
        sp = MediaPlayer.create(this,R.raw.papertwo)
        totalTime = sp.duration
        sp.isLooping = false
        sp.start()





        yeniden.setOnClickListener {
            var intent = Intent(this@Cevap, MainActivity::class.java)
            startActivity(intent)
        }


        var stringg: Array<String> = arrayOf(
            "Mutlaka Destek Görecen",
            "Önce Başka Şeyleri Bitir",
            "Bu Kesin Değil",
            "14'a Kadar Say ve Tekrar Sor",
            "Sana Pahalıya Patlayacak",
            "Önce Durumu Değerlendir Sonra Keyfini Çıkar",
            "Endişelenme",
            "Başkalarını İzle",
            "Yaptığın İçin Mutlu Olacaksın",
            "İyi Niyetle Çabalarını Sürdür",
            "Sadece Bekle",
            "Farklı Önerilere Açık Ol",
            "Bekle ve Ne Olacağını Gör",
            "Beklenmedik Şeylerle Karşılaşabilirsin",
            "Boş Yere Para Harcamak Olur",
            "Bin Kere Düşün, Bir Kere Karar Ver",
            "Niçin Olmayacağını Sıralayan Bir Liste Yap",
            "Bu İşleri Karıştıracak",
            "Eski Çözümlerini Bir Yana Bırak",
            "Bu Konuya Dikkatle Yaklaş",
            "Harekete Geçersen Durumu İyileştirebilirsin",
            "Şükretmesini Bil",
            "Hayal Kırıklığına Uğramayacaksın",
            "Başka Seçenekler Ara",
            "Şu An İçin Uygun Olmayabilir",
            "Koşullar Çok Çabuk Değişecektir",
            "Sonunda, Bilmen Gereken Her Şeyi Öğreneceksin",
            "Ya Doğrusunu Yap Ya Da Hiç Yapma",
            "Ciddi Bir Çaba Gerekiyor",
            "Ayrıntılara Dikkat Et",
            "Bu, Başkalarının Senin Hakkındaki Düşüncelerini Etkileyecektir",
            "Gecikmeden Yap",
            "Bu Hiç Unutmayacağın Birşey Olacak",
            "Bana Her Zaman Güvenme",
            "Mutlaka Başarılı Olacaksın",
            "Bu Konuda Sesin Çıksın",
            "Başka Konulara Odaklan",
            "Tek Başına Olmaz",
            "Annene Sor",
            "Devam Et",
            "Beklediğin Cevap Farklı Bir Yoldan Gelebilir",
            "Tek Başına Olma",
            "Sana Söylendiği Gibi Yap!",
            "Alışman Gerekecek",
            "Beklenmedik Şeylerle Karşılaşabilirsin",
            "Sorumluluklarını Yerine Getir",
            "Artık Bu Konuda Yeterince Deneyimin Var",
            "Herkesin Gördüğünü Görmemezlikten Gelme",
            "İşin Keyfini Çıkar",
            "Herşey Senin Elinde",
            "Asla",
            "Doğru Olanı Hissetmen Lazım",
            "Bu Büyük Ölçüde Bir Başka Konuya Bağlı",
            "Sabırlı Ol",
            "Bu İşi Daha Sonra Ele Al",
            "Endişelenme",
            "Başarmak İçin Tüm Gücünle Uğraş",
            "Bu Pek Tavsiye Edilmez",
            "Hiç Denenmemiş Bir Çözüm Düşün",
            "Şu An Daha Fazlasını İsteme",
            "Adımlarını Dikkatli At",
            "Boşuna Zamanını Harcama",
            "İlk Aldığın Karara Güven",
            "Herkesin Gördüğünü Görmezlikten Gelme",
            "Bu İş Senin Elinde Değil",
            "Bundan Emin Olabilirsin",
            "Önyargısız Bir Şekilde Araştır",
            "Yaptığın İçin Pişmanlık Duyacaksın",
            "Hiç Tereddüt Etme",
            "Durum Net Değil",
            "Bu Konuyu Kimseye Açma",
            "Yaptıklarının Sonucu Kalıcı Olacak",
            "Daha İyisi İçin Elinden Geleni Yap",
            "Kendi Koyduğun Engelleri Ortadan Kaldır",
            "Bundan Kuşku Duy",
            "Daha Dikkatle Dinle;O Zaman Anlayacaksın",
            "Aşırıya Kaçma",
            "En İyi Karara Varmak İçin Sakin Olmalısın",
            "Hayır",
            "Yaptığın İçin Mutlu Olacaksın",
            "Şimdiden Olmuş Gibi Davran",
            "Evet",
            "Her Zamankinden Farklı Bir Yol İzle",
            "Evet Ama Zorlama",
            "Belki",
            "Çok İyi Bir Sonuç Elde Edebilirsin",
            "Başka Konulara Odaklan",
            "Çaba Göstermeye Değer",
            "Sürprize Hazır Ol",
            "Acele Etmeden İlerle",
            "Aşılması Gereken Engeller Olacak"
        )
        //val diziBoyutu = stringg.size;
        val ranom = (0..stringg.size).random()
        son.text = stringg[ranom];

        son.animate().apply {
            duration = 1000
            rotationYBy(360f)
        }.withEndAction {

            son.animate().apply {
                duration = 1000
                rotationXBy(3600f)

            }


        }
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this@Cevap, "Tekrardan Hoşgeldiniz", Toast.LENGTH_SHORT).show()
        var intent = Intent(this@Cevap, MainActivity::class.java)
        startActivity(intent)
    }
}