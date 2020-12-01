package com.dyp1016.test.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dyp1016.okr.R
import com.dyp1016.okr.databinding.ActivityTestIndexBinding
import com.dyp1016.qvmvvm.core.base.BaseActivity

class TestIndexActivity : BaseActivity<ActivityTestIndexBinding>() {

    override fun initView() {
        val list = arrayListOf(
            Item(R.string.test_network_request, TestNetworkRequestActivity::class.java)
        )

        val adapter = Adapter(list) { item ->
            startActivity(item.clazz)
        }

        binding.apply {
            rvList.adapter = adapter
            rvList.layoutManager = LinearLayoutManager(mContext)
        }
    }

    override fun initData() {

    }

    override fun getViewBinding(): ActivityTestIndexBinding {
        return ActivityTestIndexBinding.inflate(layoutInflater)
    }
}

private data class Item(val name: Int, val clazz: Class<*>)

private class Adapter(
    private val list: List<Item>,
    private val onItemClickListener: (item: Item) -> Unit
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_test_index, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.setText(list[position].name)
        holder.tvName.setOnClickListener {
            onItemClickListener(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}