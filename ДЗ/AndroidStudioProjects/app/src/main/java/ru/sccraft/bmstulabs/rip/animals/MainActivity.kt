package ru.sccraft.bmstulabs.rip.animals

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import ru.sccraft.bmstulabs.rip.animals.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            val intent = Intent(this, AnimalAddActivity::class.java)
            startActivity(intent)
        }

        //////////////////
        получить_данные_из_API()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_update -> {
                получить_данные_из_API()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun получить_данные_из_API() {
        NetworkService.getInstance()
            .jsonApi
            .allAnimals
            .enqueue(object : retrofit2.Callback<List<Animal?>?> {
                override fun onResponse(
                    call: Call<List<Animal?>?>,
                    response: retrofit2.Response<List<Animal?>?>
                ) {
                    val animalList = response.body()
                    val lw = findViewById<ListView>(R.id.listView_animals)
                    if (animalList != null) {
                        Log.i("MainActivity", "Данные из API успешно получены!")
                        val adapter = ArrayAdapter<Animal>(this@MainActivity, android.R.layout.simple_list_item_1, android.R.id.text1, animalList);
                        lw.adapter = adapter
                        lw.setOnItemClickListener { parent, view, position, id ->
                            val intent = Intent(this@MainActivity, AnimalInfoActivity::class.java)
                            if (animalList[position] != null) {
                                intent.putExtra("animal_name", animalList[position]!!.animal_name)
                                intent.putExtra("animal_type", animalList[position]!!.animal_type)
                                intent.putExtra("animal_photo", animalList[position]!!.animal_photo)
                                intent.putExtra("animal_id", animalList[position]!!.id)
                            }
                            startActivity(intent)
                        }
                    }
                    else {
                        //404 - Прокси-сервер выключен //502 - прокси-сервер включён, но API выключен
                        val error_arrayList = ArrayList<String>(1)
                        error_arrayList.add("Не удалось получить данные!")
                        val adapter = ArrayAdapter<String>(this@MainActivity, android.R.layout.simple_list_item_1, android.R.id.text1, error_arrayList)
                        lw.adapter = adapter
                        lw.setOnItemClickListener { parent, view, position, id ->}
                        показать_диалог_ошибки_загрузки()

                    }
                }

                override fun onFailure(call: Call<List<Animal?>?>, t: Throwable) {
                    //Что-то пошло не так…
                    Log.e("MainActivity", "Не удалось получить данные из API")
                    t.printStackTrace()
                    показать_диалог_ошибки_загрузки()
                }
            })
    }

    // When User cilcks on dialog button, call this method
    fun показать_диалог_ошибки_загрузки() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.dialog_fail_download_title)
        builder.setMessage(R.string.dialog_fail_download_text)

        builder.setPositiveButton(R.string.retry) { dialog, id ->
            получить_данные_из_API()
        }

        builder.setNegativeButton(
            android.R.string.cancel) { dialog, id ->
        }

        builder.setNeutralButton(R.string.open_API) {dialog, id->
            val ссылка_на_API = Uri.parse("$API_URL/")
            val открыть_API_в_браузере = Intent(Intent.ACTION_VIEW, ссылка_на_API)
            startActivity(открыть_API_в_браузере)
        }
        builder.show()
    }
}