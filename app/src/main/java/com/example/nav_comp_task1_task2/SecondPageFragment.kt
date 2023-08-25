package com.example.nav_comp_task1_task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponentornek3.R
import com.example.navigationcomponentornek3.databinding.FragmentSecondPageBinding


class SecondPageFragment : Fragment() {

    private lateinit var design2 : FragmentSecondPageBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {

        design2 = FragmentSecondPageBinding.inflate(inflater,container,false)
        //veri transferi için ana sayfaya gerekli kodları yazdıktan sonra aşağıdakileri yazıyoruz:
        val bundle: SecondPageFragmentArgs by navArgs()


      //Home Page taken data
        val takenName = bundle.user.name
        val takenPassword = bundle.user.pswrd
        if (takenName!= null && takenPassword!=null ) {
           design2.nameText.text = "name: ${takenName}"
            design2.passwordText.text = "password: ${takenPassword}"
        }


        design2.buttonUpdate.setOnClickListener {

            Navigation.findNavController(it)
                .navigate(R.id.action_secondPageFragment_to_updatePageFragment)//Navigation Component kullanarak fragment geçiş
            //veri gönderecek olsaydık geçiş yaparken şu kodu yazmalıyız:
            //    val passing = SecondPageFragmentDirections.actionSecondPageFragmentToUpdatePageFragment()
            //    Navigation.findNavController(it).navigate(passing)

        }


        //Update page taken data
        val takenName2 = bundle.user.name
        val takenPassword2 = bundle.user.pswrd
        if (takenName2!= null && takenPassword2!=null ) {
            design2.nameText.text = "name: ${takenName2}"
            design2.passwordText.text = "password: ${takenPassword2}"
        }
        return design2.root
    }


}