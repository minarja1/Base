package cz.minarik.base.ui.dummy

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import cz.minarik.base.R
import cz.minarik.base.common.extensions.showToast
import cz.minarik.base.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_base.*
import kotlinx.android.synthetic.main.fragment_dummy.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DummyFragment : BaseFragment(R.layout.fragment_dummy) {

    val viewModel by viewModel<DummyViewModel>()

    private val adapter by lazy {
        DummyAdapterBuilder(requireContext()) {
            // ToDO on click
        }.adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // init views
        recyclerView.adapter = adapter

        // init observers
        viewModel.schedule.observe {
            adapter.submitList(it)
        }

        // load
        viewModel.getOrLoadDummy()
    }

}