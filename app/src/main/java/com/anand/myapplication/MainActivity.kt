package com.anand.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        var json ="{\n" +
                "  \"sort\": [\n" +
                "    {\n" +
                "      \"Mid\": 1,\n" +
                "      \"Tid\": 123456797,\n" +
                "      \"amount\": 12.32,\n" +
                "      \"narration\": 11234684654\n" +
                "    },\n" +
                "    {\n" +
                "      \"Mid\": 2,\n" +
                "      \"Tid\": 123456794,\n" +
                "      \"amount\": 12.32,\n" +
                "      \"narration\": 11234684654\n" +
                "    },\n" +
                "    {\n" +
                "      \"Mid\": 3,\n" +
                "      \"Tid\": 123456791,\n" +
                "      \"amount\": 12.32,\n" +
                "      \"narration\": 11234684654\n" +
                "    },\n" +
                "    {\n" +
                "      \"Mid\": 3,\n" +
                "      \"Tid\": 123456791,\n" +
                "      \"amount\": 12.32,\n" +
                "      \"narration\": 11234684654\n" +
                "    },\n" +
                "    {\n" +
                "      \"Mid\": 1,\n" +
                "      \"Tid\": 123456797,\n" +
                "      \"amount\": 12.32,\n" +
                "      \"narration\": 11234684654\n" +
                "    },\n" +
                "    {\n" +
                "      \"Mid\": 2,\n" +
                "      \"Tid\": 123456794,\n" +
                "      \"amount\": 12.32,\n" +
                "      \"narration\": 11234684654\n" +
                "    },\n" +
                "    {\n" +
                "      \"Mid\": 1,\n" +
                "      \"Tid\": 123456797,\n" +
                "      \"amount\": 12.32,\n" +
                "      \"narration\": 11234684654\n" +
                "    },\n" +
                "    {\n" +
                "      \"Mid\": 3,\n" +
                "      \"Tid\": 123456791,\n" +
                "      \"amount\": 12.32,\n" +
                "      \"narration\": 11234684654\n" +
                "    },\n" +
                "    {\n" +
                "      \"Mid\": 1,\n" +
                "      \"Tid\": 123456795,\n" +
                "      \"amount\": 12.32,\n" +
                "      \"narration\": 11234684654\n" +
                "    },\n" +
                "    {\n" +
                "      \"Mid\": 1,\n" +
                "      \"Tid\": 123456795,\n" +
                "      \"amount\": 12.32,\n" +
                "      \"narration\": 11234684654\n" +
                "    },\n" +
                "    {\n" +
                "      \"Mid\": 3,\n" +
                "      \"Tid\": 123456791,\n" +
                "      \"amount\": 12.32,\n" +
                "      \"narration\": 11234684654\n" +
                "    }\n" +
                "  ]\n" +
                "}\n"


        var pojo =Gson().fromJson(json,DataModel::class.java)



        var list =pojo.sort
        var maplist= HashMap<String,HashMap<String,ArrayList<Pair<String,String>>>>()



        for(i in list)
        {
            if(maplist.containsKey(i.Mid))
            {
                var hashmap=  maplist.get(i.Mid)
                if(hashmap?.containsKey(i.Tid) == true)
                {
                    var list=  hashmap.get(i.Tid)
                    var pair=Pair(i.narration!!,i.amount!!)
                    list?.add(pair)


                }
                else
                {
                    var pair =Pair(i.narration!!,i.amount!!)
                    var list = arrayListOf<Pair<String,String>>()
                    list.add(pair)

                    hashmap?.put(i.Tid!!,list)



                }
            }
            else
            {


                var pair =Pair(i.narration!!,i.amount!!)
                var list = arrayListOf<Pair<String,String>>()
                list.add(pair)
                var hashMap=HashMap<String,ArrayList<Pair<String,String>>>()
                hashMap.put(i.Tid!!,list)
                maplist.put(i.Mid!!,hashMap)
            }


        }

        for((key,value) in maplist) {
            Log.e("bb", key+""+value)
        }




         var mActualData:ArrayList<Pair<String,  HashMap<String, ArrayList<Pair<String, String>>>>> = arrayListOf()


            maplist?.forEach { s, s2 -> mActualData.add(Pair(s, s2)) }
        var adapter=RecyclerAdapter(this,mActualData)

        recycler.apply {
            this.adapter=adapter
        }


    }



}