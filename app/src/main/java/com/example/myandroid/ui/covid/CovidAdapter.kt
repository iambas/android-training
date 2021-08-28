package com.example.myandroid.ui.covid

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myandroid.data.covid.TimeLineCasesAllResponse
import com.example.myandroid.databinding.LayoutTimeLineCaseItemBinding

class CovidAdapter constructor(
    private val onItemClicked: (TimeLineCasesAllResponse) -> Unit = {},
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var timeLineCases: ArrayList<TimeLineCasesAllResponse> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = LayoutTimeLineCaseItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CovidViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CovidViewHolder -> {
                val item = timeLineCases[position]
                holder.bind(item)
                holder.itemView.setOnClickListener {
                    onItemClicked.invoke(item)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return timeLineCases.count()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(list: List<TimeLineCasesAllResponse>) {
        timeLineCases.clear()
        timeLineCases.addAll(list)
        notifyDataSetChanged()
    }

    class CovidViewHolder(
        private val binding: LayoutTimeLineCaseItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: TimeLineCasesAllResponse) {
            binding.tvDate.text = model.txnDateFormat
            binding.tvNewCase.text = model.newCaseFormat
            binding.tvTotalCase.text = model.totalCaseFormat
        }
    }
}
