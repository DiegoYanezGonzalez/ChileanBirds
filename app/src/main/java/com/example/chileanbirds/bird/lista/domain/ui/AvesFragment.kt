package com.example.chileanbirds.bird.lista.domain.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chileanbirds.R
import com.example.chileanbirds.bird.lista.domain.data.AveMapper
import com.example.chileanbirds.bird.lista.domain.data.RemoteAvesRepository
import com.example.chileanbirds.bird.lista.domain.AvesRepository
import com.example.chileanbirds.bird.lista.domain.ObtenerAveUseCase
import com.example.chileanbirds.bird.lista.domain.model.Ave
import com.example.chileanbirds.bird.lista.domain.model.Aves
import com.example.chileanbirds.bird.network.RetrofitHandler
import com.example.chileanbirds.bird.lista.domain.presentation.AvesUiState
import com.example.chileanbirds.bird.lista.domain.presentation.AvesViewModel
import com.example.chileanbirds.bird.lista.domain.presentation.AvesViewModelFactory
import com.example.chileanbirds.databinding.FragmentAvesBinding

@Suppress("CAST_NEVER_SUCCEEDS")
class AvesFragment : Fragment(R.layout.fragment_aves), AvesItemClickListener {


    private lateinit var binding: FragmentAvesBinding
    private lateinit var viewModel: AvesViewModel
    private lateinit var viewModelFactory: AvesViewModelFactory
    private lateinit var avesAdapter: AvesAdapter
    private lateinit var repository: AvesRepository


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDependencies()
        binding = FragmentAvesBinding.bind(view)
        setupLiveData()
        setupRecyclerView()

    }

    private fun setupDependencies() {
        //   filtrarTextoUseCase = FiltrarTextoUseCase(repository)

        viewModelFactory =
            AvesViewModelFactory(
                ObtenerAveUseCase(
                    RemoteAvesRepository(
                        RetrofitHandler.getAveApi(),
                        AveMapper()
                    )
                )
            )

        viewModel = ViewModelProvider(this, viewModelFactory).get(AvesViewModel::class.java)
    }

    private fun setupLiveData() {
        viewModel.getLivaData().observe(
            viewLifecycleOwner,
            Observer { state -> state?.let { handleState(it) } }
        )
        viewModel.obtenerAves()
    }

    private fun handleState(state: AvesUiState) {
        when (state) {
            is AvesUiState.LoadingAvesState -> showLoading()
            is AvesUiState.SuccessAvesState -> showLoad(state.result)
            is AvesUiState.EmptyListAvesState -> showEmpty()
            is AvesUiState.ErrorServerAvesState -> showError()
            is AvesUiState.NotInternetAvesState -> showNotInternet()
        }

    }

    private fun showLoading() {

    }

    private fun showLoad(aves: Aves) {
        //     Toast.makeText(context, "total de aves ${aves.result.size}", Toast.LENGTH_SHORT).show()
        avesAdapter =
            AvesAdapter(aves.result, this)
        binding.rvAves.adapter = avesAdapter
    }

    private fun showEmpty() {
    }

    private fun showError() {
        Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
    }

    private fun showNotInternet() {
    }

    private fun setupRecyclerView() {
        binding.apply {
            rvAves.setHasFixedSize(true)
            rvAves.layoutManager = LinearLayoutManager(
                requireContext()
            )
            rvAves.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    override fun onAvesItemClickListener(ave: Ave) {

        val bundle = Bundle().apply {
            putString("uid", ave.uid)

        }
        view?.let {
            Navigation.findNavController(it)
                .navigate(R.id.action_avesFragment_to_detalleAvesFragment, bundle)
        }
    }


}
