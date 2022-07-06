package com.hewan.namanamahewan

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.hewan.namanamahewan.adapter.AdapterHewan
import com.hewan.namanamahewan.databinding.ActivityMainBinding
import com.hewan.namanamahewan.model.Hewan

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listHewan = ArrayList<Hewan>()
        listHewan.add(Hewan("Ayam",R.drawable.ayam, "Omnivora", "Ovipar", "Darat", "Gallus gallus domesticus"))
        listHewan.add(Hewan("kura-kura",R.drawable.kurakura, "Karnivora", "Ovipar", "Amfibi", "testudies"))
        listHewan.add(Hewan("Kangguru",R.drawable.kangguru, "Herbivora", "Vivipar", "Darat", "Macropus"))
        listHewan.add(Hewan("Ikan",R.drawable.ikan, "Omnivora", "Ovipar", "Air", "Cyprinus rubrofuscus"))
        listHewan.add(Hewan("Harimau",R.drawable.harimau, "Karnivora", "Vivipar", "Darat", "Panthera tigris"))
        listHewan.add(Hewan("Cicak",R.drawable.cicak, "Karnivora", "Ovipar", "Darat", "Cosymbotus platyurus"))
        listHewan.add(Hewan("Udang",R.drawable.dang, "Omnivora", "Ovipar", "Air", "Caridea"))
        listHewan.add(Hewan("Katak",R.drawable.katak, "Karnivora", "Ovipar", "Amfibi", "Anura"))
        listHewan.add(Hewan("Sapi",R.drawable.sapi,"Herbivora", "Vivipar", "Darat", "Bos taurus"))
        listHewan.add(Hewan("Kucing",R.drawable.kucing, "Karnivora", "Vivipar", "Darat", "Felis catus"))

        binding.list.adapter = AdapterHewan(this,listHewan,object : AdapterHewan.OnClickListener {
            override fun detailData(item: Hewan?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_hewan)

                    val image = this.findViewById<ImageView>(R.id.image_hewan)
                    val nama = this.findViewById<TextView>(R.id.txtNamaHewan)

                    val pemakan = this.findViewById<TextView>(R.id.txtPemakan)
                    val berkembangbiak = this.findViewById<TextView>(R.id.txtBerkembangbiak)
                    val tmphidup = this.findViewById<TextView>(R.id.txtTmpHidup)
                    val namalatin = this.findViewById<TextView>(R.id.txtNamaLatin)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    pemakan.text = "${item?.pemakan}"
                    berkembangbiak.text = "${item?.berkembangbiak}"
                    tmphidup.text = "${item?.tmphidup}"
                    namalatin.text = "${item?.namalatin}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }

        })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

        private fun setMode(selectedMode : Int ) {
            when (selectedMode) {
                R.id.myprofile -> {
                    val intent = Intent(this,Profile::class.java)
                    startActivity(intent)
                }
            }
        }

    }

