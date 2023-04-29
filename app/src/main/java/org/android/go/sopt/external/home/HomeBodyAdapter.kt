package org.android.go.sopt.external.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.databinding.ItemHomeBodyBinding
import org.android.go.sopt.databinding.ItemHomeHeaderBinding


class HomeHeaderAdapter(context: Context) :
    RecyclerView.Adapter<HomeHeaderAdapter.HomeHeaderViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    class HomeHeaderViewHolder(private val binding: ItemHomeHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HomeHeaderData) {
            binding.tvHeader.text = data.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeHeaderViewHolder(ItemHomeHeaderBinding.inflate(inflater))

    override fun onBindViewHolder(holder: HomeHeaderViewHolder, position: Int) {
        holder.onBind(
            HomeHeaderData(content = "daehwan2daadsfadfasdfadfdaehwan2daadsfadfasdfadfdaehwan2daadsfadfasdfadf")
        )
    }

    override fun getItemCount() = 1
}

class HomeBodyAdapter(context: Context) :
    RecyclerView.Adapter<HomeBodyAdapter.HomeBodyViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var list = listOf<HomeBodyData>()

    fun setList(newList: List<HomeBodyData>) {
        if (list.listChanged(newList)) {
            notifyDataSetChanged()
            list = newList.toList()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeBodyViewHolder(ItemHomeBodyBinding.inflate(inflater))

    override fun onBindViewHolder(holder: HomeBodyViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

    class HomeBodyViewHolder(private val binding: ItemHomeBodyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HomeBodyData) {
            binding.ivHomeBodyImage.setImageDrawable(
                getDrawable(
                    binding.root.context,
                    data.image
                )
            )
            binding.tvHomeBodyTitle.text = data.title
            binding.tvHomeBodyCreator.text = data.creator
        }
    }
}

private fun <E> List<E>.listChanged(toBe: List<E>) =
    !(this.size == toBe.size && this.containsAll(toBe))