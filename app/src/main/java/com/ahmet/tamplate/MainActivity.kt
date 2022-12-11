package com.ahmet.tamplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
//import org.json.JSONObject
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),SearchView.OnQueryTextListener{
    private lateinit var filmlerArrayList:ArrayList<Kategoriler>
    private lateinit var adapter: FilmlerAdapter
    private lateinit var adapter2 : GuncelFilmlerAdapter
    private lateinit var kdi:KategorilerDaoInterface
    private lateinit var ddi:DetaylarDaoInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv.setHasFixedSize(true)
        rv.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        rvGuncel.setHasFixedSize(true)
        rvGuncel.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        kdi = ApiUtils.getKategorilerDaoInterface()
        ddi = ApiUtils.getDetaylarDaoInterface()

       // filmlerArrayList = ArrayList()
       // adapter = FilmlerAdapter(this,filmlerArrayList)

     //   rv.adapter = adapter

        tumKategoriler()
        tumDetaylar()
        toolbar.title = "Arama"
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_arama,menu)

        val item = menu.findItem(R.id.action_ara)
        val searchView  = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        Log.e("onQueryTextSubmit",query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        Log.e("onQueryTextChange",newText)
        return true
    }

    fun tumKategoriler(){
        kdi.tumKategoriler().enqueue(object : Callback<KategorilerCevap>{

            override fun onResponse(
                call: Call<KategorilerCevap>,
                response: Response<KategorilerCevap>
            ) {
                if (response != null) {
                    val liste = response.body()?.kategoriler

                    adapter = FilmlerAdapter(this@MainActivity, liste as ArrayList<Kategoriler>)

                    rv.adapter = adapter
                }
            }

            override fun onFailure(call: Call<KategorilerCevap>, t: Throwable) {

            }
        }



        )
    }

    fun tumDetaylar(){
        ddi.tumDetaylar().enqueue(object : Callback<KategorilerCevap>{

            override fun onResponse(
                call: Call<KategorilerCevap>,
                response: Response<KategorilerCevap>
            ) {
                if (response != null) {
                    val liste = response.body()?.kategoriler

                    adapter2 = GuncelFilmlerAdapter(this@MainActivity, liste as ArrayList<Kategoriler>)

                    rvGuncel.adapter = adapter2
                }
            }

            override fun onFailure(call: Call<KategorilerCevap>, t: Throwable) {

            }
        }



        )
    }


}
