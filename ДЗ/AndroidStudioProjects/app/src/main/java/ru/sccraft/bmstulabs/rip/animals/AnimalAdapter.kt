package ru.sccraft.bmstulabs.rip.animals

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class AnimalAdapter(context: Context, private val животные: List<Animal>) : BaseAdapter() {

    private val lInflater: LayoutInflater
    private val c: Context

    init {
        lInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        c = context
    }

    override fun getCount(): Int {
        return животные.size
    }

    override fun getItem(i: Int): Any {
        return животные[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        // используем созданные, но не используемые view
        var вью: View? = view
        if (вью == null) {
            вью = lInflater.inflate(R.layout.item_list_animal, viewGroup, false)
        }
        val животное = получить_животное(i)
        val кличка = вью!!.findViewById<TextView>(R.id.list_animal_name)
        val вид = вью.findViewById<TextView>(R.id.list_animal_type)
        val фото = вью.findViewById<ImageView>(R.id.list_animal_photo)

        кличка.text = животное.animal_name
        вид.text = животное.animal_type
        Glide.with(c).load(животное.animal_photo).into(фото)
        return вью
    }

    private fun получить_животное(позиция: Int): Animal {
        return getItem(позиция) as Animal
    }
}