package com.example.mobileuptestapp.main.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileuptestapp.databinding.CryptoItemBinding

class MainAdapter(private val click: (CryptoUi) -> Unit) : ListAdapter<CryptoUi, MainAdapter.CryptoVH>(
    AsyncDifferConfig.Builder(DiffCallback()).build()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoVH {
        return CryptoVH(CryptoItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CryptoVH, position: Int) {
        holder.bind(currentList[position],click)
    }

    class CryptoVH(private val cryptoItemBinding: CryptoItemBinding) :
        RecyclerView.ViewHolder(cryptoItemBinding.root) {
            fun bind(cryptoUi: CryptoUi, click: (CryptoUi) -> Unit) {
                cryptoUi.setInfo(cryptoItemBinding.cryptoFullName,
                cryptoItemBinding.cryptoIcon,
                cryptoItemBinding.cryptoPrice,
                cryptoItemBinding.cryptoIncome,
                cryptoItemBinding.cryptoShortName)
                cryptoItemBinding.root.setOnClickListener {
                    click.invoke(cryptoUi)
                }
            }
        }

    private class DiffCallback : DiffUtil.ItemCallback<CryptoUi>() {

        override fun areItemsTheSame(oldItem: CryptoUi, newItem: CryptoUi) =
            oldItem.sameId(newItem)

        override fun areContentsTheSame(oldItem: CryptoUi, newItem: CryptoUi) =
            oldItem.sameCrypto(newItem)
    }
}