package com.tadam.superapptest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<VM : ViewModel, VB : ViewDataBinding> : Fragment() {

    protected lateinit var vm: VM
    protected lateinit var vb: VB

    @LayoutRes
    protected abstract fun layout(): Int

    protected abstract fun afterCreateView(view: View, savedInstanceState: Bundle?)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(layout(), container, false)

        try {
            vm = ViewModelProvider(this).get(vmTypeClass)
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }

        vb = DataBindingUtil.bind(view)!!

        afterCreateView(view, savedInstanceState)
        return view
    }

    private val vmTypeClass: Class<VM>
        get() {
            try {
                val className =
                    (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0].toString()
                val clazz = Class.forName(className.replace("class ", ""))
                @Suppress("UNCHECKED_CAST")
                return clazz as Class<VM>
            } catch (e: Exception) {
                throw IllegalStateException(e.message)
            }
        }
}