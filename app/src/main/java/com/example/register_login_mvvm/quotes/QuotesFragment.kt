package com.example.register_login_mvvm.quotes

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.register_login_mvvm.R
import com.example.register_login_mvvm.utils.Couroutines
import com.example.register_login_mvvm.utils.toast
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
class QuotesFragment : Fragment() ,KodeinAware{
    override val kodein by kodein()

    private val factory: QuotesViewModelFactory by instance()


    private lateinit var viewModel: QuotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.quotes_fragment, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(QuotesViewModel::class.java)

        Couroutines.main {
            val quotes = viewModel.quotes.await()
            quotes.observe(this, Observer {
                context?.toast(it.size.toString())
            })
        }
    }
}
