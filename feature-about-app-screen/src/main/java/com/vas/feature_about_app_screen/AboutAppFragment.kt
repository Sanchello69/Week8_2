package com.vas.feature_about_app_screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.github.terrakok.cicerone.Router
import com.vas.feature_about_app_screen.databinding.FragmentAboutAppBinding
import com.vas.feature_about_app_screen.di.AboutAppComponentViewModel
import javax.inject.Inject

class AboutAppFragment : Fragment() {


    /*
    По хорошему router должен поставляться во viewModel посредством фабрики,
    но в данном модуле viewModel излишне из-за простоты экрана.
     */
    @Inject
    lateinit var router: Router

    private var binding: FragmentAboutAppBinding? = null

    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<AboutAppComponentViewModel>()
            .newAboutAppComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutAppBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBackImageView()
    }

    private fun initBackImageView() {
        binding?.imageViewBack?.setOnClickListener {
            router.backTo(null)
        }
    }

}