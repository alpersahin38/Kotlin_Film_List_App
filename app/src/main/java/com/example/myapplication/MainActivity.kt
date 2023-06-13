package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private lateinit var filmlerArrayList:ArrayList<Filmler>
    private lateinit var adapter: FilmlerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val f1 = Filmler(1,"Inception","inception",12.99)
        val f2 = Filmler(2,"Django","django",13.99)
        val f3 = Filmler(3,"The Pianist","thepianist",14.99)
        val f4 = Filmler(4,"The Hateful Eight","thehatefuleight",15.99)
        val f5 = Filmler(5,"Bir Zamanlar Anadoluda","birzamanlaranadoluda",16.99)
        val f6 = Filmler(6,"Interstellar","interstellar",400.99)

        filmlerArrayList = ArrayList<Filmler>()
        filmlerArrayList.add(f1)
        filmlerArrayList.add(f2)
        filmlerArrayList.add(f3)
        filmlerArrayList.add(f4)
        filmlerArrayList.add(f5)
        filmlerArrayList.add(f6)

        adapter = FilmlerAdapter(this,filmlerArrayList)

        binding.rv.adapter = adapter

    }
}