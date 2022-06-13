package com.vas.feature_main_screen.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vas.feature_main_screen.R
import com.vas.feature_main_screen.domain.model.Character

class CharacterAdapter(var context: Context): RecyclerView.Adapter<ItemCharacterViewHolder>(){

    var data = listOf<Character>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onClickListener: OnCharacterClickListener? = null

    interface OnCharacterClickListener {
        fun onCharacterClick(name: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCharacterViewHolder =
        ItemCharacterViewHolder.from(parent)

    override fun onBindViewHolder(holder: ItemCharacterViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context, onClickListener!!)
    }

    override fun getItemCount() = data.size


}

class ItemCharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    private val iconHero: ImageView = itemView.findViewById(R.id.iconImageView)
    private val nameHero: TextView = itemView.findViewById(R.id.nameTextView)

    fun bind(item: Character, context: Context, onCharacterClickListener: CharacterAdapter.OnCharacterClickListener) {

        nameHero.text = item.name

        Picasso.with(context)
            .load(item.urlIcon)
            .fit()
            .placeholder(R.drawable.ic_marvel)
            .error(R.drawable.ic_error)
            .into(iconHero)

        itemView.setOnClickListener {
            onCharacterClickListener.onCharacterClick(item.name)
        }

    }

    companion object {
        fun from(parent: ViewGroup): ItemCharacterViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater
                .inflate(R.layout.character_item, parent, false)
            return ItemCharacterViewHolder(view)
        }
    }
}