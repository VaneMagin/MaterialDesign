package com.example.ejerciciomaterialdesign

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.ejerciciomaterialdesign.databinding.ActivityScrollingBinding
import com.google.android.material.bottomappbar.BottomAppBar
import java.lang.System.load

class ScrollingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab1.setOnClickListener {
            if (binding.bottomAppBar1.fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER){
                binding.bottomAppBar1.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            } else {
                binding.bottomAppBar1.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
        }

        binding.bottomAppBar1.setNavigationOnClickListener {
            Snackbar.make(binding.root, R.string.message_action_success, Snackbar.LENGTH_LONG).setAnchorView(binding.fab1).show()
        }

        /*ocultar imageview al presionar el boton limpiar (ejecutar)*/
        binding.content.button2.setOnClickListener {
            binding.content.materialcardview1.visibility = View.GONE
        }

        /*Mensaje snackbar al presionar el boton accionar*/
        binding.content.button1.setOnClickListener {
            Snackbar.make(it, R.string.card_accionar, Snackbar.LENGTH_LONG).setAnchorView(binding.fab1)
                /*Creación de un toast dentro del snackbar*/
                .setAction(R.string.card_vamos, {
                    Toast.makeText(this, R.string.card_lista, Toast.LENGTH_LONG).show()
                })
                .show()
        }
        Glide.with(this)
            .load("https://los40es00.epimg.net/los40/imagenes/2020/05/06/musica/1588760681_744966_1588760943_rrss_normal.jpg")
            .into(binding.content.imageview2)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}