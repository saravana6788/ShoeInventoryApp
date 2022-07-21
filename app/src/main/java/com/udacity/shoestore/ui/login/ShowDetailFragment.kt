package com.udacity.shoestore.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe

class ShowDetailFragment : Fragment() {


    private lateinit var binding: ShoeDetailFragmentBinding

    private val sharedViewModel:SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_detail_fragment,container,false)

        binding.apply{
            shoe = Shoe("",0.0,"","")

        }
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(binding){
            saveButton.setOnClickListener {
                sharedViewModel.addNewShoe(binding.shoe)
                it.findNavController().navigate(
                    ShowDetailFragmentDirections.actionShowDetailFragmentToShoeListFragment()
                )
            }

            cancelButton.setOnClickListener {
                it.findNavController()
                    .navigate(ShowDetailFragmentDirections.actionShowDetailFragmentToShoeListFragment())
            }

        }


    }

}