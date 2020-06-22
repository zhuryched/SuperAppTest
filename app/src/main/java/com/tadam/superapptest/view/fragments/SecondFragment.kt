package com.tadam.superapptest.view.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.tadam.superapptest.R
import com.tadam.superapptest.databinding.FragmentSecondBinding
import com.tadam.superapptest.view.BaseFragment
import com.tadam.superapptest.viewModel.SecondViewModel

class SecondFragment : BaseFragment<SecondViewModel, FragmentSecondBinding>() {

    override fun layout(): Int = R.layout.fragment_second

    override fun afterCreateView(view: View, savedInstanceState: Bundle?) {
        with(vb.wvSecondFragment) {
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    view?.loadUrl(request?.url.toString())
                    return true
                }
            }

            loadUrl("https://vc.ru/")
        }
    }
}