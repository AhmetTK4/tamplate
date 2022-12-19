package com.ahmet.tamplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_detay.*
import kotlinx.android.synthetic.main.activity_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchActivity : AppCompatActivity() , SearchView.OnQueryTextListener{
    private lateinit var filmlerArrayList:ArrayList<Kategoriler>
    private lateinit var adapter4 : SearchAdapter
    private lateinit var adi : AramaDaoInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        rvArama.setHasFixedSize(true)

        rvArama.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        adi = ApiUtils.getAramaDaoInterface()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_arama,menu)

        val item = menu?.findItem(R.id.action_ara)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        tumAramalar(query)
        Log.e("Gönderilen arama",query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        tumAramalar(newText)
        Log.e("Harf girdikçe",newText)
        return true
    }

    fun tumAramalar(aramaKelime:String){

        val film = intent.getSerializableExtra("filmNesne") as Kategoriler


        adi.tumAramalar().enqueue(object : Callback<KategorilerCevap> {

            override fun onResponse(
                call: Call<KategorilerCevap>,
                response: Response<KategorilerCevap>
            ) {
                if (response != null) {
                    val liste = response.body()?.kategoriler

                    adapter4 = SearchAdapter(this@SearchActivity, liste as ArrayList<Kategoriler>)

                    rvBenzer.adapter = adapter4
                }
            }

            override fun onFailure(call: Call<KategorilerCevap>, t: Throwable) {

            }
        }



        )
    }
}