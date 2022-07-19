package com.udacity.shoestore.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe

class ShowDetailFragment : Fragment() {


    private lateinit var viewModel: ShowDetailViewModel

    private lateinit var binding: ShoeDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ShoeDetailFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShowDetailViewModel::class.java)

        binding.saveButton.setOnClickListener {
            val shoe = Shoe(
                binding.shoeName.text.toString(),
                binding.shoeSize.text.toString().toDouble(),
                binding.shoeCompany.text.toString(),
                binding.shoeDescription.text.toString()
            )

            it.findNavController().navigate(
                ShowDetailFragmentDirections.actionShowDetailFragmentToShoeListFragment(shoe)
            )
        }

        binding.cancelButton.setOnClickListener {
            it.findNavController()
                .navigate(ShowDetailFragmentDirections.actionShowDetailFragmentToShoeListFragment())
        }


    }

}