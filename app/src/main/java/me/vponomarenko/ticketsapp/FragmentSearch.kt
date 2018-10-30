package me.vponomarenko.ticketsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_search.*

class FragmentSearch : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_search, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewCompat.setTransitionName(editText_destination_from, "destination")
        editText_destination_from.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .addSharedElement(editText_destination_from, ViewCompat.getTransitionName(editText_destination_from)!!)
                .replace(R.id.fragmentContainer, DestinationFragment())
                .addToBackStack("From")
                .commit()
        }
    }
}