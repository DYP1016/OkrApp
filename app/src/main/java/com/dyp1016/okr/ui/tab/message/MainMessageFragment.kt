package com.dyp1016.okr.ui.tab.message

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.dyp1016.okr.R
import com.dyp1016.okr.base.BaseVMFragment
import com.dyp1016.okr.databinding.FragmentMainMessageBinding
import com.dyp1016.qvmvvm.core.base.KtxBaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainMessageFragment :
    BaseVMFragment<FragmentMainMessageBinding>(R.layout.fragment_main_message) {
    private val viewModel by viewModel<MainMessageViewModel>()
    private val item = listOf(
        "获取所有user",
        "增加一个user",
        "更新第一个user",
        "删除第一个user",
        "查询账号"
    )

    override fun initView(savedInstanceState: Bundle?) {
        binding.apply {
            lvMain.adapter =
                context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, item) }
            lvMain.setOnItemClickListener { _, _, position, _ ->
                when (item[position]) {
                    "获取所有user" -> {
                        viewModel.getAll()
                    }
                    "增加一个user" -> {
                        viewModel.createUser()
                    }
                    "更新第一个user" -> {
                        viewModel.updateFirstUser()
                    }
                    "删除第一个user" -> {
                        viewModel.deleteFirstUser()
                    }
                    "查询账号" -> {
                        context?.let {
                            val edit = EditText(it)
                            AlertDialog.Builder(it).apply {
                                setView(edit)
                                setPositiveButton(R.string.confirm) { _, _ -> viewModel.getUser(edit.text.toString()) }
                            }.show()
                        }
                    }
                }
            }
        }
    }

    override fun initData() {

    }

    override fun startObserve(): KtxBaseViewModel {
//        viewModel.testResult.observe(this) {
//            it?.apply {
//                binding.tvText.text = result
//            }
//        }

        return viewModel
    }
}