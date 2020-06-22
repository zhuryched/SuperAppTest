package com.tadam.superapptest.view.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.tadam.superapptest.R
import com.tadam.superapptest.databinding.FragmentFirstBinding
import com.tadam.superapptest.view.BaseFragment
import com.tadam.superapptest.viewModel.FirstViewModel

class FirstFragment : BaseFragment<FirstViewModel, FragmentFirstBinding>() {

    override fun layout(): Int = R.layout.fragment_first

    override fun afterCreateView(view: View, savedInstanceState: Bundle?) {
        with(vb.wvFirstFragment) {
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

            loadUrl("https://developer.android.com")
        }
    }
}