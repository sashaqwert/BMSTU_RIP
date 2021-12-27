package ru.sccraft.bmstulabs.rip.animals

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnimalAddActivity : AppCompatActivity() {

    private var кличка_животного :EditText? = null
    private var вид_животного :EditText? = null
    private var фото_животного :EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_add)
        setTitle(R.string.activity_animal_add)

        кличка_животного = findViewById(R.id.editText_animal_name)
        вид_животного = findViewById(R.id.editText_animal_type)
        фото_животного = findViewById(R.id.editText_animal_photo)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_animal_add, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_save -> {
                ServiceBuilder.buildService(POST_RestApi::class.java)
                addNewAnimal()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    //Отправка POST на сервер
    private fun addNewAnimal() {
        val apiService = RestApiService()
        val animal = Animal()
        animal.id = 0
        animal.animal_name = кличка_животного!!.text.toString()
        animal.animal_type = вид_животного!!.text.toString()
        animal.animal_photo = фото_животного!!.text.toString()

        apiService.addUser(animal) {
            if (it?.id != null) {
                //Завершаеи Activity без проверки полученного объекта
                finish()
            } else {
                Log.e("AnimalAddActivity", getString(R.string.fail_add_animal))
                Toast.makeText(applicationContext, R.string.fail_add_animal, Toast.LENGTH_LONG).show()
            }
        }
    }

    /////////////////////////

    private object ServiceBuilder {
        private val client = OkHttpClient.Builder().build()

        private val retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        fun<T> buildService(service: Class<T>): T{
            return retrofit.create(service)
        }
    }

    ///////////////

    private class RestApiService {
        fun addUser(userData: Animal, onResult: (Animal?) -> Unit){
            val retrofit = ServiceBuilder.buildService(POST_RestApi::class.java)
            retrofit.addAnimal(userData).enqueue(
                object : Callback<Animal> {
                    override fun onFailure(call: Call<Animal>, t: Throwable) {
                        onResult(null)
                    }
                    override fun onResponse(call: Call<Animal>, response: Response<Animal>) {
                        val addedAnimal = response.body()
                        onResult(addedAnimal)
                    }
                }
            )
        }
    }
}