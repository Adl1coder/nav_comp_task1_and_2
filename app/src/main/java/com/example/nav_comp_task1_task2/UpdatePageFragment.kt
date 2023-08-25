package com.example.nav_comp_task1_task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationcomponentornek3.databinding.FragmentUpdateBinding
import com.google.android.material.snackbar.Snackbar

class UpdatePageFragment : Fragment() {

    private lateinit var design3: FragmentUpdateBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       design3 = FragmentUpdateBinding.inflate(inflater, container, false)
        design3.buttonSave.setOnClickListener {
            val userNameNew = design3.editNewName.text.toString()
            val userPasswordNew = design3.editNewPassword.text.toString()

            if (design3.editNewName.text.isNullOrEmpty() || design3.editNewPassword.text.isNullOrEmpty()) {
                Snackbar.make(it, "Please fill empty fields", Snackbar.LENGTH_SHORT).show()
            } else {

                //transferring data
                val passing2 = UpdatePageFragmentDirections.actionBackToSecondPageFragment(user = User(userNameNew,userPasswordNew))
                Navigation.findNavController(it).navigate(passing2)
            }
        }
        return design3.root
    }

}
