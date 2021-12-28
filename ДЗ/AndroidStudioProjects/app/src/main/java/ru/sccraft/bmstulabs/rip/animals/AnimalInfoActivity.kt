package ru.sccraft.bmstulabs.rip.animals

import android.os.AsyncTask
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException


class AnimalInfoActivity : AppCompatActivity() {

     companion object {
         var animal_name = ""
         var animal_type = ""
         var animal_photo = ""
         var animal_id = 0
     }

    private lateinit var tv_name :TextView
    private lateinit var tv_type :TextView
    private lateinit var img :ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)
        setTitle(getString(R.string.title_activity_animalInfo))
        setupActionBar()

        if (savedInstanceState == null) {
            animal_name = intent.getStringExtra("animal_name")!!
            animal_type = intent.getStringExtra("animal_type")!!
            animal_photo = intent.getStringExtra("animal_photo")!!
            animal_id = intent.getIntExtra("animal_id", 0)
        }

        tv_name = findViewById(R.id.info_animal_name)
        tv_type = findViewById(R.id.info_animal_type)
        img = findViewById(R.id.info_animal_photo)

        tv_name.text = animal_name
        tv_type.text = animal_type
        Glide.with(this).load(animal_photo).into(img)
    }

    private fun setupActionBar() {
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_animal_info, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_delete -> {
                удалить_животное()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun удалить_животное() {
        class Поток : AsyncTask<Void, Void, Int>() {

            override fun doInBackground(vararg params: Void): Int {
                val client = OkHttpClient()
                val builder = Request.Builder()
                    .url("$API_URL/animals/$animal_id/")
                    .delete(
                        RequestBody.create(
                            MediaType.parse("application/json; charset=utf-8"), "{}"
                        )
                    )
                val request = builder.build()
                try {
                    val response = client.newCall(request).execute()
                    val string = response.body()!!.string()
                    // TODO use your response
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                return 0
            }

            override fun onPostExecute(i: Int) {
                super.onPostExecute(i)
                finish()
            }
        }

        val поток = Поток()
        поток.execute()
    }
}