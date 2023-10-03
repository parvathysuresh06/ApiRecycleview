package com.example.apirecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    val  btnShowBottomSheet=findViewById<Button>(R.id.wishlist)
//        val  BtnDismiss=findViewById<Button>(R.id.idBtnDismiss)
//        BtnDismiss.setOnClickListener {
//            Toast.makeText(getApplicationContext(), "Order Placed", Toast.LENGTH_LONG).show();
//        }

        btnShowBottomSheet.setOnClickListener {
            val dialog = BottomSheetDialog(this)
            val view=layoutInflater.inflate(R.layout.bottom_sheet,null)
            dialog.setContentView(view)
            dialog.show()
        }
        // Retrieve the data from the Intent extras
        val title = intent.getStringExtra("title")
        val price = intent.getStringExtra("price")
        val description = intent.getStringExtra("description")
        val rating = intent.getStringExtra("rating")
        val imageUrl = intent.getStringExtra("image")


        val title_card=findViewById<TextView>(R.id.title)
        val des_card=findViewById<TextView>(R.id.de)
        val rating_card=findViewById<TextView>(R.id.rating)
        val price_card=findViewById<TextView>(R.id.price)
        val image_card=findViewById<ImageView>(R.id.image)
        Picasso.get().load(imageUrl).into(image_card)


        title_card.text=title
des_card.text=description
        rating_card.text=rating
        price_card.text=price
//        image_card.setImageResource(imageUrl)



//        Log.d("title",title.toString())
//        Log.d("price",price.toString())

    }
}