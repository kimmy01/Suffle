package com.example.suffle.ui.Feed

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.suffle.R
import kotlinx.android.synthetic.main.activity_writing_review1.*

class WritingReviewActivity1 : AppCompatActivity() {

    var storelist = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_review1)

        var stores:ArrayList<String> = arrayListOf("lalabread", "ddamicoffee", "breadspot", "eslowcoffee")

        val search = findViewById<EditText>(R.id.editText_writingReview1)
        val listView = findViewById<ListView>(R.id.listView_writingReview_1)

        storelist = stores
//        var adapter: ArrayAdapter<String> = ArrayAdapter(
//            this, android.R.layout.simple_list_item_1, stores)
//        listView.adapter = adapter

        var adapter2 = WritingReview1ListViewAdapter(this, stores)
        listView.adapter = adapter2

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as String
            val intent = Intent(this, WritingReviewActivity2::class.java)
            intent.putExtra("storeName", selectItem)
            startActivity(intent)
        }

        search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val searching = s.toString()
                (listView.getAdapter() as WritingReview1ListViewAdapter).getFilter()?.filter(searching)
            }
        })

        //backbutton
        imageView_writingReview1_before.setOnClickListener { onBackPressed() }

    }

    public class WritingReview1ListViewAdapter(context: Context, stores: ArrayList<String>) : BaseAdapter(),
        Filterable {

        var context = context
        var storesName = stores //원본
        var filteredStoresName: ArrayList<String> = storesName //검색시

        var storeFilter: Filter? = null //스토어 필터

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view: View = LayoutInflater.from(context).inflate(R.layout.writingreview1_item, null)

            var storeName = view.findViewById<TextView>(R.id.textView_writingReview1item_1)
            storeName.text = filteredStoresName[position]

            var localName = view.findViewById<TextView>(R.id.textView_writingReview1item_2)
            localName.text = "공릉점"

            return view

//            val layoutInflater = LayoutInflater.from(mContext)
////            val items = layoutInflater.inflate(R.layout.writingreview1_item, viewGroup, false)
////
//////            val imageview = items.findViewById<ImageView>(R.id.icon_writingreview1item)
//////            imageview.setImageDrawable(stores.get(position))
////            val textview1 = items.findViewById<TextView>(R.id.textView_writingReview1item_1)
////            textview1.text = stores.get(position)
////            val textview2 = items.findViewById<TextView>(R.id.textView_writingReview1item_2)
////            textview2.text = "공릉점"
////
////            return items
        }

        override fun getFilter(): Filter {
            if(storeFilter == null){
                storeFilter = StoreFilter()
            }
            return storeFilter as Filter
        }

        inner class StoreFilter() : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                var result : FilterResults = FilterResults()

                if(constraint == null || constraint.length == 0){
                    result.values = storesName
                    result.count = storesName.size
                }else{
                    var itemList : ArrayList<String> = ArrayList<String>()

                    for(item:String in storesName){
                        if(item.toUpperCase().contains(constraint.toString().toUpperCase())){
                            itemList.add(item)
                        }
                    }
                    result.values = itemList
                    result.count = itemList.size

                    storesName = itemList
                }
                return result
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredStoresName = results?.values as ArrayList<String>

                if(results.count > 0) {
                    notifyDataSetChanged()
                }else{
                    notifyDataSetInvalidated()
                }
            }
        }



        override fun getItem(position: Int): Any {
            return filteredStoresName[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return filteredStoresName.size
        }
    }
}