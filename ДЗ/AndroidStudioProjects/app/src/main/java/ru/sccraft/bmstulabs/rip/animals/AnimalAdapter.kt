package ru.sccraft.bmstulabs.rip.animals

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class AnimalAdapter(context: Context, private val животные: List<Animal>) : BaseAdapter() {

    private val lInflater: LayoutInflater

    init {
        lInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
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
            вью = lInflater.inflate(android.R.layout.simple_list_item_2, viewGroup, false)
        }
        val животное = получить_животное(i)
        val кличка = вью!!.findViewById<TextView>(android.R.id.text1)
        val вид = вью.findViewById<TextView>(android.R.id.text2)
        кличка.text = животное.animal_name
        вид.text = животное.animal_type
        return вью
    }

    private fun получить_животное(позиция: Int): Animal {
        return getItem(позиция) as Animal
    }
}